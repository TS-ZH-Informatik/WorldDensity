package io_and_exceptions.com.files.population;

import io_and_exceptions.com.files.exception.BadDataException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PopulationDensity {
	
	public static void main(String[] args)
   {
		Scanner in1 = null;
		Scanner in2 = null;
		PrintWriter out = null;
		
	  try {
		  // Open input files
		  in1 = new Scanner(new File("/tmp/worldpop.txt")); 
		  in2 = new Scanner(new File("/tmp/worldarea.txt"));
		  
		  // Open output file
		  out = new PrintWriter("/tmp/world_pop_density.txt"); 		  

	      // Read lines from each file
	      while (in1.hasNextLine() && in2.hasNextLine())
	      {
	    	 try{
	         CountryValue population = new CountryValue(in1.nextLine());
	         CountryValue area = new CountryValue(in2.nextLine());
	         
	         // Compute and print the population density
	         double density = 0;
	         if (area.getValue() != 0) // Protect against division by zero
	         {
	            density = population.getValue() / area.getValue();
	         }
	         out.printf("%-40s%15.2f\n", population.getCountry(), density);
	    	 } catch(NoSuchElementException e){
	    		 System.out.println(e.getMessage());
	    	 }
	    	 catch (BadDataException e){
	    		 System.out.println(e.getMessage());
	    	 }
	      }
	  } catch(FileNotFoundException e){
		  System.out.println(e.getMessage());
	  }
	  finally{
		  in1.close();
		  in2.close();
		  out.close();		  
	  }
   }
}
