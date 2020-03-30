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
        EntityArray<Zombie> arrZ = new EntityArray<Zombie>();
        EntityArray<Plant> arrP = new EntityArray<Plant>();
        EntityArray<Bullet> arrB = new EntityArray<Bullet>();
        Player p = new Player();
        Zombie z0 = new ZombieA(1, x, arrZ);

        while (!x.gameOver()) {
            System.out.print("sunPoint: ");
            System.out.println(p.getSunPoints());

            //random generator zombie
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
                for (i = 0; i <= 59; i ++) {
                    if (arrB.getEntity(i) != null) {
                        arrB.getEntity(i).attack(x, arrB, arrZ);
                    }
                }
            }
            else if (cmd.equals("BUY")) {
                p.buy(x, arrP);
            }
            else {
                System.out.println("Input Anda tidak valid");
            }
        }

        if (x.gameOver()) {
            System.out.println("Game Over");
        }
    }
}