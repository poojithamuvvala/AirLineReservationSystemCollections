package com.javafullstackfeb.airlinereservationsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_Info")
public class UserBean {

	@Column(name = "first_name")
	@Pattern(regexp = "[A-Za-z]*")
	private String userFirstName;

	@Column(name = "last_name")
	@Pattern(regexp = "[A-Za-z]*")
	private String userLastName;

	@Column(name = "email")
	@Email(message = "Entered email id format is not valid.")
	private String userEmail;

	@Column(name = "contact", unique = true)
	@Positive
	private long userContact;

	@Id
	@Column(name = "user_Id")
	@Pattern(regexp = "[A-Za-z0-9]*")
	@Size(min = 6, message = "Entered userId must contain minimum of 6 characters.")
	private String userId;

	@Column(name = "user_Password")
	private String userPassword;

	@Column(name = "role")
	@Pattern(regexp = "[A-Za-z]*")
	private String userRole;

	
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
