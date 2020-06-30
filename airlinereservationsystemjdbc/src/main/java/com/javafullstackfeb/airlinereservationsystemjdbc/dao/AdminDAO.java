package com.javafullstackfeb.airlinereservationsystemjdbc.dao;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;

public interface AdminDAO {

	public UserInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(UserInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);


	public List<UserInfo> viewAllUsers();


}

