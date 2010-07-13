package frame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



import common.Constants;

public class MainFrame extends JFrame{
	
	
	private TxtArea tar;
	private JMenuBar jmenubar;
	private Container c;
	
	private JMenu file;
		private JMenuItem fileNew;
		private JMenuItem fileOpen;
		private JMenuItem fileSave;
		private JMenuItem fileSaveAs;
		private JMenuItem filePrint;
		private JMenuItem filePrintReview;
		private JMenuItem filePageSetup;
		private JMenuItem fileRecentFile;
		private JMenuItem fileExit;
	
	private JMenu edit;
		private JMenuItem editUndo;
		private JMenuItem editCut;
		private JMenuItem editCopy;
		private JMenuItem editPase;
		private JMenuItem editPaseSpecial;
		private JMenuItem editClear;
		private JMenuItem editSelectAll;
		private JMenuItem editFind;
		private JMenuItem editFindNext;
		private JMenuItem editReplace;
		private JMenuItem editLinks;
		private JMenuItem editObjectProperties;
		private JMenuItem editObject;
	
	
	private JMenu view;
		private JMenuItem viewToolBar;
		private JMenuItem viewFormatBar;
		private JMenuItem viewRuler;
		private JMenuItem viewStatusBar;
		private JMenuItem viewOption;
	
	private JMenu insert;
		private JMenuItem insertDate;
		private JMenuItem insertObject;

	private JMenu format;
		private JMenuItem formatFont;
		private JMenuItem formatBulletStyle;
		private JMenuItem formatParagraph;
		private JMenuItem formatTabs;
	
	private JMenu language;
		private JMenuItem la;
	private JMenu help;
		private JMenuItem helpTopics;
		private JMenuItem helpAboutWordPad;
		
	public MainFrame(){
		Constants.initBundle();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	
	public void init() {
		c = this.getContentPane();
		this.setLayout(new BorderLayout());
		this.setTitle(Constants.BUNDLE.getString("Title"));
		this.setSize(700, 700);
		
		this.menuBar();
		tar = new TxtArea();
		c.add(tar, BorderLayout.CENTER);
		
		ToolBar tbp = new ToolBar();
		c.add(tbp, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	
	public void menuBar(){
		jmenubar = new JMenuBar();
		language = new JMenu(Constants.BUNDLE.getString("language"));
			la =  new JMenuItem(Constants.BUNDLE.getString("la"));
			la.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (Constants.LANGUAGE == 0)
						Constants.LANGUAGE = 1;
					else 
						Constants.LANGUAGE = 0;
					new MainFrame();
				}
			});
		file = new JMenu(Constants.BUNDLE.getString("file"));
			fileNew = new JMenuItem(Constants.BUNDLE.getString("fileNew"));
			fileNew.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					tar.setTxtArea("");
				}
				
			});
			fileOpen = new JMenuItem(Constants.BUNDLE.getString("fileOpen"));
			fileOpen.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new OpenFile();
				}
			});
			fileSave = new JMenuItem(Constants.BUNDLE.getString("fileSave"));
			fileSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new SaveFile(tar.getTxtArea());
				}
			});
			fileSaveAs = new JMenuItem(Constants.BUNDLE.getString("fileSaveAs"));
			fileSaveAs.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Constants.duongDan = "";
					new SaveFile(tar.getTxtArea());
				}
			});
			filePrint = new JMenuItem(Constants.BUNDLE.getString("filePrint"));
			filePrintReview = new JMenuItem(Constants.BUNDLE.getString("filePrintReview"));
			filePageSetup = new JMenuItem(Constants.BUNDLE.getString("filePageSetup"));
			fileRecentFile = new JMenuItem(Constants.BUNDLE.getString("fileRecentFile"));
			fileExit = new JMenuItem(Constants.BUNDLE.getString("fileExit"));
			fileExit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Constants.exitPreForm();
				}
			});
		edit = new JMenu(Constants.BUNDLE.getString("edit"));
			editUndo = new JMenuItem(Constants.BUNDLE.getString("editUndo"));
			editCut = new JMenuItem(Constants.BUNDLE.getString("editCut"));
			editCopy = new JMenuItem(Constants.BUNDLE.getString("editCopy"));
			editPase = new JMenuItem(Constants.BUNDLE.getString("editPase"));
			editPaseSpecial = new JMenuItem(Constants.BUNDLE.getString("editPaseSpecial"));
			editClear = new JMenuItem(Constants.BUNDLE.getString("editClear"));
			editSelectAll = new JMenuItem(Constants.BUNDLE.getString("editSelectAll"));
			editFind = new JMenuItem(Constants.BUNDLE.getString("editFind"));
			editFindNext = new JMenuItem(Constants.BUNDLE.getString("editFindNext"));
			editReplace = new JMenuItem(Constants.BUNDLE.getString("editReplace"));
			editLinks = new JMenuItem(Constants.BUNDLE.getString("editLinks"));
			editObjectProperties = new JMenuItem(Constants.BUNDLE.getString("editObjectProperties"));
			editObject = new JMenuItem(Constants.BUNDLE.getString("editObject"));
		view = new JMenu(Constants.BUNDLE.getString("view"));
			viewToolBar = new JMenuItem(Constants.BUNDLE.getString("viewToolBar"));
			viewToolBar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ToolBar tbp = new ToolBar();
					c.add(tbp, BorderLayout.NORTH);
					
				}
			});
			viewFormatBar = new JMenuItem(Constants.BUNDLE.getString("viewFormatBar"));
			viewRuler = new JMenuItem(Constants.BUNDLE.getString("viewRuler"));
			viewStatusBar = new JMenuItem(Constants.BUNDLE.getString("viewStatusBar"));
			viewOption = new JMenuItem(Constants.BUNDLE.getString("viewOption"));
		insert = new JMenu(Constants.BUNDLE.getString("insert"));
			insertDate = new JMenuItem(Constants.BUNDLE.getString("insertDate"));
			insertObject = new JMenuItem(Constants.BUNDLE.getString("insertObject"));
		format = new JMenu(Constants.BUNDLE.getString("format"));
			formatFont = new JMenuItem(Constants.BUNDLE.getString("formatFont"));
			formatBulletStyle = new JMenuItem(Constants.BUNDLE.getString("formatBulletStyle"));
			formatParagraph = new JMenuItem(Constants.BUNDLE.getString("formatParagraph"));
			formatTabs = new JMenuItem(Constants.BUNDLE.getString("formatTabs"));
		help = new JMenu(Constants.BUNDLE.getString("help"));
			helpTopics = new JMenuItem(Constants.BUNDLE.getString("helpTopics"));
			helpAboutWordPad = new JMenuItem(Constants.BUNDLE.getString("helpAboutWordPad"));	
			
		file.add(fileNew);
		file.add(fileOpen);
		file.add(fileSave);
		file.add(fileSaveAs);
		file.add(filePrint);
		file.add(filePrintReview);
		file.add(filePageSetup);
		file.add(fileRecentFile);
		file.add(fileExit);
		
		edit.add(editUndo);	
		edit.add(editCut);
		edit.add(editCopy);
		edit.add(editPase);
		edit.add(editPaseSpecial);
		edit.add(editClear);
		edit.add(editSelectAll);
		edit.add(editFind);
		edit.add(editFindNext);
		edit.add(editReplace);
		edit.add(editLinks);
		edit.add(editObjectProperties);
		edit.add(editObject);
		
		view.add(viewToolBar);
		view.add(viewFormatBar);
		view.add(viewRuler);
		view.add(viewFormatBar);
		view.add(viewOption);
		
		insert.add(insertDate);
		insert.add(insertObject);
		
		format.add(formatFont);
		format.add(formatBulletStyle);
		format.add(formatParagraph);
		format.add(formatTabs);
		
		language.add(la);
		
		help.add(helpTopics);
		help.add(helpAboutWordPad);
		
		jmenubar.add(file);
		jmenubar.add(edit);
		jmenubar.add(view);
		jmenubar.add(insert);
		jmenubar.add(format);
		jmenubar.add(language);
		jmenubar.add(help);
		
		this.setJMenuBar(jmenubar);
		
	}
	public static void main(String[] args) {
		new MainFrame();
	}
}
