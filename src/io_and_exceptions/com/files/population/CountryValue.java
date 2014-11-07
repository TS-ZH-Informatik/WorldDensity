package io_and_exceptions.com.files.population;

import io_and_exceptions.com.files.exception.BadDataException;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CountryValue {
	
	private String country = "";
	private Integer value;
	
	/**
    Constructs a CountryValue from an input line.
    @param line a line containing a country name, followed by a value
 */
 public CountryValue(String line) throws NoSuchElementException, BadDataException
 {
	Scanner valueScanner = new Scanner(line);
	while(!valueScanner.hasNextInt() ){
		String tmpValue = valueScanner.next();
		if(!tmpValue.matches("[\\w\\s]+") || tmpValue.contentEquals(new StringBuffer("null")))
			throw new BadDataException("Invalid Format");
		else
			country += tmpValue;
			
	}
	// check value
	Integer tmpvalue = valueScanner.nextInt();
	if(!tmpvalue.toString().matches("(\\d+)"))
		throw new BadDataException("Invalid Number");
	else
		value = tmpvalue;
 }

 /**
    Gets the country name.
    @return the country name
 */
 public String getCountry() { return country; }

 /**
    Gets the associated value.
    @return the value associated with the country
 */
 public double getValue() { return value; }

}
