package producer_consumer;

import java.util.LinkedList;
import java.util.Random;

public class Buffer {
    private int capacity;
    private LinkedList <Integer> list;
    Buffer ( int capacity,  LinkedList <Integer> list){
        this.capacity=capacity;
        this.list= list;
    }

    public  synchronized void produce () throws InterruptedException{
        while (list.size() >=capacity){
            System.out.print( Thread.currentThread().getName()  + " " + "has to wait" + "\n");
            wait ();    
        }

           Random number =  new Random();
           list.addFirst(number.nextInt());
           capacity++;
           Thread.sleep(500);
           System.out.print( Thread.currentThread().getName()  + " " + "produced  an item" + "\n");
           notifyAll();
        
       
    
        
    }
 public  synchronized void consume () throws InterruptedException{
        while (list.size()==0){
             System.out.print( Thread.currentThread().getName()  + " " + "has to wait" + "\n");
            wait ();      
        }
           list.removeFirst();
           capacity--;
           Thread.sleep(500);
           System.out.print( Thread.currentThread().getName()  + " " + "consumed an item" + "\n");
           notifyAll();
        
        
    }
    
    
}
