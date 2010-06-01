package Bai1;

	import java.util.*;
public class HS {
	private String name;
	private double toan,van,anhvan,tinhoc;
	
	public HS(){
		
	}
	public void setName(String ten)	{
		this.name=ten;
	}
	public void settoan(double diemtoan)	{
		this.toan=diemtoan;
	}
	public void setvan(double diemvan)	{
		this.van=diemvan;
	}
	public void setanhvan(double diemanhvan){
		this.anhvan=diemanhvan;
	}
	public void settinhoc(double diemtinhoc)	{
		this.tinhoc=diemtinhoc;
	}
	public String getten(){
		return name;
	}
	public double getdiemtoan()	{
		return toan;
	}
	public double getdiemvan()	{
		return van;
	}
	public double getdiemanhvan()	{
		return anhvan;
	}
	public double getdiemtinhoc() {
		return tinhoc;
	}
	
	
	public void thongTinHS (){
		Scanner input=new Scanner(System.in);
		System.out.println("nhap ten hoc sinh: ");
		this.setName(input.next());
		
		System.out.println("nhap diem toan: ");
		this.settoan(input.nextInt());
		if(this.getdiemtoan()<0||this.getdiemtoan()>10){
			System.out.println("diem ko dc <0 va >10");
			System.out.println("nhap lai diem toan: ");
			this.settoan(input.nextInt());
		}
		
		System.out.println("nhap diem van: ");
		this.setvan(input.nextInt());
		if(this.getdiemvan()<0||this.getdiemvan()>10)	{
			System.out.println("diem ko dc <0 va >10");
			System.out.println("nhap lai diem van: ");
			this.setvan(input.nextInt());
		}
		System.out.println("nhap diem anh van: ");
		this.setanhvan(input.nextInt());
		if(this.getdiemanhvan()<0||this.getdiemanhvan()>10)	{
			System.out.println("diem ko dc <0 va >10");
			System.out.println("nhap lai diem anh van: ");
			this.setanhvan(input.nextInt());
		}
					
		System.out.println("nhap diem tin hoc");
		this.settinhoc(input.nextInt());
		if(this.getdiemtinhoc()<0||this.getdiemtinhoc()>10)	{
			System.out.println("diem ko dc <0 va >10");
			System.out.println("nhap lai diem tin hoc: ");
			this.setanhvan(input.nextInt());
		}
		
		
	}
	
}	
