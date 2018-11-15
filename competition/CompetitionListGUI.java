package competition;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;


public class CompetitionListGUI extends JFrame{

	protected static CompetitorList competitors;
	
	/**Constructor to receive the list**/
public CompetitionListGUI(CompetitorList c) {
	//competitors = c;
		
	}
	public static JPanel displayCompetitorList()
	{
		JPanel myPanel = new JPanel(); 
		//int size = competitors.size();
		//System.out.println(size);
		myPanel.setLayout(new GridLayout(6,6));
		 for (Competitor c : competitors)  
	        
		{
			JLabel no = new JLabel(""+c.competitorNumber,JLabel.LEFT);
			JLabel name = new JLabel(""+c.competitorName,JLabel.CENTER);
			JLabel type = new JLabel(c.getCompetitorType(),JLabel.CENTER);
			JLabel level = new JLabel(c.level,JLabel.CENTER);
			JLabel score = new JLabel(""+c.getOverallScore(),JLabel.CENTER);
			JLabel extra = new JLabel(c.getCompetitorType(),JLabel.CENTER);
		
		
			myPanel.add(no);
			myPanel.add(name);
			myPanel.add(type);
			myPanel.add(level);
			myPanel.add(score);
			myPanel.add(extra);
			JButton edit = new JButton("Edit");
			myPanel.add(edit);

		}
		 return myPanel;
			
		
	}
	
	
	
	

	
	public static void main(String[] args) 
	{
		Manager m = new Manager("comptList.csv");
		m.getFile();
		competitors = m.getList();
		CompetitionListGUI cgui = new CompetitionListGUI(competitors);

		//this.setLayout(new BorderLayout(5,5));
		JFrame frame = new JFrame();
		frame.setSize(300,300);
		frame.setLocation(100,100);
		frame.setTitle("Competition Group9");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(0,0));
			
		JLabel title;
		title = new JLabel("Competition List",JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20); 
		title.setFont(f);
		
	
		//frame.add(button,BorderLayout.WEST);
//		frame.add(button1, BorderLayout.EAST);
		frame.add(title, BorderLayout.NORTH);
//		frame.add(button3, BorderLayout.SOUTH);
		frame.add(displayCompetitorList(), BorderLayout.CENTER);
		frame.setSize(500,500);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
			}

}
