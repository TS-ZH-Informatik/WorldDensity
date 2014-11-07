package io_and_exceptions.com.files.Scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args){
		FileReader fr = null; 
		FileReader inputFile = null;
		PrintWriter outputFile = null;
		int counter = 1;
		try{
		fr = new FileReader("/var/log/authd.log");
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		
		Scanner scanner = new Scanner(fr);
		while (scanner.hasNextLine()){
			System.out.println(counter+": "+scanner.nextLine());
			counter++;
		}
		
		Scanner console = new Scanner(System.in);
		System.out.println("File in: ");
		String fileNameIn = console.next();
		System.out.println("File out: ");
		String fileNameOut = console.next();
		
		try{
			inputFile = new FileReader(fileNameIn);
			outputFile = new PrintWriter(fileNameOut);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		Scanner fileInputScanner = new Scanner(inputFile);
		int lineNumber = 1;
		while(fileInputScanner.hasNextLine()){
			outputFile.println(lineNumber+" "+fileInputScanner.nextLine());
			lineNumber++;
		}
	}

}
