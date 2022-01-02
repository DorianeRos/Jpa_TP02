package fr.diginamic.jpa;



import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.diginamic.cge.jpa.model.EClient;
import fr.diginamic.cge.jpa.model.EEmprunt;
import fr.diginamic.cge.jpa.model.ELivre;

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
			 * Réalisez une requête qui permet d’extraire les livres d'un emprunt
			 * associés.
			 */
			
			em.getTransaction().begin();
			EEmprunt emprunt = em.find(EEmprunt.class, 1);
			Set<ELivre> empL = emprunt.getEmpruntLivre();
			em.getTransaction().commit(); 
			// Affiche tous les emprunts liés à mon client efo (1)
			empL.stream().forEach(emp->System.out.println("ID emprunt : " + emprunt.getId() +" "+ "-> Nom du livre : " + emp.getTitre()));
			
			
			 /** Réalisez une requête qui permet d’extraire tous les emprunts d’un client
			 * donné
			 */
			em.getTransaction().begin();
			EClient client = em.find(EClient.class, 1);
			Set<EEmprunt> empC = client.getEmprunt();
			em.getTransaction().commit(); 
			// Affiche tous les emprunts liés à mon client efo (1)
			empC.stream().forEach(emp->System.out.println("Client: " + client.getNom() +" "+ client.getPrenom() + " -> ID de l'emprunt: " + emp.getId()));

			/** 
			 * fermeture de la BDD
			 */
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
