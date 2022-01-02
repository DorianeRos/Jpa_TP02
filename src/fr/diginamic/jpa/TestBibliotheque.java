package fr.diginamic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.cge.jpa.model.EClient;
import fr.diginamic.cge.jpa.model.EEmprunt;

public class TestBibliotheque {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		try {
			/**
			 * CHOIX DE L'UNITE DE PERSISTENCE DANS LE FICHIER persistence.xml "biblio"
			 */
			efm = Persistence.createEntityManagerFactory("bddFILROUGE");
			EntityManager em = efm.createEntityManager();

			/**
			 * Réalisez une requête qui permet d’extraire un emprunt et tous ses livres
			 * associés.
			 */
			



			
			
			 /** Réalisez une requête qui permet d’extraire tous les emprunts d’un client
			 * donné
			 */

			em.getTransaction().begin();

			EEmprunt eao = new EEmprunt();
			EClient efo = em.find(EClient.class, 1);
			eao.setIdClient(efo); 
			em.getTransaction().commit();

			/**
			 * Affiche tous les emprunts liés à mon client efo (1)
			 */
			efo.getEmprunt().stream().forEach(a -> System.out.println("Emprunt : " + a.getId()));

			em.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}
	}

	public TestBibliotheque() {
		// TODO Auto-generated constructor stub
	}

}
