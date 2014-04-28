package vue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import controleur.Agence;
import model.Chauffeur;
import model.Client;
import model.Contrat;
import model.PersonneException;
import model.Vehicule;

// Programme principal
public class Program {
	
	private static Agence locateur = new Agence("Le Locateur - Edition GP"); // Agence (Controleur)
	
	public static void main(String[] args) {
		String choix; // Choix de l'utilisateur au menu principal
		int iChoix;
		locateur = new Agence("Le Locateur - Edition GP"); // Creation de l'agence (controleur)
		
		// Nous avons "harcoder" des vehicules puisque la gestion des vehicules ne faisait pas partie de nos cas d'utilisations
		locateur.ajouterVehicule();
		
		// Client se trouvant dans l'application au lancement
		locateur.ajouterClient("Lamer", "Gabriel", new GregorianCalendar(1992, 11, 05), 'M', "L213405978701", "0123467289", "Visa", "9078563436456778", "11/15", "321", 953, "2", "Arpin", "Sorel", "Quebec", "j3p7t8");
		
		do {
			do {
				choix = afficherMenu(); // Affichage du menu principal
				if (!Interface.validerEntier(choix, 1, 7))
					System.out.println("Veuillez entrer un nombre entier entre 1 et 6");
			} while (!Interface.validerEntier(choix, 1, 7));
			
			iChoix = Integer.parseInt(choix);
			
			switch (iChoix) {
				case 1 : ajouterClient(); break;           // Ajouter un client
				case 2 : modifierClient(); break;          // Modifier un client
				case 3 : supprimerClient(); break;         // Supprimer un client
				case 4 : ajouterReservation(); break;      // Ajouter une reservation
				case 5 : modifierReservation(); break;     // Modifier une reservation
				case 6 : supprimerReservation(); break;    // Supprimer une reservation
			}
		} while (iChoix < 7);                              // L'application se ferme
	}
	
	// Affichage du menu principal
	// Parametre : Aucun
	// Valeur de retour : Choix de l'utilisateur
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
	
	// Methode permettant d'ajouter un client
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void ajouterClient() {
		System.out.println("Creation d'un nouveau client!");
		
		String nom;                   // Nom du client
		String prenom;                // Prenom du client
		Calendar dateNaissance;       // Date de naissance d'un client
		char sexe;                    // Sexe du client
		String noPermis;      		  // Numero de permis de conduire
		String noTelephone;			  // Numero de telephone
		String typeCarte;             // Type de carte de credit
		String noCarte;               // Numero de carte de credit
		String expiration;            // Expiration de la carte de credit
		String cvv;                   // Code de securite de la carte de credit
		int noCivique;                // Numero civique de l'adresse du client
		String noApp;                 // Numero d'appartement du client
		String nomRue;                // Nom de la rue du client
		String ville;                 // Ville du client
		String province;              // Province du client
		String codePostal;            // Code postal du client
		
		String temp;
		
		System.out.println("Saisissez votre nom :");
		nom = Interface.lecture();
		System.out.println("Saisissez votre prenom :");
		prenom = Interface.lecture();
		System.out.println("Saisissez votre date de naissance :");
		dateNaissance = saisitDate(1900, 2000);
		System.out.println("Saisissez votre sexe :");
		sexe = Interface.lecture().charAt(0);
		System.out.println("Saisissez votre numero de permis de conduire (X012345678921) :");
		noPermis = Interface.lecture();
		System.out.println("Saisissez votre numero de telephone (0123456789) :");
		noTelephone = Interface.lecture();
		System.out.println("Saisissez votre type de carte de credit :");
		typeCarte = Interface.lecture();
		System.out.println("Saisissez votre numero de carte de credit :");
		noCarte = Interface.lecture();
		System.out.println("Saisissez le cvv de votre carte de credit :");
		cvv = Interface.lecture();
		System.out.println("Saisissez la date d'expiration de votre carte de credit (MM/AA) :");
		expiration = Interface.lecture();
		
		do {
			System.out.println("Saisissez votre numero civique :");
			temp = Interface.lecture();
			if (!Interface.validerEntier(temp, 1, 999999999)) {
				System.out.println("Veuillez saisir un numero civique entier!");
			}
		} while (!Interface.validerEntier(temp, 1, 999999999));
		
		noCivique = Integer.parseInt(temp);
		
		System.out.println("Saisissez votre numero d'appartement :");
		noApp = Interface.lecture();
		System.out.println("Saisissez votre nom de rue :");
		nomRue = Interface.lecture();
		System.out.println("Saisissez votre ville :");
		ville = Interface.lecture();
		System.out.println("Saisissez votre province :");
		province = Interface.lecture();
		System.out.println("Saisissez votre code postal :");
		codePostal = Interface.lecture();
		
		// On passe toutes les informations concernant l'ajout d'un client a l'agence (Controleur)
		locateur.ajouterClient(nom, prenom, dateNaissance, sexe, noPermis, noTelephone, typeCarte, noCarte, expiration, cvv, noCivique, noApp, nomRue, ville, province, codePostal);
	}
	
	// Methode permettant de modifier un client
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void modifierClient() {
		Client client;             // Client que l'on veut modifier
		char choixModifier;        // Permet de determiner quels champs que l'on veut modifier
		
		String nom;                // Nom
		String prenom;             // Prenom
		Calendar dateNaissance;    // Date de naissance
		char sexe;                 // Sexe
		String noPermis;           // Numero de permis de conduire
		String noTelephone;        // Numero de telephone
		String typeCarte;          // Type de carte de credit
		String noCarte;            // Numero de carte de credit
		String expiration;         // Expiration de la carte de credit
		String cvv;                // Code de securite de la carte de credit
		int noCivique;             // Numero civique de l'addresse
		String noApp;              // Numero d'appartement
		String nomRue;             // Nom de la rue du client
		String ville;              // Ville du client
		String province;           // Province du client
		String codePostal;         // Code postal du client
		
		String temp;
		
		client = saisitClient(); // Recherche du client que l'on veut modifier
		
		// S'il y a des clients dans l'application
		if (client != null) {
			
			// Modification du nom
			do {
				System.out.println("Voulez-vous modifier votre nom ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre nom : ");
				nom = Interface.lecture();
			}
			else {
				nom = client.getNom();
			}
			
			// Modification du prenom
			do {
				System.out.println("Voulez-vous modifier votre prenom ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre prenom : ");
				prenom = Interface.lecture();
			}
			else {
				prenom = client.getPrenom();
			}
			
			// Modification de la date de naissance
			do {
				System.out.println("Voulez-vous modifier votre date de naissance ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre date de naissance : ");
				dateNaissance = saisitDate(1900, 2000);
			}
			else {
				dateNaissance = client.getDateNaissance();
			}
			
			// Modification du sexe
			do {
				System.out.println("Voulez-vous modifier votre sexe ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre sexe : ");
				sexe = Interface.lecture().charAt(0);
			}
			else {
				sexe = client.getSexe();
			}
			
			// Modification du numero de permis de conduire
			do {
				System.out.println("Voulez-vous modifier votre numero de permis de conduire ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre numero de permis de conduire : ");
				noPermis = Interface.lecture();
			}
			else {
				noPermis = client.getNoPermis();
			}
			
			// Modification du numero de telephone
			do {
				System.out.println("Voulez-vous modifier votre numero de telephone ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre numero de telephone : ");
				noTelephone = Interface.lecture();
			}
			else {
				noTelephone = client.getNoTelephone();
			}
			
			// Modification du type de carte de credit
			do {
				System.out.println("Voulez-vous modifier votre type de carte de credit ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre type de carte de credit : ");
				typeCarte = Interface.lecture();
			}
			else {
				typeCarte = client.getTypeCarte();
			}
			
			// Modification du numero de carte de credit
			do {
				System.out.println("Voulez-vous modifier votre numero de carte de credit ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre numero de carte de credit : ");
				noCarte = Interface.lecture();
			}
			else {
				noCarte = client.getNoCarte();
			}
			
			// Modification de l'expiration de la carte de credit
			do {
				System.out.println("Voulez-vous modifier votre expiration de carte de credit ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre expiration de votre carte de credit : ");
				expiration = Interface.lecture();
			}
			else {
				expiration = client.getExpiration();
			}
			
			// Modification du code de securite de la carte de credit
			do {
				System.out.println("Voulez-vous modifier votre cvv de carte de credit ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre cvv de votre carte de credit : ");
				cvv = Interface.lecture();
			}
			else {
				cvv = client.getCvv();
			}
			
			// Modification du numero civique de l'adresse
			do {
				System.out.println("Voulez-vous modifier votre numero civique ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				do {
					System.out.println("Saisissez votre numero civique :");
					temp = Interface.lecture();
					if (!Interface.validerEntier(temp, 1, 999999999)) {
						System.out.println("Veuillez saisir un numero civique entier!");
					}
				} while (!Interface.validerEntier(temp, 1, 999999999));
				noCivique = Integer.parseInt(temp);
			}
			else {
				noCivique = client.getAdresse().getNoCivique();
			}
			
			// Modification du numero d'appartement de l'addresse
			do {
				System.out.println("Voulez-vous modifier votre numero d'appartement ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre numero d'appartement : ");
				noApp = Interface.lecture();
			}
			else {
				noApp = client.getAdresse().getNoApp();
			}
			
			// Modification du nom de la rue de l'adresse
			do {
				System.out.println("Voulez-vous modifier votre nom de rue ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre nom de rue : ");
				nomRue = Interface.lecture();
			}
			else {
				nomRue = client.getAdresse().getNomRue();
			}
			
			// Modification de la ville du client
			do {
				System.out.println("Voulez-vous modifier votre ville ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre ville : ");
				ville = Interface.lecture();
			}
			else {
				ville = client.getAdresse().getVille();
			}
			
			// Modification de la province du client
			do {
				System.out.println("Voulez-vous modifier votre province ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre province : ");
				province = Interface.lecture();
			}
			else {
				province = client.getAdresse().getProvince();
			}
			
			// Modification du code postal du client
			do {
				System.out.println("Voulez-vous modifier votre code postal ? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez votre code postal : ");
				codePostal = Interface.lecture();
			}
			else {
				codePostal = client.getAdresse().getCodePostal();
			}
			
			// Utilisateur de l'agence (controleur) pour modifier le client
			locateur.modifierClient(client, nom, prenom, dateNaissance, sexe, noPermis, noTelephone, typeCarte, noCarte, expiration, cvv, noCivique, noApp, nomRue, ville, province, codePostal);
		}
	}
	
	// Methode permettant de supprimer un client
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void supprimerClient() {
		Client client; // Client que l'on veut supprimer
		
		// Recherche du client que l'on veut supprimer
		client = saisitClient();
		
		// S'il y a des clients dans la liste de clients
		if (client != null)
			// Utilisateur de l'agence (controleur) pour supprimer le client
			locateur.supprimerClient(client);
	}
	
	// Methode permettant d'ajouteur une reservation a un client
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void ajouterReservation() {
		char autreChauffeur; // Pour verifier si l'on veut saisir un autre chauffeur a la fin de l'ajout
		Vehicule vehicule;   // Vehicule concerner par la reservation
		Client client;       // Client concerner par la reservation
		
		ArrayList<Chauffeur> listeChauffeur = new ArrayList<Chauffeur>(); // Liste des chauffeurs
		Chauffeur chauffeur;         // Un chauffeur
		Calendar datePret;           // Date a laquelle le client prend possession du vehicule
		Calendar dateRetourPrevue;	 // Date a laquelle le client devrait rapporter le vehicule
		
		System.out.println("Creation d'une nouvelle reservation!");
		
		client = saisitClient(); // Recherche du client dans la liste des clients
		
		// S'il y a des clients dans la liste des clients
		if (client != null) {
			do {
				vehicule = saisitVehicule(); // Recherche du vehicule selon une categorie
				// S'il n'y a pas de vehicule de disponible, on recommence la recherche
				if (vehicule == null)
					System.out.println("Il n'y a pas de vehicule disponible selon vos criteres de recherche!");
			} while (vehicule == null);
			
			// Vehicule qui a ete assigner a la reservation du client
			System.out.println("Votre vehicule : ");
			System.out.println("Immatriculation : " + vehicule.getImmatriculation());
			System.out.println("Marque : " + vehicule.getMarque());
			System.out.println("Modele : " + vehicule.getModele());
			System.out.println("Prix : " + vehicule.getPrix());
			
			// Date a laquelle le client va prendre possession du vehicule
			System.out.println("Saisissez la date de pret : ");
			datePret = saisitDate(2014, 2020);
			
			// Date a laquelle le client devrait rapporter le vehicule
			System.out.println("Saisissez la date de retour prevue : ");
			dateRetourPrevue = saisitDate(2014, 2020);
			
			// Demande a l'utilisateur s'il y a des chauffeurs assigner a la reservation
			do {
				System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
				autreChauffeur = Interface.lecture().charAt(0);
				if ((autreChauffeur != 'O') && (autreChauffeur != 'o') && (autreChauffeur != 'N') && (autreChauffeur != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((autreChauffeur != 'O') && (autreChauffeur != 'o') && (autreChauffeur != 'N') && (autreChauffeur != 'n'));
			
			// Tant qu'il y a des chauffeurs a ajouter a la reservation
			while ((autreChauffeur == 'O') || (autreChauffeur == 'o')) {
				
				chauffeur = saisitChauffeur(); // Saisit des informations concernant un chauffeur
				listeChauffeur.add(chauffeur); // Ajout du chauffeur a la liste des chauffeurs
				
				// Demande a l'utilisateur s'il y a d'autres chauffeurs a ajouter
				do {
					System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
					autreChauffeur = Interface.lecture().charAt(0);
					if ((autreChauffeur != 'O') && (autreChauffeur != 'o') && (autreChauffeur != 'N') && (autreChauffeur != 'n')) {
						System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
					}
				} while ((autreChauffeur != 'O') && (autreChauffeur != 'o') && (autreChauffeur != 'N') && (autreChauffeur != 'n'));
			}
			
			// On utilise l'agence (controleur) pour ajouter le contrat a la liste des contrats du client
			locateur.ajouterContrat(client, vehicule, datePret, dateRetourPrevue, listeChauffeur);
		}
	}
	
	// Methode permettant de modifier une reservation
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void modifierReservation() {
		Client client;                    // Client pour lequel on modifie une reservation
		Contrat contrat;                  // Contrat que l'on modifie
		Vehicule vehicule;                // Nouveau vehicule sur le contrat
		Chauffeur chauffeur;              // Nouveau(x) chauffeur(s) sur le contrat
		Calendar datePret;                // Date de pret
		Calendar dateRetourPrevue;        // Date de retour prevue
		String choixContrat;              // Choix du contrat a modifier
		int iChoixContrat;				  // Idem
		
		int compteurContrat = 1;          // Compteur de contrat
		char choixModifier;               // Permet de determiner quels champs on veut modifier
		ArrayList<Chauffeur> listeChauffeur = new ArrayList<Chauffeur>(); // Liste des chauffeurs
		
		// Recherche du client pour lequel on veut modifier une reservation
		client = saisitClient();
		
		// S'il y a des clients dans la liste des clients
		if (client != null) {
			// Choix du contrat du client a modifier
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
			contrat = client.getListeContrat().get(iChoixContrat-1);
			
			// Modification du vehicule
			do {
				System.out.println("Voulez-vous modifier le vehicule? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				do {
					vehicule = saisitVehicule(); // Recherche du nouveau vehicule
					if (vehicule == null)
						System.out.println("Il n'y a pas de vehicule disponible selon vos criteres de recherche!");
				} while (vehicule == null);
				
				// Affichage du nouveau vehicule s'il a ete modifier
				System.out.println("Votre vehicule : ");
				System.out.println("Immatriculation : " + vehicule.getImmatriculation());
				System.out.println("Marque : " + vehicule.getMarque());
				System.out.println("Modele : " + vehicule.getModele());
				System.out.println("Prix : " + vehicule.getPrix());
			}	
			else {
				vehicule = contrat.getVehicule();
			}
			
			// Modification de la date de pret de la reservation
			do {
				System.out.println("Voulez-vous modifier la date de pret? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez la date de pret : ");
				datePret = saisitDate(2014, 2020);
			}
			else {
				datePret = contrat.getDatePret();
			}
			
			// Modification de la date de retour prevue de la reservation
			do {
				System.out.println("Voulez-vous modifier la date de retour prevue? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
			
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				System.out.println("Saisissez la date de retour prevue : ");
				dateRetourPrevue = saisitDate(2014, 2020);
			}
			else {
				dateRetourPrevue = contrat.getDateRetourPrevue();
			}
			
			// Modification de la liste des chauffeurs
			do {
				System.out.println("Voulez-vous modifier la liste des chauffeurs? (O/N)");
				choixModifier = Interface.lecture().charAt(0);
				if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
					System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
				}
			} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
	
			if ((choixModifier == 'O') || (choixModifier == 'o')) {
				// Pour chacun des chauffeurs, on demande s'il y a des modifications a apporter
				for (Chauffeur element : contrat.getListeChauffeur()) {
					do {
						System.out.println("Voulez-vous modifier le chauffeur " + element.getPrenom() + " " + element.getNom() + "? (O/N)");
						choixModifier = Interface.lecture().charAt(0);
						if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
							System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
						}
					} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
					
					if ((choixModifier == 'O') || (choixModifier == 'o')) {
						// Demande si on veut modifier ou supprimer le chauffeur
						do {
							System.out.println("Voulez-vous modifier (M) ou supprimer (S) ce chauffeur?");
							choixModifier = Interface.lecture().charAt(0);
							if ((choixModifier != 'M') && (choixModifier != 'm') && (choixModifier != 'S') && (choixModifier != 's')) {
								System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
							}
						} while ((choixModifier != 'M') && (choixModifier != 'm') && (choixModifier != 'S') && (choixModifier != 's'));
						
						if ((choixModifier == 'S') || (choixModifier == 's')) {
							contrat.getListeChauffeur().remove(element);
						}
						else {
							// Modification du prenom
							do {
								System.out.println("Voulez-vous modifier le prenom du chauffeur? (O/N)");
								choixModifier = Interface.lecture().charAt(0);
								if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
									System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
								}
							} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
							
							if ((choixModifier == 'O') || (choixModifier == 'o')) {
								System.out.println("Saisissez le prenom du chauffeur : ");
								try {
									element.setPrenom(Interface.lecture());
								} catch (PersonneException e) {
									e.printErreur();
								}
							}
							
							// Modification du nom
							do {
								System.out.println("Voulez-vous modifier le nom du chauffeur? (O/N)");
								choixModifier = Interface.lecture().charAt(0);
								if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
									System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
								}
							} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
							
							if ((choixModifier == 'O') || (choixModifier == 'o')) {
								System.out.println("Saisissez le nom du chauffeur : ");
								try {
									element.setNom(Interface.lecture());
								} catch (PersonneException e) {
									e.printErreur();
								}
							}
							
							// Modification du numero de permis de conduire
							do {
								System.out.println("Voulez-vous modifier le numero de permis de conduire du chauffeur? (O/N)");
								choixModifier = Interface.lecture().charAt(0);
								if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
									System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
								}
							} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
							
							if ((choixModifier == 'O') || (choixModifier == 'o')) {
								System.out.println("Saisissez le numero de permis de conduire du chauffeur : ");
								try {
									element.setNoPermis(Interface.lecture());
								} catch (PersonneException e) {
									e.printErreur();
								}
							}
							
							// Modification de la date de naissance du chauffeur
							do {
								System.out.println("Voulez-vous modifier la date de naissance du chauffeur? (O/N)");
								choixModifier = Interface.lecture().charAt(0);
								if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
									System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
								}
							} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
							
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
				
				// Ajouter de nouveaux chauffeurs a la liste des chauffeurs
				do {
					System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
					choixModifier = Interface.lecture().charAt(0);
					if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
						System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
					}
				} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
				
				// Tant qu'il y a des chauffeurs a ajouter
				while ((choixModifier == 'O') || (choixModifier == 'o')) {
					
					chauffeur = saisitChauffeur();
					contrat.getListeChauffeur().add(chauffeur);
					
					do {
						System.out.println("Voulez-vous ajouter un chauffeur ? (O/N)");
						choixModifier = Interface.lecture().charAt(0);
						if ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n')) {
							System.out.println("Vous devez choisir entre Oui (O) ou Non(N)!");
						}
					} while ((choixModifier != 'O') && (choixModifier != 'o') && (choixModifier != 'N') && (choixModifier != 'n'));
				}
			}
			else {
				listeChauffeur = contrat.getListeChauffeur();
			}
			
			// On utilise l'agence (controleur) pour modifier le contrat de reservation d'un client
			locateur.modifierContrat(contrat, client, vehicule, datePret, dateRetourPrevue, listeChauffeur);
		}
	}
	
	// Methode permettant de saisir les chauffeurs au clavier
	// Parametre : Aucun
	// Valeur de retour : Un chauffeur
	public static Chauffeur saisitChauffeur() {
		Chauffeur chauffeur = null;		// Un chauffeur
		String prenom;                  // Prenom du chauffeur
		String nom;                     // Nom du chauffeur
		char sexe;                      // Sexe du chauffeur
		String noPermis;                // Numero de permis de conduire du chauffeur
		Calendar dateNaissance;         // Date de naissance du chauffeur
		
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
	
	// Methode permettant de supprimer une reservation
	// Parametre : Aucun
	// Valeur de retour : Aucun
	public static void supprimerReservation() {
		Client client;           
		Contrat contrat;
		int compteurContrat = 1;
		
		String choixContrat;
		int iChoixContrat;
		
		client = saisitClient(); // Recherche du client
		if (client != null) {
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
			
			contrat = client.getListeContrat().get(iChoixContrat-1);
			
			// Utilisation de l'agence (controleur) pour supprimer un contrat
			locateur.supprimerContrat(client, contrat);
		}
	}
	
	// Saisir la date, puis retourner une date selon un calendrier gregorien
	public static GregorianCalendar saisitDate(int anneeDebut, int anneeFin) {	
		String naissanceAnnee; // Annee de la date
		String naissanceJour;  // Jour de la date
		String naissanceMois;  // Mois de la date
		int iNaissanceAnnee;
		int iNaissanceJour;
		int iNaissanceMois;
		
		// Annee de la date
		do {
			System.out.println("Saississez l'annee : ");
			naissanceAnnee = Interface.lecture();
			if (!Interface.validerEntier(naissanceAnnee, anneeDebut, anneeFin))
				System.out.println("Veuillez entrer une annee valide!");
		} while (!Interface.validerEntier(naissanceAnnee, anneeDebut, anneeFin));
		
		// Mois de la date
		do {
			System.out.println("Saississez le mois : ");
			naissanceMois = Interface.lecture();
			if (!Interface.validerEntier(naissanceMois, 1, 12))
				System.out.println("Veuillez entrer un mois valide!");
		} while (!Interface.validerEntier(naissanceMois, 1, 12));
		
		// Jour de la date
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
	
	// Methode permettant d'obtenir un vehicule
	// Parametre : Aucun
	// Valeur de retour : Un vehicule
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
		
		// Utilisation de l'agence pour obtenir un vehicule selon un type de vehicule
		vehicule = locateur.getCatalogue().getVehicule(iChoixVehicule);
		
		return vehicule;
	}
	
	// Methode permettant de rechercher et d'obtenir un client
	// Parametre : Aucun
	// Valeur de retour : Un client
	public static Client saisitClient() {
		Client client = null;
		int compteurClient;
		String choixClient;
		int iChoixClient = 0;
		
		do {
			compteurClient = 1;
			System.out.println("Selectionner un client");
			for (Client element : locateur.getCatalogue().getListeClient()) {
				System.out.println(compteurClient++ + ". " + element.getNoPermis() + " - " + element.getNom() + ", " + element.getPrenom());
			}
			if (compteurClient == 1) {
				System.out.println("Il n'y a aucun client dans le systeme. Fin du processus.");
				return null;
			}
			System.out.println("Votre choix : ");
			choixClient = Interface.lecture();	
			if (!Interface.validerEntier(choixClient, 1, compteurClient-1))
				System.out.println("Veuillez entrer un nombre entier entre 1 et " + (compteurClient-1));
		} while (!Interface.validerEntier(choixClient, 1, compteurClient-1));
		
		iChoixClient = Integer.parseInt(choixClient);
		
		// Utilisation de l'agence (controleur) pour obtenir un client
		client = locateur.getCatalogue().getListeClient().get(iChoixClient-1);
		
		return client;
	}
	
}
