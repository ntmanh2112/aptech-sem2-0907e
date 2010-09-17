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

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class chuyenDoiFile extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Component FileChooserDemo = null;
	private JPanel jContentPane = null;
	private JLabel lbntitle = null;
	private JLabel lbnflieE = null;
	private JLabel lbnpassE = null;
	private JPasswordField txtpasswordE = null;
	private JLabel lbndecryptor = null;
	private JLabel lbnfileD = null;
	private JLabel lbnPassD = null;
	private JTextField txtpassD = null;
	private JButton btnbrowseE = null;
	private JButton btnEncryptor = null;
	private JButton btnbrowseD = null;
	private JButton btnDencryptor = null;
	private JTextField txtflieE = null;
	private JTextField txtflieD = null;
	private File fileSave,fileBro ;
	private JTextField txtSave = null;
	private JButton btnSave = null;

	/**
	 * This is the default constructor
	 */
 public chuyenDoiFile() {


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
			lbnPassD.setBounds(new Rectangle(12, 405, 94, 34));
			lbnPassD.setText("JLabel");
			lbnfileD = new JLabel();
			lbnfileD.setBounds(new Rectangle(15, 366, 90, 27));
			lbnfileD.setText("JLabel");
			lbndecryptor = new JLabel();
			lbndecryptor.setBounds(new Rectangle(14, 330, 96, 17));
			lbndecryptor.setText("decryptor");
			lbnpassE = new JLabel();
			lbnpassE.setBounds(new Rectangle(17, 134, 103, 37));
			lbnpassE.setText("password");
			lbnflieE = new JLabel();
			lbnflieE.setBounds(new Rectangle(16, 89, 104, 29));
			lbnflieE.setText("file");
			lbntitle = new JLabel();
			lbntitle.setBounds(new Rectangle(11, 11, 656, 55));
			lbntitle.setText("password-bassed Encryted");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbntitle, null);
			jContentPane.add(lbnflieE, null);
			jContentPane.add(lbnpassE, null);
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
			jContentPane.add(getTxtSave(), null);
			jContentPane.add(getBtnSave(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtpassword	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getTxtpassword() {
		if (txtpasswordE == null) {
			txtpasswordE = new JPasswordField();
			txtpasswordE.setBounds(new Rectangle(135, 135, 181, 33));
		}
		return txtpasswordE;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (txtpassD == null) {
			txtpassD = new JTextField();
			txtpassD.setBounds(new Rectangle(119, 405, 196, 34));
		}
		return txtpassD;
	}

	/**
	 * This method initializes btnbrowseE	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnbrowseE() {
		if (btnbrowseE == null) {
			btnbrowseE = new JButton();
			btnbrowseE.setBounds(new Rectangle(315, 90, 83, 35));
			btnbrowseE.setText("Browse");
			btnbrowseE.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					JFileChooser brow = new JFileChooser();
					int returnVal = brow.showOpenDialog(FileChooserDemo);
					fileBro = brow.getSelectedFile();
					txtflieE.setText(""+fileBro);

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
			btnEncryptor.setBounds(new Rectangle(165, 283, 103, 34));
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
					
					char[] password = txtpasswordE.getPassword();
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
						String filename = new String(""+txtSave);
					
						FileOutputStream fileOut = new FileOutputStream(filename);
						
						fileOut.write(encryptedText);
						JOptionPane.showMessageDialog(null,"ghi flie thanh cong");
					}  catch (Exception e) {
					JOptionPane.showMessageDialog(null, "ban chua chon noi de save");
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
			btnbrowseD.setBounds(new Rectangle(296, 367, 78, 26));
			btnbrowseD.setText("Browse");
			btnbrowseD.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser browD = new JFileChooser();
					int returnVal = browD.showOpenDialog(FileChooserDemo);
					fileBro = browD.getSelectedFile();
					txtflieD.setText(""+fileBro);
					//	System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
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
			btnDencryptor.setBounds(new Rectangle(182, 573, 89, 26));
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
			txtflieD.setBounds(new Rectangle(107, 367, 190, 26));
			txtflieD.setEnabled(false);
		}
		return txtflieD;
	}

	/**
	 * This method initializes txtSave	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtSave() {
		if (txtSave == null) {
			txtSave = new JTextField();
			txtSave.setBounds(new Rectangle(135, 181, 181, 28));
		}
		return txtSave;
	}

	/**
	 * This method initializes btnSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton();
			btnSave.setBounds(new Rectangle(315, 180, 76, 31));
			btnSave.setText("save");
			btnSave.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFileChooser save = new JFileChooser();
					int loc =save.showSaveDialog(FileChooserDemo);
					fileSave =save.getSelectedFile();
					txtSave.setText(""+fileSave);
					
				
					//stem.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
			

		}
		return btnSave;
	}

}  //  @jve:decl-index=0:visual-constraint="40,9"
