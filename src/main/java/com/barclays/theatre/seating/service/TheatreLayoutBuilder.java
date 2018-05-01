/**
 * 
 */
package com.barclays.theatre.seating.service;

import com.barclays.theatre.seating.exceptions.SeatingException;
import com.barclays.theatre.seating.model.Row;
import com.barclays.theatre.seating.model.Section;

/**
 * @author Aarthy Rajan
 *
 */
public class TheatreLayoutBuilder {
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
					sectionCapacity = Integer.parseInt(sectionText);
				} catch (NumberFormatException e) {
					throw (new SeatingException(
							"Invalid entry for section capacity in theatre layout. Seat capacity must be a number but found "
									+ sectionText,
							e));
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