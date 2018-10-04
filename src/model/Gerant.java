package model;

/**
 * 
 * @author Fabien & Madjid; La classe Gerant extends Conseiller. A ce stade de
 *         développement de l'application, elle n'a pas de méthode de gestion
 *         des conseillers.
 *
 */
public class Gerant extends Conseiller {
	// Constructeur
	public Gerant(String nom, String prenom, String idAgence) {
		super(nom, prenom, idAgence);
	}

// Méthode
	@Override
	public String toString() {
		return "Gerant [idAgence=" + idAgence + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}
}
