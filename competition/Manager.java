package competition;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * IO class to read competitors file and output report
 * @author Nathan
 * @version 1.0 15 Oct 2018
 * @see ndaAssignment1.HaggisChef
 * @see ndaAssignment1.MainClass
 * @see getFile method reads input file
 * @see printFile method to output files.
 */
public class Manager { 
	
	private static ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	private static String inputFile;
	private static CompetitorList list = null;
	
	private static String fileIn = null;
	
	private static String type = null;
	
	private static String fileOut = null;
	
	private static WelcomeGUI gui = null;
	
	static CompetitionListGUI compList =null;
	/**
	 * Constructor for a a Manager object related to a specific file.
	 * @param inputFile String variable holding the path of the desired input file.
	 */
	public Manager(String input) {
		inputFile = input;
	}
	
	public static void main(String[] args) throws IOException {

		setList();
		showGUI();
		
	}
	
	public static void setList() {

		  list = new CompetitorList(competitors);
	}
	
	public static String getType() {
		return type;
	}
	
	public static void setGui(WelcomeGUI g) {
		gui = g;
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
	
	
	/**
	 * Method to get the name of input file
	 * @return input file name
	 */
	public static String getInputName() {
		return inputFile;
	}
	
	
	public static void showGUI() {
		gui = new WelcomeGUI();
		gui.displayWelcome();
		setGui(gui);
		//while(fileOut == null) { //loops until valid CN is provided

			//}
	}
	
	/** Method to read file and return a competitor list.
	 * @see getFile method reads input file
	 * @see Manager
	 *
	 * @return competitor list which was read from file.
	 */
	public static boolean getFile()
	  { 
	  File file = new File(fileIn);
	  boolean filefail = false;

	try {
		Scanner scanner = new Scanner(file);

	  
	  Name name = new Name("");
	  String level = "", attribute = "";
	  int CN;
	  int [] score = new int[5];
	  CN=999;

	  while(scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  String[] details = line.split(",");
		  for(int i=0; i <details.length;i++) { 
			  // Check if input has blank/null fields
			  if (details[i].length()==0 || details[i] ==" ") {
				  getFileGUI().displayFileError("ERROR: There are blank fields in the input file.\nPlease correct your input file or select a valid one.");;
				  //System.err.println("ERROR: There are blank fields in the input file. Please correct your input file or select a valid one:");
				  filefail = true;
			  }
			  // Check if scores are 0, 1, 2, 4 or 5.
			  if (i >= 4 && details[i].equals("0")==false && details[i].equals("1")==false && details[i].equals("2")==false && details[i].equals("3")==false && details[i].equals("4")==false && details[i].equals("5")==false ) {
				  getFileGUI().displayFileError("ERROR: Scores are incorrect. Please correct your input file with scores from 0 to 5:\n");
				  filefail = true;
				  break;
			  }
			  
		  }
		  
		  // Check if levels are correct		  

		 /* if (details[2].equals("Amateur")==false && details[2].equals("Cook")==false && details[2].equals("Chef")==false && details[2].equals("MasterChef")==false) {
			  System.err.println("ERROR: Levels are incorrect.\nPlease correct your input file with correct levels"
=======
		  if (details[2].equals("Amateur")==false && details[2].equals("Cook")==false && details[2].equals("Chef")==false && details[2].equals("MasterChef")==false) {
			  MainClass.getFileGUI().displayFileError("ERROR: Levels are incorrect.\nPlease correct your input file with correct levels"
>>>>>>> d4bb43bdf18ffe07ac208e0caff129f6cb298bfa
			  		+ " (Amateur, Cook, Chef or MasterChef):\n");
			  filefail = true;
			  break;
		  }*/
		  //check for missing fields
		  if (details.length < 9) {
			  getFileGUI().displayFileError("ERROR: There are missing fields in the input file. Please correct your input file or enter a valid one:");
			  filefail=true;
		  }
		  // check for extra fields
		  if (details.length > 9) {
			  getFileGUI().displayFileError("ERROR: There are extra fields in the input file. Please correct your input file or enter a valid one:");
			  filefail=true;
		  }
		  
		  if (filefail) break; // exit loop before crash occurs.
		  
		  CN = Integer.parseInt(details[0]);
		  name = new Name(details[1]);
		  level = details[2];
		  attribute = details[3];
		  
		  for (int i = 4; i < 9; i++) {
			  score[i-4] = Integer.parseInt(details[i]);
		  }
		  //String[] A = inputFile.split("\\\\");
		  if (getType().equals("Haggis")) {
		  list.add( new HaggisChef(CN, name, score, level, attribute,type)); 
		  }
		  else if (getType().equals("Hockey")){
		  list.add( new HockeyCompetitor(CN, name, level, score, attribute,type));
		  }
		  
		  else if ((getType().equals("Dart"))){
			  list.add( new DartCompetitor(CN+200, name, level, score, CN-50,type));
		  }
		  
		  else {
			  list.add( new Baseballers(CN+300, name, level, score, attribute, CN-50,type));
		  }
	  }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		getFileGUI().displayFileError(String.format("File '%s' not found, please enter valid file:", file));
		filefail = true;
	}
	  return filefail;
	} 
	
	
	/**
	 * Method to output report, statistics and full details to a single .txt file (provided a competitor list and filename).
	 * @see printFile
	 * @see Manager
	 * @param outputFile String which stores the filename to save the output
	 * @throws IOException when output path is not valid
	 * @return false if there is no problem with output file path.
	 */
	public static boolean printFile(String outputFile) throws IOException {
		Competitor best;
		best = list.getBestCompetitor();
		FileWriter file = null;
		boolean failpath = false;		
		//System.out.println(best.getFullDetails());
		//System.out.println(best.getShortDetails());
		
		//System.out.println(list.getReport());
		
		try {
			
			file = new FileWriter(outputFile);
			
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			System.err.println(String.format("Error: Filepath '%s' is not valid, please select a valid filepath", outputFile));
			failpath = true;
			 getFileGUI().displayFileError(String.format("Error: Filepath '%s' is not valid, please select a valid filepath", outputFile));
		}
		
		try {
			file.write(best.getFullDetails());
			String rep =list.getReport();
			file.write(rep);
			
			file.write(list.getStats());			
			
			file.close();
		
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			/* Don't print anything
			 * @param file should be caught with IOException if error exists. No need for NullPointerException.
			 * 
			 */
		}
		
		return failpath;
	}
	
	
	public static CompetitorList getList() {
		return list;
	}
	
	
}
