/**
 * 
 */
package com.barclays.theatre.seating.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the Layout of the Theatre.
 * 
 * @author Aarthy Rajan
 *
 */
public class TheatreLayout {
	
	private final List<Row> rows;

	public TheatreLayout() {
		this.rows = new LinkedList<Row>();
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public void addRow(Row row) {
		this.rows.add(row);
	}
	
	/***
	 * Gets the total available seats
	 * @return
	 */
	public int getAvailableSeats() {
		int capacity=0;
		for(Row row: this.getRows()) {
			capacity= capacity + row.getAvailableSeats();
		}
		return capacity;
	}
}