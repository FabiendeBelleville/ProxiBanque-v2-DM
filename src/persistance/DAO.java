package persistance;

import java.util.List;

import model.Client;

/**
 * 
 * @author Fabien & Madjid; L'interface DAO est tel un contrat de sauvegarde des objets clients.
 *
 */
public interface DAO {

	// Client
	// Create
	public void save(Client c);

	// Read
	public Client findById(int id);

	// Read
	public List<Client> findAll();

	// Update
	public void update(Client c);

	// Delete
	public void delete(int id);

}
