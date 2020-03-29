import java.util.*;

public class Bullet{
    // Atribut
    protected String bulletType;
    protected int position;
    protected int nextPosition;
    protected int damage;
    protected int speed;

    // Konstruktor
    public Bullet(final String bulletType, final int damage, final int speed, final int plantPosition,
            final GridField grid, final EntityArray<Bullet> arr) {
        this.bulletType = bulletType;
        this.damage = damage;
        this.speed = speed;
        this.position = plantPosition + 1;
        this.nextPosition = plantPosition + 1 + speed;

        grid.editGrid(bulletType, this.position);
        arr.set(position, this);
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
    public void setBulletType(final String bulletType) {
        this.bulletType = bulletType;
    }

    public void setPosition(final int position) {
        this.position = position;
    }

    public void setDamage(final int damage) {
        this.damage = damage;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    // Method
    public void move(final GridField grid, final EntityArray<Bullet> arr) {
        if ((grid.getTextButton(nextPosition).equals("")) && (!grid.getTextButton(position + 1).equals("Z"))) {
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

    public void attack(final GridField grid, final EntityArray<Bullet> arrB, final EntityArray<Zombie> arrZ) {
        if (grid.getTextButton(position + 1).equals("Z")) {
            // {serang zombie}
            final int health = arrZ.getEntity(position + 1).getHealth() - arrB.getEntity(position).getDamage();
            arrZ.getEntity(position+1).setHealth(health);
            // Menghilang setelah menyerang
            grid.editGrid("", position);
            arrB.delete(position);
        }
    }
}