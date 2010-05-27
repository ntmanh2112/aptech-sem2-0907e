/**
 * 
 */
package tamgiac;

/**
 * @author ThienVD
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TamGiac tg = new TamGiac();
		tg.nhapDiem();
		
		double cv = tg.tinhChuVi();
		double dt = tg.tinhDienTich();
		
		System.out.print("Chu vi = " + cv + "  Dien tich = " + dt);
	}

}
