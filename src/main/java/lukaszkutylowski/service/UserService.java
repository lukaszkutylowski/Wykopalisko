package lukaszkutylowski.service;

import org.springframework.stereotype.Service;

import lukaszkutylowski.dao.DAOFactory;
import lukaszkutylowski.dao.UserDAO;
import lukaszkutylowski.model.User;

@Service
public class UserService {

	public void addUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.create(user);
	}
	
	public User getUserById(long user_id) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.read(user_id);
		return user;
	}
	
	public User getUserByUsername(String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.getUserByUsername(username);
		return user;
	}
}
