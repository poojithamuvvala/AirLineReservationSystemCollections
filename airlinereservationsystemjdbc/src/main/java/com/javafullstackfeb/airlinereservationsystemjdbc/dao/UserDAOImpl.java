package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javafullstack.airlinereservationsystemjdbc.utility.JDBCUtility;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.exception.AirLineReservationSystemException;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<FlightsInfo> searchFlightByName(String flightName) {
		ResultSet resultSet = null;

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(JDBCUtility.getQuery("searchFlightByName"));) {
			preparedStatement.setString(1, flightName);
			resultSet = preparedStatement.executeQuery();
			List<FlightsInfo> listOfFlights = new ArrayList<FlightsInfo>();
			while (resultSet.next()) {
				FlightsInfo bean = new FlightsInfo();
				bean.setFlightId(resultSet.getInt("flightid"));
				bean.setFlightName(resultSet.getString("flightsname"));
				bean.setSource(resultSet.getString("source"));
				bean.setDestination(resultSet.getString("destination"));
				bean.setNoOfSeatsBooked(resultSet.getInt("noofseatsbooked"));
				bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
				bean.setArrivalTime(resultSet.getTime("timeofarrival").toLocalTime());
				bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
				bean.setDepartureTime(resultSet.getTime("timeofdeparture").toLocalTime());
				listOfFlights.add(bean);
				return listOfFlights;

			}
			if (listOfFlights.isEmpty()) {
				return null;
			} else {
				return listOfFlights;
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

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(JDBCUtility.getQuery("searchFlightBySource"));) {
			preparedStatement.setString(1, source);
			resultSet = preparedStatement.executeQuery();
			List<FlightsInfo> l = new ArrayList<FlightsInfo>();
			while (resultSet.next()) {
				FlightsInfo bean = new FlightsInfo();
				bean.setFlightId(resultSet.getInt("flightid"));
				bean.setFlightName(resultSet.getString("flightsname"));
				bean.setSource(resultSet.getString("source"));
				bean.setDestination(resultSet.getString("destination"));
				bean.setNoOfSeatsBooked(resultSet.getInt("noofseatsbooked"));
				bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
				bean.setArrivalTime(resultSet.getTime("timeofarrival").toLocalTime());
				bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
				bean.setDepartureTime(resultSet.getTime("timeofdeparture").toLocalTime());
				l.add(bean);
				return l;
			}
			if (l.isEmpty()) {
				return null;
			} else {
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

				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination) {
		ResultSet resultSet = null;

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(JDBCUtility.getQuery("searchFlightBySourceAndDestination"));) {
			preparedStatement.setString(1, source);
            preparedStatement.setString(2, destination);
			resultSet = preparedStatement.executeQuery();
			List<FlightsInfo> l = new ArrayList<FlightsInfo>();
			while (resultSet.next()) {
				FlightsInfo bean = new FlightsInfo();
				bean.setFlightId(resultSet.getInt("flightid"));
				bean.setFlightName(resultSet.getString("flightsname"));
				bean.setSource(resultSet.getString("source"));
				bean.setDestination(resultSet.getString("destination"));
				bean.setNoOfSeatsBooked(resultSet.getInt("noofseatsbooked"));
				bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
				bean.setArrivalTime(resultSet.getTime("timeofarrival").toLocalTime());
				bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
				bean.setDepartureTime(resultSet.getTime("timeofdeparture").toLocalTime());
				l.add(bean);
				return l;

			}
			if (l.isEmpty()) {
				return null;
			} else {
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

				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		ResultSet resultSet = null;

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(JDBCUtility.getQuery("viewFlights"));) {

			resultSet = preparedStatement.executeQuery();
			List<FlightsInfo> list = new ArrayList<FlightsInfo>();
			while (resultSet.next()) {
				FlightsInfo bean = new FlightsInfo();
				bean.setFlightId(resultSet.getInt("flightid"));
				bean.setFlightName(resultSet.getString("flightsname"));
				bean.setSource(resultSet.getString("source"));
				bean.setDestination(resultSet.getString("destination"));
				bean.setNoOfSeatsBooked(resultSet.getInt("noofseatsbooked"));
				bean.setDateOfArrival(resultSet.getDate("dateofarrival").toLocalDate());
				bean.setArrivalTime(resultSet.getTime("timeofarrival").toLocalTime());
				bean.setDateOfDeparture(resultSet.getDate("dateofdeparture").toLocalDate());
				bean.setDepartureTime(resultSet.getTime("timeofdeparture").toLocalTime());
				bean.setCapacity(resultSet.getInt("capacity"));
				list.add(bean);

			}
			if (list.isEmpty()) {
				throw new AirLineReservationSystemException("No FLights Found");
			} else {
				return list;
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw new AirLineReservationSystemException(e.getMessage());
		}

	}

	@Override
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo) {
		int userId = requestInfo.getUid();

		try (Connection connection = JDBCUtility.getConnection();
				PreparedStatement preparedStatementOfFlight = connection
						.prepareStatement(JDBCUtility.getQuery("getFlight"));) {

			preparedStatementOfFlight.setInt(1, requestInfo.getFlightid());

			try (ResultSet getReqSet = preparedStatementOfFlight.executeQuery();) {

				while (getReqSet.next()) {
					int bookFlightId = getReqSet.getInt("flightid");

					if (requestInfo.getFlightid() == bookFlightId) {

						try (Connection connection2 = JDBCUtility.getConnection();
								PreparedStatement preparedStatementOfUser = connection
										.prepareStatement(JDBCUtility.getQuery("getUser"));) {
							preparedStatementOfUser.setInt(1, requestInfo.getUid());
							try (ResultSet getUser = preparedStatementOfUser.executeQuery();) {
								while (getUser.next()) {
									int user = getUser.getInt("id");
									if (userId == user) {
										try (Connection connection3 = JDBCUtility.getConnection();
												PreparedStatement getRequestPstmt = connection3
														.prepareStatement(JDBCUtility.getQuery("requestBooked"));) {
											getRequestPstmt.setInt(1, requestInfo.getTicketid());
											getRequestPstmt.setInt(2, requestInfo.getUid());
											getRequestPstmt.setInt(3, requestInfo.getFlightid());
											getRequestPstmt.setInt(4, requestInfo.getNoOfSeatsToBeBooked());
											getRequestPstmt.executeUpdate();
											return requestInfo;
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								}

							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (AirLineReservationSystemException e) {
			throw new AirLineReservationSystemException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public boolean cancelTicket(int bookingId) {
		try (Connection conn = JDBCUtility.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(JDBCUtility.getQuery("cancelTicket"));) {
			pstmt.setInt(1, bookingId);
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}

		} catch (Exception e) {
			throw new AirLineReservationSystemException(e.getMessage());

		}
		return true;
	}

}
