package bai1;

import java.util.Scanner;
public class HocSinh {
	public String hoTen = new String();
	public Double diemToan = 0.0;
	public Double diemVan = 0.0;
	public Double diemAnh = 0.0;
	public Double diemTin = 0.0;
	public Double diemTrungBinh = 0.0;
	public String xepLoai = new String();
	public Scanner input = new Scanner(System.in);
	public void hoTen(){
		System.out.println("Nhap ten hoc sinh :");
		hoTen = input.nextLine();
	    
	    if(hoTen.length() > 40 || hoTen.length() <= 0)
	    {
	    	this.hoTen();
	    }
	    else{
	    	
	    }
	}
	public void diemToan(){
		 System.out.println("Nhap diem toan :");
		 diemToan = input.nextDouble();
		 while(diemToan>10||diemToan<0){
			 System.out.println("Ban da nhap sai diem moi nhap lai");
			 diemToan = input.nextDouble();
		 }
	}
	public void diemVan(){
		 System.out.println("Nhap diem van :");
		 diemVan = input.nextDouble();
		 while(diemVan>10||diemVan<0){
			 System.out.println("Ban da nhap sai diem moi nhap lai");
			 diemVan = input.nextDouble();
		 }
	}
	public void diemAnh(){
		 System.out.println("Nhap diem anh :");
		 diemAnh = input.nextDouble();
		 while(diemAnh>10||diemAnh<0){
			 System.out.println("Ban da nhap sai diem moi nhap lai");
			 diemAnh = input.nextDouble();
		 }
	}
	public void diemTin(){
		 System.out.println("Nhap diem tin hoc :");
		 diemTin = input.nextDouble();
		 while(diemTin>10||diemTin<0){
			 System.out.println("Ban da nhap sai diem moi nhap lai");
			 diemTin = input.nextDouble();
		 }
	}
	public void xepLoai(){
		diemTrungBinh=((diemToan+diemAnh+diemVan)*2+diemTin)/7;
		if(diemTrungBinh<5){
			xepLoai="Yeu";
		}
		else if(diemTrungBinh<6){
			xepLoai="Trung binh";
		}
		else if(diemTrungBinh<7){
			xepLoai="Trung binh kha";
		}
		else if(diemTrungBinh<8){
			xepLoai="Kha";
		}
		else if(diemTrungBinh<9){
			xepLoai="Gioi";
		}
		else if(diemTrungBinh<10){
			xepLoai="Xuat sac";
		}
		else {
			xepLoai="";
		}
		System.out.println("So diem trung binh "+ diemTrungBinh+" ban xep loai "+ xepLoai);
	}
}
