import java.util.*;

public class ZombieB extends Zombie {
    // Turunan Zombie dengan speed = 1, health = 80, damage = 20

    public ZombieB(int ordinat, GridField grid, EntityArray<Zombie> arr) {
        super(1, "ZB", 80, 20, ordinat, grid, arr);
    }
}