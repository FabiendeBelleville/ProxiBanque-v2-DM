package model;

/**
 * 
 * @author Fabien & Marlon;Ceci est la classe Compte Epargne qui étend la classe
 *         Compte;
 *
 */
public class CompteEpargne extends Compte {

	private static double decouvertAutoriseCE = 0;

	public CompteEpargne(String dateDuJour, double firstDepotCE, int numeroDeCompte, double decouvertAutoriseCE) {
		super.dateOuverture = dateDuJour;
		super.solde = firstDepotCE;
		super.numeroDeCompte = numeroDeCompte;
		CompteEpargne.decouvertAutoriseCE = decouvertAutoriseCE;
	}

	public static double getDecouvertAutoriseCE() {
		return decouvertAutoriseCE;
	}

	public static void setDecouvertAutoriseCE(double decouvertAutoriseCE) {
		CompteEpargne.decouvertAutoriseCE = decouvertAutoriseCE;
	}

	@Override
	public String toString() {
		return "C. Epargne [solde=" + solde + ", numeroDeCompte=" + numeroDeCompte + "]";
	}

}
