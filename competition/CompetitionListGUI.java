package competition;

import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * @author alaat
 * **/
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.JTextComponent;
/**@author alaat
 @see ViewGUI**/

public class CompetitionListGUI extends JFrame implements ActionListener {

	// GUI components
	private JButton edit;
	private JButton view;
	private JTextField searchtext;
	private JButton searchBtn;
	private JRadioButton sortByCN = new JRadioButton("CN");
	private JRadioButton sortByName = new JRadioButton("Name");
	private JRadioButton sortByScores = new JRadioButton("Score");
	private ButtonGroup sort = new ButtonGroup();
	private static CompetitorList comptlist;
	private JFrame frame = new JFrame();
	private JPanel centerPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private String[] types= {"All","Hockey","Haggis","Baseball","Dart"};
	private JScrollPane scrollPane ;
	private JComboBox<String> filter = new JComboBox<String>(types);
	private ArrayList<Competitor> filtered;
	private CompetitorList filteredList= comptlist;



	/** Constructor to receive the list **/
	public CompetitionListGUI(CompetitorList c) {
		comptlist = c;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == searchBtn) {
			if(searchtext.getText().length()>0)
			{
				searchCompetitor(searchtext.getText());
				System.out.println(searchtext.getText());
			}
			else
			{
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.revalidate();
				frame.add(setupCenterPanel(comptlist.getCompetitorList()));
				frame.setSize(500, 500);
				centerPanel.repaint();
				centerPanel.revalidate();

			}
			
		}
		else if (event.getSource() == sortByCN)
		{
			System.out.println("radio button clicked");
			sortCN();
		}
		else if (event.getSource() == sortByName)
		{
			System.out.println("radio button clicked");

			sortNames();
		}
		else if (event.getSource() == sortByScores)
		{
			System.out.println("radio button clicked");

			sortScores();
		}
		else if (event.getSource()== searchtext)
		{
			searchCompetitor(searchtext.getText());
		}
		else if(event.getSource() == filter)
		{
			filterTheList(filter.getSelectedItem().toString());
		}
		
	}
	

	private void filterTheList(String selectedItem) {
		if(selectedItem =="All")
		{
			centerPanel.removeAll();
			centerPanel.repaint();
			centerPanel.revalidate();
			filtered =comptlist.getCompetitorList();
			filteredList =comptlist;
	        scrollPane.setViewportView(setupCenterPanel(filteredList.getCompetitorList()));

			centerPanel.repaint();
			centerPanel.revalidate();
		}
		else
		{
			 filtered =comptlist.filterByType(selectedItem);
			 filteredList = new CompetitorList(filtered);
			if(!filtered.isEmpty())
			{
				System.out.println(filter.getSelectedItem());

				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.revalidate();
		        scrollPane.setViewportView(setupCenterPanel(filtered));

				centerPanel.repaint();
				centerPanel.revalidate();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Oops couldn't filter the list by "+selectedItem+
						". You did not upload it!");
			}
		}
		
		
		
		
	}

	private void sortScores() {
		System.out.print("sorting scores");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(filteredList.listByScores()));
		centerPanel.repaint();
		centerPanel.revalidate();
	}

	private void sortNames() {
		System.out.print("sorting names");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(filteredList.listByName()));
		centerPanel.repaint();
		centerPanel.revalidate();
		
	}

	private void displayEditFrame(Competitor c) {
		EditCompetitors editGUI = new EditCompetitors(c);
	}
	
	private void sortCN()
	{
		System.out.print("sorting nos");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(filteredList.listByCN()));
		centerPanel.repaint();
		centerPanel.revalidate();
		

	}

	private void searchCompetitor(String text) {
		ArrayList<Competitor> al = new ArrayList<Competitor>();
		try {
			al = comptlist.getCompetitorCN(Integer.parseInt(text));
			if (!al.isEmpty()) {
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.revalidate();
				frame.add(setupCenterPanel(al));
				frame.setSize(600, 200);

				centerPanel.repaint();
				centerPanel.revalidate();

			} else {
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.revalidate();
				JLabel alert = new JLabel("competitor not found");
				centerPanel.add(alert);
				centerPanel.repaint();
				centerPanel.revalidate();
				JOptionPane.showMessageDialog(null, "Oops couldn't find competitor!");
			
			}
			
		}catch(NumberFormatException x)
		{
			String search_text = text.trim();
			if (search_text.length() > 0) {
				al = comptlist.getCompetitorName(search_text);
				
				if (!al.isEmpty()) {
					centerPanel.removeAll();
					centerPanel.repaint();
					centerPanel.revalidate();
					frame.add(setupCenterPanel(al));
					frame.setSize(600, 200);

					centerPanel.repaint();
					centerPanel.revalidate();

				} else {
					centerPanel.removeAll();
					centerPanel.repaint();
					centerPanel.revalidate();
					JLabel alert = new JLabel("competitor not found");
					centerPanel.add(alert);
					centerPanel.repaint();
					centerPanel.revalidate();
					JOptionPane.showMessageDialog(null, "Oops couldn't find competitor!");
					// table.setText("competitor not found");
				
				}
			}
		}
		
		
	}

	/**
	 * Method to set the blocks inside north panel
	 **/
	private JPanel setupNorthPanel() {
		northPanel.setLayout(new GridLayout(2, 8,10,10));
		searchtext = new JTextField(10);
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
		northPanel.add(searchtext);
		northPanel.add(searchBtn);
		JLabel sortBy = new JLabel("Sort by:");
		northPanel.add(sortBy);
		sortByCN.addActionListener(this);
		sortByName.addActionListener(this);
		sortByScores.addActionListener(this);
		sort.add(sortByCN);
		sort.add(sortByName);
		sort.add(sortByScores);
		sortByCN.setSelected(true);
		northPanel.add(sortByCN);
		northPanel.add(sortByName);
		northPanel.add(sortByScores);
		filter.addActionListener(this);
		northPanel.add(filter);
		northPanel.add(new JLabel());
		JLabel noHDR = new JLabel("No#", JLabel.CENTER);
		JLabel nameHDR = new JLabel("Name", JLabel.CENTER);
		JLabel typeHDR = new JLabel("Competiton", JLabel.CENTER);
		JLabel levelHDR = new JLabel("Level", JLabel.CENTER);
		JLabel scoreHDR = new JLabel("Overall", JLabel.CENTER);
		JLabel  extraHDR = new JLabel("Extra", JLabel.CENTER);
		JLabel editHDR = new JLabel("EDIT", JLabel.CENTER);
		JLabel viewHDR = new JLabel("VIEW", JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 14);

		noHDR.setFont(f);
		nameHDR.setFont(f);
		typeHDR.setFont(f);
		levelHDR.setFont(f);
		scoreHDR.setFont(f);
		extraHDR.setFont(f);
		editHDR.setFont(f);
		viewHDR.setFont(f);
		northPanel.add(noHDR);
		northPanel.add(nameHDR);
		northPanel.add(typeHDR);
		northPanel.add(levelHDR);
		northPanel.add(scoreHDR);
		northPanel.add(extraHDR);

		northPanel.add(editHDR);
		northPanel.add(viewHDR);
		return northPanel;
	}

	/**
	 * Method to set the blocks inside center panel
	 **/
	private JPanel setupCenterPanel(ArrayList<Competitor> comptList) {

		centerPanel.setLayout(new GridLayout(0,8));
		
		for (Competitor c : comptList) {
			JLabel no = new JLabel("" + c.competitorNumber, JLabel.CENTER);
			JLabel name = new JLabel("" + c.competitorName.getFullName(), JLabel.CENTER);
			JLabel type = new JLabel(c.getCompetitorType(), JLabel.CENTER);
			JLabel level = new JLabel(c.level, JLabel.CENTER);
			JLabel score = new JLabel("" +String.format("%10.1f",  c.getOverallScore()), JLabel.CENTER);
			 JLabel extra = new JLabel(c.getAttribute(),JLabel.CENTER);
			centerPanel.add(no);
			centerPanel.add(name);
			centerPanel.add(type);
			centerPanel.add(level);
			centerPanel.add(score);
			centerPanel.add(extra);
			edit = new JButton("Edit");
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				  displayEditFrame(c);
			} });
			view = new JButton("View");
			view.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
		    ViewGUI v = new ViewGUI(c);
		    v.setupGUI();
			      }
			    });
			
			centerPanel.add(edit);
			centerPanel.add(view);

		}
		return centerPanel;

	}

	/** Method to setup the GUI **/

	public void setupGUI() {


		frame.setLocation(100, 100);
		if(comptlist.getCompetitorList().size()>20)
		{
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setVisible(true);
		}
		else
		{
			frame.setSize(1300,1300);

		}
		frame.setTitle("Competition App");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setVisible(true);

		JLabel title;
		title = new JLabel("Competition List", JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		title.setFont(f);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(setupNorthPanel(), BorderLayout.NORTH);
		scrollPane= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setViewportView(setupCenterPanel(comptlist.getCompetitorList()));
        scrollPane.setAutoscrolls(true);
        scrollPane.revalidate();
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
