package bai1;
import java.util.Scanner;

public class HocSinh {
	private String hoTen = "";
	private float diemToan = 0;
	private float diemVan = 0;
	private float diemAnh = 0;
	private float diemTin = 0;
	
	/*
	 * 
	 */
	public HocSinh(String Ten, float Toan, float Van, float Anh, float Tin) {
		this.hoTen = Ten;
		this.diemToan = Toan;
		this.diemVan = Van;
		this.diemAnh = Anh;
		this.diemTin = Tin;
	}
	public HocSinh() {
		
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public void nhapDiem() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap ten Hoc Sinh ");
		this.setHoTen(input.nextLine());
		System.out.println("Nhap diem Toan ");
		this.diemToan = input.nextFloat();
		System.out.println("Nhap diem Van ");
		this.diemVan = input.nextFloat();
		System.out.println("Nhap diem Anh ");
		this.diemAnh = input.nextFloat();
		System.out.println("Nhap diem Tin ");
		this.diemTin = input.nextFloat();		
	}
	
	public float tinhDiemTrungBinh() {
		float dtb = 0;
		dtb = Math.round(((this.diemToan + this.diemVan + this.diemAnh) * 2 + this.diemTin) / 7);
		return dtb;
	}
	
	public String xepLoai() {
		String loai = "";
		float dtb = this.tinhDiemTrungBinh();
		if (dtb < 5) {
			loai = "yeu";
		}else
			if (dtb < 6) {
				loai = "Trung Binh";
			}else 
				if (dtb < 7){
					loai = "Trung Binh Kha";
				}else 
					if (dtb < 8){
						loai = "Kha";
					}else 
						if (dtb < 9){
							loai = "Gioi";
						}else 
							if (dtb <= 10){
								loai = "Xuat Sac";
							}else {
								System.out.println("Diem trung binh sai ");
							}
		return loai;
	}
}

