package persistance;

import javax.servlet.ServletContext;
/**
 * Les param�tres db-url, db-login et db-passwd sont �crits dans le fichier web.xml
 * ils seront r�cup�r�s dans le UserDAO
 * 
 * Le chargement du Driver s'effectura grace � JDBC_Driver	
 * au d�marrage de l'application et va recup�rer les informations 
 * presentes dans le fichier web.xml
 * 
 * @author Marlon/Fabien
 *
 */
public class DAOContext {
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;

	public static void init(ServletContext context) {
		try {
			

		/**
		 * Le chargement du Driver aurat lieu via JDBC_Driver	
		 * au d�marrage de l'application et va recup�rer les informatios 
		 * presentes dans le fichier web.xml
		 */
			Class.forName(context.getInitParameter("JDBC_DRIVER"));
			dbURL = context.getInitParameter("JDBC_URL");
			dbLogin = context.getInitParameter("JDBC_LOGIN");
			dbPassword = context.getInitParameter("JDBC_PASSWORD");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
	}

}
