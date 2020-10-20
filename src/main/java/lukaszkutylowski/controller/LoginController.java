package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import lukaszkutylowski.controller.service.LoginControllerService;

@Controller
@SessionAttributes("username")
public class LoginController {

	LoginControllerService loginService;
	
	public LoginController(LoginControllerService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value = "login-form", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			ModelAndView mv) {
		
		if (!loginService.validateUser(username, password)) {
			mv.setViewName("login.jsp");
			return mv;
		}
		
		mv.addObject("username", username);
		mv.setViewName("index.jsp");
		
		return mv;
	}
	
	
}
