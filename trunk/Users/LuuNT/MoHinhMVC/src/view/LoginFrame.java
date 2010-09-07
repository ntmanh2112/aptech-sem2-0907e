package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.UserDAO;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbLogin = null;
	private JLabel lbUserName = null;
	private JLabel lbPassword = null;
	private JTextField txtUserName = null;
	private JButton btnSubmit = null;
	private JButton btnReset = null;
	private JPasswordField txtPassWord = null;

	/**
	 * This is the default constructor
	 */
	public LoginFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(450, 410);
		this.setContentPane(getJContentPane());
		this.setTitle("Login");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbPassword = new JLabel();
			lbPassword.setText("PassWord :");
			lbPassword.setSize(new Dimension(106, 16));
			lbPassword.setLocation(new Point(76, 135));
			lbUserName = new JLabel();
			lbUserName.setText("UserName :");
			lbUserName.setLocation(new Point(76, 105));
			lbUserName.setSize(new Dimension(106, 16));
			lbLogin = new JLabel();
			lbLogin.setBounds(new Rectangle(175, 43, 76, 33));
			lbLogin.setForeground(new Color(255, 51, 0));
			lbLogin.setFont(new Font("Dialog", Font.BOLD, 24));
			lbLogin.setText("Login");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbLogin, null);
			jContentPane.add(lbUserName, null);
			jContentPane.add(lbPassword, null);
			jContentPane.add(getTxtUserName(), null);
			jContentPane.add(getBtnSubmit(), null);
			jContentPane.add(getBtnReset(), null);
			jContentPane.add(getTxtPassWord(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtUserName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtUserName() {
		if (txtUserName == null) {
			txtUserName = new JTextField();
			txtUserName.setLocation(new Point(195, 105));
			txtUserName.setSize(new Dimension(166, 16));
		}
		return txtUserName;
	}

	/**
	 * This method initializes btnSubmit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton();
			btnSubmit.setBounds(new Rectangle(90, 181, 108, 30));
			btnSubmit.setText("Submit");
			btnSubmit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					Integer result = UserDAO.checkLogin(txtUserName.getText(),txtPassWord.getText());
					if(result == 0){
						JOptionPane.showMessageDialog(null,"Login False");
					} else {
						new PhongBanView();
						dispose();
					}
					
				
				}
			});
		}
		return btnSubmit;
	}

	/**
	 * This method initializes btnReset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton();
			btnReset.setLocation(new Point(241, 180));
			btnReset.setText("Reset");
			btnReset.setSize(new Dimension(108, 30));
		}
		return btnReset;
	}

	/**
	 * This method initializes txtPassWord	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtPassWord() {
		if (txtPassWord == null) {
			txtPassWord = new JPasswordField();
			txtPassWord.setLocation(new Point(195, 135));
			txtPassWord.setSize(new Dimension(166, 16));
		}
		return txtPassWord;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
