/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.LinkedList;
import java.util.List;

import com.barclays.theatre.seating.model.Row;

/**
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
	
	public int getAvailableSeats() {
		int capacity=0;
		for(Row row: this.getRows()) {
			capacity= capacity + row.getAvailableSeats();
		}
		return capacity;
	}
}