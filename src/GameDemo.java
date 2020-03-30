//GameDemo.java
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, temp, pos;

        //instansiasi
        GridField x = new GridField();
        //ArrayList<Zombie> arr = new ArrayList<Zombie>(60);
        EntityArray<Zombie> arrZ = new EntityArray<Zombie>();
        EntityArray<Plant> arrP = new EntityArray<Plant>();
        EntityArray<Bullet> arrB = new EntityArray<Bullet>();
        // for (i = 0; i <= 59; i ++) {
        //     arr.add(null);
        // }
        // System.out.println(arr.size());
        Player p = new Player();
        Zombie z0 = new ZombieA(1, x, arrZ);
        Plant p1 = new PlantA(4, 1, x, arrP);

        while (!x.gameOver()) {
            if (p.getGiliran() % 5 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z1 = new ZombieA(randomNum, x, arrZ);
            }
            else if (p.getGiliran() % 9 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z2 = new ZombieB(randomNum, x, arrZ);
            }
            System.out.print("Command: ");
            String cmd = input.next();
            if (cmd.equals("SKIP")) {
                p.skip(arrZ, arrP, arrB, x);
                // for (i = 0; i <= 59; i ++) {
                //     if (arrB.getEntity(i) != null) {
                //         arrB.getEntity(i).move(x, arrB);
                //     }
                // }
                for (i = 0; i <= 59 ; i++){     
                    // if (arrP.getEntity(i) != null) {
                    //     temp = arrP.getEntity(i).getTurn();
                    //     pos = arrP.getEntity(i).getPosition();
                    //     if (arrP.getEntity(i).getAttFreq() == temp){
                    //         if (arrP.getEntity(i) instanceof PlantA){
                    //             Bullet b1 = new NormalBul(pos, x, arrB);
                    //         } else if(arrP.getEntity(i) instanceof PlantB){
                    //             Bullet b2 = new FireBul(pos, x, arrB);
                    //         }
                    //         System.out.println("shoot");
                    //     }
                    //     temp--;
                    //     arrP.getEntity(i).setTurn(temp);
                    //     if (arrP.getEntity(i).getTurn() == 0){
                    //         arrP.getEntity(i).setTurn(arrP.getEntity(i).getAttFreq());
                    //     }
                    // }
                }
                for (i = 0; i <= 59; i ++) {
                    if (arrB.getEntity(i) != null) {
                        arrB.getEntity(i).attack(x, arrB, arrZ);
                    }
                }
            }
        }

        if (x.gameOver()) {
            System.out.println("Game Over");
        }

        // //testing command 1
        // System.out.print("Command: ");
        // String cmd = input.next();
        // if (cmd.equals("skip")) {
        //     for (i = 0; i <= 59; i++) {
        //         p.skip();
        //         if (arr.get(i) != null) {
        //             arr.get(i).move(x, arr);
        //         }
        //     }
        // }

        // Zombie z2 = new ZombieA(1, x, arr);

        // //testing command 2
        // System.out.print("Command: ");
        // String cmd2 = input.next();
        // if (cmd.equals("skip")) {
        //     for (i = 0; i <= 59; i++) {
        //         p.skip();
        //         if (arr.get(i) != null) {
        //             arr.get(i).move(x, arr);
        //         }
        //     }
        // }

    }
}