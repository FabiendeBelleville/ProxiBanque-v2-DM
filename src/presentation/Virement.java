package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.Compte;
import service.ImplementationService;
import service.Service;

/**
 * Servlet Virement. En cours de d�veloppement, la fonction faire virement ne
 * fonctionne pas encore.
 */
@WebServlet("/Virement")
public class Virement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private double montantDouble;
	private int numcptemetteur;
	private int numcptdestinataire;

	Service service = new ImplementationService();

	public Virement() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// r�cup�ration du formulaire html
		String montant = request.getParameter("montant");
		montantDouble = Double.parseDouble(montant);
		String cptemetteur = request.getParameter("cptemetteur");
		numcptemetteur = Integer.parseInt(cptemetteur);
		String cptdestinataire = request.getParameter("cptdestinataire");
		numcptdestinataire = Integer.parseInt(cptdestinataire);

		// Code initial avecd scanner

		Compte compteDestinataire = null;
		Compte compteEmetteur = null;
		String typeEmetteur = null;

		Scanner scanner = new Scanner(System.in);

		// Interface
		// Veuillez entrer le montant du virement
		double montantTmp = montantDouble;

		// Veuillez entrer le num�ro de compte �metteur
		int numCompteEmetteur = numcptemetteur;

		// Veuillez entrer le num�ro de compte destinataire
		int numCompteDestinataire = numcptdestinataire;

		// appel de la fonction

		// chercher les clients dans le service

		List<String> listeConsoleIssueDeLaMethode = new ArrayList<>();
//		service.faireVirement(montantTmp, numCompteEmetteur, numCompteDestinataire);
		System.out.println("**********");
		System.out.println("caca");
		System.out.println(listeConsoleIssueDeLaMethode);
		listeConsoleIssueDeLaMethode = service.faireVirement(montantTmp, numCompteEmetteur, numCompteDestinataire);
		request.setAttribute("laListeConsole", listeConsoleIssueDeLaMethode);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AffichageVirement.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
