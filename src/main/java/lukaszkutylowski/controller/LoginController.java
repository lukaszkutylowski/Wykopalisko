package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import lukaszkutylowski.model.User;
import lukaszkutylowski.service.UserService;

@Controller
@SessionAttributes("username")
public class LoginController {

	@RequestMapping(value = "login-form", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelAndView mv) {
		
		if (!validateUser(username, password)) {
			mv.setViewName("login.jsp");
			return mv;
		}
		
		mv.addObject("username", username);
		mv.setViewName("index.jsp");
		
		return mv;
	}
	
	private boolean validateUser(String username, String password) {
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
