package lab2_2;

public class ThreadAcc implements Runnable{

	@Override
	public void run() {


		System.out.println("Nhap Tai Khoan Chuyen : ");
		String acc1 = input.nextLine();
		
		System.out.println("Nhap Tai Khoan Nhan : ");
		String acc2 = input.nextLine();
		
		this.ktID(acc1, acc2);
		
		System.out.println("Nhap So Tien Can Chuyen : ");
		double money = input.nextDouble();
		
		if (money < acc[this.idTaiKhoanNGuon].getBalance()) {
			acc[this.idTaiKhoanNGuon].setBalance(acc[this.idTaiKhoanNGuon].getBalance() - money);
			acc[this.idTaiKhoanDich].setBalance(acc[this.idTaiKhoanDich].getBalance() + money);
			
			System.out.println("Hoan Tat Giao Dich.");
			System.out.println("So Tien Trong Tai Khoan "+acc1 +" La : "+acc[this.idTaiKhoanNGuon].getBalance());
			System.out.println("So Tien Trong Tai Khoan "+acc2 +" La : "+acc[this.idTaiKhoanDich].getBalance());
		}else {
			System.out.println("So Tien Cua Ban Khong Du De Chuyen");
		}
		
		this.manu();
	}
	
}
