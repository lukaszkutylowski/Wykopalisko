package lukaszkutylowski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.UserService;

@Controller
public class RegisterController {

	UserService userService;
	
	@Autowired
	public RegisterController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/register-form", method = RequestMethod.POST)
	public String doRegister(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		User checkUserIsNull;
		
		try {
			checkUserIsNull = (User) userService.getUserByUsername(username);
			checkUserIsNull.toString();
			return "registerFail.jsp";
		} catch (NullPointerException e) {
			userService.addUser(username, password);
			return "index.jsp";
		}
		
	}
}
