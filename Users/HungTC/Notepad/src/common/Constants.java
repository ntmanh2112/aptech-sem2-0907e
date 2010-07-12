package common;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;

public class Constants {
	public static Integer LANGUAGE = 1; // Vi=2 En=1
	public static Locale LOCALE;
	public static ResourceBundle BUNDLE;// xu li 2 file
	
	public static String FONTS="Times New Roman",SIZES="13";

	public static void initBundle() {
		switch (Constants.LANGUAGE) {
		case 1:
			changeLanguage("En", "US");
			break;
		case 2:
			changeLanguage("Vi", "VN");
			break;
		default:
			changeLanguage("En", "US");
			break;
		}

	}

	public static void changeLanguage(String lang, String nation) {
		Constants.LOCALE = new Locale(lang, nation);
		Constants.BUNDLE = ResourceBundle.getBundle(lang, Constants.LOCALE);
	}

	public static void exitPreFrom() {
		int i = 0;
		i = JFrame.getFrames().length;
		if (i > 1) {
			for (int j = 0; j < i - 1; j++) {
				JFrame.getFrames()[j].setVisible(false);

				JFrame.getFrames()[j].dispose();
			}

		}
	}
}
