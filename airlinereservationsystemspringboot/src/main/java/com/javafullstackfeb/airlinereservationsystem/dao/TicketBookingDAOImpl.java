package com.javafullstackfeb.airlinereservationsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;
import com.javafullstackfeb.airlinereservationsystem.bean.FlightInformationBean;

@Repository
public class TicketBookingDAOImpl implements TicketBookingDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public TicketBookingBean bookFlight(TicketBookingBean flightBooking) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		tx.begin();
		
		FlightInformationBean flightInfo = manager.find(FlightInformationBean.class, flightBooking.getFlightNo());
		
		int bussinessClassSeats = flightInfo.getBussinessClassSeats();
		int firstClassSeats = flightInfo.getFirstClassSeats();
		double bussinessClassFare = flightInfo.getBussinessClassFare();
		double firstClassSeatFare = flightInfo.getFirstClassSeatFare();
		int passengers = flightBooking.getPassengers();

		String bookingId = GenerateBookingId.generateBookingId(10);
		String classType = flightBooking.getClassType();

		if (classType.equals("Bussiness") && passengers > 0 && passengers <= bussinessClassSeats) {

			double totalFare = passengers * bussinessClassFare;
			flightBooking.setTotalFare(totalFare);
			bussinessClassSeats = bussinessClassSeats - passengers;
			flightInfo.setBussinessClassSeats(bussinessClassSeats);
			flightBooking.setPassengers(passengers);
			flightBooking.setBookingId(bookingId);
			try {
				manager.persist(flightBooking);
				//isAdded = true;
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (classType.equals("First Class") && passengers > 0 && passengers <= firstClassSeats) {

			double totalFare = passengers * firstClassSeatFare;
			flightBooking.setTotalFare(totalFare);
			firstClassSeats = firstClassSeats - passengers;
			flightInfo.setFirstClassSeats(firstClassSeats);
			flightBooking.setPassengers(passengers);
			flightBooking.setBookingId(bookingId);
			try {
				manager.persist(flightBooking);
				//isAdded = true;
				tx.commit();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			// return isAdded;

		}
		TicketBookingBean getFlight = manager.find(TicketBookingBean.class, bookingId);

		return getFlight;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<TicketBookingBean> getAllBooking(String userId) {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from TicketBookingBean where userId= :userId";
		Query query = manager.createQuery(jpql);
		query.setParameter("userId", userId);

		List<TicketBookingBean> getAllBooking = null;
		try {
			getAllBooking = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getAllBooking;
	}

	@Override
	public boolean deleteBooking(String bookingId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ars");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		FlightInformationBean flightInfo = new FlightInformationBean();
		TicketBookingBean flightBooked = new TicketBookingBean();
		flightBooked = entityManager.find(TicketBookingBean.class, bookingId);
		String flightNo = flightBooked.getFlightNo();
		int passenger1 = flightBooked.getPassengers();
		String classType1 = flightBooked.getClassType();

		

		boolean isDeleted = false;

		try {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			TicketBookingBean flightBooking = entityManager.find(TicketBookingBean.class, bookingId);
			entityManager.remove(flightBooking);

			isDeleted = true;
			if (isDeleted) {
				flightInfo = entityManager.find(FlightInformationBean.class, flightNo);
				int firstClass = flightInfo.getFirstClassSeats();
				System.err.println(firstClass);
				int bussiness = flightInfo.getBussinessClassSeats();
				System.err.println(bussiness);
				if (classType1.equalsIgnoreCase("Bussiness")) {
					bussiness = bussiness + passenger1;
					System.err.println(bussiness);
					flightInfo.setBussinessClassSeats(bussiness);
				} else if (classType1.equalsIgnoreCase("First Class")) {
					firstClass = firstClass + passenger1;
					System.err.println(firstClass);
					flightInfo.setFirstClassSeats(firstClass);
				} else {
					return false;
				}
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isDeleted;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<TicketBookingBean> getAllFlightBookings() {
		EntityManager manager = emf.createEntityManager();

		String jpql = "from TicketBookingBean";
		Query query = manager.createQuery(jpql);
		

		List<TicketBookingBean> getAllBooking = null;
		try {
			getAllBooking = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return getAllBooking;
	}

}
