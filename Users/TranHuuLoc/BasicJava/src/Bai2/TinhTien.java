package Bai2;

import java.util.*;

public class TinhTien {
	private double sodien;
	
	public TinhTien(){

		Scanner input=new Scanner(System.in);
		System.out.println("nhap so dien tieu thu trong thang: ");
		sodien=input.nextInt();
		
		if(sodien<100&&sodien>0)
			System.out.println("tien dien trong thang la: "+sodien*550 +" VND");
		else if(sodien>=100&&sodien<=150)
			System.out.println("tien dien trong thang la: "+sodien*1200 +" VND");
		else if(sodien>150)
			System.out.println("tien dien trong thang la: "+sodien*1500 +" VND");
		else if(sodien<0)
			System.out.println("dong ho dien ban bi hu roi");
		
	}

	
		
}
