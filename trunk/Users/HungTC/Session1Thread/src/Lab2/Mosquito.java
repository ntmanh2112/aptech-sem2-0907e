package Lab2;

public class Mosquito implements Runnable{
	private int id;
	public Mosquito(int id)
	{
	this.id = id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (id == 12) {
		try {
			Thread.sleep(10000);
		} catch(Exception e){}
		}
		for (int i=0; i<10; i++) {
			System.out.println("Vo ve " + id);
		}

	}

}
