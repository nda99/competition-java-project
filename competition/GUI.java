package competition;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUI extends JFrame{
	JLabel n,s,e,w,c;
	
	public GUI()
	{
		
		//i just added this comment
	}
	
	public void getInputName() {
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
		
	JFrame justAFrame = new JFrame();
	justAFrame.setSize(400,200);
	justAFrame.setLocation(200,200);
	justAFrame.setLayout(new BorderLayout(0,0));
	justAFrame.setTitle("File selector");
	justAFrame.setVisible(true);
	
	//String speed = JOptionPane.showInputDialog(null, "Speed in miles per hour?");

	
	n = this.createOneLabel("Please enter the full path of your input file:", Color.WHITE);
	s = this.createOneLabel("Please enter the full path of your output file:", Color.YELLOW);
	justAFrame.add(n,BorderLayout.NORTH);

	justAFrame.add(northPanel,BorderLayout.SOUTH);
	justAFrame.add(southPanel,BorderLayout.CENTER);


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
}
