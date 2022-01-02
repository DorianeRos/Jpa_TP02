package fr.diginamic.jpa.banque;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name ="Clients")

public class EClients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	
	@Column(name="PRENOM", length=50)
	private String prenom;
	
	
	@Column(name="DATE_NAISS", length = 20)
	private Date date_naiss;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	private EBanque idBanque;
	
	@ManyToOne
	@JoinColumn(name = "ID_COMPTE")
	private ECompte idcompte;
	
	
	@Embedded EAdresse adresse;

	
	public EClients(int id, String nom, String prenom, Date date, EBanque idBanque, ECompte idcompte,
			EAdresse adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naiss = date;
		this.idBanque = idBanque;
		this.idcompte = idcompte;
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNaiss() {
		return date_naiss;
	}


	public void setDateNaiss(Date date) {
		this.date_naiss = date;
	}


	public EBanque getIdBanque() {
		return idBanque;
	}


	public void setIdBanque(EBanque idBanque) {
		this.idBanque = idBanque;
	}


	public ECompte getIdcompte() {
		return idcompte;
	}


	public void setIdcompte(ECompte idcompte) {
		this.idcompte = idcompte;
	}


	public EAdresse getAdresse() {
		return adresse;
	}


	public void setAdresse(EAdresse adresse) {
		this.adresse = adresse;
	}


	
	public EClients(int id) {
		// TODO Auto-generated constructor stub
		
	}
	public EClients() {
		// TODO Auto-generated constructor stub
		
	}
	


}
