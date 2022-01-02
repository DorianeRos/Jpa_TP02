package fr.diginamic.jpa.banque;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name= "OPERATION")

public class EOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATE",  columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date date;
	
	@Column(name = "MONTANT", length = 50)
	private double montant;
	
	@Column(name = "MOTIF", length = 255)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private ECompte compte;
	
	
	public EOperation(int id, Date date, double montant, String motif, ECompte compte) {
		super();
		this.id = id;
		this.date = date;
		this.montant = montant;
		this.motif = motif;
		this.compte = compte;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}


	public ECompte getCompte() {
		return compte;
	}


	public void setCompte(ECompte compte) {
		this.compte = compte;
	}


	public EOperation() {
		// TODO Auto-generated constructor stub
	}

}
