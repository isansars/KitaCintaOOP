import java.util.*;

public class ZombieA extends Zombie {
    //turunan Zombie dengan speed = 1, health = 50, damage = 10

    public ZombieA(int ordinat, GridField grid, EntityArray<Zombie> arr) {
        super(1, "ZA", 50, 10, ordinat, grid, arr);
    }
}