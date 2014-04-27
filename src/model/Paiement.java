package model;

public class Paiement {
	private double montant;
	
	public Paiement(double montant) {
		this.montant = montant;
	}
	
	public void modifier(double montant) {
		this.montant = montant;
	}
	
	public void payer() {
		System.out.println("Paiement de la somme de " + this.montant + " par le client");
	}
	
	public void rembourserClient() {
		System.out.println("Remboursement de la somme de " + this.montant + " au client");
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
}
