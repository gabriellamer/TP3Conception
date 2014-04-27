package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Client extends Personne {
	private String noTelephone;
	private Calendar dateAdhesion;
	private Calendar dateExpiration;
	private Adresse adresse;
	private String typeCarte;
	private String noCarte;
	private String expiration;
	private String cvv;
	private ArrayList<Contrat> listeContrat;
	
	public Client(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis,
				  String noTelephone, Calendar dateAdhesion, Calendar dateExpiration,
				  int noCivique, String noApp, String nomRue, String ville,
				  String province, String codePostal, String typeCarte, String noCarte,
			      String expiration, String cvv, ArrayList<Contrat> listeContrat) throws PersonneException {
		super(nom, prenom, dateNaissance, sexe, noPermis);
		this.noTelephone = noTelephone;
		this.dateAdhesion = dateAdhesion;
		this.dateExpiration = dateExpiration;
		this.adresse = new Adresse(noCivique, noApp, nomRue, ville, province, codePostal);
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
		this.listeContrat = listeContrat;
	}
	
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis,
			String noTelephone, Calendar dateAdhesion, Calendar dateExpiration,
			int noCivique, String noApp, String nomRue, String ville,
			String province, String codePostal, String typeCarte, String noCarte,
			String expiration, String cvv, ArrayList<Contrat> listeContrat) throws PersonneException {
		super.modifier(nom, prenom, dateNaissance, sexe, noPermis);
		this.noTelephone = noTelephone;
		this.dateAdhesion = dateAdhesion;
		this.dateExpiration = dateExpiration;
		this.adresse.modifier(noCivique, noApp, nomRue, ville, province, codePostal);
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
		this.listeContrat = listeContrat;
	}
	
	public void ajouterContrat(Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevu,
							   ArrayList<Chauffeur> listeChauffeur) {
		Contrat dernierContrat = listeContrat.get(listeContrat.size() - 1);
		int prochainNoContrat = dernierContrat.getNoContrat() + 1;
		
		Contrat contrat = new Contrat(prochainNoContrat, datePret, dateRetourPrevu, vehicule, listeChauffeur);
		listeContrat.add(contrat);
	}
	
	public void modifierContrat(Contrat contrat, Vehicule vehicule, Calendar datePret, Calendar dateRetourPrevue,
								ArrayList<Chauffeur> listeChauffeur) {
		contrat.modifier(datePret, dateRetourPrevue, vehicule, listeChauffeur);
		
		for (Contrat c : listeContrat) {
			if(c.getNoContrat() == contrat.getNoContrat()) {
				c = contrat;
				break;
			}
		}
	}
	
	private void valideNoTelephone(String noTelephone) throws PersonneException {
		
	}
	
	public void supprimerContrat(Contrat contrat) {
		listeContrat.remove(contrat);
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) {
		this.noTelephone = noTelephone;
	}

	public Calendar getDateAdhesion() {
		return dateAdhesion;
	}

	public void setDateAdhesion(Calendar dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}

	public Calendar getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Calendar dateExpiration) {
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
