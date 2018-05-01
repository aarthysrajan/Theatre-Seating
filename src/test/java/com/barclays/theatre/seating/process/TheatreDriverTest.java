package com.barclays.theatre.seating.process;

import java.util.List;
import org.junit.Test;
import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Reservation;
import com.barclays.theatre.seating.model.TicketRequest;
import com.barclays.theatre.seating.service.Theatre;
import com.barclays.theatre.seating.service.TheatreDriver;
import com.barclays.theatre.seating.service.TheatreLayout;
import com.barclays.theatre.seating.service.TheatreLayoutBuilder;
import com.barclays.theatre.seating.service.TicketRequestBuilder;
import com.barclays.theatre.seating.utils.FileUtils;

public class TheatreDriverTest {

	@Test
	public void testBuildTheatreLayout() {
		
		try {
			String layoutText = FileUtils.getContentFromClasspath("layout.txt", "UTF-8");
			String orderText = FileUtils.getContentFromClasspath("orders.txt", "UTF-8");

			TheatreLayout layout = TheatreLayoutBuilder.buildTheatreLayout(layoutText);
			List<TicketRequest> ticketRequest = TicketRequestBuilder.buildTicketRequest(orderText);

			Theatre theatre = new Theatre(layout);
			List<Reservation> reservationResults = theatre.reserve(ticketRequest);

			TheatreDriver.printReservationResult(reservationResults);
		} catch (SeatingException e) {
			e.printStackTrace();
			assert(false);
		}
	}
}
