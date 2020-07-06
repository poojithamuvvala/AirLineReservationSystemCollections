package com.javafullstackfeb.airlinereservationsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javafullstackfeb.airlinereservationsystem.bean.TicketBookingBean;
import com.javafullstackfeb.airlinereservationsystem.response.TicketBookingResponse;
import com.javafullstackfeb.airlinereservationsystem.response.FlightResponse;
import com.javafullstackfeb.airlinereservationsystem.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class TicketBookingController {

	@Autowired
	private FlightService service;

	@PostMapping("/bookFlight")
	public FlightResponse bookFlight(@RequestBody TicketBookingBean ticketBooking) {

		TicketBookingBean bookinginfo = service.bookFlight(ticketBooking);
		String bookingId = bookinginfo.getBookingId();
		double totalFare = bookinginfo.getTotalFare();

		FlightResponse response = new FlightResponse();
		if (bookinginfo != null) {
			response.setStatusCode(201);
			response.setMessage("Congratulations!Sir/Mam Flight Ticket booked successfully.");
			response.setDescription("Congratulations! Flight Ticket booked successfully. Your BookingId is " + bookingId);
			response.setBookingid(bookingId);
			response.setTotalFare(totalFare);
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking failed.");
			response.setDescription(" Oops! Flight booked failed due to unavailability of seats.");
		}
		return response;
	}

	@GetMapping("/getAllBooking")
	public TicketBookingResponse getAllBookingInfo(String userId) {
		
		List<TicketBookingBean> allBookingInfo = service.getAllBooking(userId);
		TicketBookingResponse response = new TicketBookingResponse();
		if (allBookingInfo != null) {
			response.setStatusCode(210);
			response.setMessage("All the flight booking information retrieved successfully.");
			response.setDescription("All the flight booking information retrieved successfully for userId : " + userId);
			response.setGetAllBookingInfo(allBookingInfo);
		} else {

			response.setStatusCode(401);
			response.setMessage("No booking found!");
			response.setDescription(" No booking found " + userId);

		}
		return response;

	}// end of getAllBookingInfo()

	@DeleteMapping("/deleteBooking")
	public TicketBookingResponse deleteBooking(String bookingId) {
		boolean isDeleted = service.deleteBooking(bookingId);
		TicketBookingResponse response = new TicketBookingResponse();
		if (isDeleted) {
			response.setStatusCode(201);
			response.setMessage("Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days. ");
			response.setDescription("Congratulation! Flight booking cancelled successfully. We will refund your payment within 3 working days ");
		} else {
			response.setStatusCode(401);
			response.setMessage("Oops! Flight booking can not be cancelled.");
			response.setDescription("Oops! Flight booking can not be cancelled.");

		}
		return response;
	}
}
