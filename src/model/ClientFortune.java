package model;

/**
 * 
 * @author Fabien & Madjid; Ceci est la classe Client Fortune qui étend la
 *         classe Client Particulier; Elle ne'est pas utilisée à ce stade de
 *         développement de l'application.
 */
public class ClientFortune extends ClientParticulier {

	public ClientFortune(String nom, String prenom, String adresse, int codePostal, String ville, Number telephone,
			CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super(nom, prenom, adresse, codePostal, ville, telephone, compteCourant, compteEpargne);
	}

}
