package home_assigment2;

class Bridge {
    private int currentLoad = 0;

    public synchronized void enterBridge(int soldierLoad) throws InterruptedException {
       
        while (currentLoad + soldierLoad > 12) { // why did we use while check and not if check?
            wait();
        }
        currentLoad += soldierLoad;
        System.out.println(Thread.currentThread().getName() + " entered the bridge with a load of " + soldierLoad + " units.");
    }
    public synchronized void leaveBridge(int soldierLoad) {
        currentLoad -= soldierLoad;
        System.out.println(Thread.currentThread().getName() + " left the bridge.");
        notifyAll();
    }
}
