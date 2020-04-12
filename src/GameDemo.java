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
        Player p = new Player();
        GridField x = new GridField(p);
        EntityArray<Zombie> arrZ = new EntityArray<Zombie>();
        EntityArray<Plant> arrP = new EntityArray<Plant>();
        EntityArray<Bullet> arrB = new EntityArray<Bullet>();
        Zombie z0 = new ZombieA(1, x, arrZ);

        while (!p.gameOver(arrZ, arrP)) {
            System.out.print("sunPoint: ");
            System.out.println(p.getSunPoints());

            // Random generator Zombie
            if (p.getGiliran() % 7 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z1 = new ZombieB(randomNum, x, arrZ);
            }
            else if (p.getGiliran() % 10 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z2 = new ZombieA(randomNum, x, arrZ);
            }
            System.out.print("Command: ");
            String cmd = input.next();
            if (cmd.equals("SKIP")) {
                p.skip(arrZ, arrP, arrB, x);
            }
            else if (cmd.equals("BUY")) {
                p.buy(x, arrP);
            }
            else {
                System.out.println("Input Anda tidak valid");
            }
        }

        if (p.gameOver(arrZ, arrP)) {
            System.out.println("Game Over");
        }
    }
}