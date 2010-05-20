package tamgiac;

import java.util.Scanner;

public class Diem {
	
	public int toaDoX ;
	public int toaDoY ;
	
	public Diem(){
		
	}
	
	public void nhapToaDo(){
		Scanner input = new Scanner(System.in);
		System.out.println("Hay Nhap Toa Do Diem X :");
		this.toaDoX = input.nextInt();
		System.out.println("Hay Nhap Toa Do Diem Y :");
		this.toaDoY = input.nextInt();
	}
	
	public double tinhKhoangCach(Diem B){
		double kq = 0.0 ;
		kq = Math.sqrt(((this.toaDoX - B.toaDoX) * (this.toaDoX - B.toaDoX)) 
				+ ((this.toaDoY - B.toaDoY)*(this.toaDoY - B.toaDoY))) ; 
		return kq;
	}
}
