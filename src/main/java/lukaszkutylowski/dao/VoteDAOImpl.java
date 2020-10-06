package lukaszkutylowski.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import lukaszkutylowski.model.Vote;
import lukaszkutylowski.util.ConnectionProvider;

public class VoteDAOImpl implements VoteDAO {

	private static final String CREATE_VOTE = 
		"INSERT INTO vote (discovery_id, user_id, type) "
		+ "VALUES (:discovery_id, :user_id, :type);";
	private static final String READ_VOTE = 
		"SELECT vote_id, discovery_id, user_id, type "
		+ "FROM vote WHERE vote_id = :vote_id;";
	private static final String READ_VOTE_BY_DISCOVERY_USE_IDS = 
		"SELECT vote_id, discovery_id, user_id, type "
		+ "FROM vote WHERE user_id = :user_id AND discovery_id = :discovery_id;";
	private static final String UPDATE_VOTE = 
		"UPDATE vote SET type = :type, WHERE vote_id = :vote_id;";
	
	private NamedParameterJdbcTemplate template;
	
	public VoteDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public Vote create(Vote vote) {
		Vote voteCopy = vote;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("discovery_id", voteCopy.getDiscovery_id());
		paramMap.put("user_id", voteCopy.getUser_id());
		paramMap.put("type", voteCopy.getVoteType());
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_VOTE, paramSource, holder);
		if (update > 0) {
			voteCopy.setVote_id((holder.getKey().longValue()));
		}
		return voteCopy;
	}

	@Override
	public Vote read(Long primaryKey) {
		SqlParameterSource paramSource = new MapSqlParameterSource("vote_id", primaryKey);
		Vote vote = template.queryForObject(READ_VOTE, paramSource, new VoteRowMapper());
		return vote;
	}

	@Override
	public boolean update(Vote vote) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("type", vote.getVoteType());
		paramMap.put("vote_id", vote.getVote_id());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(UPDATE_VOTE, paramSource);
		if (update > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean dalete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Vote> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vote getVoteByUserIdDiscoveryId(long user_id, long discovery_id) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("user_id", user_id);
		paramMap.put("discovery_id", discovery_id);
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		Vote vote = null;
		try {
			vote = template.queryForObject(READ_VOTE_BY_DISCOVERY_USE_IDS, paramSource,  new VoteRowMapper());
		} catch (EmptyResultDataAccessException e) {
			//vote not found
		}
		return vote;
	}

	private class VoteRowMapper implements RowMapper<Vote> {

		@Override
		public Vote mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Vote vote = new Vote();
			vote.setVote_id(resultSet.getLong("vote_id"));
			vote.setUser_id(resultSet.getLong("user_id"));
			vote.setDiscovery_id(resultSet.getLong("discovery_id"));
			vote.setVoteType(resultSet.getString("type"));
			return vote;
		}
		
	}
}
