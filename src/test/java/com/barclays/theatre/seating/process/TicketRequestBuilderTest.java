package com.barclays.theatre.seating.process;

import static org.junit.Assert.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import com.barclays.theatre.seating.model.TicketRequest;
import com.barclays.theatre.seating.service.TicketRequestBuilder;

public class TicketRequestBuilderTest {

	private final static Logger logger = Logger.getLogger(TicketRequestBuilderTest.class.getName());
	
	@Test
	public void testBuildTicketRequest() {
		List<TicketRequest> ticketRequest;
		try {
			ticketRequest = TicketRequestBuilder.buildTicketRequest("Smith 2\nJones 5\nDavis 6\nWilson 100\nJohnson 3\nWIlliams 4\nBrown 8\nMiller 12");
			assertEquals(ticketRequest.get(0).getNumberOfTickets(), 2);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			assert(false);
		}
	}
}
