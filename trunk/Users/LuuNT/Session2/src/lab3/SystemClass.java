package lab3;

import java.io.IOException;

public class SystemClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		
		// TODO Auto-generated method stub
		int arr1[] = new int[1050000];
		int arr2[] = new int[1050000];
		
		long startTime , endTime ;
		
		for(int i=0; i< arr1.length ; i++){
			arr1[i] = i+1;			
		}
		
		startTime = System.currentTimeMillis();
		for(int i=0; i< arr1.length ; i++){
			arr2[i] = arr1[i];			
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("Time for manual copy : "+ (endTime - startTime) + " ms");
		startTime = System.currentTimeMillis();
		System.arraycopy(arr1, 0, arr2, 0 , arr1.length);
		endTime = System.currentTimeMillis();
		System.out.println("Time for copy utility provided : "+(endTime - startTime) + " ms.");
		System.gc();
		System.exit(0);
	}

}
