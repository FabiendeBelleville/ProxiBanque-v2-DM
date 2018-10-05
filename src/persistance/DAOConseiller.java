package persistance;

import java.util.List;
import model.Conseiller;

/**
 * 
 * @author Fabien et Marlon. L'interface DAOConseiller est tel un contrat de sauvegarde des objets Conseillers.
 *
 */
public interface DAOConseiller {
	// Conseiller
		// Create
			public void saveConseiller(Conseiller con);

			// Read
			//public Conseiller findById(int id);

			// Read
			public List<Conseiller> findAllConseiller();

			// Update
			public void updateConseiller(Conseiller con);

			// Delete
			//public void delete(int id);
}
