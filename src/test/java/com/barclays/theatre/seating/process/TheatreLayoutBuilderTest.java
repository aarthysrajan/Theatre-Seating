package com.barclays.theatre.seating.process;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import com.barclays.theatre.seating.service.TheatreLayout;
import com.barclays.theatre.seating.service.TheatreLayoutBuilder;

public class TheatreLayoutBuilderTest {

	private final static Logger logger = Logger.getLogger(TheatreLayoutBuilderTest.class.getName());
	
	@Test
	public void testBuildTheatreLayout() {
		try {
			TheatreLayout theatreLayout = TheatreLayoutBuilder.buildTheatreLayout("6 6\n3 5 5 3\n4 6 6 4\n2 8 8 2\n6 6");
			assertEquals(theatreLayout.getRows().get(0).getAvailableSeats(), 12);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			assert(false);
		}
	}
}
