package model;

/**
 * 
 * @author Fabien & Madjid;Ceci est la classe Compte Epargne qui �tend la classe
 *         Compte; Elle d�tient plusieurs constructeurs pour une certaine
 *         souplesse de cr�ation de compte
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
		return "CompteEpargne [dateOuverture=" + dateOuverture + ", solde=" + solde + ", numeroDeCompte="
				+ numeroDeCompte + ", getDecouvertAutoriseCE()=" + getDecouvertAutoriseCE() + "]";
	}
	
	

}
