package com.javafullstackfeb.airlinereservationsystemcollections.bean;

import java.io.Serializable;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class AdminInfo implements Serializable {
	private int adminid;
	private String emailId;
	private String password;
	private String phoneNumber;

	
}
