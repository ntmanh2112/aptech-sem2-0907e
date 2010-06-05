/*
 * Consumer.java
 *
 * Lop mo ta nguoi tieu dung
 *  Hanh vi : lay san pham ra khoi kho 
 * 
 * 
 */
package pizza;



public class Consumer extends Thread {
    
    ProducerCustomerQueue content ;   //khai bao doi tuong thuoc lop ProducerCustomerQueue
    
    /** Creates a new instance of Producer */
    public Consumer(ProducerCustomerQueue product) {
        this.content = product ;      //khoi tao cho doi tuong content
    }
    
    public void run(){
        while(true){
             
            int x = content.getProduct();                     //lay 1 sp ra khoi kho
            if(x != Integer.MIN_VALUE) 
                System.out.print("\n Get " + x);                    //xuat ra nhung SP da lay
        }
        
    }
    
}
