package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javafullstack.airlinereservationsystemhibernate.utility.JDBCUtility;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;


public class UserDAOImpl implements UserDAO {

	@Override
	public List<FlightsInfo> searchFlightByName(String flightName) {
		ResultSet resultSet = null;
		String query = "select * from flightsinfo where flightName=?";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

		resultSet = preparedStatement.executeQuery();
		List<FlightsInfo> l = new ArrayList<FlightsInfo>();
		while (resultSet.next()) {
			FlightsInfo bean = new FlightsInfo();
			bean.setFlightId(resultSet.getInt("flightid"));
			bean.setFlightName(resultSet.getString("flightname"));
			bean.setSource(resultSet.getString("source"));
			bean.setDestination(resultSet.getString("destination"));
		    bean.setNoOfSeatsBooked(resultSet.getInt("noofseatavailable"));
			bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
			bean.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
			bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
			bean.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
         
			l.add(bean);
			return l;
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

	@Override
	public List<FlightsInfo> searchFlightBySource(String source) {
		ResultSet resultSet = null;
		String query = "select * from flightsinfo where source=?";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

		resultSet = preparedStatement.executeQuery();
		List<FlightsInfo> l = new ArrayList<FlightsInfo>();
		while (resultSet.next()) {
			FlightsInfo bean = new FlightsInfo();
			bean.setFlightId(resultSet.getInt("flightid"));
			bean.setFlightName(resultSet.getString("flightname"));
			bean.setSource(resultSet.getString("source"));
			bean.setDestination(resultSet.getString("destination"));
		    bean.setNoOfSeatsBooked(resultSet.getInt("noofseatavailable"));
			bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
			bean.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
			bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
			bean.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
         
			
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

	@Override
	public List<FlightsInfo> searchFlightByDestination(String destination) {
		ResultSet resultSet = null;
		String query = "select * from flightsinfo where destination=?";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

		resultSet = preparedStatement.executeQuery();
		List<FlightsInfo> l = new ArrayList<FlightsInfo>();
		while (resultSet.next()) {
			FlightsInfo bean = new FlightsInfo();
			bean.setFlightId(resultSet.getInt("flightid"));
			bean.setFlightName(resultSet.getString("flightname"));
			bean.setSource(resultSet.getString("source"));
			bean.setDestination(resultSet.getString("destination"));
		    bean.setNoOfSeatsBooked(resultSet.getInt("noofseatavailable"));
			bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
			bean.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
			bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
			bean.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
         
			
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

	@Override
	public boolean registerUser(UserInfo usersInfo) {
		String query = "insert into userinfo values(?,?,?,?,?,?)";

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			
			preparedStatement.setInt(1, usersInfo.getId());
			preparedStatement.setString(2, usersInfo.getUsername());
			preparedStatement.setString(3, usersInfo.getEmailId());
			preparedStatement.setString(4, usersInfo.getPassword());
			preparedStatement.setString(5, usersInfo.getPhoneNumber());
			preparedStatement.setString(6, usersInfo.getRole());
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

	@Override
	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		ResultSet resultSet = null;
		String query = "select * from flightsinfo";
		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

		resultSet = preparedStatement.executeQuery();
		List<FlightsInfo> l = new ArrayList<FlightsInfo>();
		while (resultSet.next()) {
			FlightsInfo bean = new FlightsInfo();
			bean.setFlightId(resultSet.getInt("flightid"));
			bean.setFlightName(resultSet.getString("flightname"));
			bean.setSource(resultSet.getString("source"));
			bean.setDestination(resultSet.getString("destination"));
		    bean.setNoOfSeatsBooked(resultSet.getInt("noofseatavailable"));
			bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
			bean.setArrivalTime(resultSet.getTime("arrivaltime").toLocalTime());
			bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
			bean.setDepartureTime(resultSet.getTime("departuretime").toLocalTime());
         
			
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

	@Override
	public UserInfo authenticateUser(String email, String password) {
		String query = "select * from userinfo where emailid=? and password=? and role='user'";

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

}
