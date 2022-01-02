package fr.diginamic.jpa.banque;

import javax.persistence.*;

@Entity
@Table(name="VIREMENT")
public class EVirement extends EOperation {

	@Column(name = "BENEFICIAIRE")
	private String beneficiaire;

	public EVirement(String beneficiaire) {
		super();
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public EVirement() {
		// TODO Auto-generated constructor stub
	}

}
