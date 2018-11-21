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

	String[] box = {"Hockey", "HaggisCheff", "Baseball","Darts"};
	String[] style = {"<Please Select>"};
	String[] stuff = {"Please choose a competitor number to edit. "};

	JCheckBox check1 = new JCheckBox(box[0]);
	JCheckBox check2 = new JCheckBox(box[1],true);
	JCheckBox check3 = new JCheckBox(box[2]);
	JCheckBox check4 = new JCheckBox(box[3]);
	Competitor c = null;
	JButton btn = new JButton("Ok");

	JLabel lbl = new JLabel("Please check a box");

	JComboBox<String> box1 = new JComboBox<String>(style);
	JList<String> lst1 = new JList<String>(stuff);

	JTextArea txtArea = new JTextArea(5,37);
	JScrollPane pane = new JScrollPane(txtArea);
	
	public EditCompetitors(Competitor c) {
		
		super("Competitors Editor");
		
		setSize(510, 221);
		setLocation(730,550);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(pnl);
		setVisible(true);
		pnl.add(lst1);
		box1.setSelectedIndex(0);
		pnl.add(box1);
		pnl.add(btn);
		btn.addActionListener(this);
		pnl.add(check1);
		pnl.add(check2);
		pnl.add(check3);
		pnl.add(check4);
		pnl.add(lbl);
		
		
		 txtArea.setLineWrap(true);
		 txtArea.setWrapStyleWord(true);
		 pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		 pnl.add(pane);
	}

	public void actionPerformed(ActionEvent event){	
		if(event.getSource()==btn){
			int n = JOptionPane.showConfirmDialog(this, "Are you sure? ", "Confirmation Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
			if(n==0){
				int index = box1.getSelectedIndex();
				getInfos(index);
			}
		}}

	public void getInfos(int index) {
		try {
			FileReader f = new FileReader("CList.csv");
			BufferedReader buf = new BufferedReader(f);
			String l = "";
			for(int i = 1; i < index; i++)
				buf.readLine();
			l = buf.readLine();
			lbl.setText(l);
			
			buf.close();
		}
		catch(IOException e)
		{
			System.out.println("A read error occured.");
			e.printStackTrace();
		}
	}

	public void init(){
		try {
			FileReader f = new FileReader("CList.csv");
			BufferedReader buf = new BufferedReader(f);
			String l = "";
			while ((l = buf.readLine())!=null){
				
				String[] words = l.split(",");
				box1.addItem(words[0]);
			}
			buf.close();
		}
		catch(IOException e)
		{
			System.out.println("A read error occured.");
			e.printStackTrace();
		}
	}


	//public static void main(String[] args){

		EditCompetitors gui = new EditCompetitors();

		gui.init();

	//}
}