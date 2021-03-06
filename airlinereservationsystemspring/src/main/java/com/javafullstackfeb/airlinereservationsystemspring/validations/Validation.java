package com.javafullstackfeb.airlinereservationsystemspring.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.javafullstackfeb.airlinereservationsystemspring.exception.AirLineReservationSystemException;
@Component
public class Validation {
	public boolean validateId(int id) throws AirLineReservationSystemException {
		String idRegEx = "[0-9]{1}[0-9]{2}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 3 digits");
		}
		return result;
	}
	
	public boolean validateFlightId(int id) throws AirLineReservationSystemException {
		String idRegEx = "[0-9]{1}[0-9]{3}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new AirLineReservationSystemException("Invalid Id! Id should exactly contain 4 digits");
		}
		return result;
	}
	
	

	public boolean validateName(String name) throws AirLineReservationSystemException {
		String nameRegEx = "^(?=.{4,20}$)(?![_.-])(?!.*[.]{2})[a-zA-Z._-]+(?<![_.-])";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirLineReservationSystemException("Invalid Name! Name should have atleast 4 characters or more than 4 characters");
		}
		return result;
	}

	public boolean validateMobile(String checkMobileno) throws AirLineReservationSystemException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(checkMobileno))) {
			result = true;
		} else {
			throw new AirLineReservationSystemException("Inalid Mobile Number! Enter a mobile number whose length should be exactly 10 digits and should start with 6,7,8,9 digits only");
		}
		return result;
	}

	public boolean validateEmail(String email) throws AirLineReservationSystemException {
		String emailRegEx = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.(com|org)";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new AirLineReservationSystemException("Enter proper email such that it should consist of numbers and alphabets and @ symbol");
		}
		return result;
	}

	public boolean validatePassword(String password) throws AirLineReservationSystemException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{5,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} else {
			throw new AirLineReservationSystemException(
					"Password should contain atleast 5 characters ,one uppercase,one lowercase,one number,one special symbol(@#$%) ");
		}
		return result;
	}
}
