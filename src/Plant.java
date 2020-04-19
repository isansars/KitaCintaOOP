public abstract class Plant{
    // Atribut
    protected int position;
    protected String plantType;
    protected int sunPoints;
    protected int health;
    protected String bulletType;
    protected static int attFreq;
    protected int turn;
    
    // Getter
    public int getPosition(){
        return position;
    }
    public String getPlantType(){
        return plantType;
    }
    public int getSunPoints(){
        return sunPoints;
    }
    public int getHealth(){
        return health;
    }
    public String getBulletType(){
        return bulletType;
    }
    public static int getAttFreq(){
        return attFreq;
    }
    public int getTurn(){
        return turn;
    }

    // Setter
    public void setPosition(int position){
        this.position = position;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setTurn(int turn){
        this.turn = turn;
    }
    
    // Konstruktor
    /*public Plant(String plantType, int health, int sunPoints, int attFreq, String bulletType, int baris, int kolom, GridField grid, EntityArray<Plant> arr) {
        this.plantType  = plantType;
        this.health     = health;
        this.sunPoints  = sunPoints;
        this.attFreq    = attFreq;
        this.turn       = attFreq;
        this.bulletType = bulletType;
        this.position   = (kolom+((baris-1)*15)-1);
        
        arr.add(this.position, this);
    }*/

    public Plant(String plantType, int health, int sunPoints, int attFreq, String bulletType, int position, EntityArray<Plant> arr) {
        this.plantType  = plantType;
        this.health     = health;
        this.sunPoints  = sunPoints;
        this.attFreq    = attFreq;
        this.turn       = attFreq;
        this.bulletType = bulletType;
        this.position   = position;
        
        arr.add(this.position, this);
    }
    
    // Method
    public void die(GridField grid, EntityArray<Plant> arr){
        grid.editGrid("", position);
        grid.deleteIcon(position);
        arr.delete(position);
    }
    public abstract void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP);
}
