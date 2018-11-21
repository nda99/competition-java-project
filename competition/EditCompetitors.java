package competition;
import java.io.*; 
import javax.swing.*;
import java.awt.event.*;


/**
 * @author Plamen
 *
 */
/**
 * @author Plamen
 *
 */
public class EditCompetitors extends JFrame  implements ActionListener{

	JPanel pnl = new JPanel();
	
	String[] style = {"<Please Select>"};
	String[] stuff = {"Please choose a competitor number to edit. "};


	Competitor c = null;
	JButton btn = new JButton("Edit");
	

	JTextArea txtArea = new JTextArea(5,37);
	JScrollPane pane = new JScrollPane(txtArea);
	public JMenuBar buildDropDown(){
		JMenuItem mLevel;
	

		JMenuBar mbar = new JMenuBar();
		JMenu menu = new JMenu("Please select a type to edit.");
		mLevel = new JMenuItem("level");
		JList<String> lst1 = new JList<String>(stuff);
		menu.add(mLevel);
		mbar.add(menu);
		
		mLevel.addActionListener(this);
		return mbar;	
		
	}
	
	public JMenuBar jm(){
		JMenuItem nLevel;
		JMenuBar name = new JMenuBar();
		JMenu menu1 = new JMenu("Please select a type to edit.");
		nLevel = new JMenuItem("name");
		
		menu1.add(nLevel);
		name.add(menu1);
		
		nLevel.addActionListener(this);
		return name;
	}
	public EditCompetitors(Competitor c) {
		this.c = c;
		JMenuBar dropDown = buildDropDown();
		
		setSize(510, 221);
		setLocation(730,550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(pnl);
		setVisible(true);
	
		pnl.add(dropDown);
		pnl.add(btn);
		btn.addActionListener(this);
		
		
		
		 txtArea.setLineWrap(true);
		 txtArea.setWrapStyleWord(true);
		 pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		 pnl.add(pane);
	}

	public void actionPerformed(ActionEvent event){	
		
		if(event.getSource()==btn){
			String level = txtArea.getText();
			
			int n = JOptionPane.showConfirmDialog(this, "Are you sure? ", "Confirmation Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==0){
			
				c.setLevel(level);
				Manager.getList().getCompetitor(c.getCompetitorNumber()).setLevel(level);
				
				
			}
		}
	}
}