//GameDemo.java
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //instansiasi
        GridField x = new GridField();
        Zombie z1 = new ZombieA(1, x);
        Player p = new Player();

        System.out.print("Command: ");
        String cmd = input.next();
        if (cmd.equals("skip")) {
            p.skip();
            z1.move(x);
        }
    }
}