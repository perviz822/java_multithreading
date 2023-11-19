package readers_writers;

public class Writer extends Thread{
    public Book my_book;

    Writer(Book book){
        this.my_book=book;

    }

    @Override
    public void run (){
        this.my_book.write();
    }
    
}
