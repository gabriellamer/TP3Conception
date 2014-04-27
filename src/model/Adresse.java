package model;

public class Adresse {
	private int noCivique;
	private String noApp;
	private String nomRue;
	private String ville;
	private String province;
	private String codePostal;
	
	public Adresse(int noCivique, String noApp, String nomRue, String ville, String province, String codePostal) {
		this.noCivique = noCivique;
		this.noApp = noApp;
		this.nomRue = nomRue;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
	}

	public void modifier(int noCivique, String noApp, String nomRue, String ville, String province, String codePostal) {
		this.noCivique = noCivique;
		this.noApp = noApp;
		this.nomRue = nomRue;
		this.ville = ville;
		this.province = province;
		this.codePostal = codePostal;
	}

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
