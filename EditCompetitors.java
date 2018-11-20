
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EditCompetitors extends JFrame  implements ActionListener{
	
	JPanel pnl = new JPanel();
	
	String[] box = {"Hockey", "HaggisCheff", "Baseball","Darts"};
	String[] style = {"<Please Select>","100", "102", "302","304","404","301","307","309","304","308"};
	String[] stuff = {"Please choose a competitor number to edit. "};
	
	JCheckBox check1 = new JCheckBox(box[0]);
	JCheckBox check2 = new JCheckBox(box[1],true);
	JCheckBox check3 = new JCheckBox(box[2]);
	JCheckBox check4 = new JCheckBox(box[3]);
	
	JButton btn = new JButton("Ok");
	
	JComboBox<String> box1 = new JComboBox<String>(style);
	JList<String> lst1 = new JList<String>(stuff);
	
	public EditCompetitors() {
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
	}
	
	public void actionPerformed(ActionEvent event){	
		if(event.getSource()==btn){
			int n = JOptionPane.showConfirmDialog(this, "Are you sure? ", "Confirmation Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
		}}
	
//	public static void main(String[] args){
	
		EditCompetitors gui = new EditCompetitors();
		
		
		 
		
	//}
}