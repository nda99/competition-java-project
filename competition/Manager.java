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
	
	private ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	private String inputFile;
	private CompetitorList list = null;
	/**
	 * Constructor for a a Manager object related to a specific file.
	 * @param inputFile String variable holding the path of the desired input file.
	 */
	public Manager(String inputFile) {
		this.inputFile = inputFile;
	}
	
	/** Method to read file and return a competitor list.
	 * @see getFile method reads input file
	 * @see Manager
	 *
	 * @return competitor list which was read from file.
	 */
	public boolean getFile()
	  { 
	  File file = new File(inputFile); 
	  boolean filefail = false;

	try {
		Scanner scanner = new Scanner(file);

	  
	  Name name = new Name("");
	  String level = "", dish = "";
	  int CN;
	  int [] score = new int[5];
	  CN=999;

	  while(scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  String[] details = line.split(",");
		  for(int i=0; i <details.length;i++) { 
			  // Check if input has blank/null fields
			  if (details[i].length()==0 || details[i] ==" ") {
				  System.err.println("ERROR: There are blank fields in the input file. Please correct your input file or select a valid one:");
				  filefail = true;
			  }
			  // Check if scores are 0, 1, 2, 4 or 5.
			  if (i >= 4 && details[i].equals("0")==false && details[i].equals("1")==false && details[i].equals("2")==false && details[i].equals("3")==false && details[i].equals("4")==false && details[i].equals("5")==false ) {
				  System.err.println("ERROR: Scores are incorrect. Please correct your input file with scores from 0 to 5:\n");
				  filefail = true;
				  break;
			  }
			  
		  }
		  
		  // Check if levels are correct		  
		  if (details[2].equals("Amateur")==false && details[2].equals("Cook")==false && details[2].equals("Chef")==false && details[2].equals("MasterChef")==false) {
			  System.err.println("ERROR: Levels are incorrect.\nPlease correct your input file with correct levels"
			  		+ " (Amateur, Cook, Chef or MasterChef):\n");
			  filefail = true;
			  break;
		  }
		  //check for missing fields
		  if (details.length < 9) {
			  System.err.println("ERROR: There are missing fields in the input file. Please correct your input file or enter a valid one:");
			  filefail=true;
		  }
		  // check for extra fields
		  if (details.length > 9) {
			  System.err.println("ERROR: There are extra fields in the input file. Please correct your input file or enter a valid one:");
			  filefail=true;
		  }
		  
		  if (filefail) break; // exit loop before crash occurs.
		  
		  CN = Integer.parseInt(details[0]);
		  name = new Name(details[1]);
		  level = details[2];
		  dish = details[3];
		  
		  for (int i = 4; i < 9; i++) {
			  score[i-4] = Integer.parseInt(details[i]);
		  }
		  
		  competitors.add( new HaggisChef(CN, name, score, level, dish)); 
		  
	  }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		System.err.println(String.format("File '%s' not found, please enter valid file:", file));
		filefail = true;
	}
	  this.list = new CompetitorList(competitors);
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
	public boolean printFile(String outputFile) throws IOException {
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
	
	
	public CompetitorList getList() {
		return list;
	}
	
	
}
