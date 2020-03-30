import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

public class ZombieDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GridField g = new GridField();
        EntityArray<Zombie> arrZ = new EntityArray<Zombie>();
        EntityArray<Plant> arrP = new EntityArray<Plant>();
        EntityArray<Bullet> arrB = new EntityArray<Bullet>();
        Player p = new Player();
        Plant p1 = new PlantA(2, 2, g, arrP);
        Plant p2 = new PlantB(3, 13, g, arrP);
        Zombie z3 = new ZombieA(2, g, arrZ);
        Zombie z1 = new ZombieB(3, g, arrZ);

        while (!g.gameOver()) {
            System.out.print("sunPoint: ");
            System.out.println(p.getSunPoints());

            
            System.out.print("Command: ");
            String cmd = input.next();
            if (cmd.equals("SKIP")) {
                for (int i = 0; i <= 59 ; i++) {     
                    if (arrZ.getEntity(i) != null) {
                        arrZ.getEntity(i).move(g, arrZ);
                    }
                }
            }
            else if (cmd.equals("DEL")) {
                p2.die(g, arrP);
            } else if (cmd.equals("ZOM")) {
                Zombie z2 = new ZombieA(3, g, arrZ);
            }
            else {
                System.out.println("Input Anda tidak valid");
            }
        }

        if (g.gameOver()) {
            System.out.println("Game Over");
        }
    }
}