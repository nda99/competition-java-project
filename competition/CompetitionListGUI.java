package competition;

import java.awt.BorderLayout;
/**
 * @author alaat
 * **/
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
/**@author alaat
 @see ViewGUI**/

public class CompetitionListGUI extends JFrame implements ActionListener {

	// GUI components
	private JButton edit;
	private JButton view;
	private JScrollPane scrollList = new JScrollPane();
	private JTextArea table;
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
	private JScrollPane scroll = new JScrollPane(centerPanel);
	private String[] types= {"All","Hockey","Haggis","Baseball","Dart"};
	private JComboBox<String> filter = new JComboBox<String>(types);


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
			System.out.println(filter.getSelectedItem());
		}
		
	}
	

	private void filterTheList(String selectedItem) {
		ArrayList<Competitor> filtered =comptlist.filterByType(selectedItem);
		if(!filtered.isEmpty())
		{
			centerPanel.removeAll();
			centerPanel.repaint();
			centerPanel.revalidate();
			frame.add(setupCenterPanel(filtered));

			centerPanel.repaint();
			centerPanel.revalidate();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Oops couldn't filter the list by "+selectedItem+
					". You did not upload it!");
		}
		
		
		
	}

	private void sortScores() {
		System.out.print("sorting scores");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(comptlist.listByScores()));
		centerPanel.repaint();
		centerPanel.revalidate();
	}

	private void sortNames() {
		System.out.print("sorting names");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(comptlist.listByName()));
		centerPanel.repaint();
		centerPanel.revalidate();
		
	}

	private void displayEditFrame() {
		EditCompetitors editGUI = new EditCompetitors();
	}
	
	private void sortCN()
	{
		System.out.print("sorting nos");
		centerPanel.removeAll();
		centerPanel.repaint();
		centerPanel.revalidate();
		frame.add(setupCenterPanel(comptlist.listByCN()));
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
		northPanel.setLayout(new GridLayout(1, 6));
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
		return northPanel;
	}

	/**
	 * Method to set the blocks inside center panel
	 **/
	private JPanel setupCenterPanel(ArrayList<Competitor> comptList) {
		centerPanel.setLayout(new GridLayout(0, 8));
		scrollList.add(centerPanel);
		if(comptlist.equals(null))
		{
			
		
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 14);
		JLabel noHDR = new JLabel("No#", JLabel.LEFT);
		JLabel nameHDR = new JLabel("Name", JLabel.CENTER);
		JLabel typeHDR = new JLabel("Competiton", JLabel.CENTER);
		JLabel levelHDR = new JLabel("Level", JLabel.CENTER);
		JLabel scoreHDR = new JLabel("Overall", JLabel.CENTER);
		JLabel editHDR = new JLabel("EDIT", JLabel.CENTER);
		JLabel viewHDR = new JLabel("VIEW", JLabel.CENTER);

		noHDR.setFont(f);
		nameHDR.setFont(f);
		typeHDR.setFont(f);
		levelHDR.setFont(f);
		scoreHDR.setFont(f);
		editHDR.setFont(f);
		viewHDR.setFont(f);
		centerPanel.add(noHDR);
		centerPanel.add(nameHDR);
		centerPanel.add(typeHDR);
		centerPanel.add(levelHDR);
		centerPanel.add(scoreHDR);
		centerPanel.add(editHDR);
		centerPanel.add(viewHDR);

		}
		
		for (Competitor c : comptList) {
			JLabel no = new JLabel("" + c.competitorNumber, JLabel.LEFT);
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
				  displayEditFrame();
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
		frame.setTitle("Competition App");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(10, 10));
        frame.add(scroll, BorderLayout.CENTER);
		frame.setVisible(true);

		JLabel title;
		title = new JLabel("Competition List", JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		title.setFont(f);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(setupNorthPanel(), BorderLayout.NORTH);
		frame.add(setupCenterPanel(comptlist.getCompetitorList()), BorderLayout.CENTER);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
