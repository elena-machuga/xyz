package by.epam.bikerent.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.PooledConnection;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ConnectionPool {

	private static ConnectionPool instance = null;

	private ConnectionPool() {
	}

	public static ConnectionPool getInstance() {
		if (instance == null)
			instance = new ConnectionPool();
		return instance;
	}

	public Connection getConnection() {
//		ResourceBundle rb = ResourceBundle.getBundle("db_config");
//		BasicDataSource bds = new BasicDataSource();
//		bds.setDriverClassName(rb.getString("db.driver.name"));
//		bds.setUrl(rb.getString("db.url"));
//		bds.setUsername(rb.getString("db.login"));
//		bds.setPassword(rb.getString("db.pass"));
//		bds.setMaxTotal(Integer.parseInt(rb.getString("db.maxsize")));
//		bds.setMaxIdle(Integer.parseInt(rb.getString("db.maxidle")));
//		bds.setMaxWaitMillis(Integer.parseInt(rb.getString("db.maxwait")));
//		
//		Connection connection = null;
//		
//		try {
//			connection = bds.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		
		Context context;
		Connection connection = null;

		try {
			context = (Context) (new InitialContext().lookup("java:comp/env"));
			DataSource dataSource = (DataSource)context.lookup("jdbc/bike-station");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	protected void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
