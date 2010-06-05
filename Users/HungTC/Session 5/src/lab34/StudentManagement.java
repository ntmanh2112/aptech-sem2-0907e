package lab34;

import java.io.*;
import java.util.Scanner;


public class StudentManagement {
	static Student[] student = new Student[20];

	public static void main(String[] str) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		int choice;
		while (true) {
			System.out
					.println("Menu\n--------------\n1. Save to file\n2. Read file\n3. exit\nYour choice: ");
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			switch (choice) {
			case 1:
				try {
					inputInformation();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:

				ObjectInputStream in = new ObjectInputStream(
						new BufferedInputStream(new FileInputStream("F:\\WorkSpace\\Session 5\\src\\lab32\\sv.txt")));
				String strings = (String) in.readObject();
				System.out.println(strings);
				in.close();

				break;
			default:
				System.exit(1);
				break;
			}
		}
	}

	public static void inputInformation() throws FileNotFoundException,
			IOException {
		String contents = "";
		Scanner input = new Scanner(System.in);
		System.out.println("please input number of students(<20): ");
		int num = input.nextInt();
		ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("F:\\WorkSpace\\Session 5\\src\\lab32\\sv.txt")));
		
		
		for (int i = 0; i < num; i++) {
			student[i] = new Student(); 
			System.out.println(i + " please input name: ");
			String name = input.next();
			student[i].setName(name);
			System.out.println(i + " please input age: ");
			int age = input.nextInt();
			student[i].setAge(age);
			System.out.println(i + " please input mark: ");
			double mark = input.nextDouble();
			student[i].setMark(mark);

			contents += "\n " + student[i].getName() + "\t"
					+ student[i].getAge() + "\t" + student[i].getMark() + ".";
			
		}
		out.writeObject(contents);
			out.flush();	
			out.close();

	}

}
