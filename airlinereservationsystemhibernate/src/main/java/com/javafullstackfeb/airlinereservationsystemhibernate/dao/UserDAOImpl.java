package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.javafullstack.airlinereservationsystemhibernate.utility.JDBCUtility;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.TicketRequestInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;


public class UserDAOImpl implements UserDAO {

	@Override
	public List<FlightsInfo> searchFlightByName(String flightName) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select e from EmployeeBean e where flightName=:name";
			Query query = manager.createQuery(jpql);
			  query.setParameter("name", flightName);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
		
			
		}

		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightBySource(String source) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f where source=:name";
			Query query = manager.createQuery(jpql);
			  query.setParameter("name",source);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}

		return null;
	}

	@Override
	public List<FlightsInfo> searchFlightByDestination(String destination) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f where destination=:name";
			Query query = manager.createQuery(jpql);
			  query.setParameter("name",  destination);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}

		return null;
	}

	@Override
	public boolean registerUser(UserInfo usersInfo) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;

		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(usersInfo);
        transaction.commit();
        System.out.println("Record saved");
        manager.close();
		entityManagerFactory.close();
        return true;
		} catch (Exception e) {
			e.printStackTrace();
            
		}

		
		return false;
	}

	@Override
	public TicketRequestInfo bookTicket(UserInfo usersInfo, FlightsInfo flightsInfo, int noOfSeats) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightsInfo> getAllFlightDetails() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select f from FlightsInfo f";
			Query query = manager.createQuery(jpql);
			List<FlightsInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}

		return null;
	}

	@Override
	public UserInfo authenticateUser(String email, String password) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;

		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = entityManagerFactory.createEntityManager();
	    String jpql="select u from UserInfo  u where  u.emailId=:email and u.password=:password";
	       Query query =manager.createQuery(jpql);
	       query.setParameter("email", email);
			query.setParameter("password", password);
			UserInfo  record=(UserInfo)query.getSingleResult();
	        System.out.println("Record saved");
	        manager.close();
			entityManagerFactory.close();
	        return record;
			} catch (Exception e) {
				e.printStackTrace();
	            
			}
		return null;
	}

}
