package note;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.Constants;

import util.MailUtil;

public class SendMail extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField txtTo, txtCc, txtSubject;
	JTextArea txtContents;
	String textContents;

	public SendMail(String textContents) {
		this.textContents = textContents;
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Constants.initBundle();
			initialize();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void initialize() {
		Container c = this.getContentPane();
		this.setTitle(Constants.BUNDLE.getString("title"));
		this.setLayout(new GridBagLayout());
		this.setLocation(20, 50);
		// this.setSize(300, 300);
		GridBagConstraints con = new GridBagConstraints();

		JLabel lbFrom = new JLabel();
		con.gridx = 0;
		con.gridy = 0;
		con.gridwidth = 2;
		con.insets = new Insets(20, 100, 10, 100);
		lbFrom.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(lbFrom, con);

		JLabel lbTo = new JLabel(Constants.BUNDLE.getString("lbTo"));
		con.gridx = 0;
		con.gridy = 1;
		con.gridwidth = 1;
		con.insets = new Insets(10, 50, 5, 2);
		lbTo.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(lbTo, con);

		JLabel lbCc = new JLabel(Constants.BUNDLE.getString("lbCc"));
		con.gridx = 0;
		con.gridy = 2;
		con.gridwidth = 1;
		con.insets = new Insets(10, 50, 5, 2);
		lbCc.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(lbCc, con);

		JLabel lbSubject = new JLabel(Constants.BUNDLE.getString("lbSubject"));
		con.gridx = 0;
		con.gridy = 3;
		con.gridwidth = 1;
		con.insets = new Insets(10, 50, 5, 2);
		lbSubject.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(lbSubject, con);

		JLabel lbContents = new JLabel(Constants.BUNDLE.getString("lbContents"));
		con.gridx = 0;
		con.gridy = 4;
		con.gridwidth = 1;
		con.insets = new Insets(10, 50, 5, 2);
		lbContents.setFont(new Font("Arial", Font.BOLD, 20));
		c.add(lbContents, con);

		txtTo = new JTextField();
		con.gridx = 1;
		con.gridy = 1;
		con.gridwidth = 1;
		con.insets = new Insets(10, 20, 5, 2);
		txtTo.setPreferredSize(new Dimension(150, 20));
		c.add(txtTo, con);

		txtCc = new JTextField();
		con.gridx = 1;
		con.gridy = 2;
		con.gridwidth = 1;
		con.insets = new Insets(10, 20, 5, 2);
		txtCc.setPreferredSize(new Dimension(150, 20));
		txtCc.setText("hungtran1008@gmail.com");		
		c.add(txtCc, con);

		txtSubject = new JTextField();
		con.gridx = 1;
		con.gridy = 3;
		con.gridwidth = 1;
		con.insets = new Insets(10, 20, 5, 2);
		txtSubject.setPreferredSize(new Dimension(150, 20));
		c.add(txtSubject, con);

		txtContents = new JTextArea();
		con.gridx = 1;
		con.gridy = 4;
		con.gridwidth = 1;
		con.insets = new Insets(10, 20, 5, 2);
		txtContents.setPreferredSize(new Dimension(150, 100));
		txtContents.setText(textContents);
		txtContents.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
		c.add(txtContents, con);

		JButton btnSend = new JButton(Constants.BUNDLE.getString("send"));
		con.gridx = 0;
		con.gridy = 5;
		con.gridwidth = 1;
		con.insets = new Insets(20, 20, 50, 2);
		btnSend.setPreferredSize(new Dimension(100, 20));
		c.add(btnSend, con);
		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
						MailUtil.sendEmail(txtTo.getText(), "hungtran1008@gmail.com,"+txtCc.getText(), txtSubject
						.getText(), txtContents.getText());
				if (MailUtil.flag) {
					JOptionPane.showMessageDialog(null, "ok");
				} else {

					JOptionPane.showMessageDialog(null, "hix");
				}
			}

		});

		JButton btnCancel = new JButton(Constants.BUNDLE.getString("cancel"));
		con.gridx = 1;
		con.gridy = 5;
		con.gridwidth = 1;
		con.gridwidth = 1;
		con.insets = new Insets(20, 20, 50, 2);
		btnCancel.setPreferredSize(new Dimension(100, 20));
		c.add(btnCancel, con);
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int count;
				count = JFrame.getFrames().length;
				JFrame.getFrames()[count-1].setVisible(false);
			}

		});
		this.pack();
		this.setVisible(true);
	}

}
