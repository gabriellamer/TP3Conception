package model;

import java.util.ArrayList;
import java.util.Date;

public class Catalogue {
	
	private ArrayList<Client> listeClient = new ArrayList<Client>();        // Liste des clients
	private ArrayList<Vehicule> listeVehicule = new ArrayList<Vehicule>();  // Liste des vehicules
	
	// Constructeur vide de la classe catalogue
	public Catalogue() {

	}
	
	// Permet d'ajouter un client a la liste des clients
	public void ajouterClient(Client client) {
		listeClient.add(client);
	}
	
    // Permet de remplacer un client dans la liste des clients lors d'une modification
	public void modifierClient(Client client, String ancienPermis) {
		for (Client element : listeClient) {
			if (element.getNoPermis() == ancienPermis) {
				element = client;
				break;
			}
		}
	}
	
	// Permet de supprimer un client de la liste des clients
	public void supprimerClient(Client client) {
		listeClient.remove(client);
	}
	
	// Permet d'ajouter un vehicule a la liste des vehicules
	public void ajouterVehicule(Vehicule vehicule) {
		listeVehicule.add(vehicule);
	}
	
	// Permettrait de modifier un vehicule de la liste des vehicules (Ne fait pas partie de nos cas d'utilisation)
	public void modifierVehicule(Vehicule vehicule) {
	}
	
	// Permettrait de supprimer un vehicule de la liste des vehicules (Ne fait pas partie de nos cas d'utilisation)
	public void supprimerVehicule(Vehicule vehicule) {
	}
	
	// Permet d'obtenir le prochain vehicule disponible selon le type de vehicule demander par le client
	public Vehicule getVehicule(int typeVehicule) {
		for (Vehicule element : listeVehicule) {
			if (element.isDisponible()) {
				if (typeVehicule == 1) {               // Vehicule simple
					if (element instanceof Simple) {
						return element;
					}
				}
				else if (typeVehicule == 2) {          // Vehicule prestige
					if (element instanceof Prestige) {
						return element;
					}
				}
				else {
					if (element instanceof Utilitaire) { // Vehicule utilitaire
						return element;
					}
				}
			}
		}	
		return null;
	}

	// Les getters et les setters se trouvent ci-dessous
	
	public ArrayList<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(ArrayList<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public ArrayList<Vehicule> getListeVehicule() {
		return listeVehicule;
	}

	public void setListeVehicule(ArrayList<Vehicule> listeVehicule) {
		this.listeVehicule = listeVehicule;
	}
	
	
}
