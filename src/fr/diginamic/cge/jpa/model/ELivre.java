package fr.diginamic.cge.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Livre")

public class ELivre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENTAL
	private int id;
	
	@Column(name = "TITRE",length = 50,unique = true)
	private String titre;	
	
	@Column(name = "AUTEUR",length = 50,unique = true)
	private String auteur;
		
	
	@ManyToMany(mappedBy = "empruntLivre")
	private Set<EEmprunt> livresEmprunte;
	

	public ELivre() {
		// TODO Auto-generated constructor stub
		livresEmprunte = new HashSet<>();
	}
	
	public Set<EEmprunt> getLivresEmprunte() {
		return livresEmprunte;
	}

	public void setLivresEmprunte(Set<EEmprunt> livresEmprunte) {
		this.livresEmprunte = livresEmprunte;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public ELivre(int id, String titre, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}

	public void setA(String auteur) {
		this.auteur = auteur;
	}
	@Override
	public String toString() {
		return "ELivre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", livresEmprunte=" + livresEmprunte
				+ "] \n";
	}

}

