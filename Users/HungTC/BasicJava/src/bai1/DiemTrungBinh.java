package bai1;

import mymath.*;

public class DiemTrungBinh {
	HocSinh hs= new HocSinh();
	double gpa;
	double gPA;
	public DiemTrungBinh(){
		hs.inputPupilInf();
		gpa=((hs.getMath()+hs.getLit()+hs.getEng())*2+hs.getCom())/7;
		gPA= LamTronSoThapPhan.roundNumber(gpa,3);
		System.out.println(hs.getName()+"'s Grade Point Average is: "+gPA);
		
		if(gPA<5)
		System.out.println("The grade is: weak");
		else if(gPA>=5&&gPA<6)
		System.out.println("The grade is: average");
		else if (gPA>=6&&gPA<7)
		System.out.println("The grade is: fair good");
		else if (gPA>=7&&gPA<8)
		System.out.println("The grade is: good");
		else if(gPA>=8&&gPA<9)
		System.out.println("The grade is: very good");
		else
		System.out.println("The grade is: excellent");
	}
	
	
}
