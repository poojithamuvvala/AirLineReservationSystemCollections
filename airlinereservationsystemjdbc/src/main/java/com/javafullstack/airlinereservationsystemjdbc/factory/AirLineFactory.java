package com.javafullstack.airlinereservationsystemjdbc.factory;

import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserServiceImpl;

public class AirLineFactory {
 
	private AirLineFactory() {
		
	}
	public static AdminDAO getAdminDAOimplInstance() {
		AdminDAO dao=new AdminDAOImpl();
		return dao;
	}
	
	public static AdminDAO getUserDAOImplInstance() {
	      AdminDAO dao=new  AdminDAOImpl();
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
