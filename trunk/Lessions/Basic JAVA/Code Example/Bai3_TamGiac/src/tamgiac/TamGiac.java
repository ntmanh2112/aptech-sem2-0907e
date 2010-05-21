/**
 * 
 */
package tamgiac;

/**
 * @author ThienVD
 *
 */
public class TamGiac {

	/*
	 * Khai bao thuoc tinh
	 */
	public Diem diemA;
	public Diem diemB;
	public Diem diemC;
	
	public double canhAB;
	public double canhBC;
	public double canhAC;
	
	/*
	 * Khai bao ham khoi tao
	 */
	public TamGiac() {
		this.diemA = new Diem();
		this.diemB = new Diem();
		this.diemC = new Diem();
	}
	
	/*
	 * Hanh dong
	 */
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
		double cv = 0.0;
		
		this.tinhCanh();
		
		cv = this.canhAB + this.canhAC + this.canhBC;
		
		return cv;
	}
	
	public double tinhDienTich() {
		double dt = 0.0;
		double p = this.tinhChuVi()/2;
		this.tinhCanh();
		
		dt = Math.sqrt(p * (p - this.canhBC) * (p - this.canhAC) * p - this.canhAB);
		
		return dt;
	}
}
