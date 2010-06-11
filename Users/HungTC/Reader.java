package filereading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reader {
	
	
	public static void main(String[] str) throws IOException{
		

		BufferedReader reader = new BufferedReader(new FileReader("F:\\WorkSpace\\password\\input.txt"));
		String line = reader.readLine();
		String content ="";
		while (line != null){
			content += line + "\\r\\n";
			line =reader.readLine();
			
		}
		
		
		System.out.println(content);
		
		
		BufferedWriter writer = new BufferedWriter( new FileWriter("F:\\WorkSpace\\password\\output.txt"));
		String check = "name";
		String check1 = "phone";
		Pattern pattern = Pattern.compile(check);

		Matcher matcher = pattern.matcher(content);
		if (matcher.find()) {
			content = matcher.replaceAll("ho ten: ");
		}
		Pattern pattern1 = Pattern.compile(check1);

		Matcher matcher1 = pattern1.matcher(content);
		
		if (matcher1.find()) {
			content = matcher1.replaceAll("dien thoai: ");
		}
		
		System.out.println(content);
		
		writer.write(content);
		writer.flush();
		writer.close();
		reader.close();
		
		
		
		
		
		
	}
	
	
	
}
