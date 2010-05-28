package bai5;


public class ThongTinNhanVien {
	public NhanVien nv;
	
	public ThongTinNhanVien(){
		this.nv = new NhanVien();
	}
	public void nhapThongTin(){
		 this.nv.Emp();
		 this.nv.Empl();
		 this.nv.YearOld();
		 this.nv.ChucVu();
		 this.nv.YearServed();
	 }
	public void xuatThongTin(){
		System.out.println("---------------------------------HIEN THI THONG TIN NHAN VIEN--------------------------------");
	       System.out.println("ID Nhan Vien :" + nv.EmployeeID);
	       System.out.println("Ten Nhan Vien :" + nv.EmployeeName);
	       System.out.println("Tuoi Nhan Vien :" + nv.YearOld+ "tuoi");
	       System.out.println("Luong Nhan Vien :" +nv.YearServed);
	       System.out.println("Chuc vu Nhan Vien :" + nv.chucVu);
	       System.out.println("Luong Nhan Vien :" +nv.Luong);
	 }
	
}
