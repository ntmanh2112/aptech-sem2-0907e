package Bai3;

import java.util.Scanner;
public class Diem {

	public int x,y;
	public String name;
	//constructor
	public Diem(String name){
		this.name=name;
	}
	
	
	
	
	public void nhapToaDo(){

		Scanner input= new Scanner(System.in);
		System.out.print("Nhap diem "+name+" cua toa do X: ");
		this.x=input.nextInt();
		System.out.print("Nhap diem "+name+" cua toa do Y: ");
		this.y=input.nextInt();
	}
	public double tinhKhoangCach(Diem B){
		double kc;
		kc= Math.sqrt(Math.pow(2, (this.x-B.x))+Math.pow(2, (this.x-B.x)));
		kc=lamtron(kc,3);
		return kc;
	}
	public static double lamtron(double number, int digit) {
		
		if (digit>0) {
			int temp = 1, i;
			for (i = 0; i < digit; i++)
			temp = temp*10;
			number = number*temp;
			number = Math.round(number);
			number = number/temp;
			return number;
		}
		
		else	
		return number;
		}
}

