package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.controller.service.DiscoveryAddControllerService;

@Controller
public class DiscoveryAddController {

	@RequestMapping(value = "/add-form", method = RequestMethod.POST)
	protected String add(@RequestParam("inputName") String name,
			@RequestParam("inputDescription") String description,
			@RequestParam("inputUrl") String url,
			WebRequest request) {
		
		DiscoveryAddControllerService controllerService = new DiscoveryAddControllerService();
		
		String username = request.getAttribute("username", request.SCOPE_SESSION).toString();
		controllerService.proceedAddDiscovery(username, name, description, url);
		
		return "index.jsp";
	}
}
