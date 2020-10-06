package lukaszkutylowski.dao;

import java.util.List;

import lukaszkutylowski.model.User;

public interface UserDAO extends GenericDAO<User, Long> {

	List<User> getAll();
	User getUserByUsername(String username);
}
