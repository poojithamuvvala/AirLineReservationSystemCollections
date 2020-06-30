package com.javafullstackfeb.airlinereservationsystemjdbc.services;



import java.util.List;

import com.javafullstackfeb.airlinereservationsystemjdbc.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemjdbc.bean.UserInfo;

public interface AdminService {
	public UserInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(UserInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);

	public List<UserInfo> viewAllUsers();
}
