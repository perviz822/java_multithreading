public class ClassA {
    int a=0;
    
public  synchronized void method() throws InterruptedException{

    for (int i=0;i<100;i++){
        Thread.sleep(100);
         System.out.print(a);
           System.out.print("\n");
           a++;
       
    }
   
}

}
    