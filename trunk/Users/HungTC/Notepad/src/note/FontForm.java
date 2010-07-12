package note;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.Constants;

public class FontForm extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String contents;
	public FontForm(String contents){
		this.contents = contents;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initialize();
	}
	public void initialize(){
		Container c = this.getContentPane();
		this.setTitle("Font");
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		this.setLocation(20, 50);
		this.setSize(500,200);
		
		JLabel lbFont = new JLabel("Font");
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20, 100, 10, 100);
		c.add(lbFont,constraints);
		
		JLabel lbSize = new JLabel("Size");
		constraints.gridx=1;
		constraints.gridy=0;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20, 100, 10, 100);
		c.add(lbSize,constraints);
		
	
		String[] fontString ={"Arial","Times New Roman","Tahoma"};
		JComboBox cboxFont = new JComboBox(fontString);
		cboxFont.setSelectedIndex(0);
		cboxFont.addActionListener(this);
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20, 100, 10, 100);
		c.add(cboxFont,constraints);
		
		String[] sizeString ={"10","12","14","16","18"}; 
		JComboBox cbSize = new JComboBox(sizeString);
		cbSize.setSelectedIndex(0);
		cbSize.addActionListener(this);
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20, 100, 10, 100);
		c.add(cbSize,constraints);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new NotePad(contents);
				int i = 0;
				i = JFrame.getFrames().length;
				if (i > 1) {
					for (int j = 0; j < i - 1; j++) {
						JFrame.getFrames()[j].setVisible(false);

						JFrame.getFrames()[j].dispose();
					}

				}
			}
			
		});
		constraints.gridx=0;
		constraints.gridy=2;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20, 20, 50, 2);
		btnOk.setPreferredSize(new Dimension(100,20));
		c.add(btnOk,constraints);
		
		JButton btnNo= new JButton("NO");
		btnNo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int length = JFrame.getFrames().length;
				JFrame.getFrames()[length-1].setVisible(false);
				JFrame.getFrames()[length-1].dispose();
			}
			
		});
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.gridwidth=1;
		constraints.insets = new Insets(20,20,50,2);
		btnNo.setPreferredSize(new Dimension(100,20));
		c.add(btnNo,constraints);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox cb = (JComboBox)e.getSource();
		Constants.FONTS = (String) cb.getSelectedItem();
		Constants.SIZES = (String) cb.getSelectedItem();
		
	}

}
