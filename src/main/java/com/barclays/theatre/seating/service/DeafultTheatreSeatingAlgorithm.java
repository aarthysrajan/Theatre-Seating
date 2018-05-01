/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import com.barclays.theatre.seating.model.ReservationState;
import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Reservation;
import com.barclays.theatre.seating.model.Row;
import com.barclays.theatre.seating.model.Section;
import com.barclays.theatre.seating.model.TicketRequest;

/**
 * @author Aarthy Rajan
 *
 */
public class DeafultTheatreSeatingAlgorithm implements ITheatreSeatingAlgorithm {

	/* (non-Javadoc)
	 * @see com.xyz.theatre.seating.ITheatreSeater#reserve(com.xyz.theatre.seating.TheatreLayout, java.util.List)
	 */
	@Override
	public List<Reservation> reserve(final TheatreLayout layout, final List<TicketRequest> ticketRequests) throws SeatingException{
		// Sort the ticket requests by number of parties in each request 
		// makes sure it fills as many orders as possible
		//List<TicketRequest> ticketRequestList = new LinkedList<TicketRequest>(ticketRequests);
		//Collections.sort(ticketRequestList, new TicketRequestComparator());
		
		List<Row> rows = layout.getRows();
		List<Reservation> reservationsList = new LinkedList<Reservation>();
		
		for(TicketRequest request:ticketRequests) {
			// Test for no capacity
			if(request.getNumberOfTickets()>layout.getAvailableSeats()) {
				reservationsList.add(new Reservation(request, null, null, ReservationState.NO_CAPACITY));
				continue;
			}
			
			Reservation reservation = null;
			for(Row row: rows) {
				Section targetSection = row.canReserve(request);
				if(null!=targetSection) {
					// RESERVE in ONE SECTION
					targetSection.reserve(request);
					reservation = new Reservation(request, row, targetSection, ReservationState.RESERVED);
					reservationsList.add(reservation);
					break;
				}
			}
			
			if(null==reservation) {
				for(Row row: rows) { 
					if(request.getNumberOfTickets() <=row.getAvailableSeats()) {
						reservation = new Reservation(request, row, null, ReservationState.SPLIT);
						reservationsList.add(reservation);
						break;
					} 
				}
			}
		}
		return reservationsList;
	}

	protected class TicketRequestComparator implements Comparator<TicketRequest> {
		@Override
		public int compare(TicketRequest ticketRequest1, TicketRequest ticketRequest2) {
			return ticketRequest1.getNumberOfTickets() - ticketRequest2.getNumberOfTickets();
		}
	}
}