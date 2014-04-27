package model;

public class PersonneException extends Exception {
	private String erreur;
	
	public PersonneException(String erreur) {
		this.erreur = erreur;
    }
	
	public String getErreur() {
		return erreur;
	}
	
	public void printErreur() {
		System.out.print(erreur);
	}
}
