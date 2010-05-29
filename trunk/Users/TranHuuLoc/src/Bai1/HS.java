package Bai1;
import java.util.*;
public class HS {
	private String name;
	private double math,lit,eng,com;
	
	public HS()	{
		
	}

	
	public void setName(String name) {
		this.name = name;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public void setLit(double lit) {
		this.lit = lit;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public void setCom(double com) {
		this.com = com;
	}
	
	//get variable (private)
	public String getName() {
		return name;
	}
	public double getMath() {
		return math;
	}
	public double getLit() {
		return lit;
	}
	public double getEng() {
		return eng;
	}
	public double getCom() {
		return com;
	}
	
	//input information
	public void inputPupilInf(){
		Scanner input=new Scanner(System.in);
		System.out.println("Nhap ten di ban:\n");
		this.setName(input.next());
		
		System.out.println("Diem Toan:\n");
		this.setMath(input.nextInt());
		while(this.getMath()<0||this.getMath()>10){
			System.out.println("ban da nhap sai:\n");
			this.setMath(input.nextInt());
		}
		
		System.out.println("Diem Van:\n");
		this.setLit(input.nextInt());
		while(this.getLit()<0||this.getLit()>10){
			System.out.println("ban da nhap sai:\n");
			this.setLit(input.nextInt());
		}
		
		System.out.println("Diem Anh Van:\n");
		this.setEng(input.nextInt());
		while(this.getEng()<0||this.getEng()>10){
			System.out.println("ban da nhap sai:\n");
			this.setEng(input.nextInt());
		}
		
		System.out.println("Diem Tin Hoc:\n");
		this.setCom(input.nextInt());
		while(this.getCom()<0||this.getCom()>10){
			System.out.println("ban da nhap sai:\n");
			this.setCom(input.nextInt());
		}
	}

		
}
