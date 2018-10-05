package presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import service.ImplementationService;
import service.Service;

/**
 * Servlet implementation class EditerClientPres
 */
@WebServlet("/EditerClientPres")
public class EditerClientPres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new ImplementationService();

	/**
	 * @see HttpServlet#HttpServlet() Cette SERVLET permet d'appeler la fonction
	 *      service.updateClient() de la couche service pour mettre à jour un client
	 */
	public EditerClientPres() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idWEB = request.getParameter("idClient");
		int idClient = Integer.parseInt(idWEB);
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String cpS = request.getParameter("cp");
		int cp = Integer.parseInt(cpS);
		String ville = request.getParameter("ville");

		Client c1 = new Client(idClient, nom, prenom, adresse, cp, ville);
		service.updateClient(c1);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
