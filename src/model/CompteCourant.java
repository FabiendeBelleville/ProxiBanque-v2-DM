package model;

/**
 * 
 * @author Fabien & Madjid;Ceci est la classe Compte Courant qui �tend la classe
 *         Compte; Elle d�tient plusieurs constructeurs pour une certaine
 *         souplesse de cr�ation de compte
 */
public class CompteCourant extends Compte {

	private static double decouvertAutoriseCC = 1000;

	// Constructeur sans saisie du d�couvert authoris�

//Constructeur complet
	public CompteCourant(String dateDuJour, double firstDepotCC, int numeroDeCompte, double decouvertAutoriseCC) {
		super.dateOuverture = dateDuJour;
		super.solde = firstDepotCC;
		super.numeroDeCompte = numeroDeCompte;
		CompteCourant.decouvertAutoriseCC = decouvertAutoriseCC;
	}

	public static double getDecouvertAutoriseCC() {
		return CompteCourant.decouvertAutoriseCC;
	}

	public static void setDecouvertAutoriseCC(double decouvertAutoriseCC) {
		CompteCourant.decouvertAutoriseCC = decouvertAutoriseCC;
	}

	@Override
	public String toString() {
		return "CompteCourant [dateOuverture=" + dateOuverture + ", solde=" + solde + ", numeroDeCompte="
				+ numeroDeCompte + ", getDecouvertAutoriseCC()=" + getDecouvertAutoriseCC() + "]";
	}

}
