package lukaszkutylowski.dao;

import lukaszkutylowski.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {

	public Vote getVoteByUserIdDiscoveryId(long user_id, long discovery_id);
}
