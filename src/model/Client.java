package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Client extends Personne {
	private String noTelephone;
	private Adresse adresse;
	private String typeCarte;
	private String noCarte;
	private String expiration;
	private String cvv;
	private ArrayList<Contrat> listeContrat;
	
	public Client(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis,
				  String noTelephone, int noCivique, String noApp, String nomRue, String ville,
				  String province, String codePostal, String typeCarte, String noCarte,
			      String expiration, String cvv) throws PersonneException, ClientException {
		super(nom, prenom, dateNaissance, sexe, noPermis);
		this.adresse = new Adresse(noCivique, noApp, nomRue, ville, province, codePostal);
		
		valideNoTelephone(noTelephone);
		valideTypeCarte(typeCarte);
		valideNoCarte(noCarte);
		valideExpiration(expiration);
		valideCvv(cvv);
		
		this.noTelephone = noTelephone;
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
		this.listeContrat = null;
	}
	
	public void modifier(String nom, String prenom, Calendar dateNaissance, char sexe, String noPermis,
						 String noTelephone, int noCivique, String noApp, String nomRue, String ville,
						 String province, String codePostal, String typeCarte, String noCarte,
						 String expiration, String cvv) throws PersonneException {
		super.modifier(nom, prenom, dateNaissance, sexe, noPermis);
		this.noTelephone = noTelephone;
		this.adresse.modifier(noCivique, noApp, nomRue, ville, province, codePostal);
		this.typeCarte = typeCarte;
		this.noCarte = noCarte;
		this.expiration = expiration;
		this.cvv = cvv;
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
	
	public void supprimerContrat(Contrat contrat) {
		listeContrat.remove(contrat);
	}
	
	private void valideNoTelephone(String noTelephone) throws ClientException {
		if(!noTelephone.matches("[0-9]{10}"))
			throw new ClientException("Le numero de telephone doit etre numerique!");
	}
	
	private void valideTypeCarte(String typeCarte) throws ClientException {
		if(!typeCarte.matches("[a-zA-Z]*"))
			throw new ClientException("Le type de carte doit contenir que des lettres!");
	}
	
	private void valideNoCarte(String noCarte) throws ClientException {
		if(!noCarte.matches(".{16}"))
			throw new ClientException("Le numero de carte doit contenir 16 chiffres!");
		
		if(!noCarte.matches("[0-9]*"))
			throw new ClientException("Le numero de carte doit etre numerique!");
	}
	
	private void valideExpiration(String expiration) throws ClientException {
		if(!expiration.matches("[0-9]{2}[/][0-9]{2}*"))
			throw new ClientException("La date d'expiration doit etre du format «MM/AA»!");
		
		String dateExpiration[] = expiration.split("/");
		int mois = Integer.parseInt(dateExpiration[0]);
		int annee = Integer.parseInt(dateExpiration[1]);
		
		if(mois < 1 && mois > 12) {
			throw new ClientException("Le mois d'expiration doit etre entre 1 et 12!");
		}
		
		if(annee < 0 && annee > 99) {
			throw new ClientException("L'annee d'expiration doit etre entre 0 et 99!");
		}
		
		Calendar today = Calendar.getInstance();
		int todayMois = today.get(Calendar.MONTH);
		int todayYear = Integer.parseInt(String.valueOf(today.get(Calendar.YEAR)).substring(2));
		
		if(today.get(Calendar.YEAR) < annee)
			throw new ClientException("La carte est expiré!");
		else if(todayMois < mois && todayYear == annee)
			throw new ClientException("La carte est expiré!");
	}
	
	private void valideCvv(String cvv) throws ClientException {
		if(!cvv.matches(".{3}"))
			throw new ClientException("Le CVV doit contenir 3 chiffres!");
		
		if(!cvv.matches("[0-9]*"))
			throw new ClientException("Le CVV doit etre numerique!");
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) throws ClientException {
		valideNoTelephone(noTelephone);
		this.noTelephone = noTelephone;
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

	public void setTypeCarte(String typeCarte) throws ClientException {
		valideTypeCarte(typeCarte);
		this.typeCarte = typeCarte;
	}

	public String getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(String noCarte) throws ClientException {
		valideNoCarte(noCarte);
		this.noCarte = noCarte;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) throws ClientException {
		valideExpiration(expiration);
		this.expiration = expiration;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) throws ClientException {
		valideCvv(cvv);
		this.cvv = cvv;
	}

	public ArrayList<Contrat> getListeContrat() {
		return listeContrat;
	}

	public void setListeContrat(ArrayList<Contrat> listeContrat) {
		this.listeContrat = listeContrat;
	}
}
