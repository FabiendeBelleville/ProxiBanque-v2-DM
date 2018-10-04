package model;

/**
 * 
 * @author Fabien & Madjid; Ceci est la classe abstraite Compte. Elle contient 4
 *         attributs, un constructeur, et les getters et setters des attributs.
 *         Elle ne contient aucune méthode
 */
public abstract class Compte {
// Attributs
	protected String dateOuverture;
	protected double solde;
	protected int numeroDeCompte;

// Constructeur
	public Compte() {

	}

//Getters & setters
	public String getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumeroDeCompte() {
		return numeroDeCompte;
	}

	public void setNumeroDeCompte(int numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	public double getDecouvertAutorise() {
		// TODO Auto-generated method stub
		return 5;
	}

// Méthodes

}
