package common;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextArea;

import frame.MainFrame;

public class Constants {

	public static int number = 2;
	public static Integer LANGUAGE = 0;
	public static Locale LOCALE;
	public static ResourceBundle BUNDLE;
	public static String duongDan = "";
	public static JTextArea txtArea = new JTextArea("",10,15);
	public static void initBundle() {
		switch (Constants.LANGUAGE) {
		case 0: {
			Constants.LOCALE = new Locale("EN", "US");
			Constants.BUNDLE = ResourceBundle.getBundle("EN", Constants.LOCALE);
			break;
		}
		case 1: {
			Constants.LOCALE = new Locale("VI", "VN");
			Constants.BUNDLE = ResourceBundle.getBundle("VI", Constants.LOCALE);
			break;
		}
		}
	}

	public static void exitPreForm() {
		int i = 0;
		i = MainFrame.getFrames().length;

		
				MainFrame.getFrames()[0].setVisible(false);
				MainFrame.getFrames()[0].dispose();
			
		
	}

}
