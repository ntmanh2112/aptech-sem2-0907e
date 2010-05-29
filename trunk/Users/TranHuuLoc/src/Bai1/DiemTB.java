package Bai1;

public class DiemTB {
	HS hs= new HS();
	double DTB;
	public DiemTB(){
		hs.inputPupilInf();
		DTB=((hs.getMath()+hs.getLit()+hs.getEng())*2+hs.getCom())/7;
			
		System.out.println("Diem Trung Binh cua "+hs.getName()+DTB);
		
		if(DTB<5)
		System.out.println("YEU");
		else if(DTB>=5&&DTB<6)
		System.out.println("Trung Binh");
		else if (DTB>=6&&DTB<7)
		System.out.println("Trung Binh Kha" +
				"");
		else if (DTB>=7&&DTB<8)
		System.out.println("Kha");
		else if(DTB>=8&&DTB<9)
		System.out.println("Gioi");
		else
		System.out.println("Xuat sac");
	}
	
	
}
