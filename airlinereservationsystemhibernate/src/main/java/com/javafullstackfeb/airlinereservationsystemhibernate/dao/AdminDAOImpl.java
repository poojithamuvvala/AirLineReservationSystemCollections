package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;

public class AdminDAOImpl implements AdminDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");;
	public UserInfo authenticateAdmin(String email, String password) {
		
		EntityManager manager = null;

		try {
		
		manager = entityManagerFactory.createEntityManager();
	    String jpql="select u from UserInfo  u where  u.emailId=:email and u.password=:password ";
	       Query query =manager.createQuery(jpql);
	       query.setParameter("email", email);
			query.setParameter("password", password);
			UserInfo  record=(UserInfo)query.getSingleResult();
	        System.out.println("Record saved");
	        manager.close();
		
	        return record;
			} catch (Exception e) {
				e.printStackTrace();
	            
			}
		return null;
	}

	public boolean registerAdmin(UserInfo newAdmin) {
		
		EntityManager manager = null;

		try {
		
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(newAdmin);
        transaction.commit();
        System.out.println("Record saved");
        manager.close();
		
        return true;
		} catch (Exception e) {
			e.printStackTrace();
            
		}

		
		return false;
	}

	public boolean addFlight(FlightsInfo flightInfo) {
		EntityManager manager = null;

		try {
		
		manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        manager.persist(flightInfo);
        transaction.commit();
        System.out.println("Record saved");
        manager.close();
		
        return true;
		} catch (Exception e) {
			e.printStackTrace();
            
		}

		
		return false;
	}
	public boolean cancelFlight(int id) {
		
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			FlightsInfo flightInfo = entityManager.find(FlightsInfo.class, id);
			entityManager.remove(flightInfo);
			System.out.println("record is successfully deleted!!!");
			entityTransaction.commit();
			entityManager.close();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return false;
	}

	

	@Override
	public List<UserInfo> viewAllUsers() {
		
		EntityManager manager = null;
		

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = entityManagerFactory.createEntityManager();
			String jpql = "Select u from UserInfo u";
			Query query = manager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<UserInfo> recordList = query.getResultList();
			for (int i = 0; i < recordList.size()-1; i++) {
				recordList.get(i);
			}
			manager.close();
		
			return recordList;
			
		
		}catch (Exception e) {
			e.printStackTrace();
		
			
		}

		return null;
	}
}	
