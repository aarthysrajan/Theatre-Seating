/**
 * 
 */
package com.barclays.theatre.seating.model;

/**
 * @author Aarthy Rajan
 *
 */
public class TicketRequest {
	private String name;
	private int numberOfTickets;
	
	public TicketRequest(String name, int numberOfTickets) {
		super();
		this.name = name;
		this.numberOfTickets = numberOfTickets;
	}

	public String getName() {
		return name;
	}
	
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
}
