package com.javafullstackfeb.airlinereservationsystemjdbc.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
public class AdminInfo implements Serializable {
	private int adminid;
	private String adminName;
	private String emailId;
	@ToString.Exclude
	private String password;
	private String phoneNumber;

}
