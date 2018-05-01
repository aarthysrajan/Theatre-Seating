/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.List;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Reservation;
import com.barclays.theatre.seating.model.TicketRequest;

/**
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
	
	public List<Reservation> reserve(List<TicketRequest> ticketRequest) throws SeatingException {
		return this.theatreSeaterAlgorithm.reserve(this.layout, ticketRequest);
	}
}