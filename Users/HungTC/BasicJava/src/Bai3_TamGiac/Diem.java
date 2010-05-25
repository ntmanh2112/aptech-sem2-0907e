package Bai3_TamGiac;

import java.util.Scanner;
import MyMath.*;
public class Diem {

	public int x,y;
	public String name;
	//constructor
	public Diem(String name){
		this.name=name;
	}
	
	
	
	
	public void nhapToaDo(){

		Scanner input= new Scanner(System.in);
		System.out.print(name+": input X coordinate");
		this.x=input.nextInt();
		System.out.print(name+": input Y coordinate");
		this.y=input.nextInt();
	}
	public double tinhKhoangCach(Diem B){
		double kc;
		kc= Math.sqrt(Math.pow(2, (this.x-B.x))+Math.pow(2, (this.x-B.x)));
		kc=LamTronSoThapPhan.roundNumber(kc,2);
		return kc;
	}
}
