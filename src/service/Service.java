package service;

import java.util.List;

import model.Client;
import model.Compte;
import model.Conseiller;

/**
 * 
 * @author Fabien & Marlon; L'interface Service contient les m�thodes (vides)
 *         qui seront impl�ment�es dans la classe ImplementationService. Les
 *         m�thodes ne sont donc ici que des signatures.
 *
 */
public interface Service {

	public void creerClient(String nom, String prenom, String adresse, int cp, String ville, double firstDepotCC,
			double firstDepotCE);

	public Client consulterClient(int id);

	public List<Client> consulterListeClient();
	
	public void updateClient(Client c);

	public void supprimerClient(int id);

	public List<String> faireVirement(double montant, int numCompteEmetteur, int numCompteDestinataire);

	public void simulerCredit();

	public void faireAudit(Compte... qsdf);

	// Conseiller
	public void creerConseiller(Conseiller con);

	// Conseiller
	public List<Conseiller> consulterListeConseiller();

	// Attribuer Client � Conseiller
	public void attribuerClientAConseiller(Conseiller conseillerARemplir, Client clientAAttribuer);

	public String methodeScannerString(String tmp);

}
