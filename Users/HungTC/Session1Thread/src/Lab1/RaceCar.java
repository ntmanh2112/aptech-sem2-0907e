package Lab1;

public class RaceCar extends Thread{
	int finish;
	String name;
	
	public RaceCar(int finish, String name) {
		// TODO Auto-generated constructor stub
		this.finish=finish;
		this.name=name;
	}
	public void run(){
		for(int i=0; i<finish;i++){
			System.out.println(name+": "+(i+1));
			try{
				Thread.sleep(Math.round(Math.random()*5000));
			}catch(Exception e){}
			}
		System.out.println(name+" finished");
		}
}
