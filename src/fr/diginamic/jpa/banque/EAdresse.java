package fr.diginamic.jpa.banque;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable @Access(AccessType.FIELD)
public class EAdresse {
	
	@Column(name="NUM", length =10, nullable=false)
	private int num;
	
	@Column(name="RUE", length =255, nullable=false)
	private String rue;
	
	@Column(name="CP", length =5, nullable=false)
	private int codePostal;
	
	@Column(name="VILLE", length =50, nullable=false)
	private String ville;

	public EAdresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.num = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int numero) {
		this.num = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public EAdresse() {
		// TODO Auto-generated constructor stub
	}

}
