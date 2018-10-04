package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
 * Servlet implementation class consulterTousLesClients
 */
@WebServlet("/ConsulterTousLesClients")
public class ConsulterTousLesClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Service service = new ImplementationService();

	public ConsulterTousLesClients() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
		doGet(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// chercher les clients dans le service

		List<Client> listeClients = new ArrayList<>();
		listeClients = service.consulterListeClient();

		System.out.println(listeClients);
		request.setAttribute("laListe", listeClients);
		RequestDispatcher request0 = request.getRequestDispatcher("AffichageFindAllClient.jsp");
		request0.forward(request, response);

	}
}
