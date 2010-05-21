package tinhtiendien;

import java.util.Scanner;

public class Dien {
	public int luongDien;
	public int giaDien1 = 550;
	public int giaDien2 = 1200;
	public int giaDien3 = 1500;
	public long thanhTien;
	Scanner input = new Scanner(System.in);
	public Dien(){
	}
	public void nhapLuongDien()
	{
		System.out.println("Nhap luong dien :");
		this.luongDien = input.nextInt();
	}
	public void tinhTienDien()
	{
		System.out.println("Luong dien la : " + this.luongDien);
		if (this.luongDien < 100)
        {
            thanhTien = luongDien * giaDien1;
            System.out.println("So tien ban phai tra la :" + thanhTien);
        }
        else
        if (this.luongDien <= 150)
        {
           thanhTien = ((luongDien - 100)*giaDien2+100*giaDien1);
           System.out.println("So tien ban phai tra la :" + thanhTien);
        }
        else
        if (this.luongDien > 150)
        {
            thanhTien = ((luongDien - 150)*giaDien3 +50*giaDien2+100*giaDien3);
            System.out.println("So tien ban phai tra la :" + thanhTien);
        }
	}
}
