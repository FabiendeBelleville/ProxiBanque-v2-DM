package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Fabien & Marlon ; JDBC Util contient les m�thodes seConnecter et
 *         seDeconnecter propre � la database proxibanque-v2-dm avec login
 *         password et driver, �vitant de faire de la redondance de code source
 *         d'erreur
 *
 */
public abstract class JDBCUtil {
	private static final String url = "jdbc:mysql://localhost/proxibanque-v2-dm";
	private static final String login = "root";
	private static final String password = "";
	private static final String driver = "com.mysql.jdbc.Driver";

	public static Connection seConnecter() throws ClassNotFoundException, SQLException {
		Connection cn = null;
		// �tape 1 : chargement du driver
		// pleinement qualifi�e
		Class.forName("com.mysql.jdbc.Driver");
		// �tape 2 : r�cup�ration de la connexion
		cn = DriverManager.getConnection(url, login, password);
		cn.setAutoCommit(false);
		return cn;
	}

	public static void seDeconnecter(PreparedStatement ps, ResultSet r, Connection cnx) {
		// Etape 6 : lib�trer la m�moire
		try {
			if (cnx != null)
				cnx.close();
		} catch (SQLException e) {
			System.err.println("erreur de d�connexion");
		}
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			System.err.println("erreur lors de la fermeture du PreparedStatement");
			e.printStackTrace();
		}
		try {
			if (r != null)
				r.close();
		} catch (SQLException e) {
			System.err.println("erreur lors de la fermeture du ResultSet");
			e.printStackTrace();
		}
	}
}
