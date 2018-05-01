package com.barclays.theatre.seating.process;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TheatreDriverTest.class, TheatreLayoutBuilderTest.class, TheatreLayoutTest.class,
		TicketRequestBuilderTest.class })
public class TheatreSeatingTest {

}
