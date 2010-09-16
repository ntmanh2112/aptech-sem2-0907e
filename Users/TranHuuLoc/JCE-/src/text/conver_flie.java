package text;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class conver_flie extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component FileChooserDemo = null;
	private JPanel jContentPane = null;
	private JLabel lbntitle = null;
	private JLabel txtflie = null;
	private JLabel txtpass = null;
	private JPasswordField txtpassword = null;
	private JLabel lbndecryptor = null;
	private JLabel lbnfileD = null;
	private JLabel lbnPassD = null;
	private JTextField jTextField = null;
	private JButton btnbrowseE = null;
	private JButton btnEncryptor = null;
	private JButton btnbrowseD = null;
	private JButton btnDencryptor = null;
	private JTextField txtflieE = null;
	private JTextField txtflieD = null;
	private File file;

	/**
	 * This is the default constructor
	 */
	public conver_flie() {
		super();
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
			lbnPassD = new JLabel();
			lbnPassD.setBounds(new Rectangle(14, 271, 94, 34));
			lbnPassD.setText("JLabel");
			lbnfileD = new JLabel();
			lbnfileD.setBounds(new Rectangle(16, 226, 90, 33));
			lbnfileD.setText("JLabel");
			lbndecryptor = new JLabel();
			lbndecryptor.setBounds(new Rectangle(76, 181, 96, 17));
			lbndecryptor.setText("decryptor");
			txtpass = new JLabel();
			txtpass.setBounds(new Rectangle(17, 134, 103, 37));
			txtpass.setText("JLabel");
			txtflie = new JLabel();
			txtflie.setBounds(new Rectangle(16, 89, 104, 29));
			txtflie.setText("JLabel");
			lbntitle = new JLabel();
			lbntitle.setBounds(new Rectangle(11, 11, 656, 55));
			lbntitle.setText("password-bassed Encryted");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbntitle, null);
			jContentPane.add(txtflie, null);
			jContentPane.add(txtpass, null);
			jContentPane.add(getTxtpassword(), null);
			jContentPane.add(lbndecryptor, null);
			jContentPane.add(lbnfileD, null);
			jContentPane.add(lbnPassD, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getBtnbrowseE(), null);
			jContentPane.add(getBtnEncryptor(), null);
			jContentPane.add(getBtnbrowseD(), null);
			jContentPane.add(getBtnDencryptor(), null);
			jContentPane.add(getTxtflieE(), null);
			jContentPane.add(getTxtflieD(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtpassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtpassword() {
		if (txtpassword == null) {
			txtpassword = new JPasswordField();
			txtpassword.setBounds(new Rectangle(135, 135, 181, 33));
		}
		return txtpassword;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(120, 271, 196, 34));
		}
		return jTextField;
	}

	/**
	 * This method initializes btnbrowseE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnbrowseE() {
		if (btnbrowseE == null) {
			btnbrowseE = new JButton();
			btnbrowseE.setBounds(new Rectangle(375, 94, 104, 35));
			btnbrowseE.setText("Browse");
			btnbrowseE.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(FileChooserDemo);
					file = fc.getSelectedFile();
					txtflieE.setText(""+file);

					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return btnbrowseE;
	}

	/**
	 * This method initializes btnEncryptor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnEncryptor() {
		if (btnEncryptor == null) {
			btnEncryptor = new JButton();
			btnEncryptor.setBounds(new Rectangle(377, 137, 103, 34));
			btnEncryptor.setText("Encryptor");
			btnEncryptor.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					byte[] salt= {(byte)0xc7,(byte)0x73,(byte)0x21,(byte)0x8c,
							(byte)0x7e,(byte)0xc8,(byte)0xee,(byte)0x99
					};
					int count = 20;
					PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt,count);
					
					char[] password = txtpassword.getPassword();
					PBEKeySpec pbeKeySpec = new PBEKeySpec(password);
					
					try {
						SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
						SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);
						Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
						pbeCipher.init(Cipher.ENCRYPT_MODE,pbeKey,pbeParamSpec);
						
						String duongDan = txtflieE.getText();
						FileInputStream fileIn = new FileInputStream(duongDan);
						
						byte[] plainText = new byte[fileIn.available()];
						fileIn.read(plainText);
						
						byte[] encryptedText = pbeCipher.doFinal(plainText);
						String filename = new String("D:/encrypt.doc");
					
						FileOutputStream fileOut = new FileOutputStream(filename);
						
						fileOut.write(encryptedText);
						JOptionPane.showMessageDialog(null,"ghi flie thanh cong");
					}  catch (Exception e) {
						JOptionPane.showMessageDialog(null, "loi roi");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					
					
				}
			});
		}
		return btnEncryptor;
	}

	/**
	 * This method initializes btnbrowseD	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnbrowseD() {
		if (btnbrowseD == null) {
			btnbrowseD = new JButton();
			btnbrowseD.setBounds(new Rectangle(388, 232, 78, 26));
			btnbrowseD.setText("Browse");
		}
		return btnbrowseD;
	}

	/**
	 * This method initializes btnDencryptor	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnDencryptor() {
		if (btnDencryptor == null) {
			btnDencryptor = new JButton();
			btnDencryptor.setBounds(new Rectangle(384, 283, 89, 26));
			btnDencryptor.setText("Dencryptor");
		}
		return btnDencryptor;
	}

	/**
	 * This method initializes txtflieE	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtflieE() {
		if (txtflieE == null) {
			txtflieE = new JTextField();
			txtflieE.setBounds(new Rectangle(135, 90, 181, 34));
			txtflieE.setEnabled(false);
		}
		return txtflieE;
	}

	/**
	 * This method initializes txtflieD	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtflieD() {
		if (txtflieD == null) {
			txtflieD = new JTextField();
			txtflieD.setBounds(new Rectangle(125, 227, 190, 26));
			txtflieD.setEnabled(false);
		}
		return txtflieD;
	}

}
