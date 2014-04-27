package controleur;

import java.util.ArrayList;
import java.util.Date;

import model.Catalogue;
import model.Chauffeur;
import model.Client;
import model.Contrat;
import model.Vehicule;

public class Agence {
	private Catalogue catalogue;
	private String nom;
	
	public Agence(String nom) {
		this.catalogue = new Catalogue();
		this.nom = nom;
	}
	
	public void ajouterClient(String noPermis, String noTelephone, String typeCarte, String noCarte, 
							  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
							  String ville, String province, String codePostal) {

	}
	
	public void modifierClient(String noPermis, String noTelephone, String typeCarte, String noCarte, 
			  String expiration, String cvv, int noCivique, String noApp, String nomRue, 
			  String ville, String province, String codePostal) {

	}
	
	public void supprimerClient(Client client) {
		
	}
	
	public void ajouterContrat(Client client, Vehicule vehicule, Date datePret, Date dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		
	}
	
	public void modifierContrat(Contrat contrat, Client client, Vehicule vehicule, Date datePret, Date dateRetourPrevue, ArrayList<Chauffeur> listeChauffeur) {
		
	}
	
	public void supprimerContrat(Client client, Contrat contrat) {
		
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
