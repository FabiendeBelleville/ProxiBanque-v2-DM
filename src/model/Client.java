package model;

/**
 * 
 * @author Fabien et Marlon. La classe Client est l'une des classe les plus
 *         importantes du package model par son nombre d'attributs, avec leurs
 *         getters et setters associ�s ainsi qu'une m�thode toString compl�te.
 *         Elle correspond au model de fiche client.
 */
public class Client {
//Attributs

	private int idClient;
	private String idWEB;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private Number telephone;

	private int numcptC;
	private int numcptE;

	public Client(String nom, String prenom, String adresse, int codePostal, String ville, Number telephone,
			int numcptC, int numcptE) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.numcptC = numcptC;
		this.numcptE = numcptE;
	}

	public Client(int idClient, String idWEB, String nom, String prenom, String adresse, int codePostal, String ville) {
		this.idClient = idClient;
		this.idWEB = idWEB;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// Client(idClient, nom, prenom, adresse, cp, ville)
	public Client(int idClient, String nom, String prenom, String adresse, int codePostal, String ville) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	// Client(idClient, idWEB, nom, prenom, adresse, codePostal, ville, numcptC,
	// numcptE)
	public Client(int idClient, String idWEB, String nom, String prenom, String adresse, int codePostal, String ville,
			int numcptC, int numcptE) {
		super();
		this.idClient = idClient;
		this.idWEB = idWEB;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.numcptC = numcptC;
		this.numcptE = numcptE;
	}

	// Getters & setters
	public int getid() {
		return idClient;
	}

	public void setid(int id) {
		idWEB = String.valueOf(id);
		System.out.println("caca" + idWEB);
		this.idClient = id;
	}

	public String getIdWEB() {
		return idWEB;
	}

	public void setIdWEB(String idWEB) {
		this.idWEB = idWEB;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Number getTelephone() {
		return telephone;
	}

	public void setTelephone(Number telephone) {
		this.telephone = telephone;
	}

	public int getNumcptC() {
		return numcptC;
	}

	public void setNumcptC(int numcptC) {
		this.numcptC = numcptC;
	}

	public int getNumcptE() {
		return numcptE;
	}

	public void setNumcptE(int numcptE) {
		this.numcptE = numcptE;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", idWEB=" + idWEB + ", nom=" + nom + ", prenom=" + prenom
				+ ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + ", numcptC=" + numcptC + ", numcptE=" + numcptE + "]";
	}
}
