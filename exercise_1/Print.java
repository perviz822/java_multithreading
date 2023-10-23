package exercise_1;

public class Print {
    int a = 0;

    public synchronized void print_number(){
        a++;
        System.out.print(a  + " \n");
        
    }
    
}
