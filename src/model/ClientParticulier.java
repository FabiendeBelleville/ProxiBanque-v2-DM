package model;

/**
 * 
 * @author Fabien & Madjid; Ceci est la classe Client Particulier qui �tend la
 *         classe Client;
 *         Ne contient pas de m�thode;
 */
public class ClientParticulier extends Client {

	// Constructeur
	public ClientParticulier(String nom, String prenom, String adresse, int codePostal, String ville, Number telephone,
			CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super(nom, prenom, adresse, codePostal, ville, telephone, compteCourant, compteEpargne);
	}

}
