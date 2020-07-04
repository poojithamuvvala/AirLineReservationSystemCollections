package com.javafullstackfeb.airlinereservationsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystemspring.bean.AirLineResponse;
import com.javafullstackfeb.airlinereservationsystemspring.bean.UserInfo;
import com.javafullstackfeb.airlinereservationsystemspring.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemspring.services.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(path="/serachFlightBySource/{source}",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AirLineResponse serachFlightBySource(@PathVariable(name="source") String source) {
	    List flightsInfos=  userService.searchBySource(source);
	    AirLineResponse flightResponse=new AirLineResponse();
	    if(flightsInfos!=null & !flightsInfos.isEmpty()) {
	    	flightResponse.setMessage("Flights available with"+source +"are:");
	    	flightResponse.setData(flightsInfos);
	    }
	    else {
	    	flightResponse.setError(true);
    		flightResponse.setMessage("Flights are not available");
	    }
		return flightResponse;
	}
	
	@GetMapping(path="/serachFlightBySource/{name}",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AirLineResponse serachFlightByName(@PathVariable(name="name") String name) {
	    List flightsInfos=  userService.searchByName(name);
	    AirLineResponse flightResponse=new AirLineResponse();
	    if(flightsInfos!=null & !flightsInfos.isEmpty()) {
	    	flightResponse.setMessage("Flights available with"+name +"are:");
	    	flightResponse.setData(flightsInfos);
	    }
	    else {
	    	flightResponse.setError(true);
    		flightResponse.setMessage("Flights are not available");
	    }
		return flightResponse;
	}
	
	
	@GetMapping(path="/serachFlightBySourceAndDestination",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AirLineResponse searchFlightBySourceAndDestination(String source,String destination){
	    List flightsInfos=  userService.searchFlightBySourceAndDestination(source,destination);;
	    AirLineResponse flightResponse=new AirLineResponse();
	    if(flightsInfos!=null & !flightsInfos.isEmpty()) {
	    	flightResponse.setMessage("Flights available with"+source+"and"+destination+" are:");
	    	flightResponse.setData(flightsInfos);
	    }
	    else {
	    	flightResponse.setError(true);
    		flightResponse.setMessage("Flights are not available");
	    }
		return flightResponse;
	}
	
	
	
	@PostMapping(path="/registerUser" , 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public AirLineResponse registerUser(UserInfo usersInfo) {
    	boolean isRegistered=adminService.newRegistration(usersInfo);
    	AirLineResponse flightResponse=new AirLineResponse();
    	if(isRegistered) {
    		flightResponse.setMessage("Flight Added Successfully");
    	} else {
    		flightResponse.setError(true);
    		flightResponse.setMessage("Flight is Not added");
    	}
		return flightResponse;
    }
	
	
	@GetMapping(path="/serachFlightBySourceAndDestination",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AirLineResponse getAllFlightDetails(){
	    List flightsInfos=  userService.getAllFlightDetails();;
	    AirLineResponse flightResponse=new AirLineResponse();
	    if(flightsInfos!=null & !flightsInfos.isEmpty()) {
	    	flightResponse.setMessage("All Flight Infos are:");
	    	flightResponse.setData(flightsInfos);
	    }
	    else {
	    	flightResponse.setError(true);
    		flightResponse.setMessage("Flights are not available");
	    }
		return flightResponse;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
