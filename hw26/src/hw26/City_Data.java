package hw26;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class City_Data {
	  
	  public static void main(String[] args) {
	    System.out.println("Get city names from user and write them to a file ('end' to end):");
	    writeUserInputsToFile();
	    
	    System.out.println("\nRead city names from the file - output them to console and backup file:");
	    outputFileToConsoleAndNewFile();
	  }
	  
	  public static void writeUserInputsToFile() {
	    // Scanner to get console input
	    Scanner input = new Scanner(System.in);

	    // File object to define the file to write to
	    File dataFile = new File("data/city_database.txt");

	    // PrintWriter to write to the file
	    // Note that the PrintWriter might fail if the file doesn't exist
	    // therefore we have to place a try / catch block around it
	    try {
	      // create the PrintWriter - this will create the file for us 
	      // (or clobber it if it already exists)
	      PrintWriter myWriter = new PrintWriter(dataFile);

	      // Continually ask the user for city names
	      while (true) {
	        // get a city name
	        System.out.print("\tCity name: ");
	        String name = input.nextLine();

	        // if the user enters the sentinel value then we can end
	        if (name.equals("end")) {
	          input.close();
	          break;
	        }

	        // put this String into our file
	        myWriter.println(name);
	      }

	      myWriter.close();
	      System.out.println("All done reading user inputs!");
	    }

	    // If there's an exception (i.e. the file doesn't exist) we can
	    // handle it here
	    catch (FileNotFoundException e) {
	      System.out.println("Issue opening the file in question for writing!");
	    }
	  }
	  
	  public static void outputFileToConsoleAndNewFile() {
		  
		  try {
	      // File object to define the file to write to
	      File inFile = new File("data/city_database.txt");
	      File newFile  = new File("data/city_db_backup.txt");
	      PrintWriter output  = new PrintWriter(newFile);
	      
	      //TODO: Create Scanner to read from the file: inFile
	      Scanner read = new Scanner(inFile);
	      //TODO: Write data read from file to a backup file: newFile
	      int count = 1;
	      while(read.hasNext()){
	    	  
	    	  String city = read.next();
	    	  
	    	  output.println(count+" - "+city);
	    	  //TODO: Write the same data to the console
		      
	    	  System.out.println(count+" - "+city);
	    	  
	    	  count++;
	      }
		 }
		  catch(FileNotFoundException e){
			  System.out.println("Issue opening the file in question for writing!"); 
		  }
	    }
	}

