package lab1_4;

public class Message extends Thread {
	
	int mount = 0;	
	 public Message(String nameThread, int mount){
		 setName(nameThread);
		 this.mount = mount;
		 
	 }
	 
	 public void run(){
		 try{
			 sleep(1000);
		 }catch(Exception e){}
		 System.out.println("Message "+mount+": "+getName());
		 if(getPriority()>5)
			 
		 {System.out.println("Timeout: 1000");
		 System.out.println("Priority: high");}
		 else if(getPriority()==5)
		 { System.out.println("Timeout: 2000");

			 System.out.println("Priority: medium");}
		 else
		 { System.out.println("Timeout: 3000");

			 System.out.println("Priority: low");}
		 
		 try{
			 sleep(1000);
		 }catch(Exception e){}
		 
		 
		 for(int i=0;i<10;i++){
			 try{
				 sleep(200);
			 }catch(Exception e){}
			 System.out.println(getName());			
		 }
			 
	 }

}
