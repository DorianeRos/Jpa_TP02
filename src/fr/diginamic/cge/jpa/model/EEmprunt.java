package fr.diginamic.cge.jpa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


	@Entity
	@Table(name= "EMPRUNT")
	
public class EEmprunt {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "DATE_DEBUT", nullable = false)
		private String dateDebut;
		
		@Column(name = "DATE_FIN", nullable = true)
		private String dateFin;
		
		@Column(name = "DELAI", nullable = true)
		private String delai;
		
		@ManyToOne
		@JoinColumn(name = "ID_CLIENT")
		private EClient idClient;
		
	
		@ManyToMany
		@JoinTable	(	name =	"COMPO",
					// ID_EMP de la table COMPO qu'on lie avec l'ID de la table EMPRUNT
					joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
					inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID")
					//lien de ID_liv de COMPO, avec l'ID de la table LIVRE		
					)
		private Set<ELivre> empruntLivre;

	public EEmprunt() {
		// TODO Auto-generated constructor stub
		
	}
		public int getId() {
			return id;
		}

		
		public void setId(int id) {
			this.id = id;
		}

		public String getDateDebut() {
			return dateDebut;
		}

		public void setDateDebut(String dateDebut) {
			this.dateDebut = dateDebut;
		}

		public String getDateFin() {
			return dateFin;
		}

		public void setDateFin(String dateFin) {
			this.dateFin = dateFin;
		}

		public String getDelai() {
			return delai;
		}

		public void setDelai(String delai) {
			this.delai = delai;
		}

		public EClient getIdClient() {
			return idClient;
		}

		public void setIdClient(EClient idClient) {
			this.idClient = idClient;
		}



		
		
		public Set<ELivre> getEmpruntLivre() {
			return empruntLivre;
		}
		public void setEmpruntLivre(Set<ELivre> empruntLivre) {
			this.empruntLivre = empruntLivre;
		}
		@Override
		public String toString() {
			return "EEmprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
					+ ", idClient=" + idClient + ", empruntLivre=" + empruntLivre + "]";
		}
		public EEmprunt find(Class<ELivre> class1, int i) {
			// TODO Auto-generated method stub
			return null;
		}
}
