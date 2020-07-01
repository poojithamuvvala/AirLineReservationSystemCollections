package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.javafullstack.airlinereservationsystemhibernate.utility.JDBCUtility;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;

public class AdminDAOImpl implements AdminDAO {
	
	public UserInfo authenticateAdmin(String email, String password) {
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

	public boolean registerAdmin(UserInfo newAdmin) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;

		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(newAdmin);
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

	public boolean addFlight(FlightsInfo flightInfo) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;

		try {
		entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(flightInfo);
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
	public boolean cancelFlight(int id) {
		
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			FlightsInfo flightInfo = entityManager.find(FlightsInfo.class, id);
			entityManager.remove(flightInfo);
			System.out.println("record is successfully deleted!!!");
			entityTransaction.commit();
			entityManager.close();
			entityManagerFactory.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	

	@Override
	public List<UserInfo> viewAllUsers() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select u from UserInfo u";
			Query query = manager.createQuery(jpql);
			List<UserInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
			entityManagerFactory.close();
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}

		return null;
	}
}	
