/**
 * 
 */
package com.barclays.theatre.seating.model;

import java.util.LinkedList;
import java.util.List;

/**
 * This is a row in the theatre layout. A row has one or more sections. 
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
	
	public int getAvailableSeats() {
		int seatsCount=0;
		for(Section section : this.getSections()) {
			seatsCount=seatsCount + section.getAvailableSeats();
		}
		return seatsCount;
	}
	
	public Section canReserve(TicketRequest ticketRequest) {
		for(Section section : this.getSections()) {
			if(section.isSeatAvailable() && section.canReserve(ticketRequest)) {
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
