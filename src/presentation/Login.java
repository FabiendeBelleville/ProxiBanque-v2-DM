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

/**
 * Quand l'application d�marre, chargement automatique de nla servlet et de la
 * methode init qui va demarrer et charger le contexte. Tant que le login ne sera
 * pas bien renseign� la page restera sur la page login. Des lors que l'on
 * est itentifi� on restera dans la Servlet.
 * 
 * Au d�mmarage la Servlet va demander � initialiser un DAOContext permettant de
 * r�cuperer le contexte dans laquelle la servlet est demarr�e, permettant ainsi
 * d'executer la page web.xml
 * 
 * La premiere fois dans le doGet le loginne sera pas sauvgarder,
 * mais en chaine vide ainsi que errorMessage
 * 
 * 
 * 
 * Dans @request.getRequestDispatcher redirection vers la VUE au niveau du
 * login.jsp qui doit afficher les donn�es
 * 
 * 
 * 
 * Sur @request.setAttribute("login", login); Dans le cas ou l'erruer
 * d'authentification est du a un mauvais password On stocke le login pour que
 * l'utilisateur n'ait pas a le retaper
 * 
 * 
 * Dans @Conseiller conseiller = UserDAO.isValidLogin(login, password); On se
 * connecte a la BDD via UserDAO qui contient une methode static IsvalidLogin a
 * qui l'on passe le login et le password que l'on a au niveau de la requete. Si
 * il est different de null et bien connect� je le redirige vers d'autres pages
 * ou bien pointeur null on est en erreur
 * 
 * 
 * @author Marlon/Fabien
 *
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

//	/**
//	 * Au d�mmarage la Servlet va demander a initialiser un DAOContext permettant de
//	 * recuperer le contexte dans laquelle la servlet est demarrer permettant ainsi
//	 * d'executer la page web.xml
//	 */

	public void init() throws ServletException {
		DAOContext.init(this.getServletContext());
	}

//	/**
//	 * premiere fois dansle doGet du coup je ne sauvegarde pas mon login qui est en
//	 * chaine vide ainsi que errorMessage
//	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("login", "");
		request.setAttribute("password", "");
		request.setAttribute("errorMessage", "");

//		/**
//		 * redirection vers la VUE au niveau du login.jsp qui doit afficher les donn�es
//		 * 
//		 */

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		/**
//		 * je sors le login et le password et je stock cela dans la request qui est mon
//		 * mod�le de representation
//		 */

		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		/**
		 * Dans le cas ou l'erruer d'authentification est du a un mauvais password On
		 * stocke le login pour que l'utilisateur n'ait pas a le retaper
		 */

		request.setAttribute("login", login);
		request.setAttribute("password", password);
		/**
		 * Connection a la BDD via UserDAO qui contient une methode static IsvalidLogin
		 * a qui l'on passe le login et le password que l'on a au niveau de la requete.
		 * Si il est different de null et bien connect� je le redirige vers d'autres
		 * pages ou bien pointeur null on est en erreur
		 */

		Conseiller conseiller = UserDAO.isValidLogin(login, password);
		if (conseiller != null) {

			HttpSession session = request.getSession(true);
			session.setAttribute("connectedUser", conseiller);

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} else {

			request.setAttribute("errorMessage", "Mauvaise identit�");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println("Mauvaise authentification");

		}
	}

}
