package Bai3;

public class TamGiac {
	public Diem diemA;
	public Diem diemB;
	public Diem diemC;
	
	public double canhAB;
	public double canhAC;
	public double canhBC;
	
	public TamGiac()	{
		this.diemA = new Diem("A");
		this.diemB = new Diem("B");
		this.diemC = new Diem("C");
	}
	public void nhapDiem()	{
		this.diemA.nhapToaDo();
		this.diemB.nhapToaDo();
		this.diemC.nhapToaDo();
	}
	public  void tinhcanh()	{
		this.canhAC = this.diemA.tinhKhoangCach(this.diemC);
		this.canhBC =this.diemB.tinhKhoangCach(this.diemC);
		this.canhAB =this.diemA.tinhKhoangCach(this.diemB);
	}
	public double tinhchuvi()	{
		double cv;
		this.tinhcanh();
		cv=this.canhAB + this.canhAC +this.canhBC;
		return cv;
	}
	public double tinhdientich()	{
		double dt;
		this.tinhcanh();
		double p=(this.tinhchuvi()/2);
		
		dt = Math.sqrt(Math.abs(p * (p - this.canhBC) * (p - this.canhAC) * p - this.canhAB));
		return dt;
		
	}
}
