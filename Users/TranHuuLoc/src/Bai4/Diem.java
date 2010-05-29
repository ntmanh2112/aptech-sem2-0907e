package Bai4;


import java.util.Scanner;
public class Diem {

	public int x,y;
	public String name;
	
	public Diem(String name){
		this.name=name;
	}
	
	
	
	
	public void nhapToaDo(){

		Scanner input= new Scanner(System.in);
		System.out.print("nhap toa do X cua diem "+ name+": ");
		this.x=input.nextInt();
		System.out.print("nhap toa do Y cua diem "+ name+": ");
		this.y=input.nextInt();
	}
	public double tinhKhoangCach(Diem B){
		double kc;
		kc= Math.sqrt(Math.pow(2, (this.x-B.x))+Math.pow(2, (this.x-B.x)));
		kc=lamtron(kc,2);
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
