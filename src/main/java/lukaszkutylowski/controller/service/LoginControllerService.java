package lukaszkutylowski.controller.service;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.UserService;

public class LoginControllerService {

	public boolean validateUser(String username, String password) {
		UserService service = new UserService();
		User user = service.getUserByUsername(username);
		if (user.getUsername() != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
