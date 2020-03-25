public abstract class Plant{
    // Atribut
    protected int position;
    protected int nextPosition;
    protected int sunPoints;
    protected int health;
    protected Bullet bullet;
    protected int attFreq;

    // Method
    public abstract void die();
    public abstract void shoot();
}
