package lab1_4;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MesThread ms1=new MesThread("multithreading",1);
		ms1.setPriority(7);
		MesThread ms2=new MesThread("multitasking",2);
		ms2.setPriority(5);
		ms1.start();
		ms2.start();
		System.out.println("MESSAGE BOARD\n=======\nNumber of messages: "+(Thread.activeCount()-1));
		try{
			 Thread.sleep(1500);
		 }catch(Exception e){}	
		 System.out.println("Result: ");
		 //ms1.setPriority(5);
	}

}
