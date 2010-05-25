package Bai5_NhanVien;

public class Main {
	public static void main(String[]agrs){

		NhanVien nv=new NhanVien();
		nv.nhapThongTin();
		System.out.println("thong tin\nId: "+nv.getID()+"\nname: "+nv.getName()+"\nDOB: "+nv.getDOB()+ "\nchuc vu: "+nv.getTenChucVu()+"\nnam kinh nghiem: "+nv.getYears()+"\nluong: "+nv.getSalary());
		
	}
}
