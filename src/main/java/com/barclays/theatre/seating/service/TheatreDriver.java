/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.List;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Reservation;
import com.barclays.theatre.seating.model.TicketRequest;
import com.barclays.theatre.seating.utils.FileUtils;

/**
 * @author Aarthy Rajan
 * 
 *         A driver class to take theatre layout and ticket request as input
 *         from user and output the seating results
 * 
 *         Requires two files as input in the classpath: layout.txt and
 *         preorder.txt.
 * 
 *         TODO: Reads the full contents of the files into memory - to scale
 *         this driver better use a buffered input stream
 *
 */
public class TheatreDriver {

	/**
	 * @param args
	 * @throws SeatingException
	 */
	public static void main(String[] args) throws SeatingException {

		String layoutText = FileUtils.getContentFromClasspath("layout.txt", "UTF-8");
		String orderText = FileUtils.getContentFromClasspath("orders.txt", "UTF-8");

		TheatreLayout layout = TheatreLayoutBuilder.buildTheatreLayout(layoutText);
		List<TicketRequest> ticketRequest = TicketRequestBuilder.buildTicketRequest(orderText);

		Theatre theatre = new Theatre(layout);
		List<Reservation> reservationResults = theatre.reserve(ticketRequest);

		printReservationResult(reservationResults);
	}

	public static void printReservationResult(List<Reservation> reservationResults) {
		for (Reservation reservation : reservationResults) {
			String output = null;
			switch (reservation.getState()) {
			case RESERVED:
				output = String.format("%s Row %s Section %s", new Object[] {
						reservation.getTicketRequest().getName(), reservation.getRow().getRowNumber(), reservation.getSection().getSectionNumber() });
				break;
			case SPLIT:
				output = String.format("%s Call to split party.", new Object[] {
						reservation.getTicketRequest().getName()});
				break;
			case NO_CAPACITY:
				output = String.format("%s Sorry, we can't handleyour party.", new Object[] {
						reservation.getTicketRequest().getName()});
				break;
			default:
				break;
			}
			
			if(null!=output) {
				System.out.println(output);
			}
		}
	}
}