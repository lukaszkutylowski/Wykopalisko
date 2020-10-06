package lukaszkutylowski.dao;

import java.util.List;

import lukaszkutylowski.model.Discovery;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long> {

	List<Discovery> getAll();
}
