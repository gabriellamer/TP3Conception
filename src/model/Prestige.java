package model;

// Classe representant un vehicule de type Prestige
public class Prestige extends Vehicule {

	private boolean decapotable;  // Represente si le vehicule est decapotable
	
	// Constructeur de la classe Prestige
	public Prestige(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean decapotable) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		
		this.decapotable = decapotable;
	}
	
	// Methode permettant de modifier un vehicule de type Prestige
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean decapotable) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.decapotable = decapotable;
	}

	// Les getters et les setters se trouvent ci-dessous
	
	public boolean isDecapotable() {
		return decapotable;
	}

	public void setDecapotable(boolean decapotable) {
		this.decapotable = decapotable;
	}
}
