package exercise_1;


    
public class Class1  extends Thread{
     private Print obj;

    Class1 (Print obj){
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
          try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
    }
    
}
