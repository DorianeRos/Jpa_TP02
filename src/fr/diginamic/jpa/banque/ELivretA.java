package fr.diginamic.jpa.banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIVRET")
public class ELivretA  extends ECompte{
	
	@Column(name= "TAUX_LIVRETA")
	private double tauxlivret;
	
	public double getTauxlivret() {
		return tauxlivret;
	}

	public void setTauxlivret(double tauxlivret) {
		this.tauxlivret = tauxlivret;
	}

	public ELivretA(double tauxlivret) {
		super();
		this.tauxlivret = tauxlivret;
	}

	public ELivretA() {
		// TODO Auto-generated constructor stub
	}

	public void setId(ECompte compte) {
		// TODO Auto-generated method stub
		
	}

}
