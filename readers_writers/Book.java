package readers_writers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    public final ReentrantLock lock_obj = new ReentrantLock();
    public Condition readers = lock_obj.newCondition();
    public Condition writers = lock_obj.newCondition();
    public int max_num_readers;
    public int currentReaders = 0;
    public boolean isWriting = false;

    Book(int num) {
        this.max_num_readers = num;
                    
    }

    public void read() {
        lock_obj.lock();
        while (isWriting == true || this.currentReaders == this.max_num_readers) {
            try {
                writers.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.currentReaders++;
            lock_obj.unlock();
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            lock_obj.lock();
            try {
                System.out.print(Thread.currentThread().getName() + " " + "started to read the book");
                Thread.sleep(1000);
                this.currentReaders--;
                System.out.print(Thread.currentThread().getName() + " " + "finished to read the book");
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            writers.signal();
            readers.signalAll();
            lock_obj.unlock();

        }

    }

    public void write() {
        lock_obj.lock();
        while (isWriting == true || currentReaders == 0) {
            try {
                readers.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock_obj.lock();
                this.isWriting = false;
                System.out.print(Thread.currentThread().getName() + " " + "started to write to  the book");
                Thread.sleep(1000);
                readers.signalAll();
                writers.signal();
                System.out.print(Thread.currentThread().getName() + " " + "finished to write to the book");
                lock_obj.unlock();

            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }

    }

}
