/*
 *  lop mo ta nha san xuat
 *  cac hanh vi : them san pham moi vao kho
 */

package pizza;


public class Producer extends Thread {
    ProducerCustomerQueue content ;   //khai bao doi tuong thuoc lop ProducerCustomerQueue
    
    /** Creates a new instance of Producer */
    public Producer(ProducerCustomerQueue product) {
        this.content = product ;      //khoi tao cho doi tuong content
    }
    
    public void run(){
        while(true){
             
            int x = (int)(Math.round(Math.random()*1000000))%100; //gan sp la 1 so bat ky tu 0->99
            content.addProduct(x);                     //them 1 sp vao kho
          
        }
        
    }
    
}
