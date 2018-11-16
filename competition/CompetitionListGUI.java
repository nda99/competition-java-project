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
	 JButton edit;     
	 JScrollPane scrollList; 
	 JTextArea table;
	 JTextField searchtext;
	 JButton searchBtn;
	static CompetitorList list;
		
	/**Constructor to receive the list**/
public CompetitionListGUI(CompetitorList c) {
		list = c;
		//set up window title         
		setTitle("StaffList");         
		//disable standard close button    s
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);      
		setupNorthPanel();    
		setupCenterPanel(); 
		//setupSouthPanel();    	 
        //pack and set visible 
		 pack();         
		 setVisible(true);   
	}
/** Method to set the blocks inside center panel
 * **/
	private void setupCenterPanel() {         
	table = new JTextArea(15,20);         
	table.setFont(new Font (Font.SANS_SERIF, Font.PLAIN,14));         
	table.setEditable(false);         
	scrollList = new JScrollPane(table);         
	this.add(scrollList,BorderLayout.CENTER);     
	}   
	
	
	/* private void setupSouthPanel() {         
		 //search panel contains label, text field and button         
		 JPanel searchPanel = new JPanel();         
		 searchPanel.setLayout(new GridLayout(1,3));         
		 searchPanel.add(new JLabel("Enter ID"));            
		// searchField = new JTextField(5);         
		 searchPanel.add(searchField);            
		 search = new JButton("Search");           
		 searchPanel.add(search);             
		 //specify action when button is pressed         
		 search.addActionListener(this) ;                  
		 //Set up the area where the results will be displayed.         
		 result= new JTextField(25);              
		 result.setEditable(false);                  
		 //set up south panel containing 2 previous areas         
		 JPanel southPanel = new JPanel();         
		 southPanel.setLayout(new GridLayout(2,1));         
		 southPanel.add(searchPanel);         
		 southPanel.add(result);                  
		 //add south panel to the content pane         
		 this.add(southPanel, BorderLayout.SOUTH);         
		 } 
	 }*/
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
	private void setupNorthPanel() {         
	  JPanel northPanel = new JPanel();         
		  searchtext = new JTextField(10);         
		  searchBtn = new JButton("Search");
		 // searchBtn.addChangeListener();
		  northPanel.add(searchtext);
		  northPanel.add(searchBtn);
		  
		/*  showListByName = new JButton("List By Name");         
		  showListByName.addActionListener(this);                  
		  close = new JButton("Close");         
		  close.addActionListener(this);                 
		  northPanel.add (showListById);        
		  northPanel.add(showListByName);         
		  northPanel.add(close);       */  
		  this.add(northPanel, BorderLayout.NORTH);
				  }
	public static JPanel displayCompetitorList()
	{
		JPanel myPanel = new JPanel(); 
		//int size = competitors.size();
		//System.out.println(size);
		ArrayList<Competitor> comptList = list.getCompetitorList();
		myPanel.setLayout(new GridLayout(comptList.size(),5));

		for(Competitor c : comptList)
		{
			JLabel no = new JLabel(""+c.competitorNumber,JLabel.LEFT);
			JLabel name = new JLabel(""+c.competitorName.getFullName(),JLabel.CENTER);
			JLabel type = new JLabel(c.getCompetitorType(),JLabel.CENTER);
			JLabel level = new JLabel(c.level,JLabel.CENTER);
			JLabel score = new JLabel(""+c.getOverallScore(),JLabel.CENTER);
			//JLabel extra = new JLabel(c.getCompetitorType(),JLabel.CENTER);
		
		
			myPanel.add(no);
			myPanel.add(name);
			myPanel.add(type);
			myPanel.add(level);
			myPanel.add(score);
			//myPanel.add(extra);
			JButton edit = new JButton("Edit");
			myPanel.add(edit);
			

		}
		 return myPanel;
			
		
	}
	
	
	
	

	
	public static void main(String[] args) 
	{
		Manager m = new Manager("test_correct.csv");
		m.getFile();
		list = m.getList();
		//CompetitionListGUI cgui = new CompetitionListGUI(competitors);

		//this.setLayout(new BorderLayout(5,5));
		JFrame frame = new JFrame();
		frame.setSize(100,400);
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
