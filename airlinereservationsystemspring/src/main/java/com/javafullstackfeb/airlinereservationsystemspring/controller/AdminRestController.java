package com.javafullstackfeb.airlinereservationsystemspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystemspring.bean.AirLineResponse;
import com.javafullstackfeb.airlinereservationsystemspring.bean.FlightsInfo;
import com.javafullstackfeb.airlinereservationsystemspring.services.AdminService;

@RestController
public class AdminRestController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path="/addFlight" , 
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE} )
    public AirLineResponse addFlight(FlightsInfo newflightsInfo) {
    	boolean isAdded=adminService.addFlight(newflightsInfo);
    	AirLineResponse flightResponse=new AirLineResponse();
    	if(isAdded) {
    		flightResponse.setMessage("Flight Added Successfully");
    	} else {
    		flightResponse.setError(true);
    		flightResponse.setMessage("Flight is Not added");
    	}
		return flightResponse;
    }
	
	@GetMapping(path="/viewAllUsers",
			produces ={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public AirLineResponse viewAllUsers(){
	    List userInfos=  adminService.viewAllUsers();;
	    AirLineResponse flightResponse=new AirLineResponse();
	    if(userInfos!=null & !userInfos.isEmpty()) {
	    	flightResponse.setMessage("All User Infos are:");
	    	flightResponse.setData(userInfos);
	    }
	    else {
	    	flightResponse.setError(true);
    		flightResponse.setMessage("Users are not available");
	    }
		return flightResponse;
	}
}
