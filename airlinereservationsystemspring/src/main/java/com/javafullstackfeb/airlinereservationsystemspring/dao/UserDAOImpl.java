package com.javafullstackfeb.airlinereservationsystemspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemspring.exception.AirLineReservationSystemException;
@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<FlightsInfo> searchFlightByName(String flightName) {

		EntityManager manager = null;

		try {
			
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select e from EmployeeBean e where flightName=:name";
			Query query = manager.createQuery(jpql);
			query.setParameter("name", flightName);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();
			
			return recordList;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightBySource(String source) {

		EntityManager manager = null;

		try {
			
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f where source=:name";
			Query query = manager.createQuery(jpql);
			query.setParameter("name", source);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();
		
			return recordList;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightBySourceAndDestination(String source, String destination) {
		
		EntityManager manager = null;

		try {
			
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f where source=:source and destination=:destination";
			Query query = manager.createQuery(jpql);
			query.setParameter("source", source);
			query.setParameter("destination", destination);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();
			
			return recordList;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public boolean registerUser(UserInfo usersInfo) {
		
		EntityManager manager = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(usersInfo);
			transaction.commit();
			System.out.println("Record saved");
			manager.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		
		EntityManager manager = null;

		try {
			
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f";
			Query query = manager.createQuery(jpql);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size() - 1; i++) {
				recordList.get(i);
			}
			manager.close();
			
			return recordList;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public UserInfo authenticateUser(String email, String password) {
		
		EntityManager manager = null;

		try {
			
			manager = entityManagerFactory.createEntityManager();
			String jpql = "select u from UserInfo  u where  u.emailId=:email and u.password=:password";
			Query query = manager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserInfo record = (UserInfo) query.getSingleResult();
			System.out.println("Record saved");
			manager.close();
			
			return record;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

	@Override
	public TicketRequestInfo bookTicket(TicketRequestInfo requestInfo) {
		
		EntityManager manager = null;
		EntityTransaction transaction = null;
		TicketRequestInfo tickets = new TicketRequestInfo();
		try {
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();

			try {
				FlightsInfo record = manager.find(FlightsInfo.class, requestInfo.getFlightid());
				if (record != null) {
					try {
						UserInfo record1 = manager.find(UserInfo.class, requestInfo.getUid());
						if (record1 != null) {
							try {
								transaction.begin();
								tickets.setTicketid(requestInfo.getTicketid());
								tickets.setUid(requestInfo.getUid());
								tickets.setFlightid(requestInfo.getFlightid());
								tickets.setNoOfSeatsToBeBooked(requestInfo.getNoOfSeatsToBeBooked());
								manager.persist(tickets);
								transaction.commit();
								return tickets;
							} catch (Exception e) {
								e.getMessage();
								transaction.rollback();
							}
						}
					} catch (Exception e) {
						e.getMessage();
						transaction.rollback();
					}
				}
			} catch (Exception e) {
				e.getMessage();
				transaction.rollback();
			} finally {
				manager.close();
				
			}
			return null;

		} catch (Exception e) {
			e.getMessage();
		}
		throw new AirLineReservationSystemException("Can't book the ticket");

	}

	@Override
	public boolean cancelTicket(int id) {
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
	          TicketRequestInfo requestInfo = entityManager.find(TicketRequestInfo.class, id);
			entityManager.remove(requestInfo);
			System.out.println("record is successfully deleted!!!");
			entityTransaction.commit();
			entityManager.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
		
	}

}