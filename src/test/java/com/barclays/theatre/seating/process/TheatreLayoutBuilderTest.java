package com.barclays.theatre.seating.process;

import static org.junit.Assert.*;
import org.junit.Test;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.service.TheatreLayout;
import com.barclays.theatre.seating.service.TheatreLayoutBuilder;

public class TheatreLayoutBuilderTest {

	@Test
	public void testBuildTheatreLayout() {
		
		try {
			TheatreLayout theatreLayout = TheatreLayoutBuilder.buildTheatreLayout("6 6\n3 5 5 3\n4 6 6 4\n2 8 8 2\n6 6");
			assertEquals(theatreLayout.getRows().get(0).getAvailableSeats(), 12);
		} catch (SeatingException e) {
			e.printStackTrace();
			assert(false);
		}
	}
}
