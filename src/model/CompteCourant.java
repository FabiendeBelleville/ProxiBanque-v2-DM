package model;

/**
 * 
 * @author Fabien & Marlon;Ceci est la classe Compte Courant qui étend la classe
 *         Compte; Elle détient un constructeur
 */
public class CompteCourant extends Compte {

	private static double decouvertAutoriseCC = 1000;

	// Constructeur
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
		return "C. Courant [solde=" + solde + ", numeroDeCompte=" + numeroDeCompte + "]";
	}

}
