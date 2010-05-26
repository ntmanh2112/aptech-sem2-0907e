package diemtrungbinh;

public class Main {
	public static void main(String[] args) {
		HocSinh hs = new HocSinh();
		hs.nhapDiem();
		
		float dtb = hs.tinhDiemTrungBinh();
		String xl = hs.xepLoai(); 
		
		System.out.println("Hoc Sinh : "+ hs.getHoTen() + "Diem trung binh cua Hoc sinh la : " + dtb + " Xep loai Hoc sinh " + xl);
	}
}
