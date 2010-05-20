package tamgiac;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TamGiac tamGiac = new TamGiac();
		
		tamGiac.nhapDiem();
		System.out.println("Dien tich tam giac ABC la :" + tamGiac.tinhChuVi() );
		System.out.println("Dien tich tam giac ABC la :" + tamGiac.tinhDienTich() );
		
		

	}

}
