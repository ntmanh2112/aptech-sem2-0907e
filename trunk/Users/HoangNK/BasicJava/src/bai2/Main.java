package bai2;

public class Main {
	public static void main(String[] args){
		KiDien kd=new KiDien();
		kd.nhapSoKiDien();
		double td=kd.tinhTienDien();
		System.out.println("So tien dien trong thang "+ td);
	}
}
