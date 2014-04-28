package model;

import java.util.Calendar;

// Classe abstraite representant une personne
abstract class Personne {
	protected String nom;               // Nom
	protected String prenom;            // Prenom
	protected Calendar dateNaissance;   // Date de naissance
	protected char sexe;                // Sexe
	protected String noPermis;          // Numero de permis de conduire
	
	// Constructeur de la classe personne
	public Personne(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		
		// Validation des champs
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
	
	// Methode permettant de modifier une personne
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis) throws PersonneException {
		
		// Validation des champs
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
	
	// Validation du nom
	private void valideNom(String nom) throws PersonneException {
		if(!nom.matches("[a-zA-Z- ]*"))
			throw new PersonneException("Le nom ne doit contenir que des lettres!\n");
		
	}
	
	// Validation du prenom
	private void validePrenom(String prenom) throws PersonneException {
		if(!prenom.matches("[a-zA-Z- ]*"))
			throw new PersonneException("Le prenom ne doit contenir que des lettres!\n");
	}
	
	// Validation de la date de naissance
	private void valideDateNaissance(Calendar dateNaissance) throws PersonneException {
		Calendar today = Calendar.getInstance();
		
		if(today.get(Calendar.YEAR) - dateNaissance.get(Calendar.YEAR) < 18)
			throw new PersonneException("Le client doit avoir 18 et plus!\n");
	}
	
	// Validation du sexe
	private void valideSexe(char sexe) throws PersonneException {
		char sexeUpper = Character.toUpperCase(sexe);
		
		if(sexeUpper != 'M' && sexeUpper != 'F')
			throw new PersonneException("Le sexe doit être «M» ou «F»!\n");
	}
	
	// Validation du numero de permis de conduire
	private void valideNoPermis(String noPermis) throws PersonneException {
		if(!noPermis.matches(".{13}"))
			throw new PersonneException("Le numero du permis doit avoir 13 caracteres!\n");
		
		if(!noPermis.matches("[a-zA-Z0-9]*"))
			throw new PersonneException("Le numero du permis doit etre alphanumerique!\n");
		
		if(!noPermis.matches("^[a-zA-Z][0-9]{12}"))
			throw new PersonneException("Le numero du permis doit debuter avec 1 lettre et 12 chiffres!\n");
	}

	// Les getters et les setters se trouvent ci-dessous
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws PersonneException {
		valideNom(nom);
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) throws PersonneException {
		validePrenom(prenom);
		this.prenom = prenom;
	}

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) throws PersonneException {
		valideDateNaissance(dateNaissance);
		this.dateNaissance = dateNaissance;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) throws PersonneException {
		valideSexe(sexe);
		this.sexe = sexe;
	}

	public String getNoPermis() {
		return noPermis;
	}

	public void setNoPermis(String noPermis) throws PersonneException {
		valideNoPermis(noPermis);
		this.noPermis = noPermis;
	}
}