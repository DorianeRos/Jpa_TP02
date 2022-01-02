package fr.diginamic.jpa.banque;

import java.time.LocalDate;


import javax.persistence.*;


@Entity
@Table(name= "OPERATION")

public class EOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATE", length = 50, nullable = false)
	private LocalDate nom;
	
	@Column(name = "MONTANT", length = 50, nullable = false)
	private double prenom;
	
	@Column(name = "MOTIF", length = 255, nullable = false)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private ECompte compte;
	
	
	public EOperation(int id, LocalDate nom, double prenom, String motif, ECompte compte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.motif = motif;
		this.compte = compte;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getNom() {
		return nom;
	}


	public void setNom(LocalDate nom) {
		this.nom = nom;
	}


	public double getPrenom() {
		return prenom;
	}


	public void setPrenom(double prenom) {
		this.prenom = prenom;
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
