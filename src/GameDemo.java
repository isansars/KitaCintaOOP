// GameDemo.java
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, temp, pos;

        // Instansiasi
        EntityArray<Zombie> arrZ = new EntityArray<Zombie>();
        EntityArray<Plant> arrP = new EntityArray<Plant>();
        EntityArray<Bullet> arrB = new EntityArray<Bullet>();
        Player p = new Player();
        GridField x = new GridField(p, arrZ, arrP, arrB);
        Zombie z0 = new ZombieA(1, x, arrZ);

        //while (!p.gameOver(arrZ, arrP)) {
        System.out.print("sunPoint: ");
        System.out.println(p.getSunPoints());

        /* System.out.print("Command: ");
        String cmd = input.next();
        if (cmd.equals("SKIP")) {
            p.skip(arrZ, arrP, arrB, x);
        }
        else if (cmd.equals("BUY")) {
            p.buy(x, arrP);
        }
        else {
            System.out.println("Input Anda tidak valid");
        } */

        PVZThread Rbul = new PVZThread("bulletThread", x, p);
        Rbul.start();
            
        /* PVZThread Rplant = new PVZThread("plantThread", x, p);
        Rplant.start();

        PVZThread Rzom = new PVZThread("zombieThread", x, p);
        Rzom.start(); */
        if (p.gameOver(arrZ, arrP)) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Game Over");
        }
    }

    static class PVZThread implements Runnable {
        private Thread t;
        private Player p;
        private String threadName;
        private GridField grid;

        PVZThread(String name, GridField grid, Player player){
            threadName = name;
            this.grid = grid;
            p = player;
            //System.out.println("Creating " +  threadName );
        }
        
        public void run() {
            // System.out.println("Running " +  threadName );
            EntityArray<Zombie> arrZ = this.grid.getArrZ();
            EntityArray<Bullet> arrB = this.grid.getArrB();
            EntityArray<Plant> arrP = this.grid.getArrP();
            
            try {
                while (!p.gameOver(arrZ, arrP)){
                    //System.out.println("Thread: " + threadName + ", " + i);

                    if(threadName.equals("bulletThread")){
                        p.setGiliran(p.getGiliran()+1);
                        if (p.getGiliran()%2 == 0){
                            p.setSunPoint(p.getSunPoints()+25);
                        }
                        grid.getSunPointsView().setText("Jumlah SunPoints: " + p.getSunPoints());
                        for (int i = 59; i >= 0; i--){
                            if (arrB.getEntity(i) != null) {
                                arrB.getEntity(i).move(grid, arrB, arrZ);
                            }
                        }
                        for (int i = 0; i <= 59; i ++) {
                            if (arrB.getEntity(i) != null) {
                                arrB.getEntity(i).attack(grid, arrB, arrZ);
                            }
                        }

                        // plant
                        for (int i = 0; i <= 59; i ++) {
                            if (arrP.getEntity(i) != null) {
                                int temp = arrP.getEntity(i).getTurn();
                                if (arrP.getEntity(i).getAttFreq() == temp) {
                                    arrP.getEntity(i).shoot(grid, arrB, arrZ, arrP);
                                }
                                temp--;
                                if (temp ==  0){
                                    temp = arrP.getEntity(i).getAttFreq();
                                }
                                arrP.getEntity(i).setTurn(temp);
                            }
                        }

                        //zombie
                        // Random generator Zombie
                        for (int i = 0; i <= 59 ; i++) {     
                            if (arrZ.getEntity(i) != null) {
                                arrZ.getEntity(i).move(grid, arrZ, arrP);
                            }
                        }
                        for (int i = 0; i <= 59 ; i++) {     
                            if (arrZ.getEntity(i) != null) {
                                arrZ.getEntity(i).attack(grid, arrZ, arrP);
                            }
                        }
                        if (p.getGiliran() % 7 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z1 = new ZombieB(randomNum, grid, arrZ);
                        }
                        else if (p.getGiliran() % 10 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z2 = new ZombieA(randomNum, grid, arrZ);
                        }
                    /*} else if (threadName.equals("plantThread")){
                        for (int i = 0; i <= 59; i ++) {
                            if (arrP.getEntity(i) != null) {
                                int temp = arrP.getEntity(i).getTurn();
                                if (arrP.getEntity(i).getAttFreq() == temp) {
                                    arrP.getEntity(i).shoot(grid, arrB, arrZ, arrP);
                                }
                                temp--;
                                if (temp ==  0){
                                    temp = arrP.getEntity(i).getAttFreq();
                                }
                                arrP.getEntity(i).setTurn(temp);
                            }
                        }*/
                    /* } else if (threadName.equals("zombieThread")){
                        // Random generator Zombie
                        for (int i = 0; i <= 59 ; i++) {     
                            if (arrZ.getEntity(i) != null) {
                                arrZ.getEntity(i).move(grid, arrZ, arrP);
                            }
                        }
                        for (int i = 0; i <= 59 ; i++) {     
                            if (arrZ.getEntity(i) != null) {
                                arrZ.getEntity(i).attack(grid, arrZ, arrP);
                            }
                        }
                        if (p.getGiliran() % 11 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z1 = new ZombieB(randomNum, grid, arrZ);
                        }
                        else if (p.getGiliran() % 15 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z2 = new ZombieA(randomNum, grid, arrZ);
                        } */
                    }
                    // Let the thread sleep for a while.
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
            //System.out.println("Thread " +  threadName + " exiting.");
        }
        
        public void start () {
            System.out.println("Starting " +  threadName );
            
            if (t == null) {
                t = new Thread (this, threadName);
                t.start ();
            }
        }
    }
}