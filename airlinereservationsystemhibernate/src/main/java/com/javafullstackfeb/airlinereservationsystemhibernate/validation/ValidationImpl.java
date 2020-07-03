package com.javafullstackfeb.airlinereservationsystemhibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javafullstackfeb.airlinereservationsystemhibernate.exception.AirLineReservationSystemException;

public class ValidationImpl  implements Validation {
	public boolean validateId(int id) throws AirLineReservationSystemException {
		String idRegEx = "[0-9]{1}[0-9]{2}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		}
		return result;
	}
	
	public boolean validateFlightId(int id) throws AirLineReservationSystemException {
		String idRegEx = "[0-9]{1}[0-9]{3}";
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
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
		}
		return result;
	}

	public boolean validateMobile(String checkMobileno) throws AirLineReservationSystemException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(checkMobileno))) {
			result = true;
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
		} 
		return result;
	}

	public boolean validatePassword(String password) throws AirLineReservationSystemException {
		String passwordRegEx = "((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%]).{5,20})";
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) {
			result = true;
		} 
		return result;
	}
}
