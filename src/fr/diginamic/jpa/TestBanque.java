package fr.diginamic.jpa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.jpa.banque.EAdresse;
import fr.diginamic.jpa.banque.EAssuranceVie;
import fr.diginamic.jpa.banque.EClients;
import fr.diginamic.jpa.banque.ECompte;
import fr.diginamic.jpa.banque.ELivretA;
import fr.diginamic.jpa.banque.EOperation;
import fr.diginamic.jpa.banque.EVirement;

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
			 */
			
			
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
			client01.setDateNaiss(new SimpleDateFormat("yyyy-MM-dd").parse("1970-10-15"));
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
			client02.setDateNaiss(new SimpleDateFormat("yyyy-MM-dd").parse("1960-02-05"));
			client02.setIdcompte(compte);			
			em.persist(client02);
			em.getTransaction().commit();
			
			
			
			
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
			
			
			client03.setDateNaiss( new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
						
			em.persist(client03);
			em.getTransaction().commit();
			
			
			//CREATION DU COMPTE ASSURANCE VIE
		
			em.getTransaction().begin();
			EAssuranceVie assvie = new EAssuranceVie(); 
			
			assvie.setNumero("003");
			assvie.setSolde("15");
			
			assvie.setDatefin(new SimpleDateFormat("yyyy-MM-dd").parse("2030-06-07"));
			assvie.setTauxassvie(20.00);
			assvie.setId(0);
			assvie.setIdclients(client03);
						
			em.persist(assvie);
			em.getTransaction().commit(); 
			
			
			
			//CREATION DU COMPTE LIVRET A
			
			em.getTransaction().begin();
			ELivretA livreta = new ELivretA(); 
			
			livreta.setNumero("004");
			livreta.setSolde("3000");
			livreta.setTauxlivret(20.00);
			livreta.setId(0);
			livreta.setIdclients(client03);
						
			em.persist(livreta);
			em.getTransaction().commit(); 
			
			
			/**
			 *  insérer des opérations de type virements sur un compte
			 *  
			*/
			
			
			em.getTransaction().begin();
			EVirement opvirement = new EVirement(); // création d'une opération	virement	
			
			opvirement.setBeneficiaire("Jacques");
			opvirement.setDate(new Date(System.currentTimeMillis()));
			opvirement.setMontant(50.00);	
			opvirement.setMotif("operation virement");
			opvirement.setCompte(assvie); // lie l'opération au compte assurance vie créé plus haut
		
			em.persist(opvirement);
			em.getTransaction().commit(); 
			
			
			/**
			 *  insérer des opérations de type opération sur un compte
			 *  
			*/
			
			em.getTransaction().begin();
			EOperation op = new EOperation();
			op.setDate(new Date(System.currentTimeMillis()));
			op.setMontant(20.00);
			op.setMotif("operation seule");
			op.setCompte(livreta);
			em.persist(op);
			em.getTransaction().commit();
			
			
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
