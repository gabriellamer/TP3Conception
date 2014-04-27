package model;

public class Simple extends Vehicule {

	private boolean toutEquipe; 
	
	public Simple(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean toutEquipe) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.toutEquipe = toutEquipe;
		
		// TODO Auto-generated constructor stub
	}

	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean toutEquipe) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.toutEquipe = toutEquipe;
	}

	public boolean isToutEquipe() {
		return toutEquipe;
	}

	public void setToutEquipe(boolean toutEquipe) {
		this.toutEquipe = toutEquipe;
	}
}
