package dining_philosopher;
import java.util.concurrent.Semaphore;

public class Philosopher  extends Thread{
    Semaphore guard;
    Semaphore leftFork;
    Semaphore rightFork;

    Philosopher( Semaphore s1, Semaphore s2, Semaphore guard){
        this.leftFork=s1;
        this.rightFork=s2;
        this.guard = guard;

    }

    @Override
    public void run (){
        for (int i=0;i<5;i++){
            eat();
        }

    }


    public void eat (){
       try {
         guard.acquire();
         leftFork.acquire();
         System.out.print ( "Philosopher" +  " "+ Thread.currentThread().getName() +  " "  + "acquired the left fork" + "\n");
         rightFork.acquire();  
         System.out.print ( "Philosopher" +  " " + Thread.currentThread().getName() +  " "  + "acquired the right fork" + "\n");

         Thread.sleep(1000);

       
        
       } catch (Exception e) {
        e.printStackTrace();
       
       }
          
          leftFork.release();
          System.out.print ( "Philosopher" +  " "+ Thread.currentThread().getName() +  " "  + "released the left fork" + "\n");
       ;
          rightFork.release();
             System.out.print ( "Philosopher" +  " "+ Thread.currentThread().getName() +  " "  + "released the right fork" + "\n");
        
          guard.release();
          System.out.print ( "Philosopher" +  " "+ Thread.currentThread().getName() +  " "  + "released the guard" + "\n");
          
    }

}



  
    

