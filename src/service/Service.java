package service;

import java.util.List;

import model.Client;
import model.Compte;
import model.Conseiller;

/**
 * 
 * @author Fabien & Madjid; L'interface Service contient les méthodes (vides)
 *         qui seront implémentées dans la classe ImplementationService. Les
 *         méthodes ne sont donc ici que des signatures.
 *
 */
public interface Service {

	public void creerClient(String nom, String prenom, String adresse, int cp, String ville, double firstDepotCC,
			double firstDepotCE);

	public Client consulterClient(int id);

	public List<Client> consulterListeClient();

	public void supprimerClient(int id);

	public List<String> faireVirement(double montant, int numCompteEmetteur, int numCompteDestinataire);

	public void simulerCredit();

	public void faireAudit(Compte... qsdf);

	// Conseiller
	public void creerConseiller(Conseiller con);

	// Conseiller
	public List<Conseiller> consulterListeConseiller();

	// Attribuer Client à Conseiller
	public void attribuerClientAConseiller(Conseiller conseillerARemplir, Client clientAAttribuer);

	public String methodeScannerString(String tmp);

}
