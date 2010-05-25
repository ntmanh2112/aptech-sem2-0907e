package Bai1_DiemTrungBinhHS;
import java.util.*;
public class HocSinh {
	private String name;
	private double math,lit,eng,com;	
	
	public HocSinh(){}

	//set variable (private)
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
		System.out.println("Pls type pupil name:\n");
		this.setName(input.next());
		
		System.out.println("Pls input Mathematics score:\n");
		this.setMath(input.nextInt());
		while(this.getMath()<0||this.getMath()>10){
			System.out.println("Oh,your score is invalid. Pls input again Mathematics score:\n");
			this.setMath(input.nextInt());
		}
		
		System.out.println("Pls input Literature score:\n");
		this.setLit(input.nextInt());
		while(this.getLit()<0||this.getLit()>10){
			System.out.println("Oh,your score is invalid. Pls input again Literature score:\n");
			this.setLit(input.nextInt());
		}
		
		System.out.println("Pls input English score:\n");
		this.setEng(input.nextInt());
		while(this.getEng()<0||this.getEng()>10){
			System.out.println("Oh,your score is invalid. Pls input again English score:\n");
			this.setEng(input.nextInt());
		}
		
		System.out.println("Pls input Computer Skill score:\n");
		this.setCom(input.nextInt());
		while(this.getCom()<0||this.getCom()>10){
			System.out.println("Oh,your score is invalid. Pls input again Computer Skill score:\n");
			this.setCom(input.nextInt());
		}
	}
}
