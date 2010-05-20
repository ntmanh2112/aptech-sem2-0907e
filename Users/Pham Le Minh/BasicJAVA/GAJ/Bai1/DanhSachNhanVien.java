package javaadvanced.Bai1;
import java.util.*;
public class DanhSachNhanVien {
    public static void main(String[] args) {
       int EmployeeID = 0;
       String EmployeeName = new String();
       int BirthDay = 0;
       int Designation = 0;
       String chucVu = new String();
       String Salary = new String();
       Scanner input = new Scanner(System.in);
       Random rand = new Random();

       System.out.println("CHUONG TRINH HIEN THI THONG TIN NHAN VIEN");
       
       EmployeeID = rand.nextInt(100);
       System.out.println("Nhap ten Nhan Vien :");
       EmployeeName = input.nextLine();
       System.out.println("Nhap tuoi Nhap Vien :");
       BirthDay = input.nextInt();
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
       System.out.println("----------------------------------------------------------------------------------------------------");
       System.out.println("ID Nhan Vien :" + EmployeeID);
       System.out.println("Ten Nhan Vien :" + EmployeeName);
       System.out.println("Tuoi Nhan Vien :" + BirthDay);
       System.out.println("Chuc vu Nhan Vien :" + chucVu);
       System.out.println("Luong trung binh Nhan Vien :" + Salary);
    }

}
