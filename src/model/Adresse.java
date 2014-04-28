package model;

// Classe representant l'adresse d'un client
public class Adresse {
	private int noCivique;      // Numero civique de l'adresse d'un client
	private String noApp;       // Numero de l'appartement de l'adresse d'un client
	private String nomRue;      // Nom de la rue
	private String ville;       // Ville du client
	private String province;    // Province du client
	private String codePostal;  // Code postal du client
	
	// Constructeur de la classe adresse
	public Adresse(int noCivique, String noApp, String nomRue, String ville, String province, String codePostal) {
		this.noCivique = noCivique;
		this.noApp = noApp;
		this.nomRue = nomRue;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
	}

	// Methode permettant de modifier une adresse d'un client
	public void modifier(int noCivique, String noApp, String nomRue, String ville, String province, String codePostal) {
		this.noCivique = noCivique;
		this.noApp = noApp;
		this.nomRue = nomRue;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
	}
	
	// Les getters et les setters se trouve ci-dessous

	public int getNoCivique() {
		return noCivique;
	}

	public void setNoCivique(int noCivique) {
		this.noCivique = noCivique;
	}

	public String getNoApp() {
		return noApp;
	}

	public void setNoApp(String noApp) {
		this.noApp = noApp;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
}
