package competition;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.InputMismatchException;



/**
 * Class for displaying welcoming window GUI.
 * @author Nathan
 *
 */
public class WelcomeGUI extends JFrame{
	
	JFrame welcomeFrame = new JFrame();
	JPanel stat = new JPanel();
	JLabel n,s,e,w,c;

	JLabel file = createOneLabel("File selected: NONE",Color.WHITE,18);
	JLabel type = createOneLabel("Type selected: NONE",Color.WHITE,18);
	JFrame inputWindow = new JFrame();
	JFrame outputWindow = new JFrame();
	
	public WelcomeGUI()
	{
		
		
		//i just added this comment
	}

	public void displayWelcome() {

	    JMenuBar menuBar = new JMenuBar();
	    JMenuItem haggis, hockey, baseball, dart;

	    // Menu
	    JMenu compTypes = new JMenu("Select Competition Type");
        welcomeFrame = new JFrame();
	    // Menu Item (Drop down menus)
	    haggis = new JMenuItem("Haggis");
	    hockey = new JMenuItem("Hockey");
	    baseball = new JMenuItem("Baseball");
	    dart = new JMenuItem("Dart");

	    // Adding menu items to menu
	    compTypes.add(haggis);
	    compTypes.add(hockey);
	    compTypes.add(baseball);
	    compTypes.add(dart);
	    // adding menu to menu bar
	    menuBar.add(compTypes);
		
	    //Creating Search Field
	    JTextField searchCompetitor = new JTextField(10);
	    
	    
	    // Creating Panels
		JButton chooseInput, chooseOutput, seeDetails, confirmCN;
		JPanel titlePanel = new JPanel();
		JPanel centralPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		JPanel Panel = new JPanel();
		//JPanel bottomPanel = new JPanel();
		JLabel welcome1 = new JLabel();
		JLabel welcome2 = new JLabel();
		JLabel shortDetails = new JLabel();
		chooseInput = new JButton("Choose input file...");
		chooseOutput = new JButton("Save Report");
		seeDetails = new JButton("Competition Details");
		confirmCN = new JButton("Go");
		//centralPanel.setLayout(new BorderLayout(5,5));
		Panel.setLayout(new GridLayout(3,1));
		
		southPanel.add(chooseInput);
		southPanel.add(chooseOutput);
		southPanel.add(seeDetails);
		southPanel.setBackground(Color.WHITE);
		centralPanel.add(menuBar);
		centralPanel.setBackground(Color.WHITE);
		shortDetails = createOneLabel("Enter Competitor Number for short details:", Color.WHITE,12);
		searchPanel.add(shortDetails);
		searchPanel.add(searchCompetitor);
		searchPanel.add(confirmCN);
		searchPanel.setBackground(Color.WHITE);
		Panel.add(centralPanel);
		Panel.add(southPanel);
		Panel.add(searchPanel);
		Panel.setBackground(Color.WHITE);
		//centralPanel.add(compTypes);
		//welcomeFrame.add
		
		welcome1 = createOneLabel("Welcome to the Competition Manager Applet", Color.WHITE,18);
		welcome2 = createOneLabel("Please select an option:", Color.WHITE,18);
		titlePanel.setLayout(new GridLayout(2,1));
		titlePanel.add(welcome1);
		titlePanel.add(welcome2);
		
		// Adding Panels to main frame
		welcomeFrame.setSize(800,300);
		welcomeFrame.setLocation(300,300);
		welcomeFrame.setBackground(Color.WHITE);
		welcomeFrame.setLayout(new BorderLayout(0,0));
		welcomeFrame.setTitle("Competition App Group 9");
		welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		welcomeFrame.add(titlePanel,BorderLayout.NORTH);
		welcomeFrame.add(Panel,BorderLayout.CENTER);
		stat.setLayout(new GridLayout(2,1));
		stat.add(file);
		stat.add(type);
		welcomeFrame.add(stat,BorderLayout.SOUTH);
		//welcomeFrame.add(menuBar,BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
		
		confirmCN.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (Manager.getFileIn()==null) {
		    		displayFileError("The database is empty.\nPlease open a competition file before searching for a competitor.");
		    	}
		    	else {
		    	try {
		    		int CN = Integer.parseInt(searchCompetitor.getText());
		    		Competitor c = Manager.getList().getCompetitor(CN);
		    		if (c==null){
		    			displayFileError("Sorry, but the competitor number you provided does not match anyone.\nPlease try entering another number.");	
		    		}
		    		else {
		    		displayDialog(c.getShortDetails());
		    		}
		    		
		    	}
		    	catch(NumberFormatException i){
		    		displayFileError("You must input an integer as Competitor Number!");
		    	}
		    	}
		      }
		    });
		
		// Drop down menu listeners
		
		baseball.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
	    		welcomeFrame.dispose();
		    	Manager.setType("Baseball");
		    	buildInfoPanel(welcomeFrame);
		    	//welcomeFrame.setVisible(false); 
		      }
		    });
		
		dart.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
	    		welcomeFrame.dispose();
		    	Manager.setType("Dart");
		    	buildInfoPanel(welcomeFrame);
		      }
		    });
		
		
		hockey.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
	    		welcomeFrame.dispose();
		    	Manager.setType("Hockey");
		    	buildInfoPanel(welcomeFrame);
		      }
		    });
		
		haggis.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
	    		welcomeFrame.dispose();
		    	Manager.setType("Haggis");
		    	buildInfoPanel(welcomeFrame);
		    	//welcomeFrame.setVisible(false); 
		      }
		    });
		
		// Choose input file listener
		
		chooseInput.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	if (Manager.getType()==null) {

	    		displayFileError("ERROR: You can't open a file without chosing the competition type!\nPlease chose a competition type using the drop-down menu.");
	    	}
	    	else {
    		welcomeFrame.dispose();
	    	Manager.getFileGUI().getInputName();
	    	}
	    	//welcomeFrame.setVisible(false); 
	      }
	    });
		
		// Choose output file listener
		chooseOutput.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (Manager.getFileIn()==null) {

		    		displayFileError("ERROR: You can't save a file before chosing the input!\nPlease open a file by clicking on 'Choose a File'.");
		    	}
		    	else {
		    		Manager.getFileGUI().getOutputFile();
		    	}
		      }
		    });
		
		// See short details listener
		seeDetails.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (Manager.getFileIn()==null) {
		    		displayFileError("ERROR: You can't display details without chosing a file!\nPlease open a file by clicking on 'Choose a File'.");
		    	}
		    	else {
		    	Manager.getListGUI().setupGUI();
		    	}
		      }
		    });
	}
	
	
	public void displayDialog(String message) {
		
		JOptionPane.showMessageDialog(welcomeFrame,
			    message,
			    "Dialog",
			    JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Method to show error message window given a String input.
	 */
	public void displayFileError(String error) {
		
		JOptionPane.showMessageDialog(welcomeFrame,
			    error,
			    "ERROR :(",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	public void buildInfoPanel(JFrame frame) {
        file.removeAll();
        type.removeAll();
		
		if (Manager.getFileIn()==null) {
			file = createOneLabel("File selected: NONE",Color.WHITE,18);
		}
		else {
			file = createOneLabel(String.format("File selected: %s",Manager.getFileIn()),Color.WHITE,18);
		}

		if (Manager.getType()==null) {
			type = createOneLabel("Type selected: NONE",Color.WHITE,18);
		}
		else {
			type = createOneLabel(String.format("Type selected: %s",Manager.getType()),Color.WHITE,18);
		}
		stat.removeAll();
		//stat.setLayout(new GridLayout(2,1));
        //stat.add(file);
        //stat.add(type);
        
        displayWelcome();

		
		
		//frame.setVisible(true); 
	}
	
	static JLabel createOneLabel (String s, Color c, int size) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, size);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;
		}
	
	
	/**
	 * Method to show default error message window if no String is provided.
	 */
	public void displayFileError() {
		
		JOptionPane.showMessageDialog(inputWindow,
			    "Oops! Something went wrong with your file, please try again.",
			    "I/O Error :(",
			    JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Method to generate a window for the user to enter the input file name
	 */
	public void getInputName() {
		JButton openFile, browseFile, goBack;
		JPanel northPanel = new JPanel();
		openFile = new JButton("Open file");
		browseFile = new JButton("Browse...");
		goBack = new JButton("Go Back");
		northPanel.add (openFile);
		northPanel.add (browseFile);
		northPanel.add(goBack);
		inputWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel southPanel = new JPanel();
		//southPanel.setLayout(new GridLayout(2,1));
		JTextField searchField = new JTextField(20);
		southPanel.add(searchField);
		
	//JFrame inputWindow = new JFrame();
	this.inputWindow.setSize(400,200);
	inputWindow.setLocation(200,200);
	inputWindow.setLayout(new BorderLayout(0,0));
	inputWindow.setTitle("File selector");
	inputWindow.setVisible(true);
	
	//String speed = JOptionPane.showInputDialog(null, "Speed in miles per hour?");

	
	n = WelcomeGUI.createOneLabel("Please enter the full path of your input file:", Color.WHITE,18);
	s = WelcomeGUI.createOneLabel("Please enter the full path of your output file:", Color.YELLOW,18);
	inputWindow.add(n,BorderLayout.NORTH);

	inputWindow.add(northPanel,BorderLayout.SOUTH);
	inputWindow.add(southPanel,BorderLayout.CENTER);


		openFile.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String searchString = searchField.getText();
		    	
		    	//Manager in = new Manager(searchString);
				Manager.setFileIn(searchString);
				if(Manager.getFile()==false) {

		    	
		    	System.out.println(searchString);
		        Manager.setFileIn(searchString);
		    	//MainClass.in = in;
				CompetitorList list = Manager.getList();
				
				Manager.compList = new CompetitionListGUI(list);
				inputWindow.dispose();
				displayDialog("The file " + searchString + " has been loaded successfully" );
				buildInfoPanel(welcomeFrame);
				
		    	//System.exit(0);
				}
		      }
		    });



	
	browseFile.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose an input file to process:");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	        System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	        
	        
	        Manager.setFileIn(chooser.getSelectedFile().toString());
	        if(Manager.getFile()==false) {   
	        	Manager.setFileIn(chooser.getSelectedFile().toString());
	        	//MainClass.in = in;
				CompetitorList list = Manager.getList();				
				Manager.compList = new CompetitionListGUI(list);
				displayDialog("The file '" + chooser.getSelectedFile() + "' has been loaded successfully" );

				inputWindow.dispose();
				buildInfoPanel(welcomeFrame);

	        }
	    } else {
	        System.out.println("No Selection ");
	    }
	}});
	
	goBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
			inputWindow.dispose();
			buildInfoPanel(welcomeFrame);
	      }
	    });
	
	}
	
	public void getOutputFile() {
		JButton openFile, browseFile;
		JPanel northPanel = new JPanel();
		openFile = new JButton("Open file");
		browseFile = new JButton("Browse...");
		northPanel.add (openFile);
		northPanel.add (browseFile);
		
		
		JPanel southPanel = new JPanel();
		//southPanel.setLayout(new GridLayout(2,1));
		JTextField searchField = new JTextField(20);
		southPanel.add(searchField);
		
	//JFrame inputWindow = new JFrame();
	this.outputWindow.setSize(400,200);
	outputWindow.setLocation(200,200);
	outputWindow.setLayout(new BorderLayout(0,0));
	outputWindow.setTitle("File selector");
	outputWindow.setVisible(true);
	//String speed = JOptionPane.showInputDialog(null, "Speed in miles per hour?");

	
	n = WelcomeGUI.createOneLabel("Please enter the full path of your input file:", Color.WHITE,18);
	s = WelcomeGUI.createOneLabel("Please enter the full path of your output file:", Color.YELLOW,18);
	outputWindow.add(s,BorderLayout.NORTH);

	outputWindow.add(northPanel,BorderLayout.SOUTH);
	outputWindow.add(southPanel,BorderLayout.CENTER);

		
			openFile.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	boolean failpath = false;
	    	String searchString = searchField.getText();		    	
	    	System.out.println(searchString);

	    	//Manager manager = MainClass.in;
	    	
	    	try {
				failpath = Manager.printFile(searchString);
				
		    	if (failpath==false) Manager.setFileOut(searchString);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	//System.exit(0);
	      }
	    });



	
	browseFile.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
		
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Choose an input file to process:");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	        System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	        Manager.setFileOut("" + chooser.getSelectedFile());
	        try {
				Manager.printFile(Manager.getFileOut());
				displayDialog(String.format("Report %s saved successfully!", chooser.getSelectedFile()));
				outputWindow.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	    } else {
	        displayDialog("No Selection");
	    }
	}});
}

public void closeWindow(String window){
	
	if (window.equals("input")){
		inputWindow.dispose();
	}
	
	if (window.equals("output")){
		outputWindow.dispose();
	}
}


}
