package readers_writers;

public class Simulator {

    public static void main(String args[]) {
       
        Book book = new Book(5);

        for (int i = 0; i < 10; i++) {
            Thread reader = new Reader(book);
            reader.start();

        }
        for (int i = 0; i < 10; i++) {
            Thread writer = new  Writer(book);
            writer.start();

        }

    }

}
