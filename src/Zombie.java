public abstract class Zombie{
    // Atribut
    protected int position;
    protected int speed;
    protected int health;
    protected int damage;

    //getter
    public int getPosition() {
        return position;
    }
    public int getHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }
    //Konstruktor
    public Zombie(int speed, int health, int damage, int ordinat, GridField grid) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        if (ordinat == 1) {
            position = 27;
        }
        else if (ordinat == 2) {
            position = 20;
        }
        else if (ordinat == 3) {
            position = 13;
        }
        else if (ordinat == 4) {
            position = 6;
        }

        grid.editGrid("Z", this.position);
    }
    // Method
    public void move(GridField grid) {
        int tempPosition = position - speed;
        if (grid.getTextButton(tempPosition).equals("")) {
            grid.editGrid("", position);
            position = tempPosition;
            grid.editGrid("Z", position);
        }
    }
    public void die(GridField grid) {
        grid.editGrid("", position);
    }
    public void attack(GridField grid, Plant p) {
        if(grid.getTextButton(position-1).equals("P")) {
            //serang plant
        }
    }
}