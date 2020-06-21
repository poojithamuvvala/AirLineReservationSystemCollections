package com.capgemini.airlinereservationsystemcollections.bean;

import java.io.Serializable;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AdminInfo implements Serializable {
	private int adminid;
	private String emailId;
	private String password;
	private String phoneNumber;

	public AdminInfo() {
		super();
	}

	public AdminInfo(int adminid, String emailId, String password, String phoneNumber) {
		super();
		this.adminid = adminid;
		this.emailId = emailId;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

}