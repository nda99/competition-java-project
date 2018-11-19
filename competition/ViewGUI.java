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

	public ViewGUI(Competitor c)
	{
		compt = c;
		this.setLayout(new BorderLayout(100,100));
		this.setSize(400,500);
		JLabel title;
		title = new JLabel("Competitor Details",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		this.add(title);
		this.pack();
		this.setVisible(true);
		
		
		
	}
	
	private JLabel createOneLabel (String s, Color c) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;
	}

	
	public void setupGUI() {
		/*frame
		frame.setLocation(100,100);
		frame.setTitle("Competition App");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(10,10));
			
		JLabel title;
		title = new JLabel("Competition List",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		
	
		//frame.add(button,BorderLayout.WEST);
//		frame.add(button1, BorderLayout.EAST);
		frame.add(title, BorderLayout.NORTH);
//		frame.add(button3, BorderLayout.SOUTH);
		frame.add(setupCenterPanel(compt), BorderLayout.CENTER);
		frame.setSize(500,500);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);*/
		
		//c = createOneLabel("Middle", Color.YELLOW);
		centerPanel.setPreferredSize(new Dimension(200, 100));
		this.add(setupCenterPanel(compt),BorderLayout.CENTER);
		
		
	}


	private JPanel setupCenterPanel(Competitor c) {

		centerPanel.setLayout(new GridLayout(2,1,0,0));
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18); 
		JLabel fullDetailsHDR = new JLabel("Full Details:",JLabel.LEFT);
		JLabel shortDetailsHDR = new JLabel("Short Details:",JLabel.LEFT);
		JLabel fullDetails = new JLabel(c.getFullDetails(),JLabel.CENTER);
		JLabel shortDetails = new JLabel(c.getShortDetails(),JLabel.CENTER);


		fullDetailsHDR.setFont(f);
		shortDetailsHDR.setFont(f);
		fullDetails.setFont(f);
		shortDetails.setFont(f);
	
		centerPanel.add(fullDetailsHDR);
		centerPanel.add(fullDetails);
		centerPanel.add(shortDetailsHDR);

		centerPanel.add(shortDetails);
		
		
		return centerPanel;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
