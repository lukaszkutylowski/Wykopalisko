package lukaszkutylowski.controller.service;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.DiscoveryService;
import lukaszkutylowski.service.UserService;

public class DiscoveryAddControllerService {

	public void proceedAddDiscovery(String username, String name, String description, String url) {
		User authenticatedUser = createAuthenticatedUserInstance(username);
		DiscoveryService discoveryService = new DiscoveryService();
		if (!username.equals(null)) {
			discoveryService.addDiscovery(name, description, url, authenticatedUser);
		}
	}
	
	private User createAuthenticatedUserInstance(String username) {
		UserService userService = new UserService();
		return (User) userService.getUserByUsername(username);
	}
}
