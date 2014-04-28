package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Classe representant un contrat de location
public class Contrat {
	private int noContrat;             // Numero de contrat unique
	private Calendar dateReservation;  // Date de reservation
	private Calendar datePret;         // Date de pret
	private Calendar dateRetourPrevue; // Date de retour prevue
	private Calendar dateRetour;       // Date de retour reelle
	private Vehicule vehicule;         // Vehicule de location
	private double KMdepart;           // Kilometrage du vehicule au depart
	private String status;             // Status du contrat
	private double prix;               // Prix du contrat
	private Paiement paiement;         // Paiement du contrat
	private int compteurModifier;      // Compteur des modifications
	private ArrayList<Chauffeur> listeChauffeur = new ArrayList<Chauffeur>(); // Liste des chauffeurs
	
	// Constructeur de la classe Contrat
	public Contrat(int noContrat, Calendar datePret, Calendar dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		GregorianCalendar currentDate = new GregorianCalendar(); // Date courante
		
		this.noContrat = noContrat;
		this.dateReservation = new GregorianCalendar(currentDate.get(GregorianCalendar.YEAR), currentDate.get(GregorianCalendar.MONTH)+1, currentDate.get(GregorianCalendar.DAY_OF_MONTH));
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		this.compteurModifier = 0;
		
		if (dateReservation.compareTo(datePret) < 0)
			this.status = "Reserve"; // Si la date de pret est ulterieure a la date courante, l'etat est reserve
		else
			this.status = "Loue"; // Si la date de pret est egale a la date courante, l'etat est loue
		
		// Nombre de jour entre la date de pret et la date de retour prevue
		int nbJour = (int)(dateRetourPrevue.getTimeInMillis() - datePret.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		
		// Creation du paiement
		paiement = new Paiement((vehicule.getPrix() * nbJour) + 200); 
		this.listeChauffeur = listeChauffeur;
	}
	
	// Methode permettant de modifier un contrat
	public void modifier(Calendar datePret, Calendar dateRetourPrevue, Vehicule vehicule, ArrayList<Chauffeur> listeChauffeur) {
		GregorianCalendar currentDate = new GregorianCalendar(); // Date courante
		
		this.datePret = datePret;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetour = null;
		this.vehicule = vehicule;
		this.KMdepart = vehicule.getKm();
		
		this.compteurModifier++; // Compteur de modification
		
		if (this.dateReservation.compareTo(datePret) < 0)
			this.status = "Reserve"; // Si la date de pret est ulterieure a la date courante, l'etat est reserve
		else
			this.status = "Loue"; // Si la date de pret est egale a la date courante, l'etat est loue
		
		// Nombre de jour entre la date de pret et la date de retour prevue
		int nbJour = (int)(dateRetourPrevue.getTimeInMillis() - datePret.getTimeInMillis()) / (1000 * 60 * 60 * 24);
		
		// Modification du paiement
		// 200$ : Depot de garantie
		// 10$ par modification du contrat
		// Montant par jour * Nombre de jour
		paiement.modifier((vehicule.getPrix() * nbJour) + 200 + (10 * compteurModifier));
		this.listeChauffeur = listeChauffeur;
	}
	// Methode permettant de rembourser un client
	public void rembourserClient() {
		paiement.rembourserClient();
	}
	
	// Les getters et les setters se trouvent ci-dessous
	
	public int getNoContrat() {
		return noContrat;
	}

	public void setNoContrat(int noContrat) {
		this.noContrat = noContrat;
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
