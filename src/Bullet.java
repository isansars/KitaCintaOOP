import java.util.*;

public class Bullet{
    // Atribut
    protected String bulletType;
    protected int position;
    protected int nextPosition;
    protected int damage;
    protected int speed;

    // Konstruktor
    public Bullet(String bulletType, int damage, int speed, int position, GridField grid, EntityArray<Bullet> arr) {
        this.bulletType = bulletType;
        this.damage = damage;
        this.speed = speed;

        // int temp = position;
        // if (!grid.getTextButton(temp).equals("")) {
        //     while (!grid.getTextButton(temp).equals("")) {
        //         temp ++;
        //     }
        // }
        this.position = position;
        this.nextPosition = position + this.speed;

        //grid.editGrid(this.bulletType, this.position);
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
    public void move(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ) {
        if (!isOutRange()) {
            if ((position == 14) || (position == 29) || (position == 44) || (position == 59)){
                grid.editGrid("", position);
                grid.deleteIcon(position);
                arr.delete(position);
            }
            //else if ((grid.getTextButton(nextPosition).equals(""))) {
            else if (arrZ.getEntity(nextPosition) == null) {
                //TO DOmengecek di antara position dengan nextPosition ada zombie atau tidak
                // ubah GridField
                grid.editGrid("", position);
                grid.deleteIcon(position);
                position = nextPosition;
                nextPosition = position + this.speed;
                //grid.editGrid(bulletType, position);
                if (bulletType == "o") {
                    grid.addFireBul(position);
                }
                else if (bulletType == "->") {
                    grid.addNormalBul(position);
                }
    
                // ubah ArrayList
                arr.add(position, this);
                arr.delete(position - speed);
            }
        }
        else {
            grid.editGrid("", position);
            grid.deleteIcon(position);
            arr.delete(position);
        }
    }

    //attack harus diperbaiki
    public void attack(GridField grid, EntityArray<Bullet> arrB, EntityArray<Zombie> arrZ) {
        if (!isOutRange()) {
            //if (grid.getTextButton(position + 1).equals("ZA") || grid.getTextButton(position + 1).equals("ZB")) {
            if (arrZ.getEntity(position + 1) != null) {
                // serang zombie
                int health = arrZ.getEntity(position + 1).getHealth() - arrB.getEntity(position).getDamage();
                arrZ.getEntity(position+1).setHealth(health);
                // Health Zombie = 0, die.
                if (arrZ.getEntity(position+1).getHealth() <= 0){
                    arrZ.getEntity(position+1).die(grid, arrZ);
                }
                // Menghilang setelah menyerang
                grid.editGrid("", position);
                grid.deleteIcon(position);
                arrB.delete(position);
            }
        }
    }

    boolean isOutRange() {
        if (position < 15) {
            return (nextPosition >= 15);
        }
        else if (position < 30) {
            return (nextPosition >= 30);
        }
        else if (position < 45) {
            return (nextPosition >= 45);
        }
        else {
            return (nextPosition > 59);
        }
    }
}