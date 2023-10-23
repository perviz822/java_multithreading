package dining_philosopher;

import java.util.concurrent.Semaphore;

public class Simulator {

    public static void main (String [] args){
          Semaphore s1 =  new Semaphore (1);
          Semaphore s2 =  new Semaphore (1);
          Semaphore s3 =  new Semaphore (1);
          Semaphore s4 =  new Semaphore (1);
          Semaphore s5 =  new Semaphore (1);
          Semaphore guard= new Semaphore (4);

          Thread p1 = new Philosopher (s1,s2,guard);
          Thread p2 = new Philosopher (s2,s3,guard);
          Thread p3 = new Philosopher (s3,s4,guard);
          Thread p4 = new Philosopher (s4,s5,guard);
          Thread p5 = new Philosopher (s5,s1,guard);
        p1.setName("1");
          p2.setName("2");
          p3.setName("3");
          p4.setName("4");
          p5.setName("5");

          p1.start();
          p2.start();
          p3.start();
          p4.start();
          p5.start();

         
              

          
    
    
    
    }
    }
    

