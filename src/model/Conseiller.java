package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Fabien & Madjid; Elle correspond au model de fiche Conseiller
 *
 */
public class Conseiller {
	// Attributs
	private int id;
	private String nom;
	private String prenom;
	public String idAgence;
	public List<Client> clientsAttribues = new ArrayList<>();

	// Constructeur
	public Conseiller() {
		this("ROSEL", "Michel", "545k4");
	}

	public Conseiller(String nom, String prenom, String idAgence) {
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
	}
	// Getters & setters

	public List<Client> getClientsAttribues() {
		return clientsAttribues;
	}

	public void setClientsAttribues(List<Client> clientsAttribues) {
		this.clientsAttribues = clientsAttribues;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// Méthode

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", idAgence=" + idAgence
				+ ", clientsAttribues=" + clientsAttribues + "]";
	}

}
