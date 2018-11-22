package competition;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public abstract class DartBorderLayoutFrame extends JFrame
                        implements ActionListener
{
	JLabel n, s, e, w, c;
	
	//assumes a max list size of 9
	
		private static final int MAX_BUTTONS = 9;
		private static final int ROW_SIZE = 3;
		private CompetitorList allCompetitors;
		JButton buttons[] =new JButton[MAX_BUTTONS];

		public DartBorderLayoutFrame(CompetitorList c) {
			allCompetitors = c;
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLocation(300,200);
	        this.setSize(300,300);
			this.setLayout(new BorderLayout());
			
			JPanel gridP = this.createGridPanel(allCompetitors);
			this.add(gridP, BorderLayout.CENTER);	
		}
   
private void setupCenterPanel() { 
                         
	//Set up the area where the results will be displayed.
                           
	JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new GridLayout(1,1));
   
    JLabel idL = new JLabel("ID");
    centerPanel.add(idL);
                           
    JLabel phoneL = new JLabel("Phone");
    centerPanel.add(phoneL);
    JLabel qualL = new JLabel("Qualifs");
    centerPanel.add(qualL);
                            //assume only 1 qualification
    
    JPanel qualPanel = new JPanel();
    JTextField[] qualF = new JTextField[100];
    for (int i = 0; i < 10; i++) {
     qualF[i] = new JTextField(2);
     qualF[i].setEditable(false);
     qualPanel.add((qualF[i]));
     }
    centerPanel.add(qualPanel);
    
     }
                            

		
		//loop through competitor list
		//for each competitor object, get id and create button with name as label
		
		private JPanel createGridPanel(CompetitorList competitorlist) {
			JPanel panel = new JPanel(new GridLayout(ROW_SIZE, ROW_SIZE));
			
	       Manager file = new Manager("DartList.txt");
			
	       CompetitorList list = file.getList();
	       Competitor comp = list.getCompetitor(100);
	       String details = comp.getShortDetails();
	       int counter = 0;
				
				String label = comp.getCompetitorName();
				buttons[counter] = new JButton(label);
				panel.add(buttons[counter]);
				buttons[counter].addActionListener(this);
			
			return panel;
		}
		
		
		
//second Part		

	public void BorderLayoutFrame() {
		
		this.setLayout(new BorderLayout(200,200));
		n = createOneLabel("Top", Color.GREEN);
		this.add(n, BorderLayout.NORTH);
		
		s = createOneLabel("Bottom", Color.WHITE);
		this.add(s, BorderLayout.SOUTH);
		
		e = createOneLabel("Right", Color.RED);
		this.add(e, BorderLayout.EAST);
		
		w = createOneLabel("Left", Color.CYAN);
		this.add(w, BorderLayout.WEST);
		
		c = createOneLabel("Middle", Color.YELLOW);
		this.add(c,BorderLayout.CENTER);

	}
	
	private JLabel createOneLabel (String s, Color c) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;
	}

	
	public void initialise(String [] args)
	{
		JFrame dbf = new JFrame("DartBorderLayout");
		dbf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dbf.pack();  
		dbf.setVisible(true);
	}

}
