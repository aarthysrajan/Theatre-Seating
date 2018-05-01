package com.barclays.theatre.seating.process;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import com.barclays.theatre.seating.model.TicketRequest;
import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.service.TicketRequestBuilder;

public class TicketRequestBuilderTest {

	@Test
	public void testBuildTicketRequest() {
		List<TicketRequest> ticketRequest;
		try {
			ticketRequest = TicketRequestBuilder.buildTicketRequest("Smith 2\nJones 5\nDavis 6\nWilson 100\nJohnson 3\nWIlliams 4\nBrown 8\nMiller 12");
			assertEquals(ticketRequest.get(0).getNumberOfTickets(), 2);
		} catch (SeatingException e) {
			e.printStackTrace();
			assert(false);
		}
	}
}
