package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.UserService;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String doRegister(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		UserService userService = new UserService();
		User userCheck = (User) userService.getUserByUsername(username);
		
		if (userCheck == null) {
			userService.addUser(username, password);
			return "index.jsp";
		} else {
			return "registerFail.jsp";
		}
		
		
	}
}
