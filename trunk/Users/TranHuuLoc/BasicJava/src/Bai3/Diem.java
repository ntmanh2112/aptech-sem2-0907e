package Bai3;
import java.util.*;
public class Diem {
	public int x,y;
	public String name;
	
	public Diem (String name)	{
		this.name=name;
	}
	
	public void nhapToaDo()	{
		
		Scanner input =new Scanner(System.in);
		System.out.println("toa do X cua diem "+name+": ");
		this.x=input.nextInt();
		
		System.out.println("toa do Y cua diem "+name+": ");
		this.y=input.nextInt();
		
	}
	public double tinhKhoangCach(Diem diem)	{
		double kc;
		kc=Math.sqrt(Math.pow(2,(this.x-diem.x))+Math.pow(2,(this.x-diem.x)));
		return kc;
	}
}
