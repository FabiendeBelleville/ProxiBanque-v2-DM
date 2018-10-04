package presentation;

import java.util.Scanner;

import model.Agence;
import model.Gerant;
import service.ImplementationService;

/**
 * 
 * @author Fabien & Madjid; A ce stade du d�veloppement de l'application, la
 *         classe Presentation contenant une m�thode main nous permet de lancer
 *         le programme. En int�ragissant avec l'utilisateur, les donn�es
 *         initiales sont saisie, les objets sont instanci�s, les m�thodes sont
 *         appel�es.
 *
 */
public class ImplementationPresentation implements Presentation {

	@Override
	public void bonjour() {
		// Initialisations

		System.out.println("Bonjour,");
		System.out.println("Le programme ProxiBanqueSI se lance");

		Scanner scanner = new Scanner(System.in);

		String tmpnom, tmpprenom;
		System.out.println("Veuillez entrer le nom du Gerant de l'agence");
		tmpnom = scanner.nextLine();
		System.out.println("Veuillez entrer le prenom du Gerant de l'agence");
		tmpprenom = scanner.nextLine();

	}

	@Override
	public void fin() {
		System.out.println("********FIN****************************************************");
	}

}
