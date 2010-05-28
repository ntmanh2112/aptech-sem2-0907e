package bai5;

import java.util.Random;
import java.util.Scanner;

public class NhanVien {
	
	public int EmployeeID;
	public int YearOld;
	public int Designation;
	public int YearServed;
	public String chucVu = new String();
	public String Luong = new String();
	public String EmployeeName = new String();
	public Scanner input = new Scanner(System.in);
	
	public void Emp(){
		Random rand = new Random();
		EmployeeID = rand.nextInt(100);
	}
	public void Empl(){
		System.out.println("Nhap ten Nhan Vien :");
	    EmployeeName = input.nextLine();
	    
	    if(EmployeeName.length() > 40 || EmployeeName.length() <= 0)
	    {
	    	this.Empl();
	    }
	    else{
	    	
	    }
	}
	public void YearOld(){
		 System.out.println("Nhap tuoi Nhap Vien :");
		 YearOld = input.nextInt();
		 while(YearOld<18){
			 System.out.println("Ban da nhap sai tuoi moi nhap lai");
			 YearOld = input.nextInt();
		 }
	}
	public void YearServed(){
		 System.out.println("Nhap tham nien lam viec :");
		 YearServed = input.nextInt();
		 while(YearServed<=1){
			 System.out.println("Ban da nhap sai tham nien moi nhap lai");
			 YearServed = input.nextInt();
		 }
	}
	public void ChucVu(){
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
	               Luong = "12tr - 20tr";
	               break;
	           }
	           case 2:
	           {
	               chucVu = "Project Manager";
	               Luong = "8tr - 12tr";
	               break;
	           }
	           case 3:
	           {
	               chucVu = "Developer";
	               Luong = "4tr - 8tr";
	               break;
	           }
	       }
	}
}
