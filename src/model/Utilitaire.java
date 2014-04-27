package model;

public class Utilitaire extends Vehicule {

	private double longueur;
	private double capaciteCube;
	
	public Utilitaire(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, double longueur, double capaciteCube) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		
		this.longueur = longueur;
		this.capaciteCube = capaciteCube;
		// TODO Auto-generated constructor stub
	}
	
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, double longueur, double capaciteCube) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.longueur = longueur;
		this.capaciteCube = capaciteCube;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getCapaciteCube() {
		return capaciteCube;
	}

	public void setCapaciteCube(double capaciteCube) {
		this.capaciteCube = capaciteCube;
	}
	
}
