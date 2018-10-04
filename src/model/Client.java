package model;

/**
 * 
 * @author Fabien et Madjid. La classe Client est l'une des classe les plus
 *         importantes du package model par son nombre d'attributs, avec leurs
 *         getters et setters associés ainsi qu'une méthode toString complète.
 *         Elle correspond au model de fiche client, incluant même les attriburs
 *         de Compte (courant et épargne).
 *
 */
public class Client {
//Attributs

	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private Number telephone;

	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;

	// Constructeur
	public Client() {
		this("BABAR", "Tanguy", "9 rue des Platanes", 75015, "Paris", 675988684, null, null);
	}

	public Client(CompteCourant compteCourant, CompteEpargne compteEpargne) {
		this("BABAR", "Tanguy", "9 rue des Platanes", 75015, "Paris", 675988684, compteCourant, compteEpargne);
	}

	public Client(String nom, String prenom, String adresse, int codePostal, String ville, Number telephone,
			CompteCourant compteCourant, CompteEpargne compteEpargne) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
	}

	// Getters & setters
	public int getid() {
		return idClient;
	}

	public void setid(int id) {
		this.idClient = id;
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

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", compteCourant=" + compteCourant + ", compteEpargne="
				+ compteEpargne + "]";
	}

}
