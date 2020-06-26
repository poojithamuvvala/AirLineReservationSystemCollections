package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserInfo {
	private int userId;
	private int emailId;
	private String userName;
	private LocalDate dateOfBirth;
	private String address;
	private long phoneNumber;

	public UserInfo() {
		super();
	}

	public UserInfo(int userId, int emailId, String userName, LocalDate dateOfBirth, String address, long phoneNumber) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.userName = userName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

}
