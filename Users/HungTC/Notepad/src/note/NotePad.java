package note;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import common.Constants;

public class NotePad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JMenuBar menuBar;
	JMenu fileMenu, editMenu, languageMenu , sizeMenu;
	JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem,
			copyMenuItem, cutMenuItem, pasteMenuItem, mailMenuItem, viMenuItem,
			enMenuItem,fontMenuItem;
	JTextArea textArea;
	JPanel panel;

	public NotePad(String str) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Constants.initBundle();
		creatPane(str);

	}

	public void creatPane(String str) {
		this.setTitle("MiniNotePad");
		this.setLayout(new BorderLayout());
		this.setSize(500, 500);
		this.setLocation(20, 20);

		// panel = new JPanel();
		// panel.setBackground(Color.white);
		// getContentPane().add(panel);

		
		
		textArea = new JTextArea(str,50,70);


		textArea.setFont(new Font(Constants.FONTS,0,Integer.parseInt(Constants.SIZES)));

		
		textArea.setBorder(BorderFactory.createTitledBorder("Your text"));
		JScrollPane sc = new JScrollPane(textArea);
		Box bx ;
		bx = Box.createHorizontalBox();
		bx.add(sc);
		this.add(bx, BorderLayout.CENTER);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);

		fileMenu = new JMenu(Constants.BUNDLE.getString("file"));
		fileMenu.setBackground(Color.white);
		menuBar.add(fileMenu);

		editMenu = new JMenu(Constants.BUNDLE.getString("edit"));
		editMenu.setBackground(Color.white);
		menuBar.add(editMenu);

		// **************send mail**********************

		mailMenuItem = new JMenuItem(Constants.BUNDLE.getString("mail"));
		mailMenuItem.setBackground(Color.white);
		mailMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new SendMail(textArea.getText());
			}

		});
		fileMenu.add(mailMenuItem);

		// **********end of send mail*****************

		// **************new**********************
		newMenuItem = new JMenuItem(Constants.BUNDLE.getString("new"));
		newMenuItem.setBackground(Color.white);
		newMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int newInt = JOptionPane.showConfirmDialog(null,
						Constants.BUNDLE.getString("confirmNew"));
				if (newInt == 0) {
					save();
					new NotePad("");
					Constants.exitPreFrom();
				} else if (newInt == 1) {
					new NotePad("");
					Constants.exitPreFrom();
				}

			}

		});
		fileMenu.add(newMenuItem);
		// **************end of new **********************

		// open file************************************
		openMenuItem = new JMenuItem(Constants.BUNDLE.getString("open"));
		openMenuItem.setBackground(Color.white);
		openMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				open();
			}

		});
		fileMenu.add(openMenuItem);
		// ***************************end of open file

		// language*******************************
		languageMenu = new JMenu(Constants.BUNDLE.getString("language"));
		languageMenu.setBackground(Color.white);
		// vietnammese
		viMenuItem = new JMenuItem("vietnamese");
		viMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				changeLanguage(2);

			}

		});
		languageMenu.add(viMenuItem);
		// English
		enMenuItem = new JMenuItem("english");
		enMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeLanguage(1);
			}

		});

		languageMenu.add(enMenuItem);
		fileMenu.add(languageMenu);
		// *****************************end of language

		// save file************************************
		saveMenuItem = new JMenuItem(Constants.BUNDLE.getString("save"));
		saveMenuItem.setBackground(Color.white);
		saveMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				save();

			}

		});
		fileMenu.add(saveMenuItem);
		// ************************************end of save

		// exit************************************
		exitMenuItem = new JMenuItem(Constants.BUNDLE.getString("exit"));
		exitMenuItem.setBackground(Color.white);
		exitMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textArea.getText().length() < 1) {
					System.exit(1);
				} else if (textArea.getText() != null) {
					int temp = JOptionPane.showConfirmDialog(null,
							Constants.BUNDLE.getString("confirmExit"));
					if (temp == 0) {
						try {
							String selFile = "NotePad.txt";
							PrintWriter out = new PrintWriter(
									new FileOutputStream(selFile), true);
							out.print(textArea.getText());
							out.close();
							System.exit(1);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if (temp == 1) {
						System.exit(1);
					}
				}
			}

		});
		fileMenu.add(exitMenuItem);
		// *********************end of exit

		// copy**********************
		copyMenuItem = new JMenuItem(Constants.BUNDLE.getString("copy"));
		copyMenuItem.setBackground(Color.white);
		copyMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.copy();
			}

		});
		editMenu.add(copyMenuItem);
		// **************end of copy

		// cut**********************
		cutMenuItem = new JMenuItem(Constants.BUNDLE.getString("cut"));
		cutMenuItem.setBackground(Color.white);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.cut();
			}

		});
		editMenu.add(cutMenuItem);
		// **************end of cut

		// paste**********************
		pasteMenuItem = new JMenuItem(Constants.BUNDLE.getString("paste"));
		pasteMenuItem.setBackground(Color.white);
		pasteMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.paste();
			}

		});
		editMenu.add(pasteMenuItem);
		// **************paste

		// font**********************
		fontMenuItem = new JMenuItem("Font");
		fontMenuItem.setBackground(Color.white);
		fontMenuItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FontForm(textArea.getText());
				}
			
		});

		editMenu.add(fontMenuItem);
		// **************end of font
		
		setJMenuBar(menuBar);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new NotePad("");
	}

	// ****************methods**************
	public void save() {
		JFileChooser file = new JFileChooser();
		if (file.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			;
		try {
			String selFile = file.getSelectedFile().getAbsolutePath() + ".txt";
			PrintWriter out = new PrintWriter(new FileOutputStream(selFile),
					true);
			out.print(textArea.getText());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		JFileChooser file = new JFileChooser();
		if (file.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				String selFile = file.getSelectedFile().getAbsolutePath();
				Scanner scanner = new Scanner(new FileInputStream(selFile),
						"UTF-8");
				String line = "";
				while (scanner.hasNextLine()) {
					line += scanner.nextLine();
					textArea.setText(line);
					scanner.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void changeLanguage(int numberOfLanguage) {
		Constants.LANGUAGE = numberOfLanguage;
		new NotePad(textArea.getText());
		Constants.exitPreFrom();
	}
}
