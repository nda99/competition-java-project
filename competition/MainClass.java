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
	
	static Manager in = null;
	
	private static String fileIn = null;
	
	private static String type = null;
	
	private static String fileOut = null;
	
	private static WelcomeGUI gui = null;
	
	static CompetitionListGUI compList =null;
	
	public static String getType() {
		return type;
	}
	
	public static void setType(String t) {
		type = t;
	}
	
	public static CompetitionListGUI setListGUI() {
		return compList;
	}
	
	public static CompetitionListGUI getListGUI() {
		return compList;
	}
	
	public static String getFileIn() {
		return fileIn;
	}
	
	public static String getFileOut() {
		return fileOut;
	}
	
	public static WelcomeGUI getFileGUI() {
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
		
		gui = new WelcomeGUI();
		
		Scanner input =new Scanner(System.in);
		int CN;
		boolean failpath = true;
		String output;
		Competitor userChoice = null;
		System.out.print("---------------------------------------\nWelcome to the Competition application!\n");

		welcome.displayWelcome();
		while (fileIn==null) {
			System.out.print("");
		}
		

		while (fileOut==null) {
			System.out.print("");
		}

		gui.closeWindow("output");
		
		System.out.print(fileIn + "\n");
		
		
		while(userChoice == null) { //loops until valid CN is provided
		
		System.out.print("Enter competitor number for short details: ");
		CN = input.nextInt();
		
		//userChoice = list.getCompetitor(CN);
		
		if (userChoice !=null) {
		System.out.println(userChoice.getShortDetails());
		}
			
		}
		
		
	}

}
