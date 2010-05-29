package Bai3;

public class Main {

	public static void main(String[] args) {
			
		TamGiac tg = new TamGiac();
		tg.nhapDiem();
		
		double cv = tg.tinhChuVi();
		double dt = tg.tinhDienTich();
		
		System.out.println("Chu vi cua tam giac = " + cv);
		System.out.print("Dien tich1 cua tam giac = " + dt);
	}

}
