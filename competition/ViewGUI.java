package competition;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**@author alaat
 * **/

public class ViewGUI extends JFrame{
	
	private JFrame frame = new JFrame();
	private Competitor compt;
	private JPanel centerPanel=new JPanel();
	private JButton edit;
	private JButton view;
	private JTextArea fullDetails = new JTextArea(1,1);
	private JTextArea shortDetails = new  JTextArea(1,1);
	private  JScrollPane scrollList;
	private  JScrollPane scrollList2;



	public ViewGUI(Competitor c)
	{
		compt = c;	
	}
	


	
	public void setupGUI() {
	
		frame.setPreferredSize(new Dimension(900, 400));
		frame.setBackground(Color.WHITE);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setLocation(200, 200);
		frame.setTitle("View Details");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel title;
		title = new JLabel("Competitor Details",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		frame.add(title,BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);
		frame.add(setupCenterPanel(compt),BorderLayout.CENTER);
		
		
	}


	private JPanel setupCenterPanel(Competitor c) {

		centerPanel.setLayout(new GridLayout(2,1,0,0));
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18); 
		JLabel fullDetailsHDR = new JLabel("Full Details:",JLabel.LEFT);
		JLabel shortDetailsHDR = new JLabel("Short Details:",JLabel.LEFT);
		fullDetails.setText(c.getFullDetails());
		shortDetails.setText(c.getShortDetails());


		fullDetailsHDR.setFont(f);
		shortDetailsHDR.setFont(f);
		fullDetails.setFont(f);
		fullDetails.setEditable(false);
		shortDetails.setFont(f);
		shortDetails.setEditable(false);
		centerPanel.add(fullDetailsHDR);
		scrollList = new JScrollPane(fullDetails);
        centerPanel.add(scrollList,BorderLayout.CENTER);
	//	centerPanel.add(fullDetails);
		scrollList2 = new JScrollPane(shortDetails);

		centerPanel.add(shortDetailsHDR);
		

		centerPanel.add(scrollList2);
		
		
		return centerPanel;
	}


}
