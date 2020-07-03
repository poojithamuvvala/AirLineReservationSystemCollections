package com.javafullstackfeb.airlinereservationsystemjdbc.validation;

public interface Validation {
	
	public boolean validateId(int id);
	
	public boolean validateFlightId(int id);
	
	public boolean validateName(String name);
	
	public boolean validateMobile(String checkMobileno);
	
	public boolean validateEmail(String email);
	
	public boolean validatePassword(String password);
	
}
