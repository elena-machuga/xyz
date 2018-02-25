package by.epam.bikerent.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.bikerent.command.impl.LoginCommandImpl;

public class ConnectionPool {

	private static final Logger LOG = LogManager.getLogger(LoginCommandImpl.class.getName());

	private static ConnectionPool instance = null;
	private final static String CONTEXT_LOOKUP = "java:comp/env";
	private final static String DATASOURCE_LOOKUP = "jdbc/bike-station";

	private ConnectionPool() {
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	public Connection getConnection() {
		// ResourceBundle rb = ResourceBundle.getBundle("db_config");
		// BasicDataSource bds = new BasicDataSource();
		// bds.setDriverClassName(rb.getString("db.driver.name"));
		// bds.setUrl(rb.getString("db.url"));
		// bds.setUsername(rb.getString("db.login"));
		// bds.setPassword(rb.getString("db.pass"));
		// bds.setMaxTotal(Integer.parseInt(rb.getString("db.maxsize")));
		// bds.setMaxIdle(Integer.parseInt(rb.getString("db.maxidle")));
		// bds.setMaxWaitMillis(Integer.parseInt(rb.getString("db.maxwait")));
		//
		// Connection connection = null;
		//
		// try {
		// connection = bds.getConnection();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

		Context context;
		Connection connection = null;

		try {
			context = (Context) (new InitialContext().lookup(CONTEXT_LOOKUP));
			DataSource dataSource = (DataSource) context.lookup(DATASOURCE_LOOKUP);
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return connection;
	}

	protected void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.error("Connection was not closed", e);
			}
		}
	}
}
