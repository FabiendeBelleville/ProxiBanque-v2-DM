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
	private String login;
	private String password;
	
	
	public List<Client> clientsAttribues = new ArrayList<>();





	// Constructeur
	public Conseiller() {
		
	}
	

	public Conseiller(int id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}


	public Conseiller(String nom, String prenom, String idAgence) {
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
	}
	
	public Conseiller(int id, String nom, String prenom, String idAgence, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.idAgence = idAgence;
		this.login = login;
		this.password = password;
		
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
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Méthode

	@Override
	public String toString() {
		return "Conseiller [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", idAgence=" + idAgence
				+ ", clientsAttribues=" + clientsAttribues + "]";
	}

	
}
