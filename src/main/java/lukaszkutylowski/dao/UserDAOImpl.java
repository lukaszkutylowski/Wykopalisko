package lukaszkutylowski.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import lukaszkutylowski.model.User;
import lukaszkutylowski.util.ConnectionProvider;

public class UserDAOImpl implements UserDAO {
	
	private static final String CREATE_USER =
		"INSERT INTO user(username, password, is_admin)"
		+ " VALUES(:username, :password, :is_admin);";
	private static final String READ_USER =
		"SELECT user_id, username, password, is_admin FROM user"
		+ " WHERE user_id = :user_id;";
	private static final String READ_USER_BY_USERNAME =
		"SELECT user_id, username, password, is_admin FROM user"
		+ " WHERE username = :username;";

	private NamedParameterJdbcTemplate template;
	
	public UserDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}
	
	@Override
	public User create(User user) {
		User resultUser = new User(user);
		KeyHolder holder = new GeneratedKeyHolder();
		setPriviliges(resultUser);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(resultUser);
		int update = template.update(CREATE_USER, paramSource, holder);
		if (update > 0) {
			resultUser.setUser_id(holder.getKey().longValue());
		}
		return resultUser;
	}

	private void setPriviliges(User resultUser) {
		if	(	resultUser.getUsername().equals("admin") && 
				resultUser.getPassword().equals("_Pg<fCJZk#Za7jQ)QnZh")
			) {
			resultUser.setIs_admin(true);
		} else {
			resultUser.setIs_admin(false);
		}
	}
	
	@Override
	public User read(Long primaryKey) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", primaryKey);
		resultUser = template.queryForObject(READ_USER, paramSource, new UserRowMapper());
		return resultUser;
	}

	@Override
	public boolean update(User updateObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dalete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		resultUser = template.queryForObject(READ_USER_BY_USERNAME, paramSource, new UserRowMapper());
		return resultUser;
	}
	
	private class UserRowMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			
			user.setUser_id(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setIs_admin(resultSet.getBoolean("is_admin"));
			
			return user;
		}
		
	}
	
}
