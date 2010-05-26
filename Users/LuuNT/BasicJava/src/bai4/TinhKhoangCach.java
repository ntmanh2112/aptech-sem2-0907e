package bai4;

import bai3.Diem;

public class TinhKhoangCach {

	public Diem diemA ;
	public Diem diemB ;
	public Diem diemC ;
	
	public double canhAB;
	public double canhBC;
	public double canhAC;
	
	public TinhKhoangCach() {
		this.diemA = new Diem();
		this.diemB = new Diem();
		this.diemC = new Diem();
	}
	 public void nhapDiem(){
		 this.diemA.nhapToaDo();
		 this.diemB.nhapToaDo();
		 this.diemC.nhapToaDo();
	 }
	 public void tinhCanh(){
		 this.canhBC = this.diemB.tinhKhoangCach(this.diemC);
		 this.canhAC = this.diemA.tinhKhoangCach(this.diemC);
		 this.canhAB = this.diemA.tinhKhoangCach(this.diemB);
		 
	 }
	 
	 public void kiemTra(){
		 double minCanh = this.canhAB;
		 String nameMin = "AB";
		 int mount = 0 ;
		 while(mount < 2){
			 if(minCanh > this.canhAC){
				 minCanh = this.canhAC;
				 nameMin = "AC";
			 }
			 else if(minCanh > this.canhBC){
				 minCanh = this.canhBC;
				 nameMin = "BC";
			 }
			 mount++;
		 }
		 System.out.println("Canh "+nameMin+" La Canh Ngan Nhat Dai : "+minCanh);
	 }
}
