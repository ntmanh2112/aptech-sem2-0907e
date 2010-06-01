/**
 * 
 */
package tamgiac;

import java.util.Scanner;

/**
 * @author ThienVD
 *
 */
public class Diem {
	
	/*
	 *  Khai bao thuoc tinh
	 */
	public int toaDoX;
	public int toaDoY;
	
	/*
	 * Ham khoi tao (dung - Constructor)
	 */
	public Diem() {
		
	}
	
	/*
	 * Hanh dong cua class Diem
	 */
	public void nhapToaDo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hay nhap toa do diem X");
		this.toaDoX = input.nextInt();
		System.out.println("Hay nhap toa do diem Y");
		this.toaDoY = input.nextInt();		
	}
	
	public double tinhKhoangCach(Diem B) {
		double kc = 0.0;
		kc = Math.sqrt((this.toaDoX - B.toaDoX) * (this.toaDoX - B.toaDoX) 
						+ (this.toaDoY - B.toaDoY) * (this.toaDoY - B.toaDoY));
		return kc;
	}
}
