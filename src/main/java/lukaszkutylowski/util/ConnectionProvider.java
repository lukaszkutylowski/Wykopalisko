package lukaszkutylowski.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionProvider {

	private static MysqlDataSource dataSource;
	
	private static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			try {
				dataSource = new MysqlDataSource();
				dataSource.setUrl("jdbc:mysql://localhost:3306/database2h?serverTimezone=UTC");
				dataSource.setUser("root");
				dataSource.setPassword("root");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dataSource;
	}
}
