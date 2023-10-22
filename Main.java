

public class Main {


    public static void main (String [] args) throws InterruptedException{
        ClassA obj =  new ClassA();

        //here we create two threads, each of them access the method of ClassA.
        // in method of classA  we increment a variable  by 1, 100 times in a loop
        // by using synchronized keyword in front of the method, we ensure that only 
        // one thread at a time can access the  method
        //  by doing so, we ensure the  end result of the variable will be 200
        // if we didn't do it,  two threads  might have gotten the same update, 
        //  and incease the varible simulatenously, 
        MultiThreading my_thing =  new MultiThreading(obj);
        MultiThreading my_thing2 =  new MultiThreading(obj);
        my_thing.start();
        my_thing2.start();
        my_thing.join();
        my_thing2.join();
    }

    
}
