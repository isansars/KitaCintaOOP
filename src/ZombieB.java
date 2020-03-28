import java.util.*;

public class ZombieB extends Zombie {
    //turunan Zombie dengan speed = 2, health = 15, damage = 3

    public ZombieB(int ordinat, GridField grid, EntityArray<Zombie> arr) {
        super(2, 15, 3, ordinat, grid, arr);
    }
}