package model;

/**
 * 
 * @author Fabien & Madjid; Ceci est la classe agence;
 * Elle n'a pas de setters car elle n'est pas modifiable après initialisation.
 * Elle a seulement des attributs, un constructeur, des getters et une méthode toString
 *
 */
public class Agence {
	// Attributs
	private String idAgence;
	private String dateCreation;
	private String nomGerant;

	// Constructeur
	public Agence(String idAgence, String dateCreation, String nomGerant) {
		this.idAgence = idAgence;
		this.dateCreation = dateCreation;
		this.nomGerant = nomGerant;
	}

	// Getters & setters
	public String getIdAgence() {
		return idAgence;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public String getNomGerant() {
		return nomGerant;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", dateCreation=" + dateCreation + ", nomGerant=" + nomGerant + "]";
	}

	// Méthodes

}
