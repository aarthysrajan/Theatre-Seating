package com.barclays.theatre.seating.service;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.TicketRequest;

/***
 * 
 * @author Aarthy Rajan
 *
 */
public class TicketRequestBuilder {

	private final static Logger logger = Logger.getLogger(TheatreDriver.class.getName());

	public static List<TicketRequest> buildTicketRequest(String ticketRequestText) throws SeatingException {
		// TODO: Validate at each level
		String[] lines = ticketRequestText.split("\n");
		List<TicketRequest> ticketRequests = new LinkedList<TicketRequest>();
		for (String line : lines) {
			String[] sectionTexts = line.split(" ");
			if (sectionTexts.length != 2) {
				SeatingException seatingException = new SeatingException(
						"Invalid format for ticket request - please check the format for line " + line);
				logger.log(Level.SEVERE, seatingException.getMessage());
				throw (seatingException);
			}

			String name = sectionTexts[0];
			int numberOfTickets;
			try {
				numberOfTickets = Integer.parseInt(sectionTexts[1]);
			} catch (NumberFormatException numFormExc) {
				SeatingException seatingException = new SeatingException(
						"Invalid entry for number of tickets requested. Tickets requested must be a number but found "
								+ sectionTexts[1],
						numFormExc);
				logger.log(Level.SEVERE, seatingException.getMessage());
				throw (seatingException);
			}
			TicketRequest request = new TicketRequest(name, numberOfTickets);
			ticketRequests.add(request);
		}
		return ticketRequests;
	}
}