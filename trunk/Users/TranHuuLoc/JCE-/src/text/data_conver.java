package text;

import java.awt.BorderLayout;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class data_conver extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbnInputData = null;
	private JTextField txtinputdata = null;
	private JLabel lbnEncrypt = null;
	private JTextField txtEncryted = null;
	private JLabel lbnDecrypt_data = null;
	private JTextField txtDecrypt_data = null;
	private JButton btnEncryted = null;
	private JButton btndecrypt_data = null;
	private Cipher objCiper ;  //  @jve:decl-index=0:	
	private SecretKey sKey;
	/**
	 * This is the default constructor
	 */
	public data_conver() {
		super();
		try {
			objCiper = Cipher.getInstance("DES/ECB/PKCS5Padding");
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			 sKey = generator.generateKey();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1024, 678);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbnDecrypt_data = new JLabel();
			lbnDecrypt_data.setBounds(new Rectangle(15, 273, 78, 31));
			lbnDecrypt_data.setText("Decrypt_data");
			lbnEncrypt = new JLabel();
			lbnEncrypt.setBounds(new Rectangle(16, 150, 56, 27));
			lbnEncrypt.setText("Encryted");
			lbnInputData = new JLabel();
			lbnInputData.setBounds(new Rectangle(15, 34, 61, 30));
			lbnInputData.setText("inputdata");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbnInputData, null);
			jContentPane.add(getTxtinputdata(), null);
			jContentPane.add(lbnEncrypt, null);
			jContentPane.add(getTxtEncryted(), null);
			jContentPane.add(lbnDecrypt_data, null);
			jContentPane.add(getTxtDecrypt_data(), null);
			jContentPane.add(getBtnEncryted(), null);
			jContentPane.add(getBtndecrypt_data(), null);
			
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtinputdata	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtinputdata() {
		if (txtinputdata == null) {
			txtinputdata = new JTextField();
			txtinputdata.setBounds(new Rectangle(15, 73, 258, 65));
		}
		return txtinputdata;
	}

	/**
	 * This method initializes txtEncryted	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtEncryted() {
		if (txtEncryted == null) {
			txtEncryted = new JTextField();
			txtEncryted.setBounds(new Rectangle(16, 196, 255, 58));
		}
		return txtEncryted;
	}

	/**
	 * This method initializes txtDecrypt_data	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtDecrypt_data() {
		if (txtDecrypt_data == null) {
			txtDecrypt_data = new JTextField();
			txtDecrypt_data.setBounds(new Rectangle(14, 321, 258, 61));
		}
		return txtDecrypt_data;
	}

	/**
	 * This method initializes btnEncryted	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnEncryted() {
		if (btnEncryted == null) {
			btnEncryted = new JButton();
			btnEncryted.setBounds(new Rectangle(84, 148, 93, 30));
			btnEncryted.setText("Encryted");
			btnEncryted.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					
						
					
						
						try {
							objCiper.init(Cipher.ENCRYPT_MODE,sKey);
							byte[] text = txtinputdata.getText().getBytes();
							byte[] encryptedData = objCiper.doFinal(text);
							
							String encryptedText = new String(encryptedData);
							
							txtEncryted.setText(encryptedText);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
					
				
				}
			});
		}
		return btnEncryted;
	}

	/**
	 * This method initializes btndecrypt_data	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtndecrypt_data() {
		if (btndecrypt_data == null) {
			btndecrypt_data = new JButton();
			btndecrypt_data.setBounds(new Rectangle(106, 270, 120, 37));
			btndecrypt_data.setText("Decrypt_data");
			btndecrypt_data.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
						
						
						try {
							objCiper.init(Cipher.DECRYPT_MODE,sKey);
							byte[] text = txtEncryted.getText().getBytes();
							byte[] encryptedData = objCiper.doFinal(text);
							
							String encryptedText = new String(encryptedData);
							
							txtDecrypt_data.setText(encryptedText);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
					
				
				}
			});
		}
		return btndecrypt_data;
	}

}
