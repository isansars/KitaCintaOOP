import java.util.*;

public class Bullet{
    // Atribut
    protected String bulletType;
    protected int position;
    protected int nextPosition;
    protected int damage;
    protected int speed;

    // Konstruktor
    public Bullet(String bulletType, int damage, int speed, int plantPosition, GridField grid, EntityArray<Bullet> arr) {
        this.bulletType = bulletType;
        this.damage = damage;
        this.speed = speed;
        this.position = plantPosition + 1;
        this.nextPosition = plantPosition + 1 + speed;

        grid.editGrid(bulletType, this.position);
        arr.add(this.position, this);
    }

    // Getter
    public String getBulletType() {
        return bulletType;
    }

    public int getPosition() {
        return position;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    // Setter
    public void setBulletType(String bulletType) {
        this.bulletType = bulletType;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Method
    public void move(GridField grid, EntityArray<Bullet> arr) {
        if ((grid.getTextButton(nextPosition).equals("")) && (!grid.getTextButton(position + 1).equals("Z"))) {
            if ((position == 14) || (position == 29) || (position == 44) || (position == 59)){
                grid.editGrid("", position);
                arr.delete(position);
            } else {
                // ubah GridField
                grid.editGrid("", position);
                position = nextPosition;
                nextPosition = position + speed;
                grid.editGrid(bulletType, position);

                // ubah ArrayList
                arr.add(position, this);
                arr.delete(position - speed);
            }
        }
    }

    public void attack(GridField grid, EntityArray<Bullet> arrB, EntityArray<Zombie> arrZ) {
        if (grid.getTextButton(position + 1).equals("ZA") || grid.getTextButton(position + 1).equals("ZA")) {
            // serang zombie
            int health = arrZ.getEntity(position + 1).getHealth() - arrB.getEntity(position).getDamage();
            arrZ.getEntity(position+1).setHealth(health);
            // Health Zombie = 0, die.
            if (arrZ.getEntity(position+1).getHealth() <= 0){
                arrZ.getEntity(position+1).die(grid, arrZ);
            }
            // Menghilang setelah menyerang
            grid.editGrid("", position);
            arrB.delete(position);
        }
    }
}