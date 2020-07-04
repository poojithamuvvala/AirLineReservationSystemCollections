package com.javafullstackfeb.airlinereservationsystemcollections.dao;

import java.util.ArrayList;
import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.exception.AirLineReservationSystemException;
import com.javafullstackfeb.airlinereservationsystemcollections.repository.AirLineDataBase;

public class UserDAOImpl implements UserDAO {

	public UsersInfo authenticateUser(String email, String password) {
		for (UsersInfo user : AirLineDataBase.USERSINFO) {
			if ((user.getEmailId().equals(email)) && (user.getPassword().equals(password))) {
				return user;
			}
		}
		throw new AirLineReservationSystemException("Invalid Credentials");
	}

	public boolean registerUser(UsersInfo usersInfo) {
		for (UsersInfo user : AirLineDataBase.USERSINFO) {
			if ((user.getEmailId()).equals(usersInfo.getEmailId())) {
				return false;
			}
		}
		AirLineDataBase.USERSINFO.add(usersInfo);
		return true;
	}

	public List<FlightsInfo> searchBySource(String source) {
		List<FlightsInfo> searchListBySource = new ArrayList<FlightsInfo>();
		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
			FlightsInfo retrievedFlight = AirLineDataBase.FLIGHTSINFO.get(i);
			String retrievedSourcename = retrievedFlight.getSource();
			if (source.equalsIgnoreCase(retrievedSourcename)) {
				searchListBySource.add(retrievedFlight);
				return searchListBySource;
			}
		}
		if (searchListBySource.size() == 0) {
			throw new AirLineReservationSystemException("Flight with " + source + " not found");
		} else {
			return searchListBySource;
		}
	}

	public List<FlightsInfo> searchByName(String flightName) {
		List<FlightsInfo> searchListByName = new ArrayList<FlightsInfo>();
		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
			FlightsInfo retrievedFlightInfo = AirLineDataBase.FLIGHTSINFO.get(i);
			String retrievedFname = retrievedFlightInfo.getFlightName();
			if (flightName.equalsIgnoreCase(retrievedFname)) {
				searchListByName.add(retrievedFlightInfo);
				return searchListByName;
			}
		}
		if (searchListByName.size() == 0) {
			throw new AirLineReservationSystemException("Flight with " + flightName + " not found");
		} else {
			return searchListByName;
		}
	}

	public List<FlightsInfo> searchByDestination(String destination) {
		List<FlightsInfo> searchListByDestination = new ArrayList<FlightsInfo>();
		for (int i = 0; i <= AirLineDataBase.FLIGHTSINFO.size() - 1; i++) {
			FlightsInfo retrievedFlightInfo = AirLineDataBase.FLIGHTSINFO.get(i);
			String retrievedDestinationName = retrievedFlightInfo.getDestination();
			if (destination.equalsIgnoreCase(retrievedDestinationName)) {
				searchListByDestination.add(retrievedFlightInfo);
				return searchListByDestination;
			}
		}
		if (searchListByDestination.size() == 0) {
			throw new AirLineReservationSystemException("Flight with " + destination + " not found");
		} else {
			return searchListByDestination;
		}
	}

	public List<FlightsInfo> getAllFlightDetails() {
		List<FlightsInfo> flightList = new ArrayList<FlightsInfo>();
		for (FlightsInfo flight : AirLineDataBase.FLIGHTSINFO) {
			flight.getFlightId();
			flight.getFlightName();
			flight.getSource();
			flight.getDestination();
			flight.getArrivalTime();
			flight.getDepartureTime();
			flightList.add(flight);
		}
		return flightList;
	}

	public TicketRequestInfo booktTicket(UsersInfo usersInfo, FlightsInfo flightsInfo) {
		boolean flag = false, 
				isRequestExists = false;
			 TicketRequestInfo requestInfo = new TicketRequestInfo();
				UsersInfo userInfo = new UsersInfo();
				FlightsInfo flightInfo2 = new FlightsInfo();
				for (TicketRequestInfo requestInfo2 : AirLineDataBase.TICKETREQUESTS) {
					if (flightsInfo.getFlightId() == requestInfo2.getFlightInfo().getFlightId()) {
						isRequestExists = true;
					}
				}
				if (!isRequestExists) {
					for (UsersInfo user : AirLineDataBase.USERSINFO) {
						if (usersInfo.getUserId()== user.getUserId()) {
							for (FlightsInfo flight1 : AirLineDataBase.FLIGHTSINFO) {
								if (flight1.getFlightId() == flightsInfo.getFlightId()) {
									userInfo = user;
									flightInfo2 = flight1;
									flag = true;
								}
							}
						}
					}
					if (flag == true) {
						requestInfo.setFlightInfo(flightInfo2);
						requestInfo.setUserInfo(userInfo);
						AirLineDataBase.TICKETREQUESTS.add(requestInfo);
						return requestInfo;
					}
				}
				throw new AirLineReservationSystemException("Invalid request or you cannot request that flight");
	}

	
	@Override
	public boolean cancelBooking(int id) {
		boolean cancellationStatus = false;
		for (int i = 0; i <= AirLineDataBase.BOOKINGSINFO.size() - 1; i++) {
			BookingsInfo retrivedBookingInfo= AirLineDataBase.BOOKINGSINFO.get(i);
			int retrivedBookingId=retrivedBookingInfo.getBookingId();
			if(id==retrivedBookingId) {
				cancellationStatus=true;
				AirLineDataBase.BOOKINGSINFO.remove(i);
				break;
			}
			
		}
		return cancellationStatus;
	}

}
