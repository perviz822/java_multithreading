package home_assigment2;

public class Soldier  extends Thread{
    private int load;
    private Bridge bridge;

    public Soldier(int load, Bridge bridge) {
        this.load = load;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.enterBridge(load);
            Thread.sleep(490); // Simulating crossing the bridge
            bridge.leaveBridge(load);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
