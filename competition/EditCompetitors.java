import javax.swing.*;
import java.awt.event.*;

public class EditCompetitors extends JFrame  implements ActionListener{
	
	JPanel pnl = new JPanel();
	
	String[] toppings = {"Hockey", "HaggisCheff", "Baseball","Darts"};
	String[] style = {"<Please Select>","100", "102", "302","304"};
	String[] stuff = {"Please choose a competitor number to edit. "};
	
	JCheckBox chek1 = new JCheckBox(toppings[0]);
	JCheckBox chek2 = new JCheckBox(toppings[1],true);
	JCheckBox chek3 = new JCheckBox(toppings[2]);
	JCheckBox chek4 = new JCheckBox(toppings[3]);
	
	JButton btn = new JButton("Ok");
	
	JComboBox<String> box1 = new JComboBox<String>(style);
	JList<String> lst1 = new JList<String>(stuff);
	
	public EditCompetitors() {
		super("Competitors Editor");
		setSize(319, 221);
		setLocation(730,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		setVisible(true);
		pnl.add(lst1);
		pnl.add(chek1);
		pnl.add(chek2);
		pnl.add(chek3);
		pnl.add(chek4);
		box1.setSelectedIndex(0);
		pnl.add(box1);
		
		pnl.add(btn);
		btn.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent event){	
		if(event.getSource()==btn){
			int n = JOptionPane.showConfirmDialog(this, "Are you sure? ", "Confirmation Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
		}}
	
	public static void main(String[] args){
	
		EditCompetitors gui = new EditCompetitors();
		
	}
}
