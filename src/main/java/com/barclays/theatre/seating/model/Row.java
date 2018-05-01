/**
 * 
 */
package com.barclays.theatre.seating.model;

import java.util.LinkedList;
import java.util.List;

/**
 * This is a row in the theatre layout. A row has one or more sections.
 * 
 * @author Aarthy Rajan
 *
 */
public class Row {
	private final List<Section> sections;
	private final int rowNumber;

	public Row(int rowNumber) {
		this.rowNumber = rowNumber;
		this.sections = new LinkedList<Section>();
	}

	public void addSection(Section section) {
		this.sections.add(section);
	}

	/***
	 * Gets the total available seats in a row.
	 * @return
	 */
	public int getAvailableSeats() {
		int seatsCount = 0;
		for (Section section : this.getSections()) {
			seatsCount = seatsCount + section.getAvailableSeats();
		}
		return seatsCount;
	}

	/***
	 * Checks if the row has a section where the
	 * reservation can be made successfully (in full).
	 * 
	 * @param ticketRequest the ticket order / request
	 * @return null: if there is no section in this row that can satisfy the request in full<br/>
	 * the first section in the row if one section has the capacity for reservation. 
	 *  
	 */
	public Section canReserve(TicketRequest ticketRequest) {
		for (Section section : this.getSections()) {
			if (section.isSeatAvailable() && section.canReserve(ticketRequest)) {
				return section;
			}
		}
		return null;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public int getRowNumber() {
		return rowNumber;
	}
}
