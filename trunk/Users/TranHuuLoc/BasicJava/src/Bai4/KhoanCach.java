package Bai4;

public class KhoanCach {
	public Diem A,B,C;
	public double AB,AC,BC;
	
	public void timKhoanCach()	{
		this.A=new Diem("A");
		this.B=new Diem("B");
		this.C=new Diem("Loc");
		this.A.nhapToaDo();
		this.B.nhapToaDo();
		this.C.nhapToaDo();
		this.AB=this.A.tinhKhoangCach(B);
		this.AC=this.A.tinhKhoangCach(C);
		this.BC=this.B.tinhKhoangCach(C);
		System.out.println("AB = "+AB);
		System.out.println("AC = "+AC);
		System.out.println("BC = "+BC);
		if(AB<AC&&AB<BC)
			System.out.println("AB la canh nho nhat co gia tri la: "+AB);
		else if(AC<AB&&AC<BC)
			System.out.println("AC la canh nho nhat co gia tri la: "+AC);
		else if(BC<AC&&BC<AB)
			System.out.println("BC la canh nho nhat co gia tri la: "+BC);
	}
}
