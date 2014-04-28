package model;

//Classe representant un vehicule de type Utilitaire
public class Utilitaire extends Vehicule {

	private double longueur;      // Longueur du vehicule
	private double capaciteCube;  // Capacite du cube se trouvant a l'arriere du vehicule
	
	// Constructeur de la classe Utilitaire
	public Utilitaire(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, double longueur, double capaciteCube) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		
		this.longueur = longueur;
		this.capaciteCube = capaciteCube;
	}
	
	// Methode permettant de modifier un vehicule de type Utilitaire
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, double longueur, double capaciteCube) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.longueur = longueur;
		this.capaciteCube = capaciteCube;
	}

	// Les getters et les setters se trouvent ci-dessous
	
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
