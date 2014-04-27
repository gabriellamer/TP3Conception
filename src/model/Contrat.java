package model;

import java.util.ArrayList;
import java.util.Date;

public class Contrat {
	private Date dateReservation;
	private Date datePret;
	private Date dateRetourPrevue;
	private Date dateRetour;
	private Vehicule vehicule;
	private double KMdepart;
	private String status;
	private double prix;
	private Paiement paiement;
	private ArrayList<Chauffeur> listeChauffeur = new ArrayList<Chauffeur>();
	
	public Contrat(Date datePret, Date dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		this.dateReservation = null; // TODO date d'aujourd'hui
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		this.status = null; // TODO Verifier la date
		paiement = new Paiement(vehicule.getPrix() + 200); // TODO * nbJour
		this.listeChauffeur = listeChauffeur;
	}
	
	public void modifier(Date datePret, Date dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		this.dateReservation = null; // TODO date d'aujourd'hui
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		this.status = null; // TODO Verifier la date
		paiement.modifier(vehicule.getPrix() + 200); // TODO * nbJour
		this.listeChauffeur = listeChauffeur;
	}
	
	public void rembourserClient() {
		paiement.rembourserClient();
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Date getDatePret() {
		return datePret;
	}

	public void setDatePret(Date datePret) {
		this.datePret = datePret;
	}

	public Date getDateRetourPrevue() {
		return dateRetourPrevue;
	}

	public void setDateRetourPrevue(Date dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}

	public Date getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public double getKMdepart() {
		return KMdepart;
	}

	public void setKMdepart(double kMdepart) {
		KMdepart = kMdepart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public ArrayList<Chauffeur> getListeChauffeur() {
		return listeChauffeur;
	}

	public void setListeChauffeur(ArrayList<Chauffeur> listeChauffeur) {
		this.listeChauffeur = listeChauffeur;
	}
	
	
	
	
	
	

	
}
