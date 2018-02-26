package by.epam.bikerent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.epam.bikerent.dao.connectionpool.ConnectionPool;
import by.epam.bikerent.dao.exception.RentPointDaoException;
import by.epam.bikerent.domain.RentPoint;

public class RentPointDAO {
	
	private final static String SQL_CREATE_RENTPOINT = "INSERT INTO rent_point (name, address, phone) VALUES (?, ?, ?)";
	private static final String SQL_READ_RENTPOINT_NAME = "SELECT name, address, phone from rent_point where name=?";
	private static final String SQL_UPDATE_RENTPOINT_NAME = "UPDATE rent_point SET name=?, address=?, phone=? WHERE id =?";
	private static final String SQL_READ_RENTPOINT_ALL = "SELECT name, address, phone from rent_point";
	private static final String RENTPOINT_NAME = "name";
	private static final String RENTPOINT_ADDRESS = "address";
	private static final String RENTPOINT_PHONE = "phone";
	
	public void createRentPoint(String name, String address, String phone) throws RentPointDaoException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_CREATE_RENTPOINT);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RentPointDaoException();
		} finally {
			cp.closeConnection(connection);
		}
	}
	
	public RentPoint readRentPointByName(String name) throws RentPointDaoException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;
		RentPoint rp = new RentPoint();

		try {
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_READ_RENTPOINT_NAME);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				rp.setName(rs.getString(RENTPOINT_NAME));
				rp.setAddress(RENTPOINT_ADDRESS);
				rp.setPhone(RENTPOINT_PHONE);
			} else {
				rp = null;
			}

		} catch (SQLException e) {
			throw new RentPointDaoException();
		} finally {
			cp.closeConnection(connection);
		}
		
		return rp;
	}
	
	public void updateRentPoint(RentPoint rp, String id) throws RentPointDaoException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_RENTPOINT_NAME);
			ps.setString(1, rp.getName());
			ps.setString(2, rp.getAddress());
			ps.setString(3, rp.getPhone());
			ps.setString(4, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RentPointDaoException();
		} finally {
			cp.closeConnection(connection);
		}
	}

	public void deleteRentPoint(RentPoint rp) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	public List<RentPoint> readRentPointAll() throws RentPointDaoException {
		ConnectionPool cp = ConnectionPool.getInstance();
		Connection connection = null;
		RentPoint rp = new RentPoint();
		List<RentPoint> list = new ArrayList<>();

		try {

			connection = cp.getConnection();

			PreparedStatement ps = connection.prepareStatement(SQL_READ_RENTPOINT_ALL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rp.setName(rs.getString(RENTPOINT_NAME));
				rp.setAddress(RENTPOINT_ADDRESS);
				rp.setPhone(RENTPOINT_PHONE);
				list.add(rp);
			}
		} catch (SQLException e) {
			throw new RentPointDaoException();
		} finally {
			cp.closeConnection(connection);
		}
		return list;
	}

}
