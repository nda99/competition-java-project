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
	
	public WelcomeGUI()
	{
		
		
		//i just added this comment
	}

	public void displayWelcome() {

		JFrame welcomeFrame = new JFrame();
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
		welcomeFrame.setTitle("Welcome to the Competition App");
		welcomeFrame.add(welcome,BorderLayout.NORTH);
		welcomeFrame.add(centralPanel,BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
		
		chooseInput.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	MainClass.getFileGUI().getInputName();
	      }
	    });
	}
	
}
