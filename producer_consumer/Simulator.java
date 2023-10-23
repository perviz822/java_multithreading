package producer_consumer;


import java.util.LinkedList;

public class Simulator {

    public static void main (String [] args){
       LinkedList <Integer>list  =  new LinkedList <Integer> ();
       Buffer  buffer =  new Buffer(5,list);


       for  (int i=0;i<10;i++){
        Thread  producer =  new Producer(buffer);
        producer.setName("Producer " +  " " + i );
        producer.start();

       }
       for  (int i=0;i<10;i++){
        Thread  customer=  new Customer(buffer);
        customer.setName("Customer " +  " " + i );
        customer.start();

       }

    }
    
}
