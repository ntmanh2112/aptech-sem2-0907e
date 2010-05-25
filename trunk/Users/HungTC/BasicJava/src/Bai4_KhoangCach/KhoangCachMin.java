package Bai4_KhoangCach;

public class KhoangCachMin {
	public Diem A,B,C;
	public double AB,AC,BC;
	
	public KhoangCachMin(){}
	
	public void timKhoangCachMin(){
		this.A=new Diem("A");
		this.B=new Diem("B");
		this.C=new Diem("C");
		this.A.nhapToaDo();
		this.B.nhapToaDo();
		this.C.nhapToaDo();
		this.AB=this.A.tinhKhoangCach(B);
		this.AC=this.A.tinhKhoangCach(C);
		this.BC=this.B.tinhKhoangCach(C);
		System.out.println("AB= "+AB+" AC= "+AC+" BC= "+BC+" Min distance is:");
		
		double min=Math.min(AB,Math.min(AC,BC));
		if(min==AB&&min==AC)
			System.out.print("AB=AC= "+min);
		else if(min==AB&&min==BC)
			System.out.print("AB=BC= "+min);
		else if(min==AC&&min==BC)
			System.out.print("AC=BC= "+min);
		else if(min==AB)
			System.out.print("AB= "+min);
		else if(min==AC)
			System.out.print("AC= "+min);
		else
			System.out.print("BC= "+min);
		
	}
}
