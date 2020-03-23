import java.util.*;

public class ZombieA extends Zombie {
    //turunan Zombie dengan speed = 1, health = 10, damage = 2

    public ZombieA(int ordinat, GridField grid, ArrayList<Zombie> arr) {
        super(1, 10, 2, ordinat, grid, arr);
    }
}