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
import model.Compte;

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
			String sql = "INSERT INTO CLIENT (idWEB, nom, prenom, adresse, codePostal, ville, numcptC, numcptE) VALUES(?,?,?,?,?,?,?,?)";
			pst = cn.prepareStatement(sql);
			pst.setString(1, "1");
			pst.setString(2, c.getNom());
			pst.setString(3, c.getPrenom());
			pst.setString(4, c.getAdresse());
			System.out.println("on est la2");
			pst.setInt(5, c.getCodePostal());
			pst.setString(6, c.getVille());
			pst.setInt(7, c.getNumcptC());
			pst.setInt(8, c.getNumcptE());

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
			String sql = "SELECT idClient, idWEB, nom, prenom, adresse, codePostal, ville, numcptC, numcptE FROM client where idClient =?";
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
				int numcptC = rs.getInt("numcptC");
				int numcptE = rs.getInt("numcptE");

				c = new Client(idClient, idWEB, nom, prenom, adresse, codePostal, ville, numcptC, numcptE);

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
		System.out.println("on attaque la DB");

		Map<Integer, Client> fabiennnnnnnnn = new HashMap<>();
		int idClient = -500;
		String idWEB = null;
		String nom = null;
		String prenom = null;
		String adresse = null;
		int codePostal = 0;
		String ville = null;
		int numcptC = 0;
		int numcptE = 0;

		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			cn = JDBCUtil.seConnecter();
			// étape 3 : création d'un statement
			String sql = "SELECT idClient, idWEB, nom, prenom, adresse, codePostal, ville, numcptC, numcptE FROM client where idClient >=?";
			pst = cn.prepareStatement(sql);
			pst.setInt(1, 0);
			// étape 4 exécution d'une requête
			rs = pst.executeQuery();
			// étape 5 parcours ResultSet
			while (rs.next()) {
				idClient = rs.getInt("idClient");
//				idWEB = rs.getString("idWEB");
				idWEB = String.valueOf(idClient);
				nom = rs.getString("nom");
				prenom = rs.getString("prenom");
				adresse = rs.getString("adresse");
				codePostal = rs.getInt("codePostal");
				ville = rs.getString("ville");
				numcptC = rs.getInt("numcptC");
				numcptE = rs.getInt("numcptE");

				Client c = new Client(idClient, idWEB, nom, prenom, adresse, codePostal, ville, numcptC, numcptE);
				fabiennnnnnnnn.put(rs.getInt("idClient"), c);
				// System.out.println(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.seDeconnecter(pst, null, cn);
		}
		return new ArrayList<>(fabiennnnnnnnn.values());
		// return new ArrayList<>(DBClient.values());
	}

	@Override
	public void update(Client c) {
		int result = -1;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = JDBCUtil.seConnecter();
			// étape 3 : création d'un statement
			String sql = "UPDATE client SET nom=?, prenom=?, adresse=?, codePostal=?, ville=? WHERE idClient=?";
			pst = cn.prepareStatement(sql);
			pst.setString(1, c.getNom());
			pst.setString(2, c.getPrenom());
			pst.setString(3, c.getAdresse());
			pst.setInt(4, c.getCodePostal());
			pst.setString(5, c.getVille());
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
		return;
	}

	@Override
	public void delete(int id) {
		DBClient.remove(id);
	}

	@Override
	public void save(Compte cpt) {
		System.out.println("on créer les comptes");
		int result = -1;
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			cn = JDBCUtil.seConnecter();
			// étape 3 : création d'un statement
			String sql = "INSERT INTO COMPTE (dateOuverture, solde, numeroDeCompte) VALUES(?,?,?)";
			pst = cn.prepareStatement(sql);
			pst.setString(1, cpt.getDateOuverture());
			pst.setDouble(2, cpt.getSolde());
			pst.setInt(3, cpt.getNumeroDeCompte());

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

}
