package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.exception.AirLineReservationSystemException;


public class AdminDAOImpl implements AdminDAO {
	String url = "jdbc:mysql://localhost:3307?user=root&password=root";
	public AdminInfo authenticateAdmin(String email, String password) {
//		for (AdminInfo admin : AirLineDataBase.ADMININFO) {
//			if ((admin.getEmailId().equals(email)) && (admin.getPassword().equals(password))) {
//				return admin;
//			}
//		}
		throw new AirLineReservationSystemException("Invalid Credentials");
	}

	public boolean registerAdmin(AdminInfo newAdmin) {
		String query = "insert into airlinedb.admininfo values(?,?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {

			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setInt(1, newAdmin.getAdminid());
			preparedStatement.setString(2, newAdmin.getAdminName());
			preparedStatement.setString(3, newAdmin.getEmailId());
			preparedStatement.setString(4, newAdmin.getPassword());
			preparedStatement.setString(5, newAdmin.getPhoneNumber());
			
			int n = preparedStatement.executeUpdate();
			if (n != 0) {
				System.out.println("Successfully inserted!!!");
				return true;
			} else {
				System.out.println("Data already exists");
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean addFlight(FlightsInfo flightInfo) {
//		for(FlightsInfo info: AirLineDataBase.FLIGHTSINFO) {
//			if(info.getFlightId()==flightInfo.getFlightId()){
//			     return false;	
//			}
//			
//		}
//		AirLineDataBase.FLIGHTSINFO.add(flightInfo);
		return true;
	}

	public boolean cancelFlight(int id) {
		boolean cancellationStatus = false;
//		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
//			FlightsInfo retrivedFlightInfo= AirLineDataBase.FLIGHTSINFO.get(i);
//			int retrivedFlightId=retrivedFlightInfo.getFlightId();
//			if(id==retrivedFlightId) {
//				cancellationStatus=true;
//				AirLineDataBase.FLIGHTSINFO.remove(i);
//				break;
//			}
//			
//		}
		return cancellationStatus;
	}

	public List<FlightsInfo> searchFlightByName(String flightName) {
//		List<FlightsInfo> searchListByName = new ArrayList<FlightsInfo>();
//		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
//			FlightsInfo retrievedFlightInfo = AirLineDataBase.FLIGHTSINFO.get(i);
//			String retrievedFname = retrievedFlightInfo.getFlightName();
//			if (flightName.equalsIgnoreCase(retrievedFname)) {
//				searchListByName.add(retrievedFlightInfo);
//				return searchListByName;
//			}
//		}
//		if (searchListByName.size() == 0) {
//			throw new AirLineReservationSystemException("Flight with "+flightName+" not found");
//		} else {
//			return searchListByName;
//		}
		return null;
	}

	public List<FlightsInfo> searchFlightBySource(String source) {
//		List<FlightsInfo> searchListBySource = new ArrayList<FlightsInfo>();
//		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
//			FlightsInfo retrievedFlight = AirLineDataBase.FLIGHTSINFO.get(i);
//			String retrievedSourcename = retrievedFlight.getSource();
//			if (source.equalsIgnoreCase(retrievedSourcename)) {
//				searchListBySource.add(retrievedFlight);
//				return searchListBySource;
//			}
//		}
//		if (searchListBySource.size() == 0) {
//			throw new AirLineReservationSystemException("Flight with "+source+" not found");
//		} else {
//			return searchListBySource;
//		}
		return null;
	}

	public List<FlightsInfo> searchFlightByDestination(String destination) {
//		List<FlightsInfo> searchListByDestination = new ArrayList<FlightsInfo>();
//		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
//			FlightsInfo retrievedFlightInfo = AirLineDataBase.FLIGHTSINFO.get(i);
//			String retrievedDestinationName = retrievedFlightInfo.getDestination();
//			if (destination.equalsIgnoreCase(retrievedDestinationName)) {
//				searchListByDestination.add(retrievedFlightInfo);
//				return searchListByDestination;
//			}
//		}
//		if (searchListByDestination.size() == 0) {
//			throw new AirLineReservationSystemException("Flight with "+destination+" not found");
//		} else {
//			return searchListByDestination;
//		}
		return null;
	}

	public List<FlightsInfo> viewAllFlights() {
		List<FlightsInfo> flightsList = new ArrayList<FlightsInfo>();
//		for (FlightsInfo flight : AirLineDataBase.FLIGHTSINFO) {
//			flight.getFlightId();
//			flight.getFlightName();
//			flight.getSource();
//			flight.getDestination();
//			flight.getArrivalTime();
//			flight.getDepartureTime();
//			flightsList.add(flight);
//		}
		return flightsList;
	}

	public List<UsersInfo> viewAllUsers() {
		List<UsersInfo> userList = new ArrayList<UsersInfo>();
//		for (UsersInfo users : AirLineDataBase.USERSINFO) {
//			users.getUserId();
//			users.getUserName();
//			users.getEmailId();
//			users.getPhoneNumber();
//			
//			userList.add(users);
//		}
		return  userList;
	}

	public List<BookingsInfo> viewAllBookings() {
		List<BookingsInfo> bookingsList = new ArrayList<BookingsInfo>();
//		for (BookingsInfo booking : AirLineDataBase.BOOKINGSINFO) {
//			booking.getBookingId();
//			booking.getUserId();
//			booking.getNoOfSeatsBooked();
//			booking.getSeatNos();
//			booking.getDateOfBooking();
//			booking.getDateOfJourney();
//			booking.getSource();
//			booking.getDestination();
//			bookingsList.add(booking);
//		}
		return  bookingsList;
	}

}