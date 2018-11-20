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

public class ViewGUI extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	Competitor compt;
	JPanel centerPanel=new JPanel();
	 static JButton edit;
	 static JButton view;
	JLabel n, s,e,w,c;
	JTextArea fullDetails = new JTextArea(3,5);
	JTextArea shortDetails = new  JTextArea(3,5);
    JScrollPane scrollList;
    JScrollPane scrollList2;



	public ViewGUI(Competitor c)
	{
		compt = c;
		frame.setLayout(new BorderLayout(100,100));
		frame.setSize(800,900);
		frame.setLocation(100, 100);
		frame.setTitle("View Details");
		JLabel title;
		title = new JLabel("Competitor Details",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		frame.add(title);
		frame.pack();
		frame.setVisible(true);
		
		
		
	}
	
	/*private JLabel createOneLabel (String s, Color c) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;
	}*/

	
	public void setupGUI() {
	
		//centerPanel.setPreferredSize(new Dimension(200, 100));
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
