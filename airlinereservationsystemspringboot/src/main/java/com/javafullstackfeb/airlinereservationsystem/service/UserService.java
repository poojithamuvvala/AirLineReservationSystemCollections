package com.javafullstackfeb.airlinereservationsystem.service;

import com.javafullstackfeb.airlinereservationsystem.bean.UserBean;

public interface UserService {

	public boolean registerUser(UserBean userBean);

	public UserBean userLogin(String userId, String userPassword);
	
	public boolean registerByAdmin(UserBean userBean);

}
