package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conseiller;
import persistance.DAOContext;
import persistance.UserDAO;

//Quand l'application va demarrer chargement automatique de 
//notre servlet et notre methode init va demarrer et charger notre 
//contexte
//@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}
	// Au démmarage la Servlet va demander a initialiser un DAOContext permettant de
	// recuperer
	// le contexte dans laquelle
	// la servlet est demarrer permettant ainsi d'executer la page web.xml

	public void init() throws ServletException {
		DAOContext.init(this.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("errorMessage", "");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");

		request.setAttribute("login", login);
		request.setAttribute("password", password);

		Conseiller conseiller = UserDAO.isValidLogin(login, password);
		if (conseiller != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("connectedUser", conseiller);

			request.getRequestDispatcher("index.html").forward(request, response);

		} else {

			request.setAttribute("Message d'erreur", "Mauvaise identité");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}

}
