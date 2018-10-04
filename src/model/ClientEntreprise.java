package model;

/**
 * 
 * @author Fabien & Madjid; Ceci est la classe Client Entreprise qui étend la classe
 *         Client; Ne contient pas de méthode;
 */
public class ClientEntreprise extends Client {
	// Attributs
	private String nomDeSociete;
	private int numeroSiret;

	// Constructeur
	public ClientEntreprise(String nom, String prenom, String adresse, int codePostal, String ville, Number telephone,
			String nomDeSociete, int numeroSiret, CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super(nom, prenom, adresse, codePostal, ville, telephone, compteCourant, compteEpargne);
		this.nomDeSociete = nomDeSociete;
		this.numeroSiret = numeroSiret;
	}

	// Getters & setters
	public String getNomDeSociete() {
		return nomDeSociete;
	}

	public void setNomDeSociete(String nomDeSociete) {
		this.nomDeSociete = nomDeSociete;
	}

	public int getNumeroSiret() {
		return numeroSiret;
	}

	public void setNumeroSiret(int numeroSiret) {
		this.numeroSiret = numeroSiret;
	}

}
