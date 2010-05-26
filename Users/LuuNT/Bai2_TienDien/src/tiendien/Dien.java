package tiendien;

import java.util.Scanner;

public class Dien {

	public int luongDien;
	public long thanhTien;
	
	public void nhapDien(){
		Scanner input = new Scanner(System.in);
        System.out.println("CHUONG TRINH TINH TIEN DIEN");
        System.out.println("Nhap so ki dien ban su dung ");
        this.luongDien = input.nextInt();
	}

	public long tinhDien(){
		if (this.luongDien < 100)
        {
            this.thanhTien = this.luongDien * 550;
        }
        else if (this.luongDien <= 150)
        {
           thanhTien = ((this.luongDien - 100)*1200+100*550);
        }
        else if (this.luongDien > 150)
        {
        	this.thanhTien = ((this.luongDien - 150)*1500+50*1200+100*1500);
        }
		return thanhTien;
	}
}
