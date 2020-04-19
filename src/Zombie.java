import java.util.*;

public abstract class Zombie{
    // Atribut
    protected int position;
    protected String type;
    protected int nextPosition;
    protected static int speed;
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
    public String getZombieType(){
        return type;
    }
    public static int getSpeed() {
        return speed;
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
    public Zombie(int speed, String type, int health, int damage, int ordinat, GridField grid, EntityArray<Zombie> arr) {
        this.speed = speed;
        this.type = type;
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
        this.nextPosition = position - 1;

        //grid.editGrid(this.type, this.position);
        arr.add(this.position, this);
    }
    // Method
    public void move(GridField grid, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP) {
    // Zombie bisa melompati zombie lain di depannya, asal nextPosition tidak sama
    // Zombie tidak bisa melompati plant
    // Zombie dengan plant di depannya akan tertahan di posisinya
        if (arrP.getEntity(position-1) == null) {
            // Mengubah posisi yang akan ditempati oleh zombie berdasarkan ada atau tidaknya entitas pada nextPosition
            if (arrZ.getEntity(nextPosition) == null && arrP.getEntity(nextPosition) == null) {
                //delete posisi lama
                grid.editGrid("", position);
                grid.deleteIcon(position);
                arrZ.delete(position);

                //ubah jadi posisi baru
                position = nextPosition;
                nextPosition = position - 1;
                arrZ.add(position, this);
                if (type == "ZA") {
                    grid.addZombieA(position);
                    grid.editGrid("", position);
                }
                else if (type == "ZB") {
                    grid.addZombieB(position);
                    grid.editGrid("", position);
                }

            } 
            else if (arrP.getEntity(nextPosition) != null) {
                //delete posisi lama
                grid.editGrid("", position);
                grid.deleteIcon(position);
                arrZ.delete(position);

                //ubah jadi posisi baru
                position = nextPosition + 1;
                nextPosition = position - 1;
              
                arrZ.add(position, this);
              
                if (type == "ZA") {
                    grid.addZombieA(position);
                    grid.editGrid("", position);
                }
                else if (type == "ZB") {
                    grid.addZombieB(position);
                    grid.editGrid("", position);
                }
              

            } 
            else if (arrZ.getEntity(nextPosition) != null) {
                 //delete posisi lama
                 grid.editGrid("", position);
                 grid.deleteIcon(position);
                 arrZ.delete(position);
 
                 //ubah jadi posisi baru
                 position = nextPosition - 1;
                 nextPosition = position - 1;
              
                 arrZ.add(position, this);
              
                if (type == "ZA") {
                    grid.addZombieA(position);
                    grid.editGrid("", position);
                }
                else if (type == "ZB") {
                    grid.addZombieB(position);
                    grid.editGrid("", position);
                }
                System.out.println(grid.getTextButton(position));
            } 
        }
    }
    public void die(GridField grid, EntityArray<Zombie> arr) {
        grid.editGrid("", position);
        grid.deleteIcon(position);
        arr.delete(position);
        System.out.println("Zombie die");
    }

    public void attack(GridField grid, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP) {
        if (position != 0) {
            if (arrP.getEntity(position - 1) != null) {
                // Serang 
                if (arrP.getEntity(position-1).getHealth() > 0){
                    int health = arrP.getEntity(position - 1).getHealth() - getDamage();
                    arrP.getEntity(position-1).setHealth(health);
                }
                // Health Plant = 0, die.
                else if (arrP.getEntity(position-1).getHealth() <= 0){
                    arrP.getEntity(position-1).die(grid, arrP);
                }
            }
        }
    }
}