package lukaszkutylowski.controller.service;

import java.util.Comparator;
import java.util.List;

import lukaszkutylowski.model.Discovery;
import lukaszkutylowski.service.DiscoveryService;

public class HomeControllerService {

	public List<Discovery> proceedGetAllDiscoveries () {
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
		return allDiscoveries;
	}
}
