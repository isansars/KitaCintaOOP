//GameDemo.java
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i;

        //instansiasi
        GridField x = new GridField();
        //ArrayList<Zombie> arr = new ArrayList<Zombie>(60);
        EntityArray<Zombie> arr = new EntityArray<Zombie>();
        // for (i = 0; i <= 59; i ++) {
        //     arr.add(null);
        // }
        // System.out.println(arr.size());
        Player p = new Player();
        Zombie z0 = new ZombieA(1, x, arr);

        while (!x.gameOver()) {
            if (p.getGiliran() % 5 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z1 = new ZombieA(randomNum, x, arr);
            }
            else if (p.getGiliran() % 9 == 0) {
                int randomNum = ThreadLocalRandom.current().nextInt(1, 4 + 1);
                Zombie z2 = new ZombieB(randomNum, x, arr);
            }
            System.out.print("Command: ");
            String cmd = input.next();
            if (cmd.equals("SKIP")) {
                p.skip();
                for (i = 0; i <= 59 ; i++) {     
                    if (arr.getEntity(i) != null) {
                        arr.getEntity(i).move(x, arr);
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