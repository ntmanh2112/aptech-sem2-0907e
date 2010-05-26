package bai2;

public class LuongDien {
	public Dien giaDien;
	
	public LuongDien()
	{
		this.giaDien = new Dien();
	}
	
	public void nhapLuongDien(){
		this.giaDien.nhapDien(); 
	}
	
	public long tinhTienDien(){
		 
		return this.giaDien.tinhDien();
	}
}
