package model;

//Classe representant un vehicule de type Simple
public class Simple extends Vehicule {

	private boolean toutEquipe; // Represente si le vehicule est tout equipe
	
	// Constructeur de la classe Simple
	public Simple(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean toutEquipe) {
		super(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		
		this.toutEquipe = toutEquipe;
	}
	
	// Methode permettant de modifier un vehicule de type Simple
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix, boolean toutEquipe) {
		super.modifier(immatriculation, moteur, accessoires, marque, modele, km, nbPlace, disponible, prix);
		this.toutEquipe = toutEquipe;
	}

	// Les getters et les setters se trouvent ci-dessous
	
	public boolean isToutEquipe() {
		return toutEquipe;
	}

	public void setToutEquipe(boolean toutEquipe) {
		this.toutEquipe = toutEquipe;
	}
}
