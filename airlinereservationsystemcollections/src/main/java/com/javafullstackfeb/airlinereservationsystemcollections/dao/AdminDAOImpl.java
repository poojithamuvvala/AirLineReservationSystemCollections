package com.javafullstackfeb.airlinereservationsystemcollections.dao;

import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.repository.AirLineDataBase;

public class AdminDAOImpl implements AdminDAO {

	public AdminInfo authenticateAdmin(String email, String password) {
		for (AdminInfo admin : AirLineDataBase.ADMININFO) {
			if ((admin.getEmailId().equals(email)) && (admin.getPassword().equals(password))) {
				return admin;
			}
		}
		throw new AirLineReservationSystemException("Invalid Credentials");
	}

	public boolean registerAdmin(AdminInfo newAdmin) {
		for (AdminInfo a1 : AirLineDataBase.ADMININFO) {
			if ((a1.getEmailId()).equals(newAdmin.getEmailId())) {
				return false;
			}
		}
		AirLineDataBase.ADMININFO.add(newAdmin);
		return true;
	}

	public boolean addFlight(FlightsInfo flightInfo) {
		for(FlightsInfo info: AirLineDataBase.FLIGHTSINFO) {
			if(info.getFlightId()==flightInfo.getFlightId()){
			     return false;	
			}
			
		}
		AirLineDataBase.FLIGHTSINFO.add(flightInfo);
		return true;
	}

	public boolean cancelFlight(int id) {
		boolean cancellationStatus = false;
		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
			FlightsInfo retrivedFlightInfo= AirLineDataBase.FLIGHTSINFO.get(i);
			int retrivedFlightId=retrivedFlightInfo.getFlightId();
			if(id==retrivedFlightId) {
				cancellationStatus=true;
				AirLineDataBase.FLIGHTSINFO.remove(i);
				break;
			}
			
		}
		return cancellationStatus;
	}

	
	

	public List<UsersInfo> viewAllUsers() {
		List<UsersInfo> userList = new ArrayList<UsersInfo>();
		for (UsersInfo users : AirLineDataBase.USERSINFO) {
			users.getUserId();
			users.getUserName();
			users.getEmailId();
			users.getPhoneNumber();
			
			userList.add(users);
		}
		return  userList;
	}

	public List<BookingsInfo> viewAllBookings() {
		List<BookingsInfo> bookingsList = new ArrayList<BookingsInfo>();
		for (BookingsInfo booking : AirLineDataBase.BOOKINGSINFO) {
			booking.getBookingId();
			booking.getUserId();
			booking.getNoOfSeatsBooked();
			booking.getSeatNos();
			booking.getDateOfBooking();
			booking.getDateOfJourney();
			booking.getSource();
			booking.getDestination();
			bookingsList.add(booking);
		}
		return  bookingsList;
	}

}