package thongtinnhanvien;

import java.util.Random;
import java.util.Scanner;

public class NhanVien {
	
	public int EmployeeID;
	public int BirthDay;
	public int Designation;
	public String chucVu = new String();
	public String Salary = new String();
	public String EmployeeName = new String();
	public Scanner input = new Scanner(System.in);
	
	public void Emp(){
		Random rand = new Random();
		EmployeeID = rand.nextInt(100);
	}
	public void Empl(){
		System.out.println("Nhap ten Nhan Vien :");
	    this.EmployeeName = input.nextLine();
	    
	    if(EmployeeName.length() > 40 || EmployeeName.length() <= 0)
	    {
	    	this.Empl();
	    }
	    else{
	    	
	    }
	}
	public void Bir(){
		 System.out.println("Nhap tuoi Nhap Vien :");
	     BirthDay = input.nextInt();
	}
	public void Chuc(){
		System.out.println("Nhap chuc vu cua Nhan Vien :\n" +
	               "1. GL (Group Leader)\n" +
	               "2. PM (Project Manager)\n" +
	               "3. DEV (Developer)");
	       this.Designation = input.nextInt();
	       switch(Designation)
	       {
	           case 1:
	           {
	               chucVu = "Group Leader";
	               Salary = "12tr - 20tr";
	               break;
	           }
	           case 2:
	           {
	               chucVu = "Project Manager";
	               Salary = "8tr - 12tr";
	               break;
	           }
	           case 3:
	           {
	               chucVu = "Developer";
	               Salary = "4tr - 8tr";
	               break;
	           }
	       }
	}
}
