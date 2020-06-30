package com.javafullstackfeb.airlinereservationsystemhibernate.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemhibernate.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemhibernate.bean.UserInfo;

public interface AdminDAO {

	public UserInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(UserInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);


	public List<UserInfo> viewAllUsers();


}

