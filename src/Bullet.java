public class Bullet{
    // Atribut
    protected String bulletType;
    protected Point position;
    protected int damage;
    protected int speed;

    // Konstruktor
    public Bullet(String bulletType, Point position, int damage, int speed){
        this.bulletType = bulletType;
        this.position   = position;
        this.damage     = damage;
        this.speed      = speed;
    }

    // Getter
    public String getBulletType(){
        return bulletType;
    }
    public Point getPosition(){
        return position;
    }
    public int getDamage(){
        return damage;
    }
    public int getSpeed(){
        return speed;
    }

    // Setter
    public void setBulletType(String bulletType){
        this.bulletType = bulletType;
    }
    public void setPosition(Point position){
        this.position = position;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }

    // Method
    public void incrementPos(){
        this.position.translate(1, 0); // increment 1 posisi ke arah kanan 
    }
}