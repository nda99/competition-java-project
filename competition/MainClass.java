package competition;

import java.io.IOException;
import java.util.Scanner;

//import javax.swing.*;

/**
 * Main class for Competition application
 * @author Nathan
 * @version 1.0
 *
 */
public class MainClass {
	
	private static String fileIn = null;
	
	private static String fileOut = null;
	
	private static FileIO_GUI gui = null;
	
	public static String getFileIn() {
		return fileIn;
	}
	
	public static String getFileOut() {
		return fileOut;
	}
	
	public static FileIO_GUI getFileGUI() {
		return gui;
	}
		
	public static void setFileIn(String fileName) {
		fileIn = fileName;
	}
	
	public static void setFileOut(String fileName) {
		fileOut = fileName;
	}
	
	public static void main(String[] args) throws IOException {
		
		// Console (display short details for users' choice) :
		//@SuppressWarnings("resource");
		
		WelcomeGUI welcome = new WelcomeGUI();
		//welcome.displayWelcome();
		
		gui = new FileIO_GUI();
		
		Scanner input =new Scanner(System.in);
		int CN;
		boolean failpath = true;
		String output;
		Competitor userChoice = null;
		System.out.print("---------------------------------------\nWelcome to the Haggis Competition application!\n");
		//System.out.print("\nPlease type name of input file:\n");
		//MainClass.fileIn = input.nextLine();
		welcome.displayWelcome();
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
		
		CompetitorList list = in.getList();
		
		CompetitionListGUI compList = new CompetitionListGUI(list);
		
		compList.setupGUI();
		
		
		
		gui.closeWindow("input");
		
		gui.getOutputFile();
		while (fileOut==null) {
			System.out.print("");
		}
		failpath = in.printFile(fileOut);
		
		while (failpath) {
			fileIn=null;
			while (fileIn==null) {
				System.out.print("");
			}
		}

		//"D:\\Eclipse\\toto.txt"
		gui.closeWindow("output");
		
		System.out.print(fileIn + "\n");
		
		
		while(userChoice == null) { //loops until valid CN is provided
		
		System.out.print("Enter competitor number for short details: ");
		CN = input.nextInt();
		
		userChoice = list.getCompetitor(CN);
		
		if (userChoice !=null) {
		System.out.println(userChoice.getShortDetails());
		}
			
		}
		//ArrayList<HaggisChef> competitor= new Manager().getFile();
		
		//CompetitorList list = new CompetitorList(new Manager().getFile());
		
		
		
	}

}
