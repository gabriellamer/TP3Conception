package model;

import java.util.Date;

abstract class Personne {
	protected String nom;
	protected String prenom;
	protected Date dateNaissance;
	protected char sexe;
	protected String noPermis;
	
	public Personne(String nom, String prenom, Date dateNaissance, char sexe, String noPermis) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.noPermis = noPermis;
	}
	
	public void modifier(String nom, String prenom, Date dateNaissance, char sexe, String noPermis) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.noPermis = noPermis;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
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