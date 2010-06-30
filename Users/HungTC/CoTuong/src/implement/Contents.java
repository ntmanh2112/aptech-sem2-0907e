package implement;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Contents extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int height, width;
	Image image;
	Graphics g;

	// ******(-CONSTRUCTOR-)*********
	public Contents() {
	}

	public Contents(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Contents(Image image, int width, int height) {
		// Wait...Sorry, but how can you make an image?
		// --> BufferedImage image = ImageIO.read(new File("myImage"));

		this.width = width;
		this.height = height;
		this.image = image;
	}

	// ******(-PAINT COMPONENT-) You draw here*********
	public void paintComponent(Graphics g) {
		Graphics2D gr = (Graphics2D) g;
		// backGround
		BufferedImage backGround;
		try {
			backGround = ImageIO.read(new File("wood.jpg"));
			gr.drawImage(backGround, 100, 50, 400, 450, null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Set Stroke for your pen***
		gr.setStroke(new BasicStroke(5));
		// Set color for your pen
		gr.setColor(Color.black);
		// draw rectangle(x,y,width, height)
		gr.drawRect(100, 50, 400, 450);
		// draw caro
		gr.setStroke(new BasicStroke(2));
		for (int i = 100; i < 500; i += 50) {
			gr.drawLine(i, 50, i, 250);
			if (i == 250) {
				gr.drawLine(i, 50, 350, 150);
				gr.drawLine(i, 150, 350, 50);
				gr.drawLine(i, 500, 350, 400);
				gr.drawLine(i, 400, 350, 500);
			}
		}

		for (int i = 100; i < 500; i += 50) {
			gr.drawLine(i, 300, i, 500);

		}
		for (int i = 50; i < 500; i += 50) {
			gr.drawLine(100, i, 500, i);
		}

		// add chess
		try {
			chess(gr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 楚 河 漢 界 So Ha Han Gioi
		gr.setColor(Color.red);
		gr.setStroke(new BasicStroke(10));
		Font font = new Font("Time new Roman", Font.BOLD, 20);
		gr.setFont(font);
		gr.drawString("楚   河   漢   界", 250, 280);

	}

	// *********(-ADD CHESSES-)********
	public void chess(Graphics2D gr) throws IOException {
		// thuong
		BufferedImage King1 = ImageIO.read(new File("China/King1.gif"));
		gr.drawImage(King1, 275, 25, 50, 50, null);
		BufferedImage Mandarin1 = ImageIO.read(new File("China/Mandarin1.gif"));
		gr.drawImage(Mandarin1, 225, 25, 50, 50, null);
		BufferedImage Mandarin11 = ImageIO
				.read(new File("China/Mandarin1.gif"));
		gr.drawImage(Mandarin11, 325, 25, 50, 50, null);
		BufferedImage Elephant1 = ImageIO.read(new File("China/Elephant1.gif"));
		gr.drawImage(Elephant1, 175, 25, 50, 50, null);
		BufferedImage Elephant11 = ImageIO
				.read(new File("China/Elephant1.gif"));
		gr.drawImage(Elephant11, 375, 25, 50, 50, null);

		BufferedImage Knight1 = ImageIO.read(new File("China/Knight1.gif"));
		gr.drawImage(Knight1, 125, 25, 50, 50, null);
		BufferedImage Cannon1 = ImageIO.read(new File("China/Cannon1.gif"));
		gr.drawImage(Cannon1, 125, 125, 50, 50, null);
		BufferedImage Knight12 = ImageIO.read(new File("China/Knight1.gif"));
		gr.drawImage(Knight12, 425, 25, 50, 50, null);
		BufferedImage Cannon11 = ImageIO.read(new File("China/Cannon1.gif"));
		gr.drawImage(Cannon11, 425, 125, 50, 50, null);
		BufferedImage Rock1 = ImageIO.read(new File("China/Rook1.gif"));
		gr.drawImage(Rock1, 75, 25, 50, 50, null);
		BufferedImage Rock12 = ImageIO.read(new File("China/Rook1.gif"));
		gr.drawImage(Rock12, 475, 25, 50, 50, null);

		for (int i = 0; i < 5; i++) {
			BufferedImage Pawn1i = ImageIO.read(new File("China/Pawn1.gif"));
			gr.drawImage(Pawn1i, 75 + (i * 100), 175, 50, 50, null);
		}

		// ha
		BufferedImage King2 = ImageIO.read(new File("China/King2.gif"));
		gr.drawImage(King2, 275, 475, 50, 50, null);
		BufferedImage Mandarin2 = ImageIO.read(new File("China/Mandarin2.gif"));
		gr.drawImage(Mandarin2, 225, 475, 50, 50, null);
		BufferedImage Mandarin21 = ImageIO
				.read(new File("China/Mandarin2.gif"));
		gr.drawImage(Mandarin21, 325, 475, 50, 50, null);
		BufferedImage Elephant2 = ImageIO.read(new File("China/Elephant2.gif"));
		gr.drawImage(Elephant2, 175, 475, 50, 50, null);
		BufferedImage Elephant21 = ImageIO
				.read(new File("China/Elephant2.gif"));
		gr.drawImage(Elephant21, 375, 475, 50, 50, null);

		BufferedImage Cannon2 = ImageIO.read(new File("China/Cannon2.gif"));
		gr.drawImage(Cannon2, 125, 375, 50, 50, null);

		BufferedImage Knight2 = ImageIO.read(new File("China/Knight2.gif"));
		gr.drawImage(Knight2, 125, 475, 50, 50, null);

		BufferedImage Cannon21 = ImageIO.read(new File("China/Cannon2.gif"));
		gr.drawImage(Cannon21, 425, 375, 50, 50, null);
		BufferedImage Knight21 = ImageIO.read(new File("China/Knight2.gif"));
		gr.drawImage(Knight21, 425, 475, 50, 50, null);
		BufferedImage Rock2 = ImageIO.read(new File("China/Rook2.gif"));
		gr.drawImage(Rock2, 75, 475, 50, 50, null);
		BufferedImage Rock21 = ImageIO.read(new File("China/Rook2.gif"));
		gr.drawImage(Rock21, 475, 475, 50, 50, null);

		for (int i = 0; i < 5; i++) {
			BufferedImage Pawn2i = ImageIO.read(new File("China/Pawn2.gif"));
			gr.drawImage(Pawn2i, 75 + (i * 100), 325, 50, 50, null);
		}
	}
}
