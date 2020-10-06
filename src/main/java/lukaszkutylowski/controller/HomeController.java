package lukaszkutylowski.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.service.DiscoveryService;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		DiscoveryService service = new DiscoveryService();
		List<Discovery> allDiscoveries =
				service.getAllDiscoveries(new Comparator<Discovery>() {

					@Override
					public int compare(Discovery d1, Discovery d2) {
						int d1Vote = d1.getVote_up() - d1.getVote_down();
						int d2Vote = d2.getVote_up() - d2.getVote_down();
						if (d1Vote < d2Vote) {
							return 1;
						}
						return 0;
					}
					
				});
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
