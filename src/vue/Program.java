package vue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import controleur.Agence;
import model.Chauffeur;
import model.Client;
import model.Vehicule;

public class Program {
	
	private static Agence locateur = new Agence("Le Locateur - Edition GP");
	
	public static void main(String[] args) {
		String choix;
		int iChoix;
		locateur = new Agence("Le Locateur - Edition GP");
		
		do {
			choix = afficherMenu();
			if (!Interface.validerEntier(choix, 1, 6))
				System.out.println("Veuillez entrer un nombre entier entre 1 et 6");
		} while (!Interface.validerEntier(choix, 1, 6));
		
		iChoix = Integer.parseInt(choix);
		
		switch (iChoix) {
			case 1 : ajouterClient(); break;
			case 2 : modifierClient(); break;
			case 3 : supprimerClient(); break;
			case 4 : ajouterReservation(); break;
			case 5 : modifierReservation(); break;
			case 6 : supprimerReservation(); break;
		}
		
		

	}
	
	public static String afficherMenu() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1. Ajouter un client");
		System.out.println("2. Modifier un client");
		System.out.println("3. Supprimer un client");
		System.out.println("4. Ajouter une reservation");
		System.out.println("5. Modifier une reservation");
		System.out.println("6. Supprimer une reservation");
		System.out.println("Votre choix : ");
		
		return Interface.lecture();
	}
	
	public static void ajouterClient() {
		
	}
	public static void modifierClient() {
		
	}
	public static void supprimerClient() {
		
	}
	public static void ajouterReservation() {
		int compteurClient = 1;
		String choixClient;
		int iChoixClient = 0;
		String choixVehicule;
		int iChoixVehicule = 0;
		char autreChauffeur;
		Vehicule vehicule;
		Client client;
		
		ArrayList<Chauffeur> listeChauffeur = null;
		Chauffeur chauffeur;
		String nom;
		String prenom;
		char sexe;
		String noPermis;
		Calendar dateNaissance;
		Calendar datePret;
		Calendar dateRetourPrevue;
		
		Interface.clearConsole();
		
		System.out.println("Nouvelle reservation!");
		
		do {
			System.out.println("Selectionner un client");
			for (Client element : locateur.getCatalogue().getListeClient()) {
				System.out.println(compteurClient++ + ". " + element.getNoPermis() + " - " + element.getNom() + ", " + element.getPrenom());
			}
			System.out.println("Votre choix : ");
			choixClient = Interface.lecture();	
			if (!Interface.validerEntier(choixClient, 1, compteurClient-1))
				System.out.println("Veuillez entrer un nombre entier entre 1 et " + (compteurClient-1));
		} while (!Interface.validerEntier(choixClient, 1, compteurClient-1));
		
		iChoixClient = Integer.parseInt(choixClient);
		client = locateur.getCatalogue().getListeClient().get(iChoixClient);
		
		do {
			System.out.println("Selectionner un type de vehicule");
			System.out.println("1. Vehicule simple");
			System.out.println("2. Vehicule prestige");
			System.out.println("3. Vehicule utilitaire");
			System.out.println("Votre choix : ");
			choixVehicule = Interface.lecture();
			if (!Interface.validerEntier(choixClient, 1, 3))
				System.out.println("Veuillez entrer un nombre entier entre 1 et 3");
		} while (!Interface.validerEntier(choixClient, 1, 3));
		
		iChoixVehicule = Integer.parseInt(choixVehicule);
		vehicule = locateur.getCatalogue().getVehicule(iChoixVehicule);
		
		System.out.println("Votre vehicule : ");
		System.out.println("Immatriculation : " + vehicule.getImmatriculation());
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Modele : " + vehicule.getModele());
		System.out.println("Prix : " + vehicule.getPrix());
		
		System.out.println("Saisissez la date de pret : ");
		datePret = saisitDate();
		System.out.println("Saisissez la date de retour prevue : ");
		dateRetourPrevue = saisitDate();
		
		do {
			System.out.println("Voulez-vous ajouter un chaffeur ? (O/N)");
			autreChauffeur = Interface.lecture().charAt(0);
			if ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n'));
		
		while ((autreChauffeur == 'O') || (autreChauffeur == 'o')) {
			System.out.println("Saississez le prenom du chauffeur : ");
			prenom = Interface.lecture();
			System.out.println("Saississez le nom du chauffeur : ");
			nom = Interface.lecture();
			System.out.println("Saississez le sexe du chauffeur : ");
			sexe = Interface.lecture().charAt(0);
			System.out.println("Saississez le numero de permis de conduire : ");
			noPermis = Interface.lecture();
			
			System.out.println("Saisissez la date de naissance du chauffeur : ");
			dateNaissance = saisitDate();
			
			chauffeur = new Chauffeur(nom, prenom, dateNaissance, sexe, noPermis);
			
			listeChauffeur.add(chauffeur);
		}
		locateur.ajouterContrat(client, vehicule, datePret, dateRetourPrevue, listeChauffeur);
	}
				
	public static void modifierReservation() {
		
	}
	public static void supprimerReservation() {
		
	}
	
	public static GregorianCalendar saisitDate() {	
		String naissanceAnnee;
		String naissanceJour;
		String naissanceMois;
		int iNaissanceAnnee;
		int iNaissanceJour;
		int iNaissanceMois;
		
		do {
			System.out.println("Saississez l'annee : ");
			naissanceAnnee = Interface.lecture();
			if (!Interface.validerEntier(naissanceAnnee, 1900, 2000))
				System.out.println("Veuillez entrer une annee valide!");
		} while (!Interface.validerEntier(naissanceAnnee, 1900, 2000));
		
		do {
			System.out.println("Saississez le mois : ");
			naissanceMois = Interface.lecture();
			if (!Interface.validerEntier(naissanceMois, 1, 12))
				System.out.println("Veuillez entrer un mois valide!");
		} while (!Interface.validerEntier(naissanceMois, 1, 12));
		
		do {
			System.out.println("Saississez le jour : ");
			naissanceJour = Interface.lecture();
			if (!Interface.validerEntier(naissanceMois, 1, 31))
				System.out.println("Veuillez entrer un jour valide!");
		} while (!Interface.validerEntier(naissanceMois, 1, 31));
		
		iNaissanceAnnee = Integer.parseInt(naissanceAnnee);
		iNaissanceMois = Integer.parseInt(naissanceMois);
		iNaissanceJour = Integer.parseInt(naissanceJour);
		
		return new GregorianCalendar(iNaissanceAnnee, iNaissanceMois, iNaissanceJour);
	}
}
