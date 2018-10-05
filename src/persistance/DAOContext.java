package persistance;

import javax.servlet.ServletContext;
/**
 * Les paramètres db-url, db-login et db-passwd sont écrits dans le fichier web.xml
 * ils seront récupérés dans le UserDAO
 * 
 * Le chargement du Driver s'effectura grace à JDBC_Driver	
 * au démarrage de l'application et va recupérer les informations 
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
		 * au démarrage de l'application et va recupérer les informatios 
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
