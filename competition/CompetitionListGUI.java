package competition;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


public class CompetitionListGUI extends JFrame{

	 //GUI components
	 static JButton edit;
	 static JButton view;
	 JScrollPane scrollList; 
	 JTextArea table;
	 JTextField searchtext;
	 JButton searchBtn;
	 CompetitorList list;
	JFrame frame = new JFrame();

		
	/**Constructor to receive the list**/
public CompetitionListGUI(CompetitorList c) {
		list = c;
		
		 pack();         
		 setVisible(true);   
	}
/** Method to set the blocks inside center panel
 * **/

	
	

	   public void actionPerformed(ActionEvent event)
	   {
		   if(event.getSource() == "search")
		   { searchCompetitor(searchtext.getText());	   }
		   if(event.getSource() =="edit")
		   { displayEditFrame();}
		   
	   }
	  private void displayEditFrame() {
		// TODO Auto-generated method stub
		
	}
	private void searchCompetitor(String text) {
		   
		 String search_text = searchtext.getText().trim();
		 if(search_text.length()>0)
		 {
			 Competitor comp = list.getCompetitor(100);
			 if (comp !=null)
			 {
				 table.setText(comp.getCompetitorName());
			 }
			 else
			 {
				 table.setText("competitor not found");
			 }
		 }
		 
	}
	private JPanel setupNorthPanel() {         
	  JPanel northPanel = new JPanel();  
	northPanel.setLayout(new GridLayout(1,6));

		  searchtext = new JTextField(10);         
		  searchBtn = new JButton("Search");
		 // searchBtn.addChangeListener();
		  northPanel.add(searchtext);
		  northPanel.add(searchBtn); 
	 return northPanel;
				  }
	public JPanel displayCompetitorList()
	{
		
		JPanel centerPanel = new JPanel(); 
		//int size = competitors.size();
		//System.out.println(size);
		ArrayList<Competitor> comptList = list.getCompetitorList();
		
		centerPanel.setLayout(new GridLayout(0,7));
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 10); 
		JLabel noHDR = new JLabel("No#",JLabel.LEFT);
		JLabel nameHDR = new JLabel("Name",JLabel.CENTER);
		JLabel typeHDR = new JLabel("Competiton",JLabel.CENTER);
		JLabel levelHDR = new JLabel("Level",JLabel.CENTER);
		JLabel scoreHDR = new JLabel("Overall",JLabel.CENTER);
		JLabel editHDR = new JLabel("EDIT",JLabel.CENTER);
		JLabel viewHDR = new JLabel("VIEW",JLabel.CENTER);

		noHDR.setFont(f);
		nameHDR.setFont(f);
		typeHDR.setFont(f);
		levelHDR.setFont(f);
		scoreHDR.setFont(f);
		centerPanel.add(noHDR);
		centerPanel.add(nameHDR);
		centerPanel.add(typeHDR);
		centerPanel.add(levelHDR);
		centerPanel.add(scoreHDR);
		centerPanel.add(editHDR);
		centerPanel.add(viewHDR);

		for(Competitor c : comptList)
		{
			JLabel no = new JLabel(""+c.competitorNumber,JLabel.LEFT);
			JLabel name = new JLabel(""+c.competitorName.getFullName(),JLabel.CENTER);
			JLabel type = new JLabel(c.getCompetitorType(),JLabel.CENTER);
			JLabel level = new JLabel(c.level,JLabel.CENTER);
			JLabel score = new JLabel(""+c.getOverallScore(),JLabel.CENTER);
			//JLabel extra = new JLabel(c.getCompetitorType(),JLabel.CENTER);
		
		
			centerPanel.add(no);
			centerPanel.add(name);
			centerPanel.add(type);
			centerPanel.add(level);
			centerPanel.add(score);
			//myPanel.add(extra);
			edit = new JButton("Edit");
			view = new JButton("View");
			centerPanel.add(edit);
			centerPanel.add(view);
			

		}
		 return centerPanel;
			
		
	}
	
	
	
	

	
	public void setupGUI()
	{
		
		//this.setLayout(new BorderLayout(5,5));
		frame.setSize(100,300);
		frame.setLocation(100,100);
		frame.setTitle("Competition App");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(0,0));
			
		JLabel title;
		title = new JLabel("Competition List",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		
	
		//frame.add(button,BorderLayout.WEST);
//		frame.add(button1, BorderLayout.EAST);
		frame.add(title, BorderLayout.NORTH);
		frame.add(setupNorthPanel(), BorderLayout.NORTH);

//		frame.add(button3, BorderLayout.SOUTH);
		frame.add(displayCompetitorList(), BorderLayout.CENTER);
		frame.setSize(500,500);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
			}

}
