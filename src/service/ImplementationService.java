package service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import presentation.FindClient;

/**
 * 
 * @author Fabien & Madjid; La classe ImplementationService implements Service.
 *         C'est la classe où les méthodes sont codées. Les DAO Client et
 *         Conseiller sont instanciées ici. A ce stade du développement de
 *         l'application, la méthode Audit reste inachevée.
 * 
 */
public class ImplementationService implements Service {
	private DAO dao = new MemoryDAO();
	private DAOConseiller daoConseiller = new MemoryConseillerDAO();

	@Override
	public void creerClient(String nom, String prenom, String adresse, int cp, String ville, double firstDepotCC,
			double firstDepotCE) {

		// Création client
		CompteCourant courant = new CompteCourant(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				firstDepotCC, (int) Math.round(Math.random() * 1000000), 1000);
		CompteEpargne epargne = new CompteEpargne(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
				firstDepotCE, (int) Math.round(Math.random() * 1000000), 0);
		dao.save(new Client(nom, prenom, adresse, cp, ville, 000000000, courant, epargne));
		System.out.println("Client sauvegardé !");
	}

	@Override
	public Client consulterClient(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Client> consulterListeClient() {
		return dao.findAll();
	}

	@Override
	public void supprimerClient(int id) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer l'id du client à supprimer");
		int id1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Le client suivant va être supprimé");
		System.out.println(dao.findById(id1));
		System.out.println("Confirmez-vous la suppression du client ? (oui/non)");
		String suppr = scanner.nextLine();
		if (suppr.equals("oui")) {
			dao.delete(id1);
			System.out.println("Client supprimé");
		} else if (suppr.equals("non")) {
			System.out.println("annulation");

		} else {
			System.out.println("erreur de saisie");

		}

	}

	/**
	 * Le Service FaireVirement permet d'effectuer un virement. Il s'agit d'une
	 * méthode qui effectue les opérations et affiche les étapes du vrement
	 */

	@Override
	public void simulerCredit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Veuillez entrer le montant de l'emprunt (en euros)");
		double montantEmprunt = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Veuillez entrer le nombre d'échéances (nombre de mois)");
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
		System.out.println("**************Résultat de la simulation de prêt**************");
		System.out.println("*************************************************************");
		System.out.println("Montant d'une échéance mensuelle : " + montantEcheanceMensuelleRounded + " euros/mois");
		double totalEcheancesRounded = (double) Math.round(montantEcheanceMensuelle * nb_echeances * 100) / 100;
		System.out.println("Soit au total au bout des échéances : " + totalEcheancesRounded + " euros");
		double coutTotalDuPretRounded = (double) Math
				.round((montantEcheanceMensuelle * nb_echeances - montantEmprunt) * 100) / 100;
		System.out.println("Soit un coût total du prêt de : " + coutTotalDuPretRounded + " euros");
		double coutAnnuelDuPretRounded = (double) Math
				.round(((montantEcheanceMensuelle * nb_echeances - montantEmprunt) / (nb_echeances / 12)) * 100) / 100;
		System.out.println("Rapporté à une année, le coût du prêt est de " + coutAnnuelDuPretRounded + " euros/an");
		System.out.println("*************************************************************");
		System.out.println("");

	}

	@Override
	public void faireAudit(Compte... qsdf) {
		for (Compte compte : qsdf) {
			compte.getSolde();
			System.out.println(compte.getNumeroDeCompte());
		}
		// brouillon de méthode :
		// Pour chaque compte bancaire, getType
		// if particulier
		// getSold Particulier
		// if Solde<5000
		// alors syso Compte débityuer de + de 5000 euros
		// else (entreprise)
		// getSold Entreprise
		// if Solde<50000
		// alors syso Compte débityuer de + de 50000 euros
	}

	@Override
	public void creerConseiller(Conseiller con) {

		// Création d'un conseiller
		Conseiller con0 = new Conseiller();
		Service s1 = new ImplementationService();
		s1.creerConseiller(con0);

		// attribution d'un client à un conseiller
		s1.attribuerClientAConseiller(con0, null);

		System.out.println("Le conseiller qui a été automatiquement affecté au client est :");
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
			System.out.println(clientAAttribuer + " ajouté !");
		} else {
			System.out.println(conseillerARemplir.getNom() + " est complet, choisir un autre conseiller");
		}

	}

	private List<String> faireVirement(double montant, Compte compteDestinataire, Compte compteEmetteur,
			String typeEmetteur) {
		List<String> consoleprofonde = new ArrayList<>();
		// Affichage opération à effectuer
		String l1 = "Le virement bancaire suivant va être effectué :";
		System.out.println(l1);
		consoleprofonde.add(l1);
		String l2 = "Le compte Emetteur est : " + compteEmetteur;
		System.out.println(l2);
		consoleprofonde.add(l2);
		String l3 = "Le compte Destinataire est : " + compteDestinataire;
		System.out.println(l3);
		consoleprofonde.add(l3);
		String l4 = "Le montant du virement est : " + montant;
		System.out.println(l4);
		consoleprofonde.add(l4);

		// type de compte emetteur
		double decouvertAutorise = 0;
		if (typeEmetteur.equals("Courant")) {
			decouvertAutorise = CompteCourant.getDecouvertAutoriseCC();
		} else if (typeEmetteur.equals("Epargne")) {
			decouvertAutorise = CompteEpargne.getDecouvertAutoriseCE();
		} else {
			System.out.println("Problème");
		}

		// opération
		if ((compteEmetteur.getSolde() - montant) < -decouvertAutorise) {
			String l5 = "******************************************";
			consoleprofonde.add(l5);
			System.out.println(l5);
			String l6 = "REFFUSE : le virement n'a pas été effectué";
			consoleprofonde.add(l6);
			System.out.println(l6);
			String l7 = "******************************************";
			consoleprofonde.add(l7);
			System.out.println(l7);
			String l8 = "Cause : solde compte emetteur insuffisant";
			consoleprofonde.add(l8);
			System.out.println(l8);

		} else {
			compteDestinataire.setSolde(compteDestinataire.getSolde() + montant);
			compteEmetteur.setSolde(compteEmetteur.getSolde() - montant);

			// Affichage récapicé
			String l9 = "************************************";
			System.out.println(l9);
			consoleprofonde.add(l9);
			String l10 = "ACCEPTE : le virement a été effectué";
			System.out.println(l10);
			consoleprofonde.add(l10);
			String l11 = "************************************";
			System.out.println(l11);
			consoleprofonde.add(l11);
			String l12 = "à présent, le compte Destinataire (n°" + compteDestinataire.getNumeroDeCompte() + " est : "
					+ compteDestinataire;
			System.out.println(l12);
			consoleprofonde.add(l12);
			String l13 = "à présent, le compte Emetteur (n°" + compteEmetteur.getNumeroDeCompte() + " est : "
					+ compteEmetteur;
			System.out.println(l13);
			consoleprofonde.add(l13);
		}

		return consoleprofonde;

	}

	@Override
	public List<String> faireVirement(double montant, int numCompteEmetteur, int numCompteDestinataire) {
		// celle à lier avec PRESENTATION
		String typeEmetteur = null;
		Compte compteEmetteur = null;
		Compte compteDestinataire = null;
		double montantTmp = montant;

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
			System.out.println("Le compte émetteur #" + numCompteEmetteur + "# est introuvable");
		}

		List<String> console0 = faireVirement(montantTmp, compteDestinataire, compteEmetteur, typeEmetteur);

		return console0;
	}

	@Override
	public String methodeScannerString(String tmp) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			tmp = scanner.nextLine();
			if (tmp.equals("exit")) {
				System.out.println("Vous avez tapé 'exit' -> Fin du programme");
				break;
			}
			return tmp;
		}
		return tmp;
	}

}