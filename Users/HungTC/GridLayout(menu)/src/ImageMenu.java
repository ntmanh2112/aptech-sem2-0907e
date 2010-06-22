
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ImageMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Icon ico1;
	Icon ico2;
	Icon ico3;
	Icon ico4;
	Icon ico5;
	Icon ico6;
	
	
	public ImageMenu() {
		ico1 = new ImageIcon("add.png");
		ico2 = new ImageIcon("edit.png");
		ico3 = new ImageIcon("change.png");
		ico4 = new ImageIcon("ok.png");
		ico5 = new ImageIcon("cancel.png");
		ico6 = new ImageIcon("cancer.png");
		init();

	}
	public void init() {
		this.setLayout(new GridLayout(0, 10));
		JButton bt1 = new JButton("", ico1);
		JButton bt2 = new JButton("", ico2);
		JButton bt3 = new JButton("", ico3);
		JButton bt4 = new JButton("", ico4);
		JButton bt5 = new JButton("", ico5);
		JButton bt6 = new JButton("", ico6);
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);
		this.add(bt6);

	}
	
	
	

}
