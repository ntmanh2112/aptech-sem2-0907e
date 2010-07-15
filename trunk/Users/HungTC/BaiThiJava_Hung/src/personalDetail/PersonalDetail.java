package personalDetail;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonalDetail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */

	Container c = this.getContentPane();
	GridBagConstraints constraints = new GridBagConstraints();

	public PersonalDetail() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {
		this.setTitle("Personal Details");
		this.setLayout(new GridBagLayout());
		this.setSize(500, 500);

		JLabel lbBanner = new JLabel();
		Font font = new Font("Time New Roman", Font.BOLD, 25);
		lbBanner.setFont(font);
		lbBanner.setText("PERSONAL DETAILS");
		constraints.gridy = 0;
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		c.add(lbBanner, constraints);

		label("NAME: ", 0, 1);
		label("ADRRESS: ", 0, 2);
		label("PHONE: ", 0, 3);
		label("EMAIL: ", 0, 4);
		
		
		JLabel lb = new JLabel();
		lb.setText("SELECT STATE: ");
		Font fontOfSelectState = new Font("Time New Roman", Font.BOLD, 15);
		lb.setFont(fontOfSelectState);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth=1;
		constraints.insets = new Insets(10, 50, 5, 2);
		c.add(lb, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		text("Hung",1, 1);
		text("1234567",1,3);
		text("jgj@ghj.com",1,4);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setPreferredSize(new Dimension(100,20));
		btnSubmit.setBorder(BorderFactory.createRaisedBevelBorder());
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,50,0,0);
		c.add(btnSubmit,constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		String stringOfTextArea = "abcsasa \n asasa " +
				"\n dadghajddsdbhsbdjksndjsndsjcnscjsnjcnsjncsjkncjksncjksnckjsncjsnjbhjbhvhvhjb" +
				" \n dsdskd \n dsgduishud \n djswhdhwg \n dhwghd"; 
		JTextArea txtArea = new JTextArea(stringOfTextArea,4,10);
		txtArea.setPreferredSize(new Dimension(150,100));
		txtArea.setBorder(BorderFactory.createLoweredBevelBorder());
		constraints.gridx =1;
		constraints.gridy =2;
		constraints.gridwidth=1;
		constraints.insets = new Insets(10,50,5,2);
		JScrollPane scrollpanetxtArea = new JScrollPane(txtArea);
		Box boxtxtArea ;
		boxtxtArea = Box.createHorizontalBox();
		boxtxtArea.add(scrollpanetxtArea);
		c.add(boxtxtArea,constraints);		
		constraints.insets = new Insets(0,0,0,0);
	
		String states[] = { "Household", "Office", "Extended Family",
		        "Company (US)", "Company (World)", "Team", "Will",
		        "Birthday Card List", "High School", "Country", "Continent",
		        "Planet" };
		JList list = new JList(states);
		list.setSelectedIndex(2);
		constraints.gridx =2;
		constraints.gridy =2;
		constraints.gridwidth=1;
		constraints.insets = new Insets(10,50,5,2);
		JScrollPane scrollpaneList = new JScrollPane(list);	
		scrollpaneList.setPreferredSize(new Dimension(150,85));
		
		scrollpaneList.setBorder(BorderFactory.createLoweredBevelBorder());
		c.add(scrollpaneList,constraints);				
		constraints.insets = new Insets(0,0,0,0);
		
		this.setVisible(true);
	}

	public void label(String name, int x, int y) {
		JLabel lb = new JLabel();
		lb.setText(name);
		Font font = new Font("Time New Roman", Font.BOLD, 15);
		lb.setFont(font);
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth=1;
		constraints.insets = new Insets(10, 0, 5, 2);
		c.add(lb, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);

	}
	public void text(String str, int x, int y) {
		JTextField txt = new JTextField();
		txt.setText(str);
		txt.setPreferredSize(new Dimension(130,20));
		txt.setBorder(BorderFactory.createLoweredBevelBorder());
		constraints.gridx =x;
		constraints.gridy =y;
		constraints.insets = new Insets(10,50,5,2);
		c.add(txt,constraints);
		constraints.insets = new Insets(0,0,0,0);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PersonalDetail();
	}

}
