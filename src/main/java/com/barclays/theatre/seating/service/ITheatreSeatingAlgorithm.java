/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.List;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Reservation;
import com.barclays.theatre.seating.model.TheatreLayout;
import com.barclays.theatre.seating.model.TicketRequest;

/**
 * @author Aarthy Rajan
 * 
 *         Strategy interface to be implemented by a concrete algorithm for
 *         allocating seats in the theatre
 *
 */
public interface ITheatreSeatingAlgorithm {
	public List<Reservation> reserve(TheatreLayout layout, List<TicketRequest> ticketRequest) throws SeatingException;
}
