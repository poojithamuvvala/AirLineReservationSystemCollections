package com.capgemini.airlinereservationsystemcollections.bean;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UsersInfo {
	private int userId;
	private String emailId;
	private String userName;
	private LocalDate dateOfBirth;
	private String address;
	private String phoneNumber;

	public UsersInfo() {
		super();
	}

	public UsersInfo(int userId, String emailId, String userName, LocalDate dateOfBirth, String address, String phoneNumber) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

}
