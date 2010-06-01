package Bai3;

public class Main {
public static void main(String[] args){
	double a,b;
	TamGiac TG=new TamGiac();
	TG.nhapDiem();
	a=TG.tinhchuvi();
	b=TG.tinhdientich();
	
	System.out.println("chu vi tam giac la: " +a+"dien tich tam giac: "+b);
	TG.tinhcanh();
	
	}
}
