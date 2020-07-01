package com.javafullstack.airlinereservationsystemhibernate.factory;

import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemhibernate.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.UserService;
import com.javafullstackfeb.airlinereservationsystemhibernate.services.UserServiceImpl;

public class AirLineFactory {
 
	private AirLineFactory() {
		
	}
	public static AdminDAO getAdminDAOimplInstance() {
		AdminDAO dao=new AdminDAOImpl();
		return dao;
	}
	
	public static UserDAO getUserDAOImplInstance() {
	      UserDAO dao=new UserDAOImpl();
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
