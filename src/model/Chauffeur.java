package model;

import java.util.Date;

public class Chauffeur extends Personne {

	public Chauffeur(String nom, String prenom, Date dateNaissance, char sexe) {
		super(nom, prenom, dateNaissance, sexe);
	}
	
	public void modifier(String nom, String prenom, Date dateNaissance, char sexe) {
		super.modifier(nom, prenom, dateNaissance, sexe);
	}
}
