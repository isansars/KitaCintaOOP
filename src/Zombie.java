public abstract class Zombie{
    // Atribut
    protected Point position;
    protected int speed;
    protected int health;
    protected int damage;

    // Method
    public abstract void move();
    public abstract void die();
    public abstract void attack();
}