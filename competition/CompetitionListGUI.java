package competition;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
//this comment is added 13:01

public class CompetitionListGUI extends JFrame implements ActionListener {

	// GUI components
	static JButton edit;
	static JButton view;
	JScrollPane scrollList;
	JTextArea table;
	JTextField searchtext;
	JButton searchBtn;
	JRadioButton sortByCN = new JRadioButton("CN");
	JRadioButton sortByName = new JRadioButton("Name");
	JRadioButton sortByScores = new JRadioButton("Score");
	ButtonGroup filter = new ButtonGroup();

	CompetitorList comptlist;
	JFrame frame = new JFrame();
	JPanel centerPanel = new JPanel();
	JPanel northPanel = new JPanel();

	/** Constructor to receive the list **/
	public CompetitionListGUI(CompetitorList c) {
		comptlist = c;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == searchBtn) {
			searchCompetitor(searchtext.getText());
			System.out.println(searchtext.getText());
		}
		else if (event.getSource() == view) {
			// ViewGUI viewGui = new ViewGUI(compt);
		}
		else if (event.getSource() == sortByCN)
		{
			sortCN();
		}
		else if (event.getSource() == sortByName)
		{
			sortNames();
		}
		else if (event.getSource() == sortByScores)
		{
			sortScores();
		}
		
	}
	

	private void sortScores() {
		// TODO create methods in competitorlist
		
	}

	private void sortNames() {
		// TODO create methods in competitorlist
		
	}

	private void displayEditFrame() {
		// TODO : link it to plamen's class

	}
	
	private void sortCN()
	{
		ArrayList<Competitor> list = new ArrayList<Competitor>();
		list = comptlist.getCompetitorList();
		//list.sort(list.);
		for (Competitor c : list)
		{
			
		}
	}

	private void searchCompetitor(String text) {

		String search_text = text.trim();
		if (search_text.length() > 0) {
			Competitor comp = comptlist.getCompetitor(101);
			if (comp != null) {
				/*
				 * centerPanel.removeAll(); System.out.println("inside the method");
				 */

				ArrayList<Competitor> al = new ArrayList<Competitor>();
				al.add(comp);
				CompetitorList temp = new CompetitorList(al);
				centerPanel.removeAll();
				centerPanel.repaint();
				centerPanel.revalidate();
				frame.add(setupCenterPanel(temp));
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
				JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
				// table.setText("competitor not found");
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
		JLabel filterBy = new JLabel("Filter by:");
		northPanel.add(filterBy);
		filter.add(sortByCN);
		filter.add(sortByName);
		filter.add(sortByScores);
		sortByCN.setSelected(true);
		northPanel.add(sortByCN);
		northPanel.add(sortByName);
		northPanel.add(sortByScores);

		return northPanel;
	}

	/**
	 * Method to set the blocks inside center panel
	 **/
	private JPanel setupCenterPanel(CompetitorList list) {

		ArrayList<Competitor> comptList = list.getCompetitorList();

		centerPanel.setLayout(new GridLayout(0, 7));
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

		for (Competitor c : comptList) {
			JLabel no = new JLabel("" + c.competitorNumber, JLabel.LEFT);
			JLabel name = new JLabel("" + c.competitorName.getFullName(), JLabel.CENTER);
			JLabel type = new JLabel(c.getCompetitorType(), JLabel.CENTER);
			JLabel level = new JLabel(c.level, JLabel.CENTER);
			JLabel score = new JLabel("" + c.getOverallScore(), JLabel.CENTER);
			// JLabel extra = new JLabel(c.getCompetitorType(),JLabel.CENTER);
			centerPanel.add(no);
			centerPanel.add(name);
			centerPanel.add(type);
			centerPanel.add(level);
			centerPanel.add(score);
			// myPanel.add(extra);
			edit = new JButton("Edit");
			view = new JButton("View");

			centerPanel.add(edit);
			centerPanel.add(view);

		}
		return centerPanel;

	}

	/** Method to setup the GUI **/

	public void setupGUI() {

	
		frame.setSize(100, 300);
		frame.setLocation(100, 100);
		frame.setTitle("Competition App");
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(10, 10));

		JLabel title;
		title = new JLabel("Competition List", JLabel.CENTER);
		Font f = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		title.setFont(f);
		
		frame.add(title, BorderLayout.NORTH);
		frame.add(setupNorthPanel(), BorderLayout.NORTH);
		frame.add(setupCenterPanel(comptlist), BorderLayout.CENTER);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

}
