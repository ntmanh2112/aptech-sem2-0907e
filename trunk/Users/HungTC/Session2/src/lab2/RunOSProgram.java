package lab2;

public class RunOSProgram {
	public static void main(String args[]) { 
        Runtime rt = Runtime.getRuntime(); 
 
        Process proc; 
         
        try { 
             
            if (System.getProperty("os.name").startsWith("Windows")){ 
                // Run a OS specific program 
                proc = rt.exec("notepad"); 
            } 
            else{ 
                proc = rt.exec("gedit"); 
            } 
             
            proc.waitFor(); //try removing this line 
        } catch (Exception e) { 
            System.out.println("notepad is an unknown command."); 
        } 
    } 
     

}
