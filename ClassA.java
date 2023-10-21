public class ClassA {
    int a=0;
    
public  synchronized void method() throws InterruptedException{

    for (int i=0;i<100;i++){
        Thread.sleep(100);
         System.out.print(a);
           System.out.print("\n");
           a++;
           // this is actually this  a =  a+1
           // but what if both of the threads  do it at the same time ?
           // then  both of them will do  for example at some ith point
           // 45 =44+1;
           //  but two threads both incrementing the value, it should be 46 not 45!

       
    }
   
}

}
