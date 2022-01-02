package fr.diginamic.jpa.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="BANQUE")



public class EBanque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NOM", length =50, nullable=false)
	private String nom;
	
	@OneToMany(mappedBy = "idBanque")
	private Set<EClients> idclients;
	
	public EBanque(int id, String nom, Set<EClients> idclients) {
		super();
		this.id = id;
		this.nom = nom;
		this.idclients = idclients;
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

	public Set<EClients> getIdclients() {
		return idclients;
	}

	public void setIdclients(Set<EClients> idclients) {
		this.idclients = idclients;
	}

	public EBanque() {
		// TODO Auto-generated constructor stub
		idclients = new HashSet<EClients>();
	}

}
