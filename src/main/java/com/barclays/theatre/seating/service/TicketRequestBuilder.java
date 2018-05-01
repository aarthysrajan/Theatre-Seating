package com.barclays.theatre.seating.service;

import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.TicketRequest;

/***
 * 
 * Class responsible for building a {@link List} of {@link TicketRequest} objects from
 * a plain text input.
 * 
 * 
 * @author Aarthy Rajan
 *
 */
public class TicketRequestBuilder {

	private final static Logger logger = Logger.getLogger(TheatreDriver.class.getName());

	/***
	 * Converts a given input string of the below format into a {@link List} of {@link TicketRequest} objects.
	 * 
	 * Smith 2
	 * Jones 5
	 * Davis 6
	 * Wilson 100
	 * Johnson 3
	 * Williams 4
	 * Brown 8
	 * Miller 12
	 * 
	 * TODO: Can be improved to use {@link BufferedInputStream} instead of loading 
	 * the entire content in memory.
	 * 
	 * @param ticketRequestText
	 * @return list of {@link TicketRequest} objects
	 * @throws SeatingException if there are issues parsing the plain text
	 */
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
				numberOfTickets = Integer.parseInt(sectionTexts[1].trim());
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