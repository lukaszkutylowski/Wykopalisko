package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.DiscoveryService;
import lukaszkutylowski.service.UserService;

@Controller
public class DiscoveryAddController {

	@RequestMapping(value = "/add-form", method = RequestMethod.POST)
	protected String add(@RequestParam("inputName") String name,
			@RequestParam("inputDescription") String description,
			@RequestParam("inputUrl") String url,
			WebRequest request) {
		
		UserService userService = new UserService();
		DiscoveryService discoveryService = new DiscoveryService();
		
		String username = request.getAttribute("username", request.SCOPE_SESSION).toString();
		User authenticatedUser = (User) userService.getUserByUsername(username);
		
		url = "https://" + url;
		
		if (!username.equals(null)) {
			discoveryService.addDiscovery(name, description, url, authenticatedUser);
		}
		
		return "index.jsp";
	}
}
