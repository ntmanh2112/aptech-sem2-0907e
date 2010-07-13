package frame;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import common.Constants;

public class TxtArea extends JPanel{

	
	private JScrollPane scroll;
	private Box box;
	
	public TxtArea(){
		this.setLayout(new GridLayout(1,1));
		init();
	}
	
	public void init() {
		Constants.txtArea = new JTextArea("",10,15);
		
		scroll = new JScrollPane(Constants.txtArea);
		
		box = Box.createHorizontalBox();
		box.add(scroll);
	
		this.add(box);
		
		
	}
	public void setTxtArea(String txt){
		Constants.txtArea.setText(txt);
	}
	
	public String getTxtArea(){
		return Constants.txtArea.getText();
	}
}
