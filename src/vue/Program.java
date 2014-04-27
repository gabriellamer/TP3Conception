package vue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import controleur.Agence;
import model.Chauffeur;
import model.Client;
import model.Contrat;
import model.PersonneException;
import model.Vehicule;

public class Program {
	
	private static Agence locateur = new Agence("Le Locateur - Edition GP");
	
	public static void main(String[] args) {
		String choix;
		int iChoix;
		locateur = new Agence("Le Locateur - Edition GP");
		
		do {
			do {
				choix = afficherMenu();
				if (!Interface.validerEntier(choix, 1, 7))
					System.out.println("Veuillez entrer un nombre entier entre 1 et 6");
			} while (!Interface.validerEntier(choix, 1, 7));
			
			iChoix = Integer.parseInt(choix);
			
			switch (iChoix) {
				case 1 : ajouterClient(); break;
				case 2 : modifierClient(); break;
				case 3 : supprimerClient(); break;
				case 4 : ajouterReservation(); break;
				case 5 : modifierReservation(); break;
				case 6 : supprimerReservation(); break;
			}
		} while (iChoix < 6);
	}
	
	public static String afficherMenu() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1. Ajouter un client");
		System.out.println("2. Modifier un client");
		System.out.println("3. Supprimer un client");
		System.out.println("4. Ajouter une reservation");
		System.out.println("5. Modifier une reservation");
		System.out.println("6. Supprimer une reservation");
		System.out.println("7. Quitter");
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
		char autreChauffeur;
		Vehicule vehicule;
		Client client;
		
		ArrayList<Chauffeur> listeChauffeur = null;
		Chauffeur chauffeur;
		Calendar datePret;
		Calendar dateRetourPrevue;
		
		Interface.clearConsole();
		
		System.out.println("Nouvelle reservation!");
		
		client = saisitClient();
		
		do {
			vehicule = saisitVehicule();
			if (vehicule == null)
				System.out.println("Il n'y a pas de vehicule disponible selon vos criteres de recherche!");
		} while (vehicule == null);
		
		System.out.println("Votre vehicule : ");
		System.out.println("Immatriculation : " + vehicule.getImmatriculation());
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Modele : " + vehicule.getModele());
		System.out.println("Prix : " + vehicule.getPrix());
		
		System.out.println("Saisissez la date de pret : ");
		datePret = saisitDate(2014, 2020);
		System.out.println("Saisissez la date de retour prevue : ");
		dateRetourPrevue = saisitDate(2014, 2020);
		
		do {
			System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
			autreChauffeur = Interface.lecture().charAt(0);
			if ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n'));
		
		while ((autreChauffeur == 'O') || (autreChauffeur == 'o')) {
			
			chauffeur = saisitChauffeur();
			listeChauffeur.add(chauffeur);
			
			do {
				System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
				autreChauffeur = Interface.lecture().charAt(0);
				if ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((autreChauffeur != 'O') || (autreChauffeur != 'o') || (autreChauffeur != 'N') || (autreChauffeur != 'n'));
		}
		locateur.ajouterContrat(client, vehicule, datePret, dateRetourPrevue, listeChauffeur);
	}
				
	public static void modifierReservation() {
		Client client;
		Contrat contrat;
		Vehicule vehicule;
		Chauffeur chauffeur;
		Calendar datePret;
		Calendar dateRetourPrevue;
		String choixContrat;
		int iChoixContrat;				
		int compteurContrat = 1;
		char choixModifier;
		ArrayList<Chauffeur> listeChauffeur = null;
		
		client = saisitClient();
			
		do {
			System.out.println("Selectionner un contrat a modifier:");
			for (Contrat element : client.getListeContrat()) {
				System.out.println(compteurContrat++ + ". Contrat #" + element.getNoContrat() + " - " + element.getStatus());
			}
			System.out.println("Votre choix : ");
			choixContrat = Interface.lecture();
			if (!Interface.validerEntier(choixContrat, 1, compteurContrat-1))
				System.out.println("Veuillez entrer un entier entre 1 et " + (compteurContrat-1));
		} while (!Interface.validerEntier(choixContrat, 1, compteurContrat-1)); 
		
		iChoixContrat = Integer.parseInt(choixContrat);	
		contrat = client.getListeContrat().get(iChoixContrat);
		
		do {
			System.out.println("Voulez-vous modifier le vehicule? (O/N)");
			choixModifier = Interface.lecture().charAt(0);
			if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
		
		if ((choixModifier == 'O') || (choixModifier == 'o'))
			do {
				vehicule = saisitVehicule();
				if (vehicule == null)
					System.out.println("Il n'y a pas de vehicule disponible selon vos criteres de recherche!");
			} while (vehicule == null);
		else
			vehicule = contrat.getVehicule();
		
		do {
			System.out.println("Voulez-vous modifier la date de pret? (O/N)");
			choixModifier = Interface.lecture().charAt(0);
			if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
		
		if ((choixModifier == 'O') || (choixModifier == 'o')) {
			System.out.println("Saisissez la date de pret : ");
			datePret = saisitDate(2014, 2020);
		}
		else {
			datePret = contrat.getDatePret();
		}
		
		do {
			System.out.println("Voulez-vous modifier la date de retour prevue? (O/N)");
			choixModifier = Interface.lecture().charAt(0);
			if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
		
		if ((choixModifier == 'O') || (choixModifier == 'o')) {
			System.out.println("Saisissez la date de retour prevue : ");
			dateRetourPrevue = saisitDate(2014, 2020);
		}
		else {
			dateRetourPrevue = contrat.getDateRetourPrevue();
		}
		
		do {
			System.out.println("Voulez-vous modifier la liste des chauffeurs? (O/N)");
			choixModifier = Interface.lecture().charAt(0);
			if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
				System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
			}
		} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));

		if ((choixModifier == 'O') || (choixModifier == 'o')) {
			for (Chauffeur element : contrat.getListeChauffeur()) {
				do {
					System.out.println("Voulez-vous modifier le chauffeur " + element.getPrenom() + " " + element.getNom() + "? (O/N)");
					choixModifier = Interface.lecture().charAt(0);
					if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
						System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
					}
				} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
				
				if ((choixModifier == 'O') || (choixModifier == 'o')) {
					do {
						System.out.println("Voulez-vous modifier (M) ou supprimer (S) ce chauffeur?");
						choixModifier = Interface.lecture().charAt(0);
						if ((choixModifier != 'M') || (choixModifier != 'm') || (choixModifier != 'S') || (choixModifier != 's')) {
							System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
						}
					} while ((choixModifier != 'M') || (choixModifier != 'm') || (choixModifier != 'S') || (choixModifier != 's'));
					
					if ((choixModifier == 'S') || (choixModifier == 's')) {
						contrat.getListeChauffeur().remove(element);
					}
					else {
						do {
							System.out.println("Voulez-vous modifier le prenom du chauffeur? (O/N)");
							choixModifier = Interface.lecture().charAt(0);
							if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
								System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
							}
						} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
						
						if ((choixModifier == 'O') || (choixModifier == 'o')) {
							System.out.println("Saisissez le prenom du chauffeur : ");
							try {
								element.setPrenom(Interface.lecture());
							} catch (PersonneException e) {
								e.printErreur();
							}
						}
						
						do {
							System.out.println("Voulez-vous modifier le nom du chauffeur? (O/N)");
							choixModifier = Interface.lecture().charAt(0);
							if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
								System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
							}
						} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
						
						if ((choixModifier == 'O') || (choixModifier == 'o')) {
							System.out.println("Saisissez le nom du chauffeur : ");
							try {
								element.setNom(Interface.lecture());
							} catch (PersonneException e) {
								e.printErreur();
							}
						}
						
						do {
							System.out.println("Voulez-vous modifier le numero de permis de conduire du chauffeur? (O/N)");
							choixModifier = Interface.lecture().charAt(0);
							if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
								System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
							}
						} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
						
						if ((choixModifier == 'O') || (choixModifier == 'o')) {
							System.out.println("Saisissez le numero de permis de conduire du chauffeur : ");
							try {
								element.setNoPermis(Interface.lecture());
							} catch (PersonneException e) {
								e.printErreur();
							}
						}
						
						do {
							System.out.println("Voulez-vous modifier le prenom du chauffeur? (O/N)");
							choixModifier = Interface.lecture().charAt(0);
							if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
								System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
							}
						} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
						
						if ((choixModifier == 'O') || (choixModifier == 'o')) {
							System.out.println("Saisissez la date de naissance du chauffeur : ");
							try {
								element.setDateNaissance(saisitDate(1900, 2000));
							} catch (PersonneException e) {
								e.printErreur();
							}
						}
					}
				}
			}
			
			do {
				System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
			
			while ((choixModifier == 'O') || (choixModifier == 'o')) {
				
				chauffeur = saisitChauffeur();
				contrat.getListeChauffeur().add(chauffeur);
				
				do {
					System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
					choixModifier = Interface.lecture().charAt(0);
					if ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n')) {
						System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
					}
				} while ((choixModifier != 'O') || (choixModifier != 'o') || (choixModifier != 'N') || (choixModifier != 'n'));
			}
		}
		else {
			listeChauffeur = contrat.getListeChauffeur();
		}
			
		locateur.modifierContrat(contrat, client, vehicule, datePret, dateRetourPrevue, listeChauffeur);
	}
	
	public static Chauffeur saisitChauffeur() {
		Chauffeur chauffeur = null;
		String prenom;
		String nom;
		char sexe;
		String noPermis;
		Calendar dateNaissance;
		
		System.out.println("Saississez le prenom du chauffeur : ");
		prenom = Interface.lecture();
		System.out.println("Saississez le nom du chauffeur : ");
		nom = Interface.lecture();
		System.out.println("Saississez le sexe du chauffeur : ");
		sexe = Interface.lecture().charAt(0);
		System.out.println("Saississez le numero de permis de conduire : ");
		noPermis = Interface.lecture();
		
		System.out.println("Saisissez la date de naissance du chauffeur : ");
		dateNaissance = saisitDate(1900, 2000);
		
		try {
			chauffeur = new Chauffeur(nom, prenom, dateNaissance, sexe, noPermis);
		} catch (PersonneException e) {
			e.printErreur();
		}
		
		return chauffeur;
	}
	
	
	
	public static void supprimerReservation() {
		Client client;
		Contrat contrat;
		int compteurContrat = 1;
		
		String choixContrat;
		int iChoixContrat;
		
		client = saisitClient();
		
		do {
			System.out.println("Selectionner un contrat a supprimer:");
			for (Contrat element : client.getListeContrat()) {
				System.out.println(compteurContrat++ + ". Contrat #" + element.getNoContrat() + " - " + element.getStatus());
			}
			System.out.println("Votre choix : ");
			choixContrat = Interface.lecture();
			if (!Interface.validerEntier(choixContrat, 1, compteurContrat-1))
				System.out.println("Veuillez entrer un entier entre 1 et " + (compteurContrat-1));
		} while (!Interface.validerEntier(choixContrat, 1, compteurContrat-1)); 
		
		iChoixContrat = Integer.parseInt(choixContrat);
		
		contrat = client.getListeContrat().get(iChoixContrat);
		
		locateur.supprimerContrat(client, contrat);
	}
	
	public static GregorianCalendar saisitDate(int anneeDebut, int anneeFin) {	
		String naissanceAnnee;
		String naissanceJour;
		String naissanceMois;
		int iNaissanceAnnee;
		int iNaissanceJour;
		int iNaissanceMois;
		
		do {
			System.out.println("Saississez l'annee : ");
			naissanceAnnee = Interface.lecture();
			if (!Interface.validerEntier(naissanceAnnee, anneeDebut, anneeFin))
				System.out.println("Veuillez entrer une annee valide!");
		} while (!Interface.validerEntier(naissanceAnnee, anneeDebut, anneeFin));
		
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
	
	public static Vehicule saisitVehicule() {
		Vehicule vehicule = null;
		String choixVehicule;
		int iChoixVehicule;
		
		do {
			System.out.println("Selectionner un type de vehicule");
			System.out.println("1. Vehicule simple");
			System.out.println("2. Vehicule prestige");
			System.out.println("3. Vehicule utilitaire");
			System.out.println("Votre choix : ");
			choixVehicule = Interface.lecture();
			if (!Interface.validerEntier(choixVehicule, 1, 3))
				System.out.println("Veuillez entrer un nombre entier entre 1 et 3");
		} while (!Interface.validerEntier(choixVehicule, 1, 3));
		
		iChoixVehicule = Integer.parseInt(choixVehicule);
		vehicule = locateur.getCatalogue().getVehicule(iChoixVehicule);
		
		return vehicule;
	}
	
	public static Client saisitClient() {
		Client client = null;
		int compteurClient = 1;
		String choixClient;
		int iChoixClient = 0;
		
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
		
		return client;
	}
	
}
