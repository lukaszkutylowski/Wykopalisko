package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.controller.service.VoteControllerService;

@Controller
public class VoteController {

	VoteControllerService voteService = new VoteControllerService();
	
	@RequestMapping(value = "/vote-up", method = RequestMethod.POST)
	public String voteUp(@RequestParam("discovery_id") long discovery_id,
			WebRequest request) {
		
		String voteType = "VOTE_UP";
		voteService.voteProceed(request, voteType, discovery_id);
		return "index.jsp";
	}
	
	@RequestMapping(value = "/vote-down", method = RequestMethod.POST)
	public String voteDown(@RequestParam("discovery_id") long discovery_id,
			WebRequest request) {
		
		String voteType = "VOTE_DOWN";
		voteService.voteProceed(request, voteType, discovery_id);
		return "index.jsp";
	}
	
	
}
