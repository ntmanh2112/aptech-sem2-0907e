
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	JTextArea txt1;
	JTextArea txt2;
	JTextArea txt3;
	JTextArea txt4;
	JTextArea txt5;
	JTextArea txt6;
	
	
	public  TextArea() {
		// TODO Auto-generated constructor stub
	
		txt1 = new JTextArea(fillText(),10,15);
		txt2 = new JTextArea(fillText(),10,15);
		txt3 = new JTextArea(fillText(),10,15);
		txt4 = new JTextArea(fillText(),10,15);
		txt5 = new JTextArea(fillText(),10,15);
		txt6 = new JTextArea(fillText(),10,15);
		
		init();

	}
	public String fillText(){
		String str = "asdakhdjahdjjajdhjfdsfsfsf" +
				"fgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfahd\ndsfsfssfs\n"+
		"asdakhdjahdjjajdhjfdsfsfsf" +
		"fgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfahd\ndsfsfssfs\n"+
		"asdakhdjahdjjajdhjfdsfsfsf" +
		"fgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfahd\ndsfsfssfs\n"+
		"asdakhdjahdjjajdhjfdsfsfsf" +
		"fgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfgfahd\ndsfsfssfs\n";
		return str;
		
	}
	public void init() {
		this.setLayout(new GridLayout(2,3));
		box();
		this.add(bx1);
		this.add(bx2);
		this.add(bx3);
		this.add(bx4);
		this.add(bx5);
		this.add(bx6);

	}
	JScrollPane sc1;
	JScrollPane sc2;
	JScrollPane sc3;
	JScrollPane sc4;
	JScrollPane sc5;
	JScrollPane sc6;
	public void scrollpane(){
		sc1 = new JScrollPane(txt1);
		sc2 = new JScrollPane(txt2);
		sc3 = new JScrollPane(txt3);
		sc4 = new JScrollPane(txt4);
		sc5 = new JScrollPane(txt5);
		sc6 = new JScrollPane(txt6);
		
	}
	Box bx1;
	Box bx2;
	Box bx3;
	Box bx4;
	Box bx5;
	Box bx6;
	public void box(){
		scrollpane();
		bx1 = Box.createHorizontalBox();
		bx1.add(sc1);
		bx2 = Box.createHorizontalBox();
		bx2.add(sc2);
		bx3 = Box.createHorizontalBox();
		bx3.add(sc3);
		bx4 = Box.createHorizontalBox();
		bx4.add(sc4);
		bx5 = Box.createHorizontalBox();
		bx5.add(sc5);
		bx6 = Box.createHorizontalBox();
		bx6.add(sc6);
	}
	

}
