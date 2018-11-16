package competition;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FileIO_GUI extends JFrame{
	JLabel n,s,e,w,c;
	JFrame inputWindow = new JFrame();
	JFrame outputWindow = new JFrame();
	
	public FileIO_GUI()
	{
		
		//i just added this comment
	}
	
	/**
	 * Method to generate a window for the user to enter the input file name
	 */
	public void getInputName() {
		JButton openFile, browseFile;
		JPanel northPanel = new JPanel();
		openFile = new JButton("Open file");
		browseFile = new JButton("Browse...");
		northPanel.add (openFile);
		northPanel.add (browseFile);
		
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

	
	n = this.createOneLabel("Please enter the full path of your input file:", Color.WHITE);
	s = this.createOneLabel("Please enter the full path of your output file:", Color.YELLOW);
	inputWindow.add(n,BorderLayout.NORTH);

	inputWindow.add(northPanel,BorderLayout.SOUTH);
	inputWindow.add(southPanel,BorderLayout.CENTER);


		String searchString = null;
		
			openFile.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    	
	    	String searchString = searchField.getText();
	    	System.out.println(searchString);
	    	MainClass.setFileIn(searchString);
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
	        MainClass.setFileIn("" + chooser.getSelectedFile());
	    } else {
	        System.out.println("No Selection ");
	    }
	}});


	
	System.out.println("Thank you for your input");
	
	
	
	
	//southPanel.add(searchField);

	
	
	//String searchString = searchField.getText();
	

	
	}
	
	
	private JLabel createOneLabel (String s, Color c) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;
		}
	
	/**
	 * Method to show error message window given a String input.
	 */
	public void displayFileError(String error) {
		
		JOptionPane.showMessageDialog(inputWindow,
			    error,
			    "I/O Error :(",
			    JOptionPane.ERROR_MESSAGE);
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

		
		n = this.createOneLabel("Please enter the full path of your input file:", Color.WHITE);
		s = this.createOneLabel("Please enter the full path of your output file:", Color.YELLOW);
		outputWindow.add(s,BorderLayout.NORTH);

		outputWindow.add(northPanel,BorderLayout.SOUTH);
		outputWindow.add(southPanel,BorderLayout.CENTER);


			String searchString = null;
			
				openFile.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String searchString = searchField.getText();
		    	System.out.println(searchString);
		    	MainClass.setFileIn(searchString);
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
		        MainClass.setFileOut("" + chooser.getSelectedFile());
		    } else {
		        System.out.println("No Selection ");
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
