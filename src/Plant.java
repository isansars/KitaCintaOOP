public abstract class Plant{
    // Atribut
    protected int position;
    protected String plantType;
    protected int sunPoints;
    protected int health;
    protected String bulletType;
    protected int attFreq;

    // Method
    
    //Getter
    public int getPosition(){
        return position;
    }

    public char getPlantType(){
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
    
    public int getAttFreq(){
        return attFreq;
    }
    
    //Konstruktor
    public Plant(String plantType, int health, int sunPoints, int attFreq, String bulletType, int baris, int kolom, GridField grid, EntityArray<Plant> arr) {
        this.plantType=plantType;
        this.health=health;
        this.sunPoints=sunPoints;
        this.attFreq=attFreq;
        this.bulletType=bulletType;
        this.position=(kolom+((baris-1)*15)-1);
        grid.editGrid("P", this.position);
        arr.set(position, this);
    }
    
    //Action
    public abstract void die(GridField grid, EntityArray<Plant> arr);
    public abstract void shoot(GridField grid, EntityArray<Bullet> arr);
}
