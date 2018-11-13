package competition;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class CompetitionListGUI extends JFrame{

	public CompetitionListGUI(Competitor c) {
		//this.setLayout(new BorderLayout(5,5));
		JFrame justAFrame = new JFrame();
		justAFrame.setSize(300,300);
		justAFrame.setLocation(100,100);
		justAFrame.setTitle("Competition Group9");
		justAFrame.setVisible(true);
		justAFrame.setLayout(new BorderLayout(0,0));
		
		JPanel northPanel = new JPanel();
		String title =c.getCompetitorType()+"COMPETITION";
		JLabel GUItitle = this.createOneLabel(title, Color.blue);
		justAFrame.add(GUItitle,BorderLayout.NORTH);		
	
		
	}
	
	
	
	private JLabel createOneLabel (String s, Color c) {
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 18);
		JLabel label= new JLabel(s, JLabel.CENTER);
		label.setFont(f);
		label.setBackground(c);
		label.setOpaque(true);
		return label;}
	
	public static void main(String[] args) 
	{
		int[] scores = {1,2,3,4,5};
		Name n =new Name("Keith John Talbot");
		HockeyCompetitor competitor1 = new HockeyCompetitor(100,n,"Novice",scores,"ScotLand");
		CompetitionListGUI cgui = new CompetitionListGUI(competitor1);
	}

}
