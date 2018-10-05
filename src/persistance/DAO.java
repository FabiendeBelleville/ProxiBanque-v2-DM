package persistance;

import java.util.List;

import model.Client;
import model.Compte;

/**
 * 
 * @author Fabien & Marlon ; L'interface DAO est tel un contrat de sauvegarde des objets clients.
 *
 */
public interface DAO {

	// Client
	// Create
	public void save(Client c);
	
	//Compte
	//Create
	public void save(Compte cpt);

	// Read
	public Client findById(int id);

	// Read
	public List<Client> findAll();

	// Update
	public void update(Client c);

	// Delete
	public void delete(int id);

}
