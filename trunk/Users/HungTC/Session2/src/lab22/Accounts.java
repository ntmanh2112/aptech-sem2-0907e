package lab22;

public class Accounts {
	int id;
	String name;
	int balance=1000;
	public Accounts(int id, String name){
		this.id=id;
		this.name=name;
		System.out.println("the id: "+id+" name: "+ name +" balance: "+ balance);
			
	}	
}
