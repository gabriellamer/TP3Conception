package controleur;

import java.util.ArrayList;
import java.util.Calendar;

import model.Catalogue;
import model.Chauffeur;
import model.Client;
import model.ClientException;
import model.Contrat;
import model.PersonneException;
import model.Vehicule;

public class Agence {
	private Catalogue catalogue;
	private String nom;
	
	public Agence(String nom) {
		this.catalogue = new Catalogue();
		this.nom = nom;
	}
	
	public void ajouterClient(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis, String noTelephone, String typeCarte, String noCarte, 
							  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
							  String ville, String province, String codePostal) {
		Client client;
		try {
			client = new Client(nom, prenom, dateNaissance, sexe, noPermis, noTelephone, noCivique, noApp, nomRue, ville, province, codePostal, typeCarte, noCarte, expiration, cvv);
			catalogue.ajouterClient(client);
		} catch (PersonneException e) {
			e.printErreur();
		} catch (ClientException e) {
			e.printErreur();
		}
	}
	
	public void modifierClient(Client client, String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis, String noTelephone, String typeCarte, String noCarte, 
			  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
			  String ville, String province, String codePostal) {
		
		String ancienPermis = client.getNoPermis();
		//client.modifier();
		catalogue.modifierClient(client, ancienPermis);
	}
	
	public void supprimerClient(Client client) {
		catalogue.supprimerClient(client);
	}
	
	public void ajouterContrat(Client client, Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		client.ajouterContrat(vehicule, datePret, dateRetourPrevue, listeChauffeur);
		vehicule.setDisponible(false);
	}
	
	public void modifierContrat(Contrat contrat, Client client, Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		client.modifierContrat(contrat, vehicule, datePret, dateRetourPrevue, listeChauffeur);
	}
	
	public void supprimerContrat(Client client, Contrat contrat) {
		contrat.getVehicule().setDisponible(true);
		contrat.getPaiement().rembourserClient();
		client.supprimerContrat(contrat);
	}

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
