package lukaszkutylowski.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.UserService;

@Service
public class LoginControllerService {

	UserService userService;
	
	@Autowired
	public LoginControllerService (UserService userService) {
		this.userService = userService;
	}
	
	public boolean validateUser(String username, String password) {
		User user = userService.getUserByUsername(username);
		if (user.getUsername() != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
