package Bai4;
import java.util.*;
public class Diem {
	public int x,y;
	public String name;
	
	public Diem(String name)	{
		this.name=name;
	}
	public void nhapToaDo()	{
		Scanner input=new Scanner(System.in);
		System.out.println("Nhap toa do X cua diem "+name);
		this.x=input.nextInt();
		
		System.out.println("Nhap toa do Y cua diem "+name);
		this.y=input.nextInt();
	}
	public double tinhKhoangCach(Diem B){
		double kc;
		kc= Math.sqrt(Math.pow(2, (this.x-B.x))+Math.pow(2, (this.x-B.x)));
		return kc;
	}
}