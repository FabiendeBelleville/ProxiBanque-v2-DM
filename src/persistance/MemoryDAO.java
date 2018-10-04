package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Client;

/**
 * 
 * @author Fabien et Madjid. La classe MemoryDAO permet d'enregistrer les objets
 *         Client en simulant la sauvegarde en base de donnée. Elle implémente
 *         les fonctions de l'interface DAOConseiller
 *
 */
public class MemoryDAO implements DAO {

	private static final Map<Integer, Client> DBClient = new HashMap<>();
	private int idClient = 0;

	public MemoryDAO() {
	}

	@Override
	public void save(Client c) {
		// avant
//		c.setid(idClient); // Artifice pour simuler l'auto increment d'une DB. Ne fait pas tous les cas !
//		DBClient.put(c.getid(), c);
//		System.out.println(DBClient);
//		idClient++;
		System.out.println("on est la");
		int result = -1;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = JDBCUtil.seConnecter();
			// étape 3 : création d'un statement
			String sql = "INSERT INTO CLIENT (idWEB, nom, prenom, adresse, codePostal, ville) VALUES(?,?,?,?,?,?)";
			pst = cn.prepareStatement(sql);
			pst.setString(1, "1");
			pst.setString(2, c.getNom());
			pst.setString(3, c.getPrenom());
			pst.setString(4, c.getAdresse());
			System.out.println("on est la2");
			pst.setInt(5, c.getCodePostal());
			pst.setString(6, c.getVille());

			// étape 4 : exécution requête
			result = pst.executeUpdate();
			cn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				if (cn != null)
					cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCUtil.seDeconnecter(pst, null, cn);
		}

	}

	@Override
	public Client findById(int id) {
		// avant
//		System.out.println(DBClient.get(id));
//		return DBClient.get(id);test

		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Client c = null;
		try {
			cn = JDBCUtil.seConnecter();
			// étape 3 : création d'un statement
			String sql = "SELECT idClient, idWEB, nom, prenom, adresse, codePostal, ville FROM client where idClient =?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, id);
			// étape 4 exécution d'une requête
			rs = pst.executeQuery();
			// étape 5 parcours ResultSet
			while (rs.next()) {

				// allé
				// idWEB, nom, prenom, adresse, codePostal, ville

				int idClient = rs.getInt("idClient");
				String idWEB = rs.getString("idWEB");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				int codePostal = rs.getInt("codePostal");
				String ville = rs.getString("ville");
				c = new Client(idClient, idWEB, nom, prenom, adresse, codePostal, ville);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.seDeconnecter(pst, null, cn);
		}
		return c;
	}

	@Override
	public List<Client> findAll() {
		return new ArrayList<>(DBClient.values());
	}

	@Override
	public void update(Client c) {
	}

	@Override
	public void delete(int id) {
		DBClient.remove(id);
	}

}
