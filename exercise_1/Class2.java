package exercise_1;


    
public class Class2  extends Thread{
     private Print obj;

    Class2 (Print obj){
        this.obj=obj;
    }

    @Override
    public  void run (){
        while (true){
            if (obj.a <100){
                obj.print_number(); 
            } 
            else{
                break;
            }
            obj.print_number();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }   
    }
    
}
