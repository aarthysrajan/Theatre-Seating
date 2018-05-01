# Theatre-Seating
Theatre-Seating Solution

An object oriented solution for a seating algorithm / tool using Java. The design includes the builder and strategy design patterns.

# Build

Use maven to build the jar from source.

```
mvn clean install
```

# Usability

You can run this tool using the driver class(java com.barclays.theatre.seating.service.TheatreDriver)

Make sure your input text files are in the root of the class path. Sample files are provided in src/test/resources. So you can build the theatre-seating.jar as described above and then edit and place the two text files along with the jar and then use the following command to run the tool.

```
java -jar -cp . theatre-seating.jar
```

# Testing

You use maven test to run the test suite (regular build will also run the junit tests)

```
mvn clean test
```
#### Unit Tests

The following are the JUnit test cases and suite:

* TicketRequestBuilderTest can be run to test the ticket request functionality.

* TheatreLayoutBuilderTest can be run to test the theatre layout functionality.

* TheatreDriverTest can be run to cover main functionality of theatre seating.

* RowAndSectionAlignmentTest can be run to test teh adding of rows and sections functionality.

* The test suite (com.barclays.theatre.seating.process.TheatreSeatingTestSuite) can be run to cover all test cases




