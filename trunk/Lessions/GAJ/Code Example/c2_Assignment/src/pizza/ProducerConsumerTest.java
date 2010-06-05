/*
 * ProducerConsumerTest.java
 *
 * 
 *
 * 
 * 
 */
package pizza;



public class ProducerConsumerTest {
    
     public static void main(String arg[]){
        
         ProducerCustomerQueue pcq = new ProducerCustomerQueue(20); //khoi tao doi tuong pcq voi mang 500 phan tu
         Producer p = new Producer(pcq);    //khoi tao doi tuong p 
         Consumer c = new Consumer(pcq);    //khoi tao doi tuong c
      
         p.start();
         c.start();
         try{
            p.join();
            c.join();
         }
         catch(Exception ex)
         {

         }
     }
    
}
