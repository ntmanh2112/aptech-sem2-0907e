package Bai5;

import java.util.*;

public class Nhanvien {
	public int employeeId,day,moth,year,kinhNghiem,maChucVu;
	public String employeeName,salary,tenChucVu;
	public Scanner input=new Scanner(System.in);
	
	
	public Nhanvien()	{
		
	}
	public void setEmployeeId(int employeeId)	{
		this.employeeId=employeeId;
	}
	public int getEmployeeId()	{
		return employeeId;
	}
	public void setDay(int day){
		this.day=day;
	}
	public int getDay()	{
		return day;
	}
	public void setMoth(int moth)	{
		this.moth=moth;
	}
	public int getMoth()	{
		return moth;
	}
	public void setYear(int year)	{
		this.year=year;
	}
	public int getYear()	{
		return year;
	}
	public void setEmployeeName(String name)	{
		this.employeeName=name;
	}
	public String getEmployeeName()	{
		return employeeName;
	}
	public void setSalary(String salary)	{
		this.salary=salary;
	}
	public String getSalary()	{
		return salary;
	}
	public void setTenChucVu(String tenChucVu)	{
		this.tenChucVu=tenChucVu;
	}
	public String getTenChucVu()	{
		return tenChucVu;
	}
	public void setMaChucVu(int maChucVu)	{
		this.maChucVu=maChucVu;
	}
	public int getMaChucVu()	{
		return maChucVu;
	}
	public void setKinhNghiem(int kinhNghiem)	{
		this.kinhNghiem=kinhNghiem;
	}
	public int getKinhNghiem()	{
		return kinhNghiem;
	}
	public void nhapThongTin()	{
	//nhap id	
		System.out.println("Nhap ID vao di ban: ");
		this.setEmployeeId(input.nextInt());
		while(this.getEmployeeId()<1){
			System.out.println("nhap lai id ");
			this.setEmployeeId(input.nextInt());
		}
	
		//nhap ten
		System.out.println("nhap ten nhan vien(toi da 40 ky tu): ");
		this.setEmployeeName(input.next());
		while(employeeName.length()>40){
			System.out.println("ten ban wa dai nhap lai ten di: ");
			this.setEmployeeName(input.next());
		}
		
		//nhap ngay	
		System.out.println("nhap ngay sinh cua ban: ");
		this.setDay(input.nextInt());
		while (day<1||day>31){
			System.out.println("viet nam ko co ngay do,moi ban nhap lai");
		this.setDay(input.nextInt());
		}
		//nhap thang
		System.out.println("nhap thang sinh cua ban: ");
		this.setMoth(input.nextInt());
		while(moth<1||moth>12){
			System.out.println("viet nam ko co thang do,moi ban nhap lai");
			this.setMoth(input.nextInt());
		}
		//nhap nam
		System.out.println("nhap nam sinh cua ban: ");
		this.setYear(year=input.nextInt());
		while(2010-year<1||year<1970||year>3000){
		System.out.println("nhap lai nam sinh cua ban: ");
		this.setYear(year=input.nextInt());	
		}
		//nhap ma chuc vu
		System.out.println("moi ban chon ma cac chuc vu sau day:" +
				"\n1.Group Leader" +
				"\n2.Project manager" +
				"\n3.Developer:");
		this.setMaChucVu(input.nextInt());
		while(this.getMaChucVu()>3||this.getMaChucVu()<1){
			System.out.println("ko co chuc vu do ,moi ban nhap lai ");
			this.setMaChucVu(input.nextInt());
		}
		switch(this.getMaChucVu())	{
		case 1:
			this.setTenChucVu("Group Leader");
			this.setSalary("12tr-20tr");
			break;
		case 2:
			this.setTenChucVu("Project manager");
			this.setSalary("8tr-12tr");
			break;
		case 3:
			this.setTenChucVu("Deverloper");
			this.setSalary("4tr-8tr");
			break;
			default:
				break;
		}
		
		//nhap kinh nghiem
		System.out.println("Nhap nam kinh nghiem cua ban: ");
		this.setKinhNghiem(input.nextInt());
		while(kinhNghiem<1){
		System.out.println("nhap lai nam kinh nghiem di ban: ");
		this.setKinhNghiem(input.nextInt());
		}
		//output tat ca thong tin
		System.out.println("thong tin ca nhan cua nhan do:");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("employeeID: "+this.getEmployeeId());
		System.out.println("ten nhan vien: "+this.getEmployeeName());
		System.out.println("dd/mm/yyyy cua nhan vien: "+this.getDay()+"/"+this.getMoth()+"/"+this.getYear());
		System.out.println("chuc vu: "+this.getTenChucVu());
		System.out.println("Salary cua nhan vien do: "+this.getSalary());
		System.out.println("kinh nghiem lam vien la: "+this.kinhNghiem+ " nam");
	}
}
