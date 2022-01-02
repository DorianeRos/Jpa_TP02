package fr.diginamic.cge.jpa.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "CLIENT")

public class EClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;
	
	

	
	@OneToMany(mappedBy = "idClient")
	private Set<EEmprunt> emprunt;
	
	
	public EClient() {
		// TODO Auto-generated constructor stub
		emprunt = new HashSet<EEmprunt>();
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

	public Set<EEmprunt> getEmprunt() {
		return emprunt;
	}

	public void setEmprunt(Set<EEmprunt> emprunt) {
		this.emprunt = emprunt;
	}

}