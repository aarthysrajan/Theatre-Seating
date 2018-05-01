/**
 * 
 */
package com.barclays.theatre.seating.model;

import com.barclays.theatre.seating.model.ReservationState;

/**
 * The state of a reservation per order. This is the result of processing 
 * an order.
 * @author Aarthy Rajan
 *
 */
public class Reservation {
	private final TicketRequest ticketRequest;
	private final Row row;
	private final Section section;
	private ReservationState state;
	
	public Reservation(TicketRequest ticketRequest, Row row, Section section, ReservationState state) {
		super();
		this.ticketRequest = ticketRequest;
		this.row = row;
		this.section = section;
		this.state = state;
	}
	
	public Reservation(TicketRequest ticketRequest, Row row, Section section) {
		this(ticketRequest, row, section, ReservationState.REQUESTED);
	}
	
	public ReservationState getState() {
		return state;
	}
	public void setState(ReservationState state) {
		this.state = state;
	}
	
	public TicketRequest getTicketRequest() {
		return ticketRequest;
	}
	
	public Row getRow() {
		return row;
	}
	
	public Section getSection() {
		return section;
	}
}
