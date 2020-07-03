package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemjdbc.utility.JDBCUtility;

public class AdminDAOImpl implements AdminDAO {
	
	public UserInfo authenticateAdmin(String email, String password) {
		
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("loginCheckAdmin"));) {
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
			bean.setRole(resultSet.getString("role"));
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
		
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("addUser"));) {

			
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
	

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("addFlight"));)  {
			   
			    preparedStatement.setInt(1, flightInfo.getFlightId());
			    preparedStatement.setString(2, flightInfo.getFlightName());
			    preparedStatement.setString(3, flightInfo.getSource());
			    preparedStatement.setString(4, flightInfo.getDestination());
			    preparedStatement.setDate(5, java.sql.Date.valueOf(flightInfo.getDateOfDeparture()));
			    preparedStatement.setDate(6, java.sql.Date.valueOf(flightInfo.getDateOfArrival()));
			    preparedStatement.setTime(7, java.sql.Time.valueOf(flightInfo.getDepartureTime()));
			    preparedStatement.setTime(8, java.sql.Time.valueOf(flightInfo.getArrivalTime()));
			    preparedStatement.setInt(9, flightInfo.getCapacity());
			    preparedStatement.setInt(10, flightInfo.getNoOfSeatsBooked());
			
			preparedStatement.executeUpdate();

	} catch (SQLException e) {
		
		e.printStackTrace();
	}catch (Exception e) {
			
			e.printStackTrace();
		}
		return true;
	}
	public boolean cancelFlight(int id) {
		
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("removeFlight"));)  {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0) {
				System.out.println("Succesfully Deleted!!!");
				return true;
			} else {
				System.out.println("Employee not found!");
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	

	@Override
	public List<UserInfo> viewAllUsers() {
		ResultSet resultSet = null;
		
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("allUsers"));) {

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