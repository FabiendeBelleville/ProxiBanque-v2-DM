package persistance;

import javax.servlet.ServletContext;

public class DAOContext {
	protected static String dbURL;
	protected static String dbLogin;
	protected static String dbPassword;

	public static void init(ServletContext context) {
		try {
			
//Les param�tres db-url, db-login et db-passwd sont �crits dans le fichier web.xml
			
			Class.forName(context.getInitParameter("JDBC_DRIVER"));
			dbURL = context.getInitParameter("JDBC_URL");
			dbLogin = context.getInitParameter("JDBC_LOGIN");
			dbPassword = context.getInitParameter("JDBC_PASSWORD");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		
	}

}
