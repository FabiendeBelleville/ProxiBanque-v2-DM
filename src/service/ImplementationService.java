package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import model.Conseiller;
import persistance.DAO;
import persistance.DAOConseiller;
import persistance.MemoryConseillerDAO;
import persistance.MemoryDAO;
import presentation.CreerClient;
import presentation.findClient;

/**
 * 
 * @author Fabien & Madjid; La classe ImplementationService implements Service.
 *         C'est la classe o� les m�thodes sont cod�es. Les DAO Client et
 *         Conseiller sont instanci�es ici. A ce stade du d�veloppement de
 *         l'application, la m�thode Audit reste inachev�e.
 * 
 */
public class ImplementationService implements Service {
	private DAO dao = new MemoryDAO();
	private DAOConseiller daoConseiller = new MemoryConseillerDAO();

	@Override
	public void creerClient(String nom, String prenom, String adresse, int cp, String ville, double firstDepotCC,
			double firstDepotCE) {

		// Cr�ation client
		CompteCourant courant = new CompteCourant(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				firstDepotCC, (int) Math.round(Math.random() * 1000000), 1000);
		CompteEpargne epargne = new CompteEpargne(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				firstDepotCE, (int) Math.round(Math.random() * 1000000), 0);
		dao.save(new Client(nom, prenom, adresse, cp, ville, 000000000, courant, epargne));
		System.out.println("Client sauvegard� !");
	}

	@Override
	public Client consulterClient(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Client> consulterListeClient() {
		System.out.println("Voici la liste exhaustive des clients de l'agence");
		System.out.println(dao.findAll());
		System.out.println("retour menu principal");
		return dao.findAll();
	}

	@Override
	public void supprimerClient(int id) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer l'id du client � supprimer");
		int id1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Le client suivant va �tre supprim�");
		System.out.println(dao.findById(id1));
		System.out.println("Confirmez-vous la suppression du client ? (oui/non)");
		String suppr = scanner.nextLine();
		if (suppr.equals("oui")) {
			dao.delete(id1);
			System.out.println("Client supprim�");
			System.out.println("retour au menu principal");
		} else if (suppr.equals("non")) {
			System.out.println("annulation");
			System.out.println("retour au menu principal");

		} else {
			System.out.println("erreur de saisie");
			System.out.println("retour au menu principal");

		}

	}

	/**
	 * Le Service FaireVirement permet d'effectuer un virement. Il s'agit d'une
	 * m�thode qui effectue les op�rations et affiche les �tapes du vrement
	 */

	@Override
	public void simulerCredit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer le montant de l'emprunt (en euros)");
		double montantEmprunt = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Veuillez entrer le nombre d'�ch�ances (nombre de mois)");
		int nb_echeances = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Veuillez entrer le taux annuel (en %, par exemple 2,2)");
		double taux_annuel = scanner.nextDouble() / 100;
		scanner.nextLine();
		double montantEcheanceMensuelle = (montantEmprunt * (taux_annuel) / 12)
				/ (1 - (Math.pow((1 + ((taux_annuel) / 12)), (-nb_echeances))));

		double montantEcheanceMensuelleRounded = (double) Math.round(montantEcheanceMensuelle * 100) / 100;
		System.out.println("");
		System.out.println("*************************************************************");
		System.out.println("**************R�sultat de la simulation de pr�t**************");
		System.out.println("*************************************************************");
		System.out.println("Montant d'une �ch�ance mensuelle : " + montantEcheanceMensuelleRounded + " euros/mois");
		double totalEcheancesRounded = (double) Math.round(montantEcheanceMensuelle * nb_echeances * 100) / 100;
		System.out.println("Soit au total au bout des �ch�ances : " + totalEcheancesRounded + " euros");
		double coutTotalDuPretRounded = (double) Math
				.round((montantEcheanceMensuelle * nb_echeances - montantEmprunt) * 100) / 100;
		System.out.println("Soit un co�t total du pr�t de : " + coutTotalDuPretRounded + " euros");
		double coutAnnuelDuPretRounded = (double) Math
				.round(((montantEcheanceMensuelle * nb_echeances - montantEmprunt) / (nb_echeances / 12)) * 100) / 100;
		System.out.println("Rapport� � une ann�e, le co�t du pr�t est de " + coutAnnuelDuPretRounded + " euros/an");
		System.out.println("*************************************************************");
		System.out.println("");
		System.out.println("retour au menu principal");

	}

	@Override
	public void faireAudit(Compte... qsdf) {
		for (Compte compte : qsdf) {
			compte.getSolde();
			System.out.println(compte.getNumeroDeCompte());
		}
		// brouillon de m�thode :
		// Pour chaque compte bancaire, getType
		// if particulier
		// getSold Particulier
		// if Solde<5000
		// alors syso Compte d�bityuer de + de 5000 euros
		// else (entreprise)
		// getSold Entreprise
		// if Solde<50000
		// alors syso Compte d�bityuer de + de 50000 euros
	}

	@Override
	public void creerConseiller(Conseiller con) {

		// Cr�ation d'un conseiller
		Conseiller con0 = new Conseiller();
		Service s1 = new ImplementationService();
		s1.creerConseiller(con0);

		// attribution d'un client � un conseiller
		s1.attribuerClientAConseiller(con0, null);

		System.out.println("Le conseiller qui a �t� automatiquement affect� au client est :");
		System.out.println(con0);
		System.out.println("************************************************************");
		System.out.println("Voici la liste exhaustive des clients de l'agence");
		System.out.println(s1.consulterListeClient());
		System.out.println("************************************************************");
		System.out.println("Voici la liste exhaustive des conseillers de l'agence");
		System.out.println(s1.consulterListeConseiller());
		System.out.println("************************************************************");

		if (con != null) {
			daoConseiller.saveConseiller(con);
		}
	}

	@Override
	public List<Conseiller> consulterListeConseiller() {
		return daoConseiller.findAllConseiller();
	}

	@Override
	public void attribuerClientAConseiller(Conseiller conseillerARemplir, Client clientAAttribuer) {

		if (conseillerARemplir.clientsAttribues.size() < 10) {
			conseillerARemplir.clientsAttribues.add(clientAAttribuer);
			System.out.println(clientAAttribuer + " ajout� !");
		} else {
			System.out.println(conseillerARemplir.getNom() + " est complet, choisir un autre conseiller");
		}

	}

	private void faireVirement(double montant, Compte compteDestinataire, Compte compteEmetteur, String typeEmetteur) {
		// Affichage op�ration � effectuer
		System.out.println("Le virement bancaire suivant va �tre effectu� :");
		System.out.println("Le compte Emetteur est : " + compteEmetteur);
		System.out.println("Le compte Destinataire est : " + compteDestinataire);
		System.out.println("Le montant du virement est : " + montant);

		// type de compte emetteur
		double decouvertAutorise = 0;
		if (typeEmetteur.equals("Courant")) {
			decouvertAutorise = CompteCourant.getDecouvertAutoriseCC();
		} else if (typeEmetteur.equals("Epargne")) {
			decouvertAutorise = CompteEpargne.getDecouvertAutoriseCE();
		} else {
			System.out.println("Probl�me");
		}

		// op�ration
		if ((compteEmetteur.getSolde() - montant) < -decouvertAutorise) {
			System.out.println("******************************************");
			System.out.println("REFFUSE : le virement n'a pas �t� effectu�");
			System.out.println("******************************************");
			System.out.println("Cause : solde compte emetteur insuffisant");

		} else {
			compteDestinataire.setSolde(compteDestinataire.getSolde() + montant);
			compteEmetteur.setSolde(compteEmetteur.getSolde() - montant);

			// Affichage r�capic�
			System.out.println("************************************");
			System.out.println("ACCEPTE : le virement a �t� effectu�");
			System.out.println("************************************");
			System.out.println("� pr�sent, le compte Destinataire (n�" + compteDestinataire.getNumeroDeCompte()
					+ " est : " + compteDestinataire);
			System.out.println("� pr�sent, le compte Emetteur (n�" + compteEmetteur.getNumeroDeCompte() + " est : "
					+ compteEmetteur);
		}

	}

	@Override
	public void faireVirement() {
		Compte compteDestinataire = null;
		Compte compteEmetteur = null;
		String typeEmetteur = null;

		Scanner scanner = new Scanner(System.in);

		// Interface
		System.out.println("Veuillez entrer le montant du virement");
		double montantTmp = scanner.nextDouble();
		scanner.nextLine();

		while (compteDestinataire == null || compteEmetteur == null) {
			compteDestinataire = null;
			compteEmetteur = null;

			System.out.println("Veuillez entrer le num�ro de compte �metteur");
			int numCompteEmetteur = scanner.nextInt();
			scanner.nextLine();

			System.out.println("Veuillez entrer le num�ro de compte destinataire");
			int numCompteDestinataire = scanner.nextInt();
			scanner.nextLine();

			for (Client client : dao.findAll()) {
				if (client.getCompteCourant().getNumeroDeCompte() == numCompteEmetteur) {
					compteEmetteur = client.getCompteCourant();
					typeEmetteur = "Courant";
				}
				if (client.getCompteEpargne().getNumeroDeCompte() == numCompteEmetteur) {
					compteEmetteur = client.getCompteEpargne();
					typeEmetteur = "Epargne";
				}
				if (client.getCompteCourant().getNumeroDeCompte() == numCompteDestinataire) {
					compteDestinataire = client.getCompteCourant();
				}
				if (client.getCompteEpargne().getNumeroDeCompte() == numCompteDestinataire) {
					compteDestinataire = client.getCompteEpargne();
				}
			}

			if (compteDestinataire == null) {
				System.out.println("Le compte destinataire #" + numCompteDestinataire + "# est introuvable");
			}
			if (compteEmetteur == null) {
				System.out.println("Le compte �metteur #" + numCompteEmetteur + "# est introuvable");
			}
		}
		faireVirement(montantTmp, compteDestinataire, compteEmetteur, typeEmetteur);
	}

	@Override
	public String methodeScannerString(String tmp) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			tmp = scanner.nextLine();
			if (tmp.equals("exit")) {
				System.out.println("Vous avez tap� 'exit' -> Fin du programme");
				break;
			}
			return tmp;
		}
		return tmp;
	}

}