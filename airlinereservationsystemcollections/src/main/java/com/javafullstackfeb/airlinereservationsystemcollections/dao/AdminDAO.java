package com.javafullstackfeb.airlinereservationsystemcollections.dao;

import java.util.List;

import com.javafullstackfeb.airlinereservationsystemcollections.bean.AdminInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.BookingsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemcollections.bean.UsersInfo;

public interface AdminDAO {

	public AdminInfo authenticateAdmin(String email, String password);

	public boolean registerAdmin(AdminInfo adminInfo);

	public boolean addFlight(FlightsInfo flightInfo);

	public boolean cancelFlight(int id);


	public List<UsersInfo> viewAllUsers();

	public List<BookingsInfo> viewAllBookings();

}

