package Bai1;

public class DiemTB {
	HS hocsinh=new HS();
	Double DTB;
	public DiemTB()	{
		hocsinh.thongTinHS();
		DTB=(((hocsinh.getdiemtoan()+hocsinh.getdiemanhvan()
			+hocsinh.getdiemvan())*2+hocsinh.getdiemtinhoc())/7);
		System.out.println("Diem Trung Binh la: "+DTB);
		if(DTB<5)

			System.out.println(hocsinh.getten()+" la mot hoc sinh yeu");
		else if(DTB>=5&&DTB<=6)
			System.out.println(hocsinh.getten()+" la mot hos sinh trung binh");
		else if(DTB>6&&DTB<=7)
			System.out.println(hocsinh.getten()+" la mot hoc sinh trung binh kha");
		else if(DTB>7&&DTB<=8)	
			System.out.println(hocsinh.getten()+" la la mot sinh kha");
		else if(DTB>8&&DTB<=9)	
			System.out.println(hocsinh.getten()+" la la mot sinh gioi");
		else if(DTB>9&&DTB<=10)	
			System.out.println(hocsinh.getten()+" la la mot sinh xuat sac");
		
		
	}
}
