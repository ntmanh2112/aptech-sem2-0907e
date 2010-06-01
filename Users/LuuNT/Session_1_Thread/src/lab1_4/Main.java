package lab1_4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message mulThread=new Message("Multithreading",1);
		Message mulTas=new Message("Multitasking",2);

		mulThread.setPriority(3);
		mulTas.setPriority(5);
		
		mulThread.start();
		mulTas.start();
		System.out.println("MESSAGE BOARD\n=======\nNumber of messages: "+(Thread.activeCount()-1));
		try{
			 Thread.sleep(1500);
		 }catch(Exception e){}	
		 System.out.println("Result: ");
		 //ms1.setPriority(5);
	}
}
