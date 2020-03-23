//GameDemo.java
import java.util.*;

public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i;

        //instansiasi
        GridField x = new GridField();
        ArrayList<Zombie> arr = new ArrayList<Zombie>(60);
        for (i = 0; i <= 59; i ++) {
            arr.add(null);
        }
        System.out.println(arr.size());
        Player p = new Player();
        Zombie z1 = new ZombieA(1, x, arr);

        //testing command 1
        System.out.print("Command: ");
        String cmd = input.next();
        if (cmd.equals("skip")) {
            for (i = 0; i <= 59; i++) {
                p.skip();
                if (arr.get(i) != null) {
                    arr.get(i).move(x, arr);
                }
            }
        }

        Zombie z2 = new ZombieA(1, x, arr);

        //testing command 2
        System.out.print("Command: ");
        String cmd2 = input.next();
        if (cmd.equals("skip")) {
            for (i = 0; i <= 59; i++) {
                p.skip();
                if (arr.get(i) != null) {
                    arr.get(i).move(x, arr);
                }
            }
        }

    }
}