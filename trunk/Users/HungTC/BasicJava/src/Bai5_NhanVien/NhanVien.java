package Bai5_NhanVien;
import java.util.Scanner;
public class NhanVien {

	private int ID,years,chucVu;
	private String name,DOB,salary,tenChucVu;
	public NhanVien(){}
	public void setChucVu(int chucVu) {
		this.chucVu = chucVu;
	}
	public void setDOB(String dob) {
		DOB = dob;
	}
	public void setID(int id) {
		ID = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getChucVu() {
		return chucVu;
	}
	public String getDOB() {
		return DOB;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getSalary() {
		return salary;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public int getYears() {
		return years;
	}
	public void nhapThongTin(){
		Scanner input= new Scanner(System.in);
		System.out.println("nhap ID:");
		this.setID(input.nextInt());
		while(this.getID()<0){
			System.out.println("nhap sai, nhap lai ID:");
			this.setID(input.nextInt());
		}
		System.out.println("nhap ten:");
		this.setName(input.next());
		while(this.getName().length()>40){
			System.out.println("ten qua dai, nhap ten lai di:");
			this.setName(input.next());
		}
		
		System.out.println("nhap DOB(dd/mm/yyyy):");
		this.setDOB(input.next());
		int dd,mm,yyyy,tuoi;
		dd=Integer.parseInt(this.getDOB().substring(0,2));
		mm=Integer.parseInt(this.getDOB().substring(3,5));
		yyyy=Integer.parseInt(this.getDOB().substring(6));
		tuoi=2010-yyyy;
		while(dd<1||dd>31||mm<1||mm>12||tuoi>100||tuoi<18){
			System.out.println("nhapsai hoac chua du tuoi, nhap lai DOB(dd/mm/yyyy):");
			this.setDOB(input.next());
			dd=Integer.parseInt(this.getDOB().substring(0,2));
			mm=Integer.parseInt(this.getDOB().substring(3,5));
			yyyy=Integer.parseInt(this.getDOB().substring(6));
			tuoi=2010-yyyy;
		}
		
		System.out.println("chon ma so chuc vu:\n1.Group Leader\n2.Project manager\n3.Developer:");
		this.setChucVu(input.nextInt());		
		while(this.getChucVu()>3||this.getChucVu()<1){
			System.out.println("ban da nhap sai, nhap lai de. nhap chuc vu:\n1.Group Leader\n2.Project manager\n3.Developer:");
			this.setChucVu(input.nextInt());
		}
		switch(this.getChucVu()){
		case 1:
			this.setTenChucVu("Group Leader");
			this.setSalary("12-20tr");
			break;
		case 2:
			this.setTenChucVu("Project Manager");
			this.setSalary("8-12tr");
			break;
		case 3:
			this.setTenChucVu("Developer");
			this.setSalary("4-8tr");
			break;			
		default:
			break;
		}
		System.out.println("nhap kinh nghiem:");
		this.setYears(input.nextInt());
		while(this.getYears()<1){
			System.out.println("nhap sai,nhap lai kinh nghiem:");

			this.setYears(input.nextInt());
		}
		
	}
}
