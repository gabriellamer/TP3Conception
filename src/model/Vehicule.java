package model;

public abstract class Vehicule {
	protected String immatriculation;
	protected String moteur;
	protected String accessoires;
	protected String marque;
	protected String modele;
	protected double km;
	protected int nbPlace;
	protected boolean disponible;
	protected double prix;
	
	public Vehicule(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix) {
		this.immatriculation = immatriculation;
		this.moteur = moteur;
		this.accessoires = accessoires;
		this.marque = marque;
		this.modele = modele;
		this.km = km;
		this.nbPlace = nbPlace;
		this.disponible = disponible;
		this.prix = prix;
	}
	
	public void modifier(String immatriculation, String moteur, String accessoires, String marque, String modele, double km, int nbPlace, boolean disponible, double prix) {
		this.immatriculation = immatriculation;
		this.moteur = moteur;
		this.accessoires = accessoires;
		this.marque = marque;
		this.modele = modele;
		this.km = km;
		this.nbPlace = nbPlace;
		this.disponible = disponible;
		this.prix = prix;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMoteur() {
		return moteur;
	}

	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}

	public String getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(String accessoires) {
		this.accessoires = accessoires;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
