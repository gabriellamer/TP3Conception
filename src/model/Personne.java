package model;

import java.util.Calendar;

abstract class Personne {
	protected String nom;
	protected String prenom;
	protected Calendar dateNaissance;
	protected char sexe;
	protected String noPermis;
	
	public Personne(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		valideNom(nom);
		validePrenom(prenom);
		valideDateNaissance(dateNaissance);
		valideSexe(sexe);
		valideNoPermis(noPermis);
		
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.noPermis = noPermis;
	}
	
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.noPermis = noPermis;
	}
	
	private void valideNom(String nom) throws PersonneException {
		if(!nom.matches("[a-zA-Z- ]*"))
			throw new PersonneException("Le nom doit alphanumerique!");
		
	}
	
	private void validePrenom(String prenom) throws PersonneException {
		if(!prenom.matches("[a-zA-Z- ]*"))
			throw new PersonneException("Le prenom doit etre alphanumerique!");
	}
	
	private void valideDateNaissance(Calendar dateNaissance) throws PersonneException {
		Calendar today = Calendar.getInstance();
		
		if(today.get(Calendar.YEAR) - dateNaissance.get(Calendar.YEAR) < 18)
			throw new PersonneException("Le client doit avoir 18 et plus!");
	}
	
	private void valideSexe(char sexe) throws PersonneException {
		char sexeUpper = Character.toUpperCase(sexe);
		
		if(sexeUpper != 'M' && sexeUpper != 'F')
			throw new PersonneException("Le sexe doit être «M» ou «F»!");
	}
	
	private void valideNoPermis(String noPermis) throws PersonneException {
		if(!noPermis.matches(".{13}"))
			throw new PersonneException("Le numero du permis doit avoir 13 caracteres!");
		
		if(!noPermis.matches("[a-zA-Z0-9]"))
			throw new PersonneException("Le numero du permis doit etre alphanumerique!");
		
		if(!noPermis.matches("^[a-zA-Z][0-9]{12}"))
			throw new PersonneException("Le numero du permis doit debuter avec 1 lettre et 12 chiffres!");
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public String getNoPermis() {
		return noPermis;
	}

	public void setNoPermis(String noPermis) {
		this.noPermis = noPermis;
	}
}