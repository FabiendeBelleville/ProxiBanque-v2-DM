package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Conseiller;
// ouverture de connection a la BDD
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
