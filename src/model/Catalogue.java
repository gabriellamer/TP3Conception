package model;

import java.util.ArrayList;
import java.util.Date;

public class Catalogue {
	
	private Date dernierMAJ;
	private ArrayList<Client> listeClient = new ArrayList<Client>();
	private ArrayList<Vehicule> listeVehicule = new ArrayList<Vehicule>();
	
	public Catalogue() {
		listeClient = null;
		listeVehicule = null;
	}
	
	public void ajouterClient(Client client) {
		listeClient.add(client);
	}
	
	public void modifierClient(Client client) {
		
	}
	
	public void supprimerClient(Client client) {
		listeClient.remove(client);
	}
	
	public void ajouterVehicule(Vehicule vehicule) {
		listeVehicule.add(vehicule);
	}
	
	public void modifierVehicule(Vehicule vehicule) {
		
	}
	
	public void supprimerVehicule(Vehicule vehicule) {
		listeClient.remove(vehicule);
	}
	
	public Vehicule getVehicule(int typeVehicule) {
		for (Vehicule element : listeVehicule) {
			if (element.isDisponible()) {
				if (typeVehicule == 1) {
					if (element instanceof Simple) {
						return element;
					}
				}
				else if (typeVehicule == 2) {
					if (element instanceof Prestige) {
						return element;
					}
				}
				else {
					if (element instanceof Utilitaire) {
						return element;
					}
				}
			}
		}	
		return null;
	}

	public Date getDernierMAJ() {
		return dernierMAJ;
	}

	public void setDernierMAJ(Date dernierMAJ) {
		this.dernierMAJ = dernierMAJ;
	}

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
