import java.util.*;

public abstract class Zombie{
    // Atribut
    protected int position;
    protected int nextPosition;
    protected int speed;
    protected int health;
    protected int damage;

    // Getter
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

    // Setter
    public void setPosition(int position){
        this.position = position;
    }
    public void setNextPos(int nextPosition){
        this.nextPosition = nextPosition;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

    // Konstruktor
    public Zombie(int speed, int health, int damage, int ordinat, GridField grid, EntityArray<Zombie> arr) {
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
        arr.add(this.position, this);
    }
    // Method
    public void move(GridField grid, EntityArray<Zombie> arr) {
    //zombie bisa melompati zombie lain di depannya, asal nextPosition tidak sama
    //zombie tidak bisa melompati plant
    //zombie dengan plant di depannya akan tertahan di posisinya
        if ((grid.getTextButton(nextPosition).equals("")) && (!grid.getTextButton(position-1).equals("P"))) {
            //ubah GridField
            grid.editGrid("", position);
            position = nextPosition;
            nextPosition = position - speed;
            grid.editGrid("Z", position);

            //ubah EntityArray
            arr.add(position, this);
            arr.delete(position + speed);
        }
    }
    public void die(GridField grid, EntityArray<Zombie> arr) {
        grid.editGrid("", position);
        arr.delete(position);
    }
    public void attack(GridField grid, Plant p) {
        if (grid.getTextButton(position-1).equals("P")) {
            //serang plant
            
        }
    }
}