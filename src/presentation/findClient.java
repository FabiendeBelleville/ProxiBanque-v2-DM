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
 * Servlet implementation class CestQui
 */
@WebServlet("/findclient")
public class findClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;

	Service service = new ImplementationService();

	public findClient() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idS = request.getParameter("id");
		id = Integer.parseInt(idS);

		// cherche le client dans le service
		Client client = service.consulterClient(id);
		// on attaque le service ici//////////////
		request.setAttribute("detailUser", client);
		RequestDispatcher request0 = request.getRequestDispatcher("AffichageFindClient.jsp");
		request0.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
