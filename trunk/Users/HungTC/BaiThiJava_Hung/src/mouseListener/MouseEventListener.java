package mouseListener;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventListener extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
    
	public MouseEventListener() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() {

		this.setTitle("Mouse Event Listener");
		this.setLayout(null);
		this.setSize(500, 500);
		this.setLocation(20, 20);

		JLabel lb = new JLabel("Please make a mouse event for the button");
		lb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lb.setLocation(50, 50);
		lb.setSize(300, 70);
		this.add(lb);

		JButton btn = new JButton("ACTION");
		btn.setSize(200, 25);
		btn.setLocation(100, 100);
		this.add(btn);

		btn.addMouseListener(this);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MouseEventListener();
	}
/*
 * Ở đây nói một chút, Để hiện bảng thông báo (messageDialog) khi 
 * mình click, hay release thì bị lỗi. Vì khi mình nhấn(press) vô rồi
 * chương trình sẽ thực hiện lệnh press trước, bảng thông báo hiên ra và cắt ngang
 * tiến trình (process) nên khi mình buông chuột, chương trình sẽ không hiểu, mình phải bắt đầu lại
 * và như thế chỉ sẽ thông báo được 3 lệnh: enter, exit và press. Giải quyết như thế nào nếu không dùng console?
 * vì console chỉ dùng để print lỗi.
 * Vậy mình tách tiến trình hiện bảng thông báo thành độc lập,
 * không ảnh hưởng đến tiến trình chính của mình, đồng thời tạo thêm độ trễ cho thông báo
 * để đảm bảo cho event của chuột hòan tất
 * -> dùng thread, ở đây mình tạo 1 class implement Runnable để chạy.
 * đáng tiếc là khi thi mình không làm vậy, mình đã nghĩ JOPtionPane là 1 luồng độc lập
 * ->lỗi tại tôi, lỗi tại tôi mọi đàng.
 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println( "You have just clicked.");
		AlertOfMouse alert = new AlertOfMouse("Clicked");
		Thread mythread = new Thread(alert);
		mythread.start();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("You have just entered.");
		AlertOfMouse alert = new AlertOfMouse("Entered");
		Thread mythread = new Thread(alert);
		mythread.start();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println( "You have just exited.");
		AlertOfMouse alert = new AlertOfMouse("Exited");
		Thread mythread = new Thread(alert);
		mythread.start();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println( "You have just pressed.");
		AlertOfMouse alert = new AlertOfMouse("Pressed");
		Thread mythread = new Thread(alert);
		mythread.start();
}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("You have just released.");
		AlertOfMouse alert = new AlertOfMouse("Released");
		Thread mythread = new Thread(alert);
		mythread.start();
}

	
}
