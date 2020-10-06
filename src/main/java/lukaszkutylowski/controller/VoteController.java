package lukaszkutylowski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.model.User;
import lukaszkutylowski.model.Vote;
import lukaszkutylowski.service.DiscoveryService;
import lukaszkutylowski.service.UserService;
import lukaszkutylowski.service.VoteService;

@Controller
public class VoteController {

	@RequestMapping(value = "/vote-up", method = RequestMethod.POST)
	public String voteUp(@RequestParam("discovery_id") long discovery_id,
			WebRequest request) {
		
		String voteType = "VOTE_UP";
		voteProcessing(request, voteType, discovery_id);
		return "index.jsp";
	}
	
	@RequestMapping(value = "/vote-down", method = RequestMethod.POST)
	public String voteDown(@RequestParam("discovery_id") long discovery_id,
			WebRequest request) {
		
		String voteType = "VOTE_DOWN";
		voteProcessing(request, voteType, discovery_id);
		return "index.jsp";
	}
	
	private void voteProcessing(WebRequest request,
			String voteType,
			long discovery_id) {
	
		UserService userService = new UserService();
		
		String username = request.getAttribute("username", request.SCOPE_SESSION).toString();
		User authenticatedUser = (User) userService.getUserByUsername(username);
		
		if (!username.equals(null)) {
			long user_id = authenticatedUser.getUser_id();
			//updateVote(user_id, discovery_id, voteType);
			updateDiscovery(discovery_id, voteType);
		}
	}
	
	private void updateVote(long user_id, long discovery_id, String voteType) {
		VoteService voteService = new VoteService();
//		Vote existingVote = voteService.getVoteByDiscoveryUserId(discovery_id, user_id);
		voteService.addOrUpdateVote(discovery_id, user_id, voteType);
//		if (existingVote != updatedVote || !updatedVote.equals(existingVote)) {
//			updateDiscovery(discovery_id, existingVote, updatedVote);
//		}
	}
	
	private void updateDiscovery(long discovery_id, String voteType) {
		DiscoveryService discoveryService = new DiscoveryService();
		Discovery discoveryById = discoveryService.getDiscoveryById(discovery_id);
		Discovery updatedDiscovery = null;
		if (voteType.equals("VOTE_UP")) {
			updatedDiscovery = addVoteUp(discoveryById);
		} else if (voteType.equals("VOTE_DOWN")) {
			updatedDiscovery = addVoteDown(discoveryById);
		}
		discoveryService.updateDiscovery(updatedDiscovery);
	}
	
	private Discovery addVoteUp(Discovery discovery) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_up(discoveryCopy.getVote_up() + 1);
		return discoveryCopy;
	}
	
	private Discovery addVoteDown(Discovery discovery) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_down(discoveryCopy.getVote_down() + 1);
		return discoveryCopy;
	}
	
//	private void updateDiscovery(Discovery discovery) {
//		DiscoveryService discoveryService = new DiscoveryService();
//		Discovery discoveryById = discoveryService.getDiscoveryById(discovery_id);
//		Discovery updatedDiscovery = null;
//		if (oldVote == null && newVote != null) {
//			updatedDiscovery = addDiscoveryVote(discoveryById, newVote.getVoteType());
//		} else if (oldVote != null && newVote != null) {
//			//updatedDiscovery = removeDiscoveryVote(discoveryById, oldVote.getVoteType());
//			updatedDiscovery = addDiscoveryVote(updatedDiscovery, newVote.getVoteType());
//		}
//		discoveryService.updateDiscovery(updatedDiscovery);
//	}	
}
