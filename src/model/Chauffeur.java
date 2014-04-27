package model;

import java.util.Calendar;

public class Chauffeur extends Personne {

	public Chauffeur(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		super(nom, prenom, dateNaissance, sexe, noPermis);
	}
	
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) {
		super.modifier(nom, prenom, dateNaissance, sexe, noPermis);
	}
}
