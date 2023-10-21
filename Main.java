public class Main {


    public static void main (String [] args) throws InterruptedException{
        ClassA obj =  new ClassA();
        MultiThreading my_thing =  new MultiThreading(obj);
        MultiThreading my_thing2 =  new MultiThreading(obj);
        my_thing.start();
        my_thing2.start();
        my_thing.join();
        my_thing2.join();
    }

    
}
