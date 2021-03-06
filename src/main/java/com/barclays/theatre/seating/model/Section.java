/**
 * 
 */
package com.barclays.theatre.seating.model;

/**
 * Represents one section within a row in the Theatre Layout
 * 
 * @author Aarthy Rajan
 *
 */
public class Section {
	private final int sectionNumber;
	private final int totalSeats;
	private int availableSeats;
	private final Row row;

	public Section(int sectionNumber, int totalSeats, Row row) {
		super();
		// TODO: Validate that total seats is not negative
		// TODO: Test Boundary
		this.totalSeats = totalSeats;
		this.availableSeats = totalSeats;
		this.row = row;
		this.sectionNumber = sectionNumber;
	}

	/***
	 * Returns true if there is atleast one available set in this section
	 * @return
	 */
	public boolean isSeatAvailable() {
		return availableSeats > 0;
	}
	
	/***
	 * Does this section have the capacity to make a reservation (in full). Returns true if yes.
	 *  
	 * @param ticketRequest
	 * @return
	 */
	public boolean canReserve(TicketRequest ticketRequest) {
		return ticketRequest.getNumberOfTickets() <= this.availableSeats;
	}
	
	/***
	 * Reserves the requested number of seats in this section.
	 * 
	 * @param ticketRequest
	 * @return
	 */
	public synchronized boolean reserve(TicketRequest ticketRequest) {
		this.availableSeats = this.availableSeats - ticketRequest.getNumberOfTickets();
		return true;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}
	
	public Row getRow() {
		return row;
	}
}
