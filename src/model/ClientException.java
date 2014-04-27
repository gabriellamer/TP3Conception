package model;

public class ClientException extends Exception {
	private String erreur;
	
	public ClientException(String erreur) {
		this.erreur = erreur;
    }
	
	public String getErreur() {
		return erreur;
	}
	
	public void printErreur() {
		System.out.print(erreur);
	}
}
