package model;

public class Prestige extends Vehicule {

	private boolean decapotable;
	
	public Prestige(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean decapotable) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		
		this.decapotable = decapotable;
		// TODO Auto-generated constructor stub
	}
	
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean decapotable) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.decapotable = decapotable;
	}

	public boolean isDecapotable() {
		return decapotable;
	}

	public void setDecapotable(boolean decapotable) {
		this.decapotable = decapotable;
	}
}
