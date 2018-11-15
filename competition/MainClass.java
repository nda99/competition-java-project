package competition;

import java.io.IOException;
import java.util.Scanner;

//import javax.swing.*;

/**
 * Main class for Haggis Chef competition application
 * @author Nathan
 * @version 1.0
 * @see ndaAssignment1.HaggisChef
 * @see ndaAssignment1.Manager
 *
 */
public class MainClass {
	
	private static String fileIn = null;
	
	private static FileIO_GUI gui = null;
	
	public static String getFileIn() {
		return fileIn;
	}
	
	public static FileIO_GUI getFileGUI() {
		return gui;
	}
		
	public static void setFileIn(String fileName) {
		fileIn = fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		// Console (display short details for users' choice) :
		//@SuppressWarnings("resource");
		
		gui = new FileIO_GUI();
		
		Scanner input =new Scanner(System.in);
		int CN;
		boolean failpath = true;
		String output;
		Competitor userChoice = null;
		System.out.print("---------------------------------------\nWelcome to the Haggis Competition application!\n");
		//System.out.print("\nPlease type name of input file:\n");
		//MainClass.fileIn = input.nextLine();
		gui.getInputName();
		while (fileIn==null) {
			System.out.print("");
		}
		System.out.print(".");
		Manager in = new Manager(fileIn);
		
		while(in.getFile()) {
			//gui.displayFileError();
			fileIn=null;
			while (fileIn==null) {
				System.out.print("");
			}
			
			System.out.print(".");
			//"D:\\Eclipse\\toto.txt"
			in = new Manager(fileIn);
		}; 
		
		while (failpath) {
			System.out.print("Please type name of output file:\n");

			output = input.nextLine();
			failpath = in.printFile(output);
		}

		//"D:\\Eclipse\\toto.txt"

		

		System.out.print(fileIn + "\n");
		
		while (failpath) {
			System.out.print("Please type name of output file:\n");
			output = input.nextLine();
			failpath = in.printFile(output);
		}

		
		while(userChoice == null) { //loops until valid CN is provided
		
		System.out.print("Enter competitor number for short details: ");
		CN = input.nextInt();
		
		CompetitorList list = in.getList();
		userChoice = list.getCompetitor(CN);
		
		if (userChoice !=null) {
		System.out.println(userChoice.getShortDetails());
		}
			
		}
		//ArrayList<HaggisChef> competitor= new Manager().getFile();
		
		//CompetitorList list = new CompetitorList(new Manager().getFile());
		
		
		
	}

}
