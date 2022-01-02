package fr.diginamic.jpa.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity

@Table(name= "COMPTE")
public class ECompte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NUMERO", length = 50)
	private String numero;
	
	@Column(name = "SOLDE", length = 50)
	private String solde;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENTS")
	private EClients idclients;
	
	@OneToMany(mappedBy="compte")
	private Set<EOperation> operation;
	
	

	public ECompte() {
		// TODO Auto-generated constructor stub
		operation = new HashSet<EOperation>();
		
	}

	public ECompte(int id, String numero, String solde, EClients idclients, Set<EOperation> operation) {
		super();
		this.id = id;
		this.numero = numero;
		this.solde = solde;
		this.idclients = idclients;
		this.operation = operation;
	}
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getSolde() {
		return solde;
	}



	public void setSolde(String solde) {
		this.solde = solde;
	}



	public EClients getIdclients() {
		return idclients;
	}



	public void setIdclients(EClients idclients) {
		this.idclients = idclients;
	}



	public Set<EOperation> getOperation() {
		return operation;
	}



	public void setOperation(Set<EOperation> operation) {
		this.operation = operation;
	}

}
