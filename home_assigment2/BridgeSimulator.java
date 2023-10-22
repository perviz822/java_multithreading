package home_assigment2;

import java.util.Random;

public class BridgeSimulator {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        for (int i = 1; i <= 31; i++) {
            int soldierLoad = new Random().nextInt(5) + 3; 
            Thread soldier = new Soldier(soldierLoad, bridge);
            soldier.setName("Soldier " + i);
            soldier.start();
        }
    }
    
}
