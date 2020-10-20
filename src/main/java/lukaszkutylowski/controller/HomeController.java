package lukaszkutylowski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lukaszkutylowski.controller.service.HomeControllerService;
import lukaszkutylowski.model.Discovery;

@Controller
public class HomeController {

	HomeControllerService homeService;
	
	@Autowired
	public HomeController(HomeControllerService homeService) {
		this.homeService = homeService;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		List<Discovery> allDiscoveries = homeService.proceedGetAllDiscoveries();
		mv.addObject("discoveries", allDiscoveries);
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/register")
	public String register() {
		return "register.jsp";
	}
	
	@RequestMapping(value = "/add")
	public String add() {
		return "add.jsp";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login.jsp";
	}
}
