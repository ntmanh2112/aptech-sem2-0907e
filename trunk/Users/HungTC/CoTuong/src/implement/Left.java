package implement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Left extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int height, width;
	Image image;
	Graphics g;

	// ******(-CONSTRUCTOR-)*********

	public Left(Image image, int width, int height) {
		// Wait...Sorry, but how can you make an image?
		// --> BufferedImage image = ImageIO.read(new File("myImage"));
		this.width = width;
		this.height = height;
		this.image = image;
		init();
	}

	// ******(-PAINT COMPONENT-) You draw here*********
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g;
		// draw image
		gr.drawImage(image, 0, 0, width, height, null);

	}

	// ********init()********
	public void init() {
		this.setLayout(new GridLayout(1, 1));
		this.setSize(width, height);
		JLabel lb = new JLabel("How To Play Chess");
		lb.setForeground(Color.green);
		JTextArea txt = new JTextArea(10,5);
		txt.setBackground(new Color(244,186,11));
		JScrollPane scrollPane = new JScrollPane(txt);
		txt.setText("Tướng đi trong cung," + "\n đi một ô, ăn trực tiếp"
				+ "\nSĩ: đi chéo trong cung," + "\nđi một ô, ăn trực tiếp"
				+ "\nTượng: đi chéo trong nước,"
				+ "\n mỗi lần đi 2 ô, ăn trực tiếp"
				+ "\nXa: đi thẳng và ngang," + "\n đi thoải mái, ăn trực tiếp"
				+ "\nPháo đi thẳng, ngang, \n" + "đi thoải mái, ăn cách con"
				+ "\n" + "Mã,đi thẳng một ô rồi \nđi chéo một ô bất kỳ,"
				+ "\n ăn trên đường đi" + "\nTốt đi thẳng trong nước,"
				+ "\n được đi ngang bên \nnước ngoài, cấm đi lùi."
				+ "\nNguyên tắc ăn là \năn trên đường đi."
				+ "\nMã bị cản khi có quân \nđứng ở ngay ô thuộc"
				+ "\n nước đi đầu tiên.");

		this.add(lb);
		this.add(scrollPane);

	}
}
