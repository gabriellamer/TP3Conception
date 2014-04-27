package model;

import java.util.Date;

public class Chauffeur extends Personne {

	public Chauffeur(String nom, String prenom, Date dateNaissance, char sexe, String noPermis) {
		super(nom, prenom, dateNaissance, sexe, noPermis);
	}
	
	public void modifier(String nom, String prenom, Date dateNaissance, char sexe, String noPermis) {
		super.modifier(nom, prenom, dateNaissance, sexe, noPermis);
	}
}
