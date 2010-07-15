package mouseListener;

import javax.swing.JOptionPane;

public class AlertOfMouse implements Runnable {
	String str;
	public AlertOfMouse(String str){
		this.str = str;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "You have just "+str);
		
	}

}
