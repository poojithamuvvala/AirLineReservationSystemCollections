package com.javafullstackfeb.airlinereservationsystemjdbc.bean;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
public class UserInfo implements Serializable {
	private int id;
	private String username;
	private String emailId;
	@ToString.Exclude
	private String password;
	private String phoneNumber;
	private String address;
    private String role;
}
