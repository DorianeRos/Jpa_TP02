package fr.diginamic.cge.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOURNISSEUR")
public class EFounisseur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENTAL
	private int id;
	
	@Column(name = "NOM",length = 25,unique = true)
	private String nom;

	public EFounisseur() {
		// TODO Auto-generated constructor stub
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

}
