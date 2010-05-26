package bai5;

import java.util.Random;
import java.util.Scanner;

public class NhanVien {
	
	public int EmployeeID;
	public int Day;
	public int Month;
	public int Year;
	
	public int Designation;
	public String chucVu = "";
	public String Salary = "";
	public String EmployeeName = "";
	public Scanner input = new Scanner(System.in);
	
	public NhanVien(){
		
	}
	public void Empid(){
		Random rand = new Random();
		EmployeeID = rand.nextInt(100);
	}
	public void EmpName(){
		System.out.println("Nhap ten Nhan Vien :");
	    EmployeeName = input.nextLine();
	    
	    if(EmployeeName.length() > 40 || EmployeeName.length() <= 0)
	    {
	    	this.EmpName();
	    }
	    else{
	    	
	    }
	}
	public void day(){
		 System.out.println("Nhap Ngay Sinh :");
	     Day = input.nextInt();
	}
	public void mounth(){
		 System.out.println("Nhap Thang Sinh:");
	     Month = input.nextInt();
	}
	public void year(){
		 System.out.println("Nhap Nam Sinh:");
	     Year = input.nextInt();
	     if((2010 - Year) <18){
	    	 System.out.println("So Tuoi Cua Ban Nho Hon 18. Yeu Cau Nhap Lai");
	    	 this.day();
	    	 this.mounth();
	    	 this.year();
	     }
	}
	public void Chuc(){
		System.out.println("Nhap chuc vu cua Nhan Vien :\n" +
	               "1. GL (Group Leader)\n" +
	               "2. PM (Project Manager)\n" +
	               "3. DEV (Developer)");
	       Designation = input.nextInt();
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
