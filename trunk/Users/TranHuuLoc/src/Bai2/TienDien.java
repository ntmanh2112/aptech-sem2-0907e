package Bai2;

import java.util.*;
public class TienDien {
	public TienDien(){
		System.out.println("So kw dien trong thang: ");
		Scanner input = new Scanner(System.in);
		int Tien=input.nextInt();
		if(Tien<100){
			Tien=Tien*550;
			System.out.println(Tien+" VND");
		}
		else if(Tien>=100&&Tien<=150)
		{	Tien=Tien*1200;
			System.out.println(Tien+" VND");
		}
		else{
			Tien=Tien*1500;
			System.out.println(Tien+" VND");
		}
		
	}
}
