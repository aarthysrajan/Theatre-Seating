/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 *         orders.txt.
 * 
 *         TODO: Reads the full contents of the files into memory - to scale
 *         this driver better use a buffered input stream
 *
 */
public class TheatreDriver {

	private final static Logger logger = Logger.getLogger(TheatreDriver.class.getName());

	/**
	 * @param args
	 * @throws SeatingException
	 */
	public static void main(String[] args)  {

		try {
			String layoutText = FileUtils.getContentFromClasspath("layout.txt", "UTF-8");
			String orderText = FileUtils.getContentFromClasspath("orders.txt", "UTF-8");

			logger.info("Building theatre layout from layout file: " + layoutText);
			TheatreLayout layout = TheatreLayoutBuilder.buildTheatreLayout(layoutText);
			logger.info("Building ticket request from order file: " + orderText);
			List<TicketRequest> ticketRequest = TicketRequestBuilder.buildTicketRequest(orderText);

			Theatre theatre = new Theatre(layout);
			List<Reservation> reservationResults = theatre.reserve(ticketRequest);

			printReservationResult(reservationResults);
		} catch (SeatingException e) {
			logger.log(Level.SEVERE, "Seating exception occured. Deatils: " + e.getMessage(), e);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Unknown exception occured. Deatils: " + e.getMessage());
		}
	}

	public static void printReservationResult(List<Reservation> reservationResults) {
		for (Reservation reservation : reservationResults) {
			String output = null;
			switch (reservation.getState()) {
			case RESERVED:
				output = String.format("%s Row %s Section %s", new Object[] { reservation.getTicketRequest().getName(),
						reservation.getRow().getRowNumber(), reservation.getSection().getSectionNumber() });
				break;
			case SPLIT:
				output = String.format("%s Call to split party.",
						new Object[] { reservation.getTicketRequest().getName() });
				break;
			case NO_CAPACITY:
				output = String.format("%s Sorry, we can't handleyour party.",
						new Object[] { reservation.getTicketRequest().getName() });
				break;
			default:
				break;
			}

			if (null != output) {
				System.out.println(output);
			}
		}
	}
}