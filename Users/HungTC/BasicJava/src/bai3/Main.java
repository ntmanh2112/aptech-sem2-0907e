package bai3;

public class Main {

	public static void main(String[] args) {
			
		TamGiac tg = new TamGiac();
		tg.nhapDiem();
		
		double cv = tg.tinhChuVi();
		double dt = tg.tinhDienTich();
		
		System.out.print("The triangle perimeter= " + cv + " the triangle area = " + dt);
	}

}

