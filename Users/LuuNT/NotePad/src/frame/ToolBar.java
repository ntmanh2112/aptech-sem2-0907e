package frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.Constants;

public class ToolBar extends JPanel{
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	
	public ToolBar() {
		this.setLayout(new GridLayout(0,30));
		init();
	}
	public void init() {
		Icon icon1 = new ImageIcon("Image/new.gif");
		Icon icon2 = new ImageIcon("Image/open.gif");
		Icon icon3 = new ImageIcon("Image/save.gif");
		
		btn1 = new JButton("",icon1);
		btn1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Constants.txtArea.setText("");
			}
			
		});
		btn2 = new JButton("",icon2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OpenFile();
			}
		});
		btn3 = new JButton("",icon3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SaveFile(Constants.txtArea.getText());
			}
		});
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		
	}
}
