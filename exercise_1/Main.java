package exercise_1;

public class Main {

    public static void main (String args []){
        Print obj = new Print();
        Thread thread1 =  new Class1(obj);
         Thread thread2 =  new Class2(obj);
        thread1.start();
        thread2.start();

        
        

        
    }
    
}
