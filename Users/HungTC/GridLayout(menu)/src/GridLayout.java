import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;

public class GridLayout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageMenu image = new ImageMenu();

	/**
	 * @param args
	 * @throws IOException
	 */
	public GridLayout() throws IOException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}

	public void init() throws IOException {

		this.setLayout(new BorderLayout());
		this.setSize(500, 500);

		this.add(image, BorderLayout.NORTH);
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new GridLayout();
	}

}
