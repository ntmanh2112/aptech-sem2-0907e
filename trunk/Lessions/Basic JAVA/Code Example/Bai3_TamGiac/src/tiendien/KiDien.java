package tiendien;

import java.util.Scanner;

public class KiDien {
	public double kiDien;
	public KiDien() {
		
	}
	public void nhapSoKiDien() {
		Scanner input = new Scanner(System.in);
		System.out.println("Hay nhap so ki dien ");
		this.kiDien = input.nextDouble();		
	}
	public double tinhTienDien(){
		double tienDien=0;
		double bieuGia=0;
		if(kiDien<100)
        {
			bieuGia=550;
        }
        else if(kiDien>=100&&kiDien<150)
        {
        	bieuGia=1200;
        }
         else if(kiDien>=150)
        {
        	 bieuGia=1500;
        }
         else{
        	 bieuGia=0;
         }
		tienDien = kiDien* bieuGia ;
        return tienDien;
	}
}
