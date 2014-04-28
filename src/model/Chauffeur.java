package model;

import java.util.Calendar;

// Classe representant un chauffeur (Peut conduire un vehicule louer par un client)
public class Chauffeur extends Personne {

	// Constructeur faisant appel au constructeur de la super-classe Personne
	public Chauffeur(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		super(nom, prenom, dateNaissance, sexe, noPermis);
	}
	
	// Methode permettant de supprimer un chauffeur faisant appel a la methode modifier de la super-classe Personne
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		super.modifier(nom, prenom, dateNaissance, sexe, noPermis);
	}
}
