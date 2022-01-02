package fr.diginamic.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.jpa.banque.EAdresse;
import fr.diginamic.jpa.banque.EAssuranceVie;
import fr.diginamic.jpa.banque.EClients;
import fr.diginamic.jpa.banque.ECompte;
import fr.diginamic.jpa.banque.ELivretA;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory efm = null;
		try {
			/**
			 * CHOIX DE L'UNITE DE PERSISTENCE DANS LE FICHIER persistence.xml "bddbanque"
			 */
			efm = Persistence.createEntityManagerFactory("bddbanque");
			EntityManager em = efm.createEntityManager();
			
			

			/** 
			 * 
			 * insérer un compte associé à 2 clients
			 * 
						
			//CREATION DU COMPTE
			em.getTransaction().begin();
			ECompte compte = new ECompte(); // création d’un objet compte
			compte.setNumero("001");
			compte.setSolde("1050,0");
			em.persist(compte);
			em.getTransaction().commit();
			System.out.println("client enregistré : " + compte.getNumero());
				
			
			
			// INSERTION DU PREMIER CLIENT LIE 
			em.getTransaction().begin();
			EAdresse adresse01 = new EAdresse(); //création d'une adresse			
			adresse01.setNum(14);
			adresse01.setRue("rue de la patate");
			adresse01.setCodePostal(71890);
			adresse01.setVille("plouf");
			EClients client01 = new EClients(); //creation d'un objet client
			client01.setNom("ROS");
			client01.setPrenom("Doriane");
			client01.setAdresse(adresse01);
			client01.setDateNaiss(new Date(1990,10,23));
			client01.setIdcompte(compte);
			em.persist(client01);
			em.getTransaction().commit();
			
			
			// INSERTION DU DEUXIEME CLIENT LIE 
			em.getTransaction().begin();
			EAdresse adresse02 = new EAdresse(); //création d'une adresse			
			adresse02.setNum(2);
			adresse02.setRue("rue de la mandragore");
			adresse02.setCodePostal(78012);
			adresse02.setVille("poudlard");
			EClients client02 = new EClients(); //creation d'un objet client
			client02.setNom("COCA");
			client02.setPrenom("Cola");
			client02.setAdresse(adresse02);
			client02.setDateNaiss(new Date(1960,2,5));
			client02.setIdcompte(compte);			
			em.persist(client02);
			em.getTransaction().commit();
			*/
			
			
			
			/** 
			 * 
			 * insérer un client avec plusieurs comptes
			 */
			 
			//INSERTION DU CLIENT
			em.getTransaction().begin();
			EAdresse adresse03 = new EAdresse(); //création d'une adresse			
			adresse03.setNum(3);
			adresse03.setRue("rue de la marmotte");
			adresse03.setCodePostal(74102);
			adresse03.setVille("pokemon");
			EClients client03 = new EClients(); //creation d'un objet client
			client03.setNom("CLIENT LIE ");
			client03.setPrenom("DEUX COMPTES");
			client03.setAdresse(adresse03);
			client03.setDateNaiss(new Date(1950,7,12));
						
			em.persist(client03);
			em.getTransaction().commit();
			
			
			//CREATION DU COMPTE
			em.getTransaction().begin();
			
			ECompte compte = new ECompte(); // création d’un objet compte
			compte.setNumero("002");
			compte.setSolde("105,0");
			
			ELivretA livreta = new ELivretA(); //creation livret A
			livreta.setTauxlivret(5.0);
			
			EAssuranceVie assvie = new EAssuranceVie(); //creation Assurance vie
			assvie.setTauxassvie(20.00);
			assvie.setDatefin(new Date(2070,5,24));
			
			
			compte.setIdclients(client03); 
			client03.setIdcompte(compte);
			em.persist(compte);
			em.persist(livreta);
			em.persist(assvie);
			em.getTransaction().commit();
			
			System.out.println("client enregistré : " + compte.getNumero());

			
			
			
			
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (efm != null)
				efm.close();
		}
	}

	public TestBanque() {
		// TODO Auto-generated constructor stub
	}

}
