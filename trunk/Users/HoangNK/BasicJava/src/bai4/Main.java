package bai4;

public class Main {
	
	public static void main(String[] args){
		Diem A=new Diem();
		Diem B=new Diem();
		Diem C=new Diem();
		double CanhAB;
		double CanhAC;
		double CanhBC;
		
		A.nhapToaDo();
		B.nhapToaDo();
		C.nhapToaDo();
		
		CanhAB=A.tinhKhoangCach(B);
		CanhAC=A.tinhKhoangCach(C);
		CanhBC=B.tinhKhoangCach(C);
		System.out.println("Do dai canh AB "+CanhAB);
		System.out.println("Do dai canh AC "+CanhAC);
		System.out.println("Do dai canh BC "+CanhBC);
		System.out.print("Canh nho nhat la canh "+Math.min(CanhAB,Math.min(CanhAC,CanhBC)));
		
	}
}
