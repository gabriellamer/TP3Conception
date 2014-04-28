package model;

//Classe permettant de recuperer les exceptions provenant de la classe Personne
public class PersonneException extends Exception {
	private String erreur;
	
	// Constructeur de la classe des exceptions de la classe Personne
	public PersonneException(String erreur) {
		this.erreur = erreur;
    }
	
	public String getErreur() {
		return erreur;
	}
	
	// Affichage de l'exception
	public void printErreur() {
		System.out.print(erreur);
	}
}
