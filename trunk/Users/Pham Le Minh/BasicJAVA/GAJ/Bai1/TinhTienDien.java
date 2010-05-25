package javaadvanced.Bai1;
import java.util.*;
public class TinhTienDien {

    public static void main(String[] args) {
        int luongDien = 0;
        int gia1 = 550;
        int gia2 = 1200;
        int gia3 = 1500;
        long thanhTien = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("CHUONG TRINH TINH TIEN DIEN");
        System.out.println("Nhap so ki dien ban su dung ");
        luongDien = input.nextInt();
        if (luongDien < 100)
        {
            thanhTien = luongDien * gia1;
            System.out.println("So tien ban phai tra la :" + thanhTien);
        }
        else if (luongDien <= 150)
        {
           thanhTien = ((luongDien - 100)*gia2+100*gia1);
           System.out.println("So tien ban phai tra la :" + thanhTien);
        }
        else if (luongDien > 150)
        {
            thanhTien = ((luongDien - 150)*gia3+50*gia2+100*gia3);
            System.out.println("So tien ban phai tra la :" + thanhTien);
        }
    }

}
