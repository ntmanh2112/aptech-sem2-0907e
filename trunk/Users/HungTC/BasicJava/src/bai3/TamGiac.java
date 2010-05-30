package bai3;
import mymath.*;
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
		cv=SoThapPhan.roundNumber(cv,2);
		return cv;
	}
	
	public double tinhDienTich() {
		double dt;
		double p = this.tinhChuVi()/2;
		this.tinhCanh();
		
		dt = Math.sqrt(Math.abs(p * (p - this.canhBC) * (p - this.canhAC) * p - this.canhAB));
		dt=SoThapPhan.roundNumber(dt,2);
		return dt;
	}
}
