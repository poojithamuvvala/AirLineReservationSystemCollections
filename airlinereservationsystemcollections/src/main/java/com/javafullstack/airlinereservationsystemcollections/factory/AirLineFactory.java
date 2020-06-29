package com.javafullstack.airlinereservationsystemcollections.factory;

import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemcollections.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserService;
import com.javafullstackfeb.airlinereservationsystemcollections.services.UserServiceImpl;

public class AirLineFactory {
 
	private AirLineFactory() {
		
	}
	public static AdminDAO getAdminDAOimplInstance() {
		AdminDAO dao=new AdminDAOImpl();
		return dao;
	}
	
	public static UserDAO getUserDAOImplInstance() {
	      UserDAO dao=new  UserDAOImpl();
	      return dao;
	}
	
	public static AdminService getAdminServiceImplInstance() {
		AdminService service=new AdminServiceImpl();
		return service;
	}
	
	public static UserService getUserServiceImplInstance() {
	       UserService service=new UserServiceImpl();
	       return service;
	}
}
