import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadWriteData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  i=324;
		double d=23.343;
		boolean t=true;
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("F:\\WorkSpace\\Training\\src\\text.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("no link");
		}
try {
	dos.writeInt(i);
	dos.writeDouble(d);
	dos.writeBoolean(t);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

DataInputStream dis = null;


try {dis= new DataInputStream(new FileInputStream("F:\\WorkSpace\\Training\\src\\text.txt"));
	i=dis.readInt();
	d=dis.readDouble();
 t=dis.readBoolean();
 System.out.println(i +" "+ d+" "+ t);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}






	}

}
