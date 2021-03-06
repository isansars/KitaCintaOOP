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

        PVZThread RNbul = new PVZThread("bulletThread", "NormalBul", x, p);
        RNbul.start();
        PVZThread RFbul = new PVZThread("bulletThread", "FireBul", x, p);
        RFbul.start();
            
        PVZThread RplantA = new PVZThread("plantThread", "PA", x, p);
        RplantA.start();
        PVZThread RplantB = new PVZThread("plantThread", "PB", x, p);
        RplantB.start(); 

        PVZThread RzomA = new PVZThread("zombieThread", "ZA", x, p);
        RzomA.start(); 
        PVZThread RzomB = new PVZThread("zombieThread", "ZB", x, p);
        RzomB.start();

        PVZThread Rsun = new PVZThread("sunThread", "S", x, p);
        Rsun.start();
    }

    // Inner Class yang mengimplementasikan Runnable
    static class PVZThread implements Runnable {
        private Thread t;
        private Player p;
        private String threadName;
        private String entityType;
        private GridField grid;

        PVZThread(String name, String entityType, GridField grid, Player player){
            threadName = name;
            this.entityType = entityType;
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
                    // Thread Bullet
                    if(threadName.equals("bulletThread")){
                        p.setGiliran(p.getGiliran()+1);
                        grid.getSunPointsView().setText("Jumlah SunPoints: " + p.getSunPoints());
                        // Thread NormalBul
                        if (entityType.equals("NormalBul")){
                            System.out.println("NormaBul run");
                            // Bullet Move
                            for (int i = 59; i >= 0; i--){
                                if (arrB.getEntity(i) != null && (arrB.getEntity(i).getBulletType().equals("->"))) {
                                    arrB.getEntity(i).move(grid, arrB, arrZ, arrP);
                                }
                            }
                            // Bullet Attack
                            for (int i = 0; i <= 59; i ++) {
                                if (arrB.getEntity(i) != null && (arrB.getEntity(i).getBulletType().equals("->"))) {
                                    arrB.getEntity(i).attack(grid, arrB, arrZ);
                                }
                            }
                            Thread.sleep(4000); //frekuensi move dan attack NormalBul
                        // Thread FireBul
                        } else if (entityType.equals("FireBul")){
                            System.out.println("FireBul run");
                            for (int i = 59; i >= 0; i--){
                                if (arrB.getEntity(i) != null && (arrB.getEntity(i).getBulletType().equals("o"))) {
                                    arrB.getEntity(i).move(grid, arrB, arrZ, arrP);
                                }
                            }
                            for (int i = 0; i <= 59; i ++) {
                                if (arrB.getEntity(i) != null && (arrB.getEntity(i).getBulletType().equals("o"))) {
                                    arrB.getEntity(i).attack(grid, arrB, arrZ);
                                }
                            }
                            Thread.sleep(2000); //frekuensi move dan attack FireBul
                        }
                    // Thread Plant
                    } else if (threadName.equals("plantThread")){
                        // Thread PlantA
                        if (entityType.equals("PA")){
                            System.out.println("PA run");
                            for (int i = 0; i <= 59; i ++) {
                                if (arrP.getEntity(i) != null && (arrP.getEntity(i).getPlantType().equals(entityType))) {
                                    arrP.getEntity(i).shoot(grid, arrB, arrZ, arrP);
                                }
                            }
                            Thread.sleep(8*1000); //frekuensi tembakan Plant A
                        // Thread PlantB
                        } else if (entityType.equals("PB")){
                            System.out.println("PB run");
                            for (int i = 0; i <= 59; i ++) {
                                if (arrP.getEntity(i) != null && (arrP.getEntity(i).getPlantType().equals(entityType))) {
                                    arrP.getEntity(i).shoot(grid, arrB, arrZ, arrP);
                                }
                            }
                            Thread.sleep(4*1000); //frekuensi tembakan Plant B
                        }
                    // Thread Zombie
                    } else if (threadName.equals("zombieThread")){
                        // Random generator Zombie
                        if (p.getGiliran() % 11 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z1 = new ZombieB(randomNum, grid, arrZ);
                        }
                        else if (p.getGiliran() % 15 == 0) {
                            int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                            Zombie z2 = new ZombieA(randomNum, grid, arrZ);
                        }

                        // Thread ZombieA
                        if (entityType.equals("ZA")){
                            System.out.println("ZA run");
                            for (int i = 0; i <= 59 ; i++){
                                if ((arrZ.getEntity(i) != null) && (arrZ.getEntity(i).getZombieType().equals(entityType))) {
                                    arrZ.getEntity(i).move(grid, arrZ, arrP);
                                }
                            }
                            for (int i = 0; i <= 59 ; i++) {     
                                if ((arrZ.getEntity(i) != null) && (arrZ.getEntity(i).getZombieType().equals(entityType))) {
                                    arrZ.getEntity(i).attack(grid, arrZ, arrP);
                                }
                            }
                            Thread.sleep(4*1000); //frekuensi move dan attack Zombie A
                        // Thread ZombieB
                        } else if (entityType.equals("ZB")){
                            System.out.println("ZB run");
                            for (int i = 0; i <= 59 ; i++){
                                if ((arrZ.getEntity(i) != null) && (arrZ.getEntity(i).getZombieType().equals(entityType))) {
                                    arrZ.getEntity(i).move(grid, arrZ, arrP);
                                }
                            }
                            for (int i = 0; i <= 59 ; i++) {     
                                if ((arrZ.getEntity(i) != null) && (arrZ.getEntity(i).getZombieType().equals(entityType))) {
                                    arrZ.getEntity(i).attack(grid, arrZ, arrP);
                                }
                            }
                            Thread.sleep(2*1000); //frekuensi move dan attack Zombie B
                        }
                    }
                    // Thread Sun
                    else if (threadName.equals("sunThread")) {
                        SunPoint sun = new SunPoint();
                        sun.generateSunPoint(arrZ, arrP, arrB, grid);
                        Thread.sleep(3*1000); //waktu hidup sunPoint
                        sun.deleteSun(grid);
                        Thread.sleep(6*1000); //waktu tunggu ke generator sunPoint selanjutnya
                    }
                    // Let the thread sleep for a while.
                    if (p.gameOver(arrZ, arrP)) {
                        Thread.interrupted();
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Game Over");
                        System.out.println("go");

                        //terminate game
                        System.exit(0);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " +  threadName + " interrupted.");
            }
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