public abstract class Plant{
    // Atribut
    protected Point position;
    protected int sunPoints;
    protected int health;
    protected Bullet bulletType;
    protected int attFreq;

    // Method
    public abstract void die();
    public abstract void shoot();
}
