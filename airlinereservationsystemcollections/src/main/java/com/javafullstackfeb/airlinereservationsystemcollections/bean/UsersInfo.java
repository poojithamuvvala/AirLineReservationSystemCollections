package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class UsersInfo implements Serializable {
	private int userId;
	private String emailId;
	private String userName;
	private String password;
	private LocalDate dateOfBirth;
	private String address;
	private String phoneNumber;

	

}
