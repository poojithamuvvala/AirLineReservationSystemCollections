package com.javafullstackfeb.airlinereservationsystemspring.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;

public interface AdminDAO {

	public UserInfo authenticate(String email, String password);

	public boolean newRegistration(UserInfo userInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);


	public List<UserInfo> viewAllUsers();


}

