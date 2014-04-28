package controleur;

import java.util.ArrayList;
import java.util.Calendar;

import model.Catalogue;
import model.Chauffeur;
import model.Client;
import model.ClientException;
import model.Contrat;
import model.PersonneException;
import model.Prestige;
import model.Simple;
import model.Utilitaire;
import model.Vehicule;

// Agence qui agit a titre de controleur
public class Agence {
	private Catalogue catalogue;   // Catalogue de clients et de vehicules
	private String nom;            // Nom de l'agence
	
	// Constructeur de l'agence
	public Agence(String nom) {
		this.catalogue = new Catalogue();
		this.nom = nom;
	}
	
	// Permet d'ajouter un client dans le systeme
	public void ajouterClient(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis, String noTelephone, String typeCarte, String noCarte, 
							  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
							  String ville, String province, String codePostal) {
		Client client;
		try {
			// Instanciation du client
			client = new Client(nom, prenom, dateNaissance, sexe, noPermis, noTelephone, noCivique, noApp, nomRue, ville, province, codePostal, typeCarte, noCarte, expiration, cvv);
			catalogue.ajouterClient(client); // Ajout du client a la liste de clients
			
			System.out.println("Le client a ete ajouter avec succes a l'application!");
		} catch (PersonneException e) {
			e.printErreur();
		} catch (ClientException e) {
			e.printErreur();
		}
	}
	
	// Methode permettant de modifier un client
	public void modifierClient(Client client, String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis, String noTelephone, String typeCarte, String noCarte, 
			  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
			  String ville, String province, String codePostal) {
		
		// Ancien numero de permis de conduire pour pouvoir retrouver le contrat dans la liste apres la modification
		String ancienPermis = client.getNoPermis();
		
		try {
			// Modification du client
			client.modifier(nom, prenom, dateNaissance, sexe, noPermis, noTelephone, noCivique, noApp, nomRue, ville, province, codePostal, typeCarte, noCarte, expiration, cvv);
			catalogue.modifierClient(client, ancienPermis); // Remplacement du client dans la liste des clients
			
			System.out.println("Le client a ete modifier avec succes!");
		} catch (PersonneException e) {
			e.printErreur();
		}
	}
	
	// Methode permettant de supprimer un client
	public void supprimerClient(Client client) {
		catalogue.supprimerClient(client); // Supprime un client de la liste des clients
		System.out.println("Le client a ete supprimer!");
	}
	
	// Methode permettant d'ajouter un contrat et de l'assigner a un client
	public void ajouterContrat(Client client, Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		// Ajout du contrat au client
		client.ajouterContrat(vehicule, datePret, dateRetourPrevue, listeChauffeur);
		vehicule.setDisponible(false); // Le vehicule sur le contrat n'est plus disponible
		System.out.println("Le contrat a ete ajouter avec succes!");
	}
	
	// Methode permettant de modifier un contrat
	public void modifierContrat(Contrat contrat, Client client, Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		contrat.getVehicule().setDisponible(true); // L'ancien vehicule redevient disponible
		contrat.getPaiement().rembourserClient();  // Le systeme rembourse le vehicule
		
		// On effectue la modification du contrat avec les nouvelles donnees
		client.modifierContrat(contrat, vehicule, datePret, dateRetourPrevue, listeChauffeur);
		contrat.getVehicule().setDisponible(false); // Le nouveau vehicule n'est plus disponible
		System.out.println("Le contrat a ete modifier avec succes!");
	}
	
	// Methode permettant de supprimer un contrat
	public void supprimerContrat(Client client, Contrat contrat) {
		contrat.getVehicule().setDisponible(true); // Le vehicule redevient disponible
		contrat.getPaiement().rembourserClient(); // On rembourse le client
		client.supprimerContrat(contrat); // Et on supprime le contrat 
		System.out.println("Le contrat a ete supprimer avec succes!");
	}
	
	// Vehicule "hardcoder" dans l'application puisque la gestion des vehicules ne fait pas partie de nos cas d'utilisation
	public void ajouterVehicule() {
		Vehicule vehicule;
		
		vehicule = new Simple("KMGH43894343", "Standard", "Air climatise", "Hyundai", "Elantra", 10543, 5, true, 25, false);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Simple("KWUV32968274", "Faible", "Manuel", "Hyundai", "Accent", 23965, 5, true, 20, true);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Simple("UWTR54329669", "Puissant", "Manuel", "Mazda", "Mazda 3", 98432, 5, true, 25, false);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Simple("PVJE57823675", "Standard", "Radio", "Kia", "Rio", 18324, 5, true, 25, true);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Simple("GANR58329675", "Faible", "Chauffage", "Ford", "Escape", 12544, 5, true, 25, false);
		catalogue.ajouterVehicule(vehicule);
		
		vehicule = new Prestige("VSRE56565460", "Puissant", "Radio", "Porsche", "Cayenne", 50000, 4, true, 140, true);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Prestige("BNGP65438642", "Puissant", "Chauffage", "Porsche", "911", 55000, 2, true, 155, false);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Prestige("REWQ64584356", "Puissant", "Air climatise", "Ferrari", "Enzo", 60000, 2, true, 170, true);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Prestige("MBKA68921443", "Puissant", "Siege chauffant", "Ferrari", "F430", 70000, 4, true, 185, false);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Prestige("JKBF53428654", "Puissant", "Toit ouvrant", "Aston Martin", "Venquish", 80000, 2, true, 200, true);
		catalogue.ajouterVehicule(vehicule);
		
		vehicule = new Utilitaire("CSSD54236789", "Puissant", "Air climatise", "Dodge", "Ram", 100000, 3, true, 100, 17, 50);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Utilitaire("MKAD69032402", "Standard", "Chauffage", "Dodge", "Voyageur", 110000, 3, true, 125, 19, 60);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Utilitaire("LAPQ52893051", "Puissant", "Radio", "Volvo", "F2000", 111000, 2, true, 150, 21, 70);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Utilitaire("MCLJ13782413", "Standard", "Groupe electrique", "Mack", "Version 1300", 111100, 2, true, 175, 23, 80);
		catalogue.ajouterVehicule(vehicule);
		vehicule = new Utilitaire("XAJF68439053", "Puissant", "Radio", "Birel", "Explorer", 111110, 3, true, 200, 26, 95);
		catalogue.ajouterVehicule(vehicule);
	}
	
	// Les getters et les setters se trouve ci-dessous
	
	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
