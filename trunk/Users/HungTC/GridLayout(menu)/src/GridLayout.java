import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GridLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageMenu image = new ImageMenu();
	TextArea text = new TextArea();
	StatusPanel status = new StatusPanel();
	JMenuBar menubar;
	JMenu menuFile;
	JMenu menuAction;
	JMenu menuHelp;
	JMenuItem menuFileNew;
	JMenuItem menuFileOpen;
	JMenuItem menuFileSave;
	JMenuItem menuFileProperti;
	JMenuItem menuFileExit;
	
	Icon ico1;
	Icon ico2;
	Icon ico3;
	Icon ico4;
	Icon ico5;
	Icon ico6;
	/**
	 * @param args
	 * @throws IOException
	 */
	public GridLayout() throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() throws IOException {

		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		menubar = new JMenuBar();

		ico1 = new ImageIcon("add.png");
		ico2 = new ImageIcon("edit.png");
		ico3 = new ImageIcon("change.png");
		ico4 = new ImageIcon("ok.png");
		ico5 = new ImageIcon("cancel.png");
		ico6 = new ImageIcon("cancer.png");
		
		menuFile = new JMenu("File");
		menuAction = new JMenu("Action");
		menuHelp = new JMenu("Help");
		
		
		menuFileNew = new JMenuItem("New",ico1);
		menuFileOpen= new JMenuItem("Open",ico2);
		menuFileSave= new JMenuItem("Save",ico3);
		menuFileProperti= new JMenuItem("Properti",ico4);
		menuFileExit = new JMenuItem("Exit",ico5);
		
		menuFile.add(menuFileNew);
		menuFile.add(menuFileOpen);
		menuFile.add(menuFileSave);
		menuFile.add(menuFileProperti);
		menuFile.add(menuFileExit);
		
		menubar.add(menuFile);
		menubar.add(menuAction);
		menubar.add(menuHelp);
		
		this.setJMenuBar(menubar);
		
		
		
		
		
		this.add(image, BorderLayout.NORTH);
		
		this.add(status,BorderLayout.SOUTH);
		this.add(text, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new GridLayout();
	}

}
