package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends Personne {
	private String noTelephone;
	private Date dateAdhesion;
	private Date dateExpiration;
	private Adresse adresse;
	private String typeCarte;
	private String noCarte;
	private String expiration;
	private String cvv;
	private ArrayList<Contrat> listeContrat;
	
	public Client(String nom, String prenom, Date dateNaissance, char sexe,
			String noTelephone, Date dateAdhesion, Date dateExpiration,
			Adresse adresse, String typeCarte, String noCarte,
			String expiration, String cvv, ArrayList<Contrat> listeContrat) {
		super(nom, prenom, dateNaissance, sexe);
		this.noTelephone = noTelephone;
		this.dateAdhesion = dateAdhesion;
		this.dateExpiration = dateExpiration;
		this.adresse = adresse;
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
		this.listeContrat = listeContrat;
	}
	
	public void modifier(String nom, String prenom, Date dateNaissance, char sexe,
			String noTelephone, Date dateAdhesion, Date dateExpiration,
			Adresse adresse, String typeCarte, String noCarte,
			String expiration, String cvv, ArrayList<Contrat> listeContrat) {
		super.modifier(nom, prenom, dateNaissance, sexe);
		this.noTelephone = noTelephone;
		this.dateAdhesion = dateAdhesion;
		this.dateExpiration = dateExpiration;
		this.adresse = adresse;
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
		this.listeContrat = listeContrat;
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) {
		this.noTelephone = noTelephone;
	}

	public Date getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(Date dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(String noCarte) {
		this.noCarte = noCarte;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public ArrayList<Contrat> getListeContrat() {
		return listeContrat;
	}

	public void setListeContrat(ArrayList<Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}
}
