//Guard loop in multithreading:
//Excellent explanation from stack overflow
//Read very carefully and understand. Please send me an email if you have any questions.
//Look at producer/consumer (assumption is a ProducerConsumer class with two methods). IT IS BROKEN (because it uses notify) - yes it MAY work - even most of the time, but it may also cause deadlock - we will see why:

public synchronized void put(Object o) {
    while (buf.size()==MAX_SIZE) {
        wait(); // called if the buffer is full (try/catch removed for brevity)
    }
    buf.add(o);
    notify(); // called in case there are any getters or putters waiting
}

public synchronized Object get() {
    // Y: this is where C2 tries to acquire the lock (i.e. at the beginning of the method)
    while (buf.size()==0) {
        wait(); // called if the buffer is empty (try/catch removed for brevity)
        // X: this is where C1 tries to re-acquire the lock (see below)
    }
    Object o = buf.remove(0);
    notify(); // called if there are any getters or putters waiting
    return o;
}

//FIRSTLY,

//Why do we need a while loop surrounding the wait?

//We need a while loop in case we get this situation:

//Consumer 1 (C1) enter the synchronized block and the buffer is empty, so C1 is put in the wait set (via the wait call). Consumer 2 (C2) is about to enter the synchronized method (at point Y above), but Producer P1 puts an object in the buffer, and subsequently calls notify. The only waiting thread is C1, so it is woken and now attempts to re-acquire the object lock at point X (above).

//Now C1 and C2 are attempting to acquire the synchronization lock. One of them (nondeterministically) is chosen and enters the method,
//the other is blocked (not waiting - but blocked, trying to acquire the lock on the method). Let's say C2 gets the lock first
//. C1 is still blocking (trying to acquire the lock at X). C2 completes the method and releases the lock. Now, C1 acquires the lock. 
//Guess what, lucky we have a while loop, because, C1 performs the loop check (guard) and is prevented from removing a non-existent element 
//from the buffer (C2 already got it!). If we didn't have a while, we would get an IndexArrayOutOfBoundsException as C1 tries to remove the first element
//from the buffer!
