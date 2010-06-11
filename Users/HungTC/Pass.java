package password;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pass {
public Pass(){
	
}

	public static void main(String[] str) {
		boolean loops = true;
		Scanner input = new Scanner(System.in);
		while(loops){
			System.out.println("enter your password: ");
			String password = input.nextLine();
		loops = check(password);
		}
		
		
	}

	public static Boolean check(String password) {
		String regex = "\\s";
		 Pattern pattern0 = Pattern.compile(regex);
		Matcher matcher = pattern0.matcher(password);
		 if (matcher.find()) {
		 System.out.println("du khoang trang vui long danh pass ko co khoang trang");
		 return true;
		 }
		 

		 regex = "[A-Z]";

		Pattern pattern = Pattern.compile(regex);

		 matcher = pattern.matcher(password);
		if (!matcher.find()) {
			System.out.println("thieu ky tu hoa");return true;
		}

		regex = "[a-z]";
		Pattern pattern1 = Pattern.compile(regex);
		matcher = pattern1.matcher(password);
		if (!matcher.find()) {
			System.out.println("thieu ky tu thuong");return true;
		}

		regex = "[0-9]";
		Pattern pattern2 = Pattern.compile(regex);
		matcher = pattern2.matcher(password);
		if (!matcher.find()) {
			System.out.println("thieu so");return true;
		}

		regex = "[^a-zA-Z0-9]";
		Pattern pattern3 = Pattern.compile(regex);
		matcher = pattern3.matcher(password);
		if (!matcher.find()) {
			System.out.println("thieu ki tu dac biet");
			return true;
		}

		if (password.length() < 6 || password.length() > 30) {
			System.out.println("pass chi chua 6-30 ki tu");
			return true;
		}
		return false;
	}
	
	

}
