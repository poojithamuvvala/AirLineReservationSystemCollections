package com.javafullstackfeb.airlinereservationsystemhibernate.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="userinfo")
public class UserInfo implements Serializable {
	@Id
	@Column
	private int id;
	@Column(name="name")
	private String username;
	@Column(name="emailid")
	private String emailId;
	

	@ToString.Exclude
	@Column(name="password")
	private String password;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column
    private String role;
}
