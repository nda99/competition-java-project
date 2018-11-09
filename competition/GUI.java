package competition;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class GUI extends JFrame{
	JLabel n,s,e,w,c;
	
	public GUI()
	{
		JButton showListById, showListByName;
		JPanel northPanel = new JPanel();
		showListById = new JButton("List By ID");
		showListByName = new JButton("List By Name");
		northPanel.add (showListById);
		northPanel.add (showListByName);
		
		
	JFrame justAFrame = new JFrame();
	justAFrame.setSize(800,400);
	justAFrame.setLocation(200,200);
	justAFrame.setLayout(new BorderLayout(5,5));
	justAFrame.setTitle("File selector");
	justAFrame.setVisible(true);
	
	n = this.createOneLabel("Please enter the full path of your input file:", Color.WHITE);
	s = this.createOneLabel("Please enter the full path of your output file:", Color.YELLOW);
	justAFrame.add(n,BorderLayout.NORTH);
	justAFrame.add(s,BorderLayout.SOUTH);
	justAFrame.add(northPanel,BorderLayout.CENTER);

	
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
