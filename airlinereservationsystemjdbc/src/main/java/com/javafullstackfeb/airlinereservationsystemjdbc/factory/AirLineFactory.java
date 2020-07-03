package com.javafullstackfeb.airlinereservationsystemjdbc.factory;

import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.AdminDAOImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.UserDAO;
import com.javafullstackfeb.airlinereservationsystemjdbc.dao.UserDAOImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.AdminServiceImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserService;
import com.javafullstackfeb.airlinereservationsystemjdbc.services.UserServiceImpl;
import com.javafullstackfeb.airlinereservationsystemjdbc.validation.Validation;
import com.javafullstackfeb.airlinereservationsystemjdbc.validation.ValidationImpl;

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
	
	public static Validation getValidationImpl() {
		Validation validation=new ValidationImpl();
		return validation;
	}
}
