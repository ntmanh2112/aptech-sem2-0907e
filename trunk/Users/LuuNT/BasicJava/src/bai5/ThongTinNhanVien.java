package bai5;


public class ThongTinNhanVien {
	public NhanVien nv;
	
	public ThongTinNhanVien(){
		this.nv = new NhanVien();
	}
	public void nhapThongTin(){
		 this.nv.Empid();
		 this.nv.EmpName();
		 this.nv.day();
		 this.nv.mounth();
		 this.nv.year();
		 this.nv.Chuc();
	 }
	public void xuatThongTin(){
		System.out.println("----------------------------------------------------------------------------------------------------");
	       System.out.println("ID Nhan Vien :" + nv.EmployeeID);
	       System.out.println("Ten Nhan Vien :" + nv.EmployeeName);
	       System.out.println("Tuoi Nhan Vien :" + nv.Day +"/"+nv.Month+"/"+nv.Year);
	       System.out.println("Chuc vu Nhan Vien :" + nv.chucVu);
	       System.out.println("Luong trung binh Nhan Vien :" +nv.Salary);
	 }
	
}
