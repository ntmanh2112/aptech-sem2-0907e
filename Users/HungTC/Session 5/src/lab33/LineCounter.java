package lab33;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;

public class LineCounter extends Thread{
	String fileName;
	public LineCounter(String fileName){
		this.fileName = fileName;
	}
	public void run(){
		LineNumberReader numberLines;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			numberLines = new LineNumberReader(reader);
			int lines = numberLines.getLineNumber();
			System.out.println("your file name: "+ fileName+"; the number of lines = "+lines);
			
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
					}
		
		
		
	}

}
