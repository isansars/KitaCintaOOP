import java.util.*;

public class ZombieA extends Zombie {
    // Turunan Zombie dengan speed = 2, health = 50, damage = 10

    public ZombieA(int ordinat, GridField grid, EntityArray<Zombie> arr) {
        super(2, "ZA", 50, 10, ordinat, grid, arr);
    }
}