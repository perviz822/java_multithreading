package producer_consumer;

public class Producer  extends Thread{
Buffer obj ;
    
    Producer(Buffer obj){
        this.obj=  obj;

    }

    @Override
     public void run (){
        try {
            obj.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     }
    
}
