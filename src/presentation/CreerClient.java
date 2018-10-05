package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ImplementationService;
import service.Service;

/**
 * Servlet dans Presentation : Creer Client
 */
@WebServlet("/CreerClient")
public class CreerClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new ImplementationService();

	public CreerClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String cpS = request.getParameter("cp");
		int cp = Integer.parseInt(cpS);
		String ville = request.getParameter("ville");
		String firstDepotCCS = request.getParameter("depotCC");
		double firstDepotCC = Double.parseDouble(firstDepotCCS);
		String firstDepotCES = request.getParameter("depotCE");
		double firstDepotCE = Double.parseDouble(firstDepotCES);

		service.creerClient(nom, prenom, adresse, cp, ville, firstDepotCC, firstDepotCE);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
