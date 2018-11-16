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
		
		chooseInput = new JButton("Choose input file");
		chooseOutput = new JButton("Save File");
		seeDetails = new JButton("Competition Details");
		
		centralPanel.add(chooseInput);
		centralPanel.add(chooseOutput);
		centralPanel.add(seeDetails);
		//welcomeFrame.add
		
		welcomeFrame.setSize(800,800);
		welcomeFrame.setLayout(new BorderLayout(0,0));
		welcomeFrame.setTitle("Welcome to the Competition App");
		welcomeFrame.add(centralPanel,BorderLayout.CENTER);
		welcomeFrame.setVisible(true);
	}
	
}
