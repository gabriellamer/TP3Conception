package model;

// Paiement d'un contrat de location
public class Paiement {
	private double montant; // Montant du paiement
	
	// Constructeur de la clase Paiement
	public Paiement(double montant) {
		this.montant = montant;
	}
	
	// Methode permettant de modifier un paiement
	public void modifier(double montant) {
		this.montant = montant;
	}
	
	// Methode permettant de proceder au paiement d'un contrat de location
	public void payer() {
		System.out.println("Paiement de la somme de " + this.montant + " par le client");
	}
	
	// Methode permettant de rembourser le montant debourser par le client
	public void rembourserClient() {
		System.out.println("Remboursement de la somme de " + this.montant + " au client");
	}

	// Les getters et les setters se trouvent ci-dessous
	
	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
