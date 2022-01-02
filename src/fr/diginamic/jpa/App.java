package fr.diginamic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.cge.jpa.model.ELivre;


public class App {

	public static void main(String[] args) {
		EntityManagerFactory efm = null ;
		try {
			/**
			 * CHOIX DE L'UNITE DE PERSISTENCE DANS LE FICHIER persistence.xml "biblio2"
			 */
			efm = Persistence.createEntityManagerFactory("bddFILROUGE");
			EntityManager em = efm.createEntityManager();
			
			/**
			 * 	REALISER UN FIND SIMPLE permettant d'extraire un livre en fonction de son identifiant
			 * et affichez son titre et son auteur.
			
			
			ELivre efo = em.find(ELivre.class, 1);
			if(efo != null) System.out.println(efo.getTitre());
			ELivre efo1 = em.find(ELivre.class, 6);
			if (efo1 != null)System.out.println(efo1.getTitre());			
			else System.out.println("NON TROUVE");
			 */
			
			 /** INSERTION DE LIVRE
	        em.getTransaction().begin();
	        ELivre efonew = new ELivre(0,  "Les Ortientales", "Victor Hugo");
	        em.persist(efonew);
	        em.getTransaction().commit();
	        System.out.println(efonew.getId());*/

	        /**MODIFICATION : UPDATE
	       
	        em.getTransaction().begin();
	        ELivre efomod = em.find(ELivre.class, 5);
	        efomod.setTitre("Du plaisir dans la cuisine");
	        em.merge(efomod);
	        em.getTransaction().commit();*/
	        
	        
	        /**EXTRAIRE de la base un livre en fonction de son titreÂ avec une requÃªte JPQL
	        
	        TypedQuery<ELivre> query = em.createQuery("select l from ELivre l where l.titre='Du plaisir dans la cuisine'", ELivre.class);

	        ELivre l = query.getResultList().get(0); */
	        
	        
	        /**EXTRAIRE de la base un livre en fonction de son auteurÂ avec une requÃªte JPQL 
	        
	        TypedQuery<ELivre> query2 = em.createQuery("select l2 from ELivre l2 where l2.auteur='Victor Hugo'", ELivre.class);

	        ELivre l2 = query2.getResultList().get(0);
	        System.out.println(l2.getTitre());*/
	        
	        
	        /** MODIFICATION : DELETE 
	        em.getTransaction().begin();
	        ELivre efosupp = em.find(ELivre.class, 6);
	        em.remove(efosupp);
	        em.getTransaction().commit();
	        
	        em.close();*/
	        
	        /**Affichez la liste de tous les livres prÃ©sents en base de donnÃ©es (titre et auteur).*/
	        
	        TypedQuery<ELivre> query3 = em.createQuery("select l3 from ELivre l3 ", ELivre.class);
	        List<ELivre> livre = query3.getResultList();
	        System.out.println(livre);
	        
	        
			
		} catch(Exception e) {e.printStackTrace();}
		finally {
			if(efm != null) efm.close();
		}
	}
	
	public App() {
		// TODO Auto-generated constructor stub
	}

}
