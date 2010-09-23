package common;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextArea;


public class Constants {

	public static int number = 2;
	public static ResourceBundle SQL_RES = null;
	public static ResourceBundle SETING = null;
	public static Locale LOCALE;
	public static ResourceBundle BUNDLE;
	public static String duongDan = "";
	public static JTextArea txtArea = new JTextArea("",10,15);
	public static void initBundle() {
		
		Constants.SQL_RES = ResourceBundle.getBundle("sql");
		Constants.SETING = ResourceBundle.getBundle("seting");
		
		
	}

}
