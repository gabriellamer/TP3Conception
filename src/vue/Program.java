package vue;

import controleur.Agence;
import model.Client;
import model.Vehicule;

public class Program {
	
	private static Agence locateur = new Agence("Le Locateur - Edition GP");
	
	public static void main(String[] args) {
		int choix;
		locateur = new Agence("Le Locateur - Edition GP");
		
		choix = afficherMenu();
		
		switch (choix) {
			case 1 : ajouterClient(); break;
			case 2 : modifierClient(); break;
			case 3 : supprimerClient(); break;
			case 4 : ajouterReservation(); break;
			case 5 : modifierReservation(); break;
			case 6 : supprimerReservation(); break;
		}
		
		

	}
	
	public static int afficherMenu() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1. Ajouter un client");
		System.out.println("2. Modifier un client");
		System.out.println("3. Supprimer un client");
		System.out.println("4. Ajouter une reservation");
		System.out.println("5. Modifier une reservation");
		System.out.println("6. Supprimer une reservation");
		System.out.println("Votre choix : ");
		
		return 0;
	}
	
	public static void ajouterClient() {
		
	}
	public static void modifierClient() {
		
	}
	public static void supprimerClient() {
		
	}
	public static void ajouterReservation() {
		// Clear console
		int compteurClient = 1;
		int choixClient;
		int choixVehicule = 0;
		Vehicule vehicule;
		
		System.out.println("Nouvelle reservation!");
		
		for (Client element : locateur.getCatalogue().getListeClient()) {
			System.out.println(compteurClient + ". "); // TODO complete
		}
		
		System.out.println("Selectionner un type de vehicule");
		System.out.println("1. Vehicule simple");
		System.out.println("2. Vehicule prestige");
		System.out.println("3. Vehicule utilitaire");
		System.out.println("Votre choix : ");
		
		vehicule = locateur.getCatalogue().getVehicule(choixVehicule);
		
	}
	public static void modifierReservation() {
		
	}
	public static void supprimerReservation() {
		
	}
}
