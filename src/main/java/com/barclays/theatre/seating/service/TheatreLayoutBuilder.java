/**
 * 
 */
package com.barclays.theatre.seating.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Row;
import com.barclays.theatre.seating.model.Section;

/**
 * @author Aarthy Rajan
 *
 */
public class TheatreLayoutBuilder {

	private final static Logger logger = Logger.getLogger(TheatreDriver.class.getName());

	public static TheatreLayout buildTheatreLayout(String layoutText) throws SeatingException {
		// TODO: Validation at each level
		String[] lines = layoutText.split("\n");
		TheatreLayout layout = new TheatreLayout();

		int rowNumber = 1;
		for (String line : lines) {
			String[] sectionTexts = line.split(" ");
			int sectionNumber = 1;
			Row row = new Row(rowNumber);
			for (String sectionText : sectionTexts) {
				int sectionCapacity;
				try {
					sectionCapacity = Integer.parseInt(sectionText.trim());
				} catch (NumberFormatException e) {
					SeatingException seatingException = new SeatingException("Invalid entry for section capacity in "
							+ "theatre layout. Seat capacity must be a number but found " + sectionText, e);
					logger.log(Level.SEVERE, seatingException.getMessage());
					throw (seatingException);
				}
				Section section = new Section(sectionNumber, sectionCapacity, row);
				row.addSection(section);
				sectionNumber++;
			}
			layout.addRow(row);
			rowNumber++;
		}
		return layout;
	}
}