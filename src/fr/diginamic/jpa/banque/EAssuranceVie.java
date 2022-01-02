package fr.diginamic.jpa.banque;


import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="ASSURANCE")
public class EAssuranceVie extends ECompte{
	
	@Temporal(TemporalType.DATE)
	@Column(name= "DATE_FIN")
	private Date datefin;
	
	@Column(name= "TAUX_ASSVIE")
	private double tauxassvie;
	

	public EAssuranceVie(Date datefin, double tauxassvie) {
		super();
		this.datefin = datefin;
		this.tauxassvie = tauxassvie;
	}


	public Date getDatefin() {
		return datefin;
	}


	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	public double getTauxassvie() {
		return tauxassvie;
	}


	public void setTauxassvie(double tauxassvie) {
		this.tauxassvie = tauxassvie;
	}


	public EAssuranceVie() {
		// TODO Auto-generated constructor stub
	}


}
