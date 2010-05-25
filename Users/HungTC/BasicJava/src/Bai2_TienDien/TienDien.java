package Bai2_TienDien;
import java.util.*;
public class TienDien {
	public TienDien(){
		System.out.println("Wellcome, please input the KW: ");
		Scanner input = new Scanner(System.in);
		int money=input.nextInt();
		if(money<100){
			money=money*550;
			System.out.println(money+" VietNam Dollars");
		}
		else if(money>=100&&money<=150)
		{	money=money*1200;
			System.out.println(money+" VietNam Dollars");
		}
		else{
			money=money*1500;
			System.out.println(money+" VietNam Dollars");
		}
		
	}
}
