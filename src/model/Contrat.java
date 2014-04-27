package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Contrat {
	private int noContrat;
	private Calendar dateReservation;
	private Calendar datePret;
	private Calendar dateRetourPrevue;
	private Calendar dateRetour;
	private Vehicule vehicule;
	private double KMdepart;
	private String status;
	private double prix;
	private Paiement paiement;
	private ArrayList<Chauffeur> listeChauffeur = new ArrayList<Chauffeur>();
	
	public Contrat(int noContrat, Calendar datePret, Calendar dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		GregorianCalendar currentDate = new GregorianCalendar(); // Date courante
		
		this.noContrat = noContrat;
		this.dateReservation = new GregorianCalendar(currentDate.get(GregorianCalendar.YEAR), currentDate.get(GregorianCalendar.MONTH), currentDate.get(GregorianCalendar.DAY_OF_MONTH));
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		
		if (currentDate.compareTo(datePret) > 0)
			this.status = "Reserve";
		else
			this.status = "Loue";
		
		paiement = new Paiement(vehicule.getPrix() + 200); // TODO * nbJour
		this.listeChauffeur = listeChauffeur;
	}
	
	public void modifier(Calendar datePret, Calendar dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		GregorianCalendar currentDate = new GregorianCalendar(); // Date courante
		
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		
		if (currentDate.compareTo(datePret) > 0)
			this.status = "Reserve";
		else
			this.status = "Loue";
		
		paiement.modifier(vehicule.getPrix() + 210); // TODO * nbJour
		this.listeChauffeur = listeChauffeur;
	}
	
	public int getNoContrat() {
		return noContrat;
	}

	public void setNoContrat(int noContrat) {
		this.noContrat = noContrat;
	}

	public void rembourserClient() {
		paiement.rembourserClient();
	}

	public Calendar getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Calendar dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Calendar getDatePret() {
		return datePret;
	}

	public void setDatePret(Calendar datePret) {
		this.datePret = datePret;
	}

	public Calendar getDateRetourPrevue() {
		return dateRetourPrevue;
	}

	public void setDateRetourPrevue(Calendar dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}

	public Calendar getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(Calendar dateRetour) {
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

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	public ArrayList<Chauffeur> getListeChauffeur() {
		return listeChauffeur;
	}

	public void setListeChauffeur(ArrayList<Chauffeur> listeChauffeur) {
		this.listeChauffeur = listeChauffeur;
	}
	
	
	
	
	
	

	
}
