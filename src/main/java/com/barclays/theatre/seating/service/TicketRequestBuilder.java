package com.barclays.theatre.seating.service;

import java.util.LinkedList;
import java.util.List;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.TicketRequest;

/***
 * 
 * @author Aarthy Rajan
 *
 */
public class TicketRequestBuilder {
	public static List<TicketRequest> buildTicketRequest(String ticketRequestText) throws SeatingException {
		//TODO: Validate at each level
		String[] lines = ticketRequestText.split("\n");
		List<TicketRequest> ticketRequests = new LinkedList<TicketRequest>();
		for (String line : lines) {
			String[] sectionTexts = line.split(" ");
			if(sectionTexts.length!=2) {
				throw(new SeatingException("Invalid format for ticket request - please check the format for line " + line));
			}
			
			String name = sectionTexts[0];
			int numberOfTickets;
			try {
				numberOfTickets = Integer.parseInt(sectionTexts[1]);
			} catch (NumberFormatException numFormExc) {
				throw (new SeatingException(
						"Invalid entry for number of tickets requested. Tickets requested must be a number but found "
								+ sectionTexts[1],
								numFormExc));
			}
			TicketRequest request = new TicketRequest(name, numberOfTickets);
			ticketRequests.add(request);
		}
		return ticketRequests;
	}
}