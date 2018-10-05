package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Conseiller;

/**
 *  
 *  ouverture de connection a la BDD
 *  La servlet excécute ma méthode mais tout ce qui concerne la BDD
 *  ce trouve dans ce paquetage, permettant de la garder evolutive 
 *  
 *  production d'un ordre sql et d'un @statement qui l'excecute.
 *  le resultat est stocké dans un @resulset
 *  Ou bien on n'a un utilisateur connecté qui renvoi à la base 
 *  et l'on a un Conseiller ou bien il renvoi strictement rien et alors on 
 *  renvoi null
 *  
 *  
 *  utilisation de try with ressource qui me permettent de garantir que des lors que je sors du bloc
 *  dans lequel je suis placé il y'aura systématiquement une libérations de mes ressources
 *  (le @resultset implemente l'interface autoclosable)
 *  
 *  
 * @author Marlon Fabien
 *
 */

public class UserDAO extends DAOContext {
	public static Conseiller isValidLogin(String login, String password) {
		try (Connection connection = JDBCUtil.seConnecter()) {
			
			String strSql = "SELECT * FROM Conseiller WHERE nom=? AND pwd=?";
			try (PreparedStatement statement = connection.prepareStatement(strSql)) {
				statement.setString(1, login);
				statement.setString(2, password);
				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						return new Conseiller(
								resultSet.getInt("id"), 
								resultSet.getString("nom"),
								resultSet.getString("pwd"));
					} else {
						return null;
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
