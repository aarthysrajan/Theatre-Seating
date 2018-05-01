package com.barclays.theatre.seating.process;

import static org.junit.Assert.*;
import org.junit.Test;
import com.barclays.theatre.seating.model.Row;
import com.barclays.theatre.seating.model.Section;
import com.barclays.theatre.seating.model.TicketRequest;
import com.barclays.theatre.seating.service.TheatreLayout;

public class RowAndSectionAlignmentTest {

	@Test
	public void testIsSeatAvailable() {
		Row row = new Row(0);
		Section section = new Section(0, 6, row);
		
		assert(section.isSeatAvailable());
	}
	
	@Test
	public void testCanReserve() {
		Row row = new Row(0);
		Section section = new Section(0, 80, row);
		
		TicketRequest ticketRequest = new TicketRequest("Smith", 65);
		
		assert(section.canReserve(ticketRequest));
	}
	
	@Test
	public void testReserve() {
		Row row = new Row(0);
		Section section = new Section(0, 80, row);
		
		TicketRequest ticketRequest = new TicketRequest("Smith", 100);
		
		assert(section.reserve(ticketRequest));
	}
	
	@Test
	public void testGetAvailableSeats() {
		Row row = new Row(0);
		
		row.addSection(new Section(0, 6, row));
		row.addSection(new Section(1, 8, row));
		
		assertEquals(row.getAvailableSeats(), 14);
	}
		
	@Test
	public void testAddRow() {
		TheatreLayout theatreLayout = new TheatreLayout();
		
		Row row = new Row(0);
		
		row.addSection(new Section(0, 6, row));
		row.addSection(new Section(1, 6, row));
		
		theatreLayout.addRow(row);
		
		Row row2 = new Row(0);
		
		row2.addSection(new Section(0, 3, row));
		row2.addSection(new Section(1, 5, row));
		row2.addSection(new Section(2, 5, row));
		row2.addSection(new Section(3, 3, row));
		
		theatreLayout.addRow(row2);
		
		assert(true);
	}

	@Test
	public void testAddSection() {
		Row row = new Row(0);
		Section section = new Section(0, 6, row);
		
		assert(section.isSeatAvailable());
	}
}