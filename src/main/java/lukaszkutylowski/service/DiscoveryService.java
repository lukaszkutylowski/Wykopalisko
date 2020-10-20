package lukaszkutylowski.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import lukaszkutylowski.dao.DAOFactory;
import lukaszkutylowski.dao.DiscoveryDAO;
import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.model.User;

@Service
public class DiscoveryService {

	public void addDiscovery(String name, String desc, String url, User user) {
		Discovery discovery = createDiscoveryObject(name, desc, url, user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		discoveryDao.create(discovery);
	}
	
	private Discovery createDiscoveryObject(String name, String desc, String url, User user) {
		Discovery discovery = new Discovery();
		discovery.setName(name);
		discovery.setDescription(desc);
		discovery.setUrl(url);
		User userCopy = user;
		discovery.setUser(userCopy);
		return discovery;
	}
	
	public Discovery getDiscoveryById(long discovery_id) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		Discovery discovery = discoveryDao.read(discovery_id);
		return discovery;
	}
	
	public boolean updateDiscovery(Discovery discovery) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		boolean result = discoveryDao.update(discovery);
		return result;
	}
	
	public List<Discovery> getAllDiscoveries() {
		return getAllDiscoveries(null);
	}
	
	public List<Discovery> getAllDiscoveries(Comparator<Discovery> comparator) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		List<Discovery> discoveries = discoveryDao.getAll();
		if (comparator != null && discoveries != null) {
			discoveries.sort(comparator);
		}
		return discoveries;
	}
	
	
}
