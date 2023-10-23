 package producer_consumer;

public class Customer extends Thread{
   


Buffer obj ; 
    Customer(Buffer obj){
        this.obj=  obj;

    }
    @Override
     public void run (){
        try {
            obj.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     }
    






}