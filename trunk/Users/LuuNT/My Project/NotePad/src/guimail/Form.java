package guimail;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.MailUtil;

import common.Constants;

public class Form extends JFrame {
	private String from;
	private String to;
	private String cc;
	private String subject;
	private String content;
	
	private JLabel lbBanner;
	private JLabel lbFrom;
	private JLabel lbTo;
	private JLabel lbCc;
	private JLabel lbSubject;
	private JLabel lbContent;
	
	private JTextArea areaContent;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtCc;
	private JTextField txtSubject;
	
	private JButton btnSubmit;
	private JButton btnReset;
	
	public Form() {
		Constants.initBundle();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {
		Container c = this.getContentPane();
		this.setTitle(Constants.BUNDLE.getString("lbTitle"));
		this.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		lbBanner = new JLabel();
		lbBanner.setText(Constants.BUNDLE.getString("lbBanner"));
		lbBanner.setFont(new Font("Arial", Font.BOLD, 30));
		lbBanner.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.insets = new Insets(20, 200, 10, 100);
		c.add(lbBanner, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		lbFrom = new JLabel();
		lbFrom.setText(Constants.BUNDLE.getString("lbFrom"));
		lbFrom.setFont(new Font("Arial", Font.BOLD, 20));
		lbFrom.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 150, 10, 10);
		c.add(lbFrom, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		lbTo = new JLabel();
		lbTo.setText(Constants.BUNDLE.getString("lbTo"));
		lbTo.setFont(new Font("Arial", Font.BOLD, 20));
		lbTo.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 150, 10, 10);
		c.add(lbTo, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		lbCc = new JLabel();
		lbCc.setText(Constants.BUNDLE.getString("lbCc"));
		lbCc.setFont(new Font("Arial", Font.BOLD, 20));
		lbCc.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 50, 10, 10);
		c.add(lbCc, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		
		lbSubject = new JLabel();
		lbSubject.setText(Constants.BUNDLE.getString("lbSubject"));
		lbSubject.setFont(new Font("Arial", Font.BOLD, 20));
		lbSubject.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 150, 10, 10);
		c.add(lbSubject, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		lbContent = new JLabel();
		lbContent.setText(Constants.BUNDLE.getString("lbContent"));
		lbContent.setFont(new Font("Arial", Font.BOLD, 20));
		lbContent.setForeground(Color.black);
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10, 150, 10, 10);
		c.add(lbContent, constraints);
		constraints.insets = new Insets(0, 0, 0, 0);
		
		txtFrom = new JTextField();
		txtFrom.setPreferredSize(new Dimension(150,25));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,20,5,50);
		c.add(txtFrom, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		txtTo = new JTextField();
		txtTo.setPreferredSize(new Dimension(150,25));
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,20,5,50);
		c.add(txtTo, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		txtCc = new JTextField();
		txtCc.setPreferredSize(new Dimension(150,25));
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,20,5,50);
		c.add(txtCc, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		txtSubject = new JTextField();
		txtSubject.setPreferredSize(new Dimension(150,25));
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,20,5,50);
		c.add(txtSubject, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		areaContent = new JTextArea();
		areaContent.setPreferredSize(new Dimension(200,200));
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(10,20,5,50);
		c.add(areaContent, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		btnSubmit = new JButton();
		//btnSubmit.setIcon(icon1);
		btnSubmit.setText(Constants.BUNDLE.getString("btnSubmit"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				from = txtFrom.getText();
				to = txtTo.getText();
				cc = txtCc.getText();
				subject = txtSubject.getText();
				content = areaContent.getText();
				try {
					if(MailUtil.SendMail(from, to, cc, subject, content)){
						JOptionPane.showMessageDialog(null,Constants.BUNDLE.getString("afterSubmit1"));
					}
					else
						JOptionPane.showMessageDialog(null,Constants.BUNDLE.getString("afterSubmit2"));
						
				} catch (Exception e) {
					System.out.println("Error");
				}
			}
		});
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(20,150,50,2);
		c.add(btnSubmit, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		btnReset = new JButton();
		//btnSubmit.setIcon(icon1);
		btnReset.setText(Constants.BUNDLE.getString("btnReset"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,Constants.BUNDLE.getString("resetAction"));
				if (result == 0){
					txtFrom.setText("");
					txtTo.setText("");
					txtCc.setText("");
					txtSubject.setText("");
					areaContent.setText("");
				}
			}
		});
		constraints.gridx = 1;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.insets = new Insets(20,20,50,2);
		c.add(btnReset, constraints);
		constraints.insets = new Insets(0,0,0,0);
		
		
		this.pack();
		this.setVisible(true);
		
	}

}
