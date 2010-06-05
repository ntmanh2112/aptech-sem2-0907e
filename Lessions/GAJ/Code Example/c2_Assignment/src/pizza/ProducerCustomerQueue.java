

 package pizza;



public class ProducerCustomerQueue {
    int[] arr;                          //khai bao mang (kho) chua cac san pham 
    int max ;                           //khai bao so san pham toi da chua trong kho
    private int count = 0, in = 0, out = 0; // khai bao bien dem, vi tri lay phan tu va vi tri dat phan tu
   static int lastPosition = 0 ;              //vi tri cua  san pham dau tien trong mang
    
    /** Creates a new instance of ProducerCustomerQueue */
    public ProducerCustomerQueue(int maxN) {
       max =  ( maxN >0 ) ? maxN : 100 ;
       arr   = new int[max];             // cap phat so phan tu trong mang
    }
    
    //************************them san pham vao kho***************************//
    
    public synchronized void addProduct(int value){
        
   
       
        try{        
              
            if(count==arr.length ){                    //neu Kho day San pham
                System.out.println("Add Product is waiting");
                 Thread.currentThread().wait();          //dung thread add SP    
            
            }
            else {   
                
                arr[in] = value  ;             //add sp vao Kho
                in=(in+1)%arr.length;                         //tang vi tri chua sp len 1
                count ++;
                System.out.print(" Add: "+value);
            }
              notifyAll();
              
        }catch(Exception e){}
   
    }
    
    //************************************************************************//
    
    
    //*************************nguoi dung lay san pham ra mua******************//
    
    public  int getProduct(){
        
         int c=0;           //san pham duoc ban
         
         try{
         
             if(count == 0) {             //neu mang trong
               System.out.println("Get Product is waiting");
               Thread.currentThread().wait();       //thread lay SP  doi 
               notifyAll();
             }     
                         
              c = arr[out];
             out=(out+1)%arr.length;
             count --;
        }catch(Exception e){}
         
        return c;
    }
    
    //************************************************************************//
    
}
