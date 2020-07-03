package com.javafullstackfeb.airlinereservationsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightResponse;
import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.services.AdminService;
import com.javafullstackfeb.airlinereservationsystemspring.services.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private UserService userService;
	@PostMapping(path="/addFlight" , 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public void addFlight(FlightsInfo newflightsInfo) {
    	boolean isAdded=adminService.addFlight(newflightsInfo);
    	FlightResponse flightResponse=new FlightResponse();
    	if(isAdded) {
    		flightResponse.setMessage("Flight Added Successfully");
    	} else {
    		flightResponse.setError("Unable To Add a Flight");
    	}
    }
	
	@GetMapping(path="/serachFlightBySource/{source}",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void serachFlightBySource(String source) {
	    List<FlightsInfo> flightsInfos=  userService.searchBySource(source);
	}
}
