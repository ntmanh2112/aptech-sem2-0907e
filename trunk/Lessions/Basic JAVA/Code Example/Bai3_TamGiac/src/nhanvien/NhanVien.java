package nhanvien;

import java.util.Scanner;

public class NhanVien {
	public double ID;
	public String Ten;
	public double NgaySinh;
	public double ThangSinh;
	public double NamSinh;
	public String ChucVu;
	public double ThamNien;
	public NhanVien() {
		
	}
	public void NhapThongTin(){
		Scanner input = new Scanner(System.in);
		System.out.println("EmployeeID:");
		this.ID = input.nextDouble();
		System.out.println("EmployeeName:");
		this.TEN = input.nextString();
		System.out.println("Ngay sinh:");
		this.NgaySinh= input.nextDouble();
		System.out.println("Thang sinh:");
		this.ThangSinh= input.nextDouble();
		System.out.println("Nam sinh:");
		this.NamSinh= input.nextDouble();
		System.out.println("Designation :");
		this.ChucVu= input.nextString();
		
	}
}
