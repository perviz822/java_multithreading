package readers_writers;

public class Reader extends Thread {
    public Book my_book;

    Reader(Book book) {
        this.my_book = book;
    }

    @Override
    public void run() {
        this.my_book.read();
    }

}
