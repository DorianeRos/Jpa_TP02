package fr.diginamic.jpa.banque;

import javax.persistence.*;
@Entity
	@Table(name="BENEFICIAIRE")
public class EVirement extends EOperation{

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;
	
	public EVirement() {
		// TODO Auto-generated constructor stub
	}

}
