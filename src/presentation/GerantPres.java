package presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Agence;
import model.Gerant;

/**
 * Servlet implementation class CestQui
 */
@WebServlet("/gerant")
public class GerantPres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerantPres() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		writer.println("<p>***********************Réponse du formulaire***********************");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		writer.println("<p> Nom : " + request.getParameter("nom"));
		writer.println("<p> Prénom : " + request.getParameter("prenom"));

		Gerant g1 = new Gerant(nom, prenom, "545k4");
		Agence a1 = new Agence(g1.idAgence, "01 janvier 1974", g1.getNom());
		writer.println("<p> Vous êtes connecté à l'agence : " + a1);

		writer.println("<p>*******************************************************************");
		response.getWriter().append("<p> Served at: ").append(request.getContextPath());

		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
