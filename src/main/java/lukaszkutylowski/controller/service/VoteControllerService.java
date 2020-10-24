package lukaszkutylowski.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.model.User;
import lukaszkutylowski.model.Vote;
import lukaszkutylowski.service.DiscoveryService;
import lukaszkutylowski.service.UserService;
import lukaszkutylowski.service.VoteService;

@Service
public class VoteControllerService {

	DiscoveryService discoveryService;
	VoteService voteService;
	UserService userService;
	
	@Autowired
	public VoteControllerService (DiscoveryService discoveryService,
			VoteService voteService, UserService userService) {
		this.discoveryService = discoveryService;
		this.voteService = voteService;
		this.userService = userService;
	}
	
	public void voteProceed(WebRequest request,
			String voteType,
			long discovery_id) {
		
		String username = request.getAttribute("username", request.SCOPE_SESSION).toString();
		
		User user = userService.getUserByUsername(username);
		Long user_id = user.getUser_id();
//		Vote vote = voteService.getVoteByDiscoveryUserId(discovery_id, user_id);
		
		if (!username.equals(null)) {
			updateDiscovery(discovery_id, user_id, voteType);
		}
	}
	
	private void updateDiscovery(long discovery_id, long user_id, String voteType) {
		
		Discovery discoveryById = discoveryService.getDiscoveryById(discovery_id);
		Discovery updatedDiscovery = null;
		Vote vote;
		int voteCount = 0;
		if (voteType.equals("VOTE_UP")) {
			voteService.addOrUpdateVote(discovery_id, user_id, voteType);
			voteCount = voteService.countVoteByIdAndVoteType(discovery_id, voteType);
			updatedDiscovery = addVoteUp(discoveryById, voteCount);
		} else if (voteType.equals("VOTE_DOWN")) {
			voteService.addOrUpdateVote(discovery_id, user_id, voteType);
			voteCount = voteService.countVoteByIdAndVoteType(discovery_id, voteType);
			updatedDiscovery = addVoteDown(discoveryById, voteCount);
		}
		discoveryService.updateDiscovery(updatedDiscovery);
	}
	
	private Discovery addVoteUp(Discovery discovery, int voteCount) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_up(voteCount);
		return discoveryCopy;
	}
	
	private Discovery addVoteDown(Discovery discovery, int voteCount) {
		Discovery discoveryCopy = discovery;
		discoveryCopy.setVote_down(voteCount);
		return discoveryCopy;
	}	
}
