public class MultiThreading  extends Thread{
    private ClassA classA; // Field to store the ClassA reference

    public MultiThreading(ClassA classA) {
        this.classA = classA;
    }
    @Override
    public void run(){
   
    try {
        classA.method();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
      

    }
    
}