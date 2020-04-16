import java.util.*;

public class ZombieA extends Zombie {
    // Turunan Zombie dengan speed = 5000, health = 50, damage = 10

    public ZombieA(int ordinat, GridField grid, EntityArray<Zombie> arr) {
        super(5000, "ZA", 50, 10, ordinat, grid, arr);

        grid.addZombieA(position);
    }
}