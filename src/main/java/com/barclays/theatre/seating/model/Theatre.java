/**
 * 
 */
package com.barclays.theatre.seating.model;

import java.util.List;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.service.DeafultTheatreSeatingAlgorithm;
import com.barclays.theatre.seating.service.ITheatreSeatingAlgorithm;

/**
 * Represents the entire Theatre.
 * 
 * @author Aarthy Rajan
 *
 */
public class Theatre {
	
	private ITheatreSeatingAlgorithm theatreSeaterAlgorithm;
	private final TheatreLayout layout;
	
	public Theatre(TheatreLayout layout) {
		//TODO: dependency injection or factory to decouple the
		// concrete algo from the Theatre
		this.theatreSeaterAlgorithm = new DeafultTheatreSeatingAlgorithm();
		this.layout = layout;
	}
	
	/***
	 * Method to perform a reservation. Internally uses the decoupled algorithm using the strategy
	 * design pattern.
	 * @param ticketRequest
	 * @return
	 * @throws SeatingException
	 */
	public List<Reservation> reserve(List<TicketRequest> ticketRequest) throws SeatingException {
		return this.theatreSeaterAlgorithm.reserve(this.layout, ticketRequest);
	}
}