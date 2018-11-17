package competition;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



/**
 * Class for displaying welcoming window GUI.
 * @author Nathan
 *
 */
public class WelcomeGUI {
	
	JFrame welcomeFrame = new JFrame();
	
	public WelcomeGUI()
	{
		
		
		//i just added this comment
	}

	public void displayWelcome() {

		
		JButton chooseInput, chooseOutput, seeDetails;
		JPanel centralPanel = new JPanel();
		JLabel welcome = new JLabel();
		
		chooseInput = new JButton("Choose input file");
		chooseOutput = new JButton("Save File");
		seeDetails = new JButton("Competition Details");
		
		centralPanel.add(chooseInput);
		centralPanel.add(chooseOutput);
		centralPanel.add(seeDetails);
		//welcomeFrame.add
		
		
		
		welcome = FileIO_GUI.createOneLabel("Welcome to the Competition Manager Applet\n Please select an option:", Color.WHITE);
		
		
		welcomeFrame.setSize(800,600);
		welcomeFrame.setLayout(new BorderLayout(0,0));
		welcomeFrame.setTitle("Competition App Group 9");
		welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		welcomeFrame.add(welcome,BorderLayout.NORTH);
		welcomeFrame.add(centralPanel,BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
		
		chooseInput.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	MainClass.getFileGUI().getInputName();
	      }
	    });
		
		chooseOutput.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (MainClass.getFileIn()==null) {
		    		displayFileError("ERROR: You can't save a file before chosing the input!\nPlease open a file by clicking on 'Choose a File'.");
		    	}
		    	else {
		    		MainClass.getFileGUI().getOutputFile();
		    	}
		      }
		    });
		
		seeDetails.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (MainClass.getFileIn()==null) {
		    		displayFileError("ERROR: You can't display details without chosing a file!\nPlease open a file by clicking on 'Choose a File'.");
		    	}
		    	else {
		    	MainClass.getListGUI().setupGUI();
		    	}
		      }
		    });
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
	
	
}
