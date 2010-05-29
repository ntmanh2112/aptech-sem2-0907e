package Bai3;

public class TamGiac {

	public Diem diemA;
	public Diem diemB;
	public Diem diemC;
	
	public double canhAB;
	public double canhBC;
	public double canhAC;
	
	
	public TamGiac() {
		this.diemA = new Diem("A");
		this.diemB = new Diem("B");
		this.diemC = new Diem("C");
	}
	
	
	public void nhapDiem() {
		this.diemA.nhapToaDo();
		this.diemB.nhapToaDo();
		this.diemC.nhapToaDo();
	}		
	
	public void tinhCanh() {
		this.canhBC = this.diemB.tinhKhoangCach(this.diemC);
		this.canhAC = this.diemA.tinhKhoangCach(this.diemC);
		this.canhAB = this.diemB.tinhKhoangCach(this.diemA);
	}
	
	public double tinhChuVi() {
		double cv;
		
		this.tinhCanh();
		
		cv = this.canhAB + this.canhAC + this.canhBC;
		cv=lamtron(cv,2);
		return cv;
	}
	
	public double tinhDienTich() {
		double dt;
		double p = this.tinhChuVi()/2;
		this.tinhCanh();
		
		dt = Math.sqrt(Math.abs(p * (p - this.canhBC) * (p - this.canhAC) * p - this.canhAB));
		dt=lamtron(dt,2);return dt;
		
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
