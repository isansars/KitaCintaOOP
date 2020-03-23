import java.util.*;

public abstract class Zombie{
    // Atribut
    protected int position;
    protected int nextPosition;
    protected int speed;
    protected int health;
    protected int damage;

    //getter
    public int getPosition() {
        return position;
    }
    public int getNextPosition() {
        return nextPosition;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    //Konstruktor
    public Zombie(int speed, int health, int damage, int ordinat, GridField grid, ArrayList<Zombie> arr) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        if (ordinat == 1) {
            position = 59;
        }
        else if (ordinat == 2) {
            position = 44;
        }
        else if (ordinat == 3) {
            position = 29;
        }
        else if (ordinat == 4) {
            position = 14;
        }
        this.nextPosition = position - speed;

        grid.editGrid("Z", this.position);
        arr.set(position, this);
    }
    // Method
    public void move(GridField grid, ArrayList<Zombie> arr) {
    //zombie bisa melompati zombie lain di depannya, asal nextPosition tidak sama
    //zombie tidak bisa melompati plant
    //zombie dengan plant di depannya akan tertahan di posisinya
        if ((grid.getTextButton(nextPosition).equals("")) && (!grid.getTextButton(position-1).equals("P"))) {
            //ubah GridField
            grid.editGrid("", position);
            position = nextPosition;
            nextPosition = position - speed;
            grid.editGrid("Z", position);

            //ubah ArrayList
            arr.set(position, this);
            arr.set(position + speed, null);
        }
    }
    public void die(GridField grid, ArrayList<Zombie> arr) {
        grid.editGrid("", position);
        arr.set(position, null);
    }
    public void attack(GridField grid, Plant p) {
        if (grid.getTextButton(position-1).equals("P")) {
            //serang plant
        }
    }
}