package lukaszkutylowski.controller.service;

import org.springframework.web.context.request.WebRequest;

import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.service.DiscoveryService;

public class VoteControllerService {

	public void voteProceed(WebRequest request,
			String voteType,
			long discovery_id) {
		
		String username = request.getAttribute("username", request.SCOPE_SESSION).toString();
		
		if (!username.equals(null)) {
			updateDiscovery(discovery_id, voteType);
		}
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
}
