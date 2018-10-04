package model;
/**
 * 
 * @author Fabien & Madjid;
 * Classe abstraie CB; A ce stade du développement de l'application, elle ne contient qu'une seule méthode.
 *
 */
public abstract class CB {
	// Attributs
	private String numeroDeCB;

	// Constructeur
	
	// Getters & setters
	public String getNumerodeCB() {
		return numeroDeCB;
	}

	public void setNumerodeCB(String numerodeCB) {
		this.numeroDeCB = numerodeCB;
	}

	// Méthodes

	abstract void paiementCB(double montant);

}
