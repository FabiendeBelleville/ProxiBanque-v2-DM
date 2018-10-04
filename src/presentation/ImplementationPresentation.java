package presentation;

import java.util.Scanner;

import model.Agence;
import model.Gerant;
import service.ImplementationService;

/**
 * 
 * @author Fabien & Madjid; A ce stade du développement de l'application, la
 *         classe Presentation contenant une méthode main nous permet de lancer
 *         le programme. En intéragissant avec l'utilisateur, les données
 *         initiales sont saisie, les objets sont instanciés, les méthodes sont
 *         appelées.
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
