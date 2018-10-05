package persistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Conseiller;

/**
 * 
 * @author Fabien et Marlon. La classe MemoryConseillerDAO permet d'enregistrer
 *         les objets Conseiller en simulant la sauvegarde en base de donnée.
 *         Elle implémente les fonctions de l'interface DAOConseiller
 */
public class MemoryConseillerDAO implements DAOConseiller {

	private static final Map<Integer, Conseiller> DBConseiller = new HashMap<>();
	private int id = 0;

	@Override
	public void saveConseiller(Conseiller con) {
		con.setId(id); // Artifice pour simuler l'auto increment d'une DB. Ne fait pas tous les cas !
		DBConseiller.put(con.getId(), con);
		id++;
	}

	@Override
	public List<Conseiller> findAllConseiller() {
		return new ArrayList<>(DBConseiller.values());
	}

	@Override
	public void updateConseiller(Conseiller con) {

	}

}
