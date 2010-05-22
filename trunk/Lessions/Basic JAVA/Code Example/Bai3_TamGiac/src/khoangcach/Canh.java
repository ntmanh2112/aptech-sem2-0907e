package khoangcach;

import tamgiac.Diem;

public class Canh {
	public Diem diemA;
	public Diem diemB;
	public Diem diemC;
	
	public double canhAB;
	public double canhBC;
	public double canhAC;
	public double canhNhoNhat;
	public Canh() {
		this.diemA = new Diem();
		this.diemB = new Diem();
		this.diemC = new Diem();
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
		if((canhBC>canhAC)&&(canhAC>canhAB)){
			System.out.println("Canh nho nhat la AB "+canhAB);
			}
		else if((canhBC>canhAC)&&(canhAC<canhAB)){
			System.out.println("Canh nho nhat la AC "+canhAC);
			}
		else{
			System.out.println("Canh nho nhat la BC "+canhBC);
		}
	}
	
}
