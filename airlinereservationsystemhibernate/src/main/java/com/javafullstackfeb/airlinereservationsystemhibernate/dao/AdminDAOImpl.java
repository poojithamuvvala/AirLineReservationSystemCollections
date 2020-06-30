package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.javafullstack.airlinereservationsystemhibernate.utility.JDBCUtility;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;

public class AdminDAOImpl implements AdminDAO {
	
	public UserInfo authenticateAdmin(String email, String password) {
		String query = "select * from userinfo where emailid=? and password=? and role='admin'";

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			UserInfo bean = new UserInfo();
			bean.setId(resultSet.getInt("id"));
			bean.setUsername(resultSet.getString("name"));
			bean.setEmailId(resultSet.getString("emailid"));
			bean.setPassword(resultSet.getString("password"));
			bean.setPhoneNumber(resultSet.getString("phonenumber"));
			return bean;
		} else {
			return null;
		}

	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}

	}

	public boolean registerAdmin(UserInfo newAdmin) {
		String query = "insert into userinfo values(?,?,?,?,?,?)";

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			
			preparedStatement.setInt(1, newAdmin.getId());
			preparedStatement.setString(2, newAdmin.getUsername());
			preparedStatement.setString(3, newAdmin.getEmailId());
			preparedStatement.setString(4, newAdmin.getPassword());
			preparedStatement.setString(5, newAdmin.getPhoneNumber());
			preparedStatement.setString(6, newAdmin.getRole());
			int n=preparedStatement.executeUpdate(); 
			if(n!=0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	public boolean addFlight(FlightsInfo flightInfo) {
		String query = "insert into flightsinfo values(?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			
			preparedStatement.setInt(1, flightInfo.getFlightId());
			preparedStatement.setString(2, flightInfo.getFlightName());
			preparedStatement.setString(3,flightInfo.getSource());
			preparedStatement.setString(4, flightInfo.getDestination());
			preparedStatement.setDate(5, java.sql.Date.valueOf(flightInfo.getDateOfDeparture()));
			preparedStatement.setDate(6, java.sql.Date.valueOf(flightInfo.getDateOfArrival()));
			preparedStatement.setTime(7, java.sql.Time.valueOf(flightInfo.getDepartureTime()));
			preparedStatement.setTime(8, java.sql.Time.valueOf(flightInfo.getArrivalTime()));
			preparedStatement.setInt(9, flightInfo.getCapacity());
			preparedStatement.setInt(10, flightInfo.getNoOfSeatsBooked());
			preparedStatement.executeUpdate();
		
			return true;

		

	} catch (Exception e) {
		//throw new AirLineReservationSystemException("Can't Add New Flight, as Flight Already Exists");
		e.printStackTrace();
		return false;
	}
	}
	public boolean cancelFlight(int id) {
		boolean cancellationStatus = false;
	
		return cancellationStatus;
	}

	

	@Override
	public List<UserInfo> viewAllUsers() {
		ResultSet resultSet = null;
		String query = "select * from userinfo where role='user'";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

		resultSet = preparedStatement.executeQuery();
		List<UserInfo> l = new ArrayList<UserInfo>();
		while (resultSet.next()) {
			UserInfo bean = new UserInfo();
			bean.setId(resultSet.getInt("id"));
			bean.setUsername(resultSet.getString("name"));
			bean.setEmailId(resultSet.getString("emailid"));
			bean.setPassword(resultSet.getString("password"));
			bean.setPhoneNumber(resultSet.getString("phonenumber"));
			bean.setRole(resultSet.getString("role"));
			l.add(bean);
		}
		if(l.isEmpty()) {
			return null;
		}
		else {
		return l;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	finally {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	return null;
}	
}