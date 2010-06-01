package lab2_2;

import java.util.Scanner;

public class Manager implements Runnable{

	CustomAcc [] acc ;
	
	
	
	static int idTaiKhoan;
	
	public Manager()	{
		this.acc = new CustomAcc [20] ;
	}
	
	public void create(){
		
		
		for(int i = 0 ; i < 20 ; i++) {
			if(acc[i] != null){
				
				
			}else {
				acc[i] = new CustomAcc();
				Scanner input = new Scanner(System.in);
				System.out.println("Nhap Ten Tai Khoan Moi: ");
				String accName = input.nextLine();
				acc[i].setAccount(accName);
				
				System.out.println("So Tien Ban Can Gui Vao: ");
				
				double baLan = input.nextDouble();
				acc[i].setBalance(baLan);
				
				break;
			}
		}
		
		this.manu();
	}

	public void manu() {
		System.out.println("Menu");
		System.out.println("");
		System.out.println("");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("1.Create account");
		System.out.println("2.Do transaction");
		System.out.println("3.Exit");
		
		System.out.println("Your choice:_");
		Scanner input = new Scanner(System.in);
		int manu = 0;
		try {
		 manu = input.nextInt();
		} catch (Exception e) {
			System.out.println("Ban Da Nhap Sai");
			this.manu();
		}
		if(manu == 1){
			this.create();
		}else if(manu == 2){
			
		}else if(manu == 3){
			Thread.currentThread().stop();
		}
	}
	public void ktID(String nameTaiKhoan){
		
		for(int i = 0 ; i < 20 ; i++){
			if(acc[i] != null){
				if(acc[i].getAccount().equals(nameTaiKhoan)){
					this.idTaiKhoan = i ;
					break;
				}
				else{
					
				}
			}
			else{
				System.out.println("Tai Khoan Khong Ton Tai");
				this.manu();
				break;
			}
		}
		
		
	}
	@Override
	public void run() {

		this.manu();
		
		while(true){
				Scanner input = new Scanner(System.in);
				System.out.println("Nhap Tai Khoan : ");
				String acc1 = input.nextLine();
				this.ktID(acc1);
				System.out.println("1.Gui Tien ");
				System.out.println("2.Rut Tien");
				System.out.println("3.Exit");
				int manu = input.nextInt();
				
				if(manu == 1){
					System.out.println("Nhap So Tien Can Gui: ");
					double money = input.nextDouble();
					acc[this.idTaiKhoan].setBalance(acc[this.idTaiKhoan].getBalance() + money);
					
					System.out.println("Hoan Tat Giao Dich.");
					System.out.println("So Tien Trong Tai Khoan "+acc1 +" La : "+acc[this.idTaiKhoan].getBalance());
				
					
				}else if(manu == 2){
					System.out.println("Nhap So Tien Can Rut: ");
					double money = input.nextDouble();
				
					if (money < acc[this.idTaiKhoan].getBalance()) {
						acc[this.idTaiKhoan].setBalance(acc[this.idTaiKhoan].getBalance() - money);
						
						System.out.println("Hoan Tat Giao Dich.");
						System.out.println("So Tien Trong Tai Khoan "+acc1 +" La : "+acc[this.idTaiKhoan].getBalance());
					}else {
						System.out.println("So Tien Cua Ban Khong Du De Rut");
					}
				
				}else if(manu == 3){
					
				}
				this.manu();	
		}	
	}
	
	
}
