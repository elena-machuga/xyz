package by.epam.bikerent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.bikerent.domain.User;

public class UserDAO {

	private static final String SQL_SELECT_USER_AUTH = "SELECT login, pass, name, role_id from user where login = ? and pass = ?";
	private static final String SQL_SELECT_ALL_USER = "SELECT name, address, phone, login, pass, role_id from user";
	private static final String SQL_REGISTER_USER = "INSERT INTO user (name, address, phone, login, pass, role_id) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_USER = "UPDATE user SET name=?, address=?, phone=?, login=?, pass=?, role_id=? WHERE id=?";
	private static final String USER_NAME = "name";
	private static final String USER_ADDRESS = "address";
	private static final String USER_PHONE = "phone";
	private static final String USER_LOGIN = "login";
	private static final String USER_PASSWORD = "pass";
	private static final String USER_ROLE = "role_id";
	private static final String USER_ID = "id";

	public User readUserAuthorization(String login, String password) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;
		PreparedStatement ps = null;
		User user = new User();

		try {
			connection = cp.getConnection();

			ps = connection.prepareStatement(SQL_SELECT_USER_AUTH);
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user.setName(rs.getString(USER_NAME));
				user.setLogin(rs.getString(USER_LOGIN));
				String r = rs.getString(USER_ROLE);
				user.setRole(r);
				user.setAddres(USER_ADDRESS);
				user.setPhone(USER_PHONE);
			} else {
				user = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.closeConnection(connection);
		}
		return user;
	}

	public void createUser(String name, String address, String phone, String login, String pass) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_REGISTER_USER);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, login);
			ps.setString(5, pass);
			ps.setString(6, "2");

			int rs = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.closeConnection(connection);
		}
	}

	public void updateUser(User user) {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_USER);
			ps.setString(1, user.getName());
			ps.setString(2, user.getAddres());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getLogin());
			ps.setString(5, user.getPassword());
			ps.setString(6, "2");
			ps.setInt(7, user.getUserID());

			ResultSet rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.closeConnection(connection);
		}
	}
	
	public void deleteUser(User user) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public List<User> requestUserList() {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;
		User user = new User();
		List<User> list = new ArrayList<>();

		try {
			
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL_USER);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setName(rs.getString(USER_NAME));
				user.setLogin(rs.getString(USER_LOGIN));
				user.setRole(rs.getString(USER_ROLE));
				user.setAddres(USER_ADDRESS);
				user.setPhone(USER_PHONE);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cp.closeConnection(connection);
		}
		return list;
	}

}
