/**
 * 
 */
package com.barclays.theatre.seating.utils;

import java.util.Scanner;

/**
 * @author Aarthy Rajan
 *
 */
public class FileUtils {
	
	/***
	 * For use with small files only
	 * 
	 * @param path
	 * @return
	 */
	public static String getContentFromClasspath(String path, String encoding) {
		String text = new Scanner(FileUtils.class.getClassLoader().getResourceAsStream(path), encoding).useDelimiter("\\A").next();
		return text;
	}
}
