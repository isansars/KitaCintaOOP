public class Player{
    // Atribut
    protected static int sunPoints;
    protected static int giliran; //  ini mending int apa boolean?

    // Konstruktor
    public Player(){
        this.sunPoints  = 100; // ini mending initialnya berapa ya?
        this.giliran    = 1;
    }

    // Getter
    public int getSunPoints(){
        return sunPoints;
    }
    public int getGiliran(){
        return giliran;
    }

    // Setter
    public void setSunPoint(int sunPoints){
        this.sunPoints = sunPoints;
    }
    public void setGiliran(int giliran){
        this.giliran = giliran;
    }

    // Method
    public void skip(EntityArray<Zombie> arrZ, EntityArray<Plant> arrP, EntityArray<Bullet> arrB, GridField grid){
        this.giliran += 1;
        System.out.println(giliran);
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null) {
                arrZ.getEntity(i).move(grid, arrZ);
            }
        }
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null) {
                arrZ.getEntity(i).attack(grid, arrZ, arrP);
            }
        } 
        for (int i = 59; i >= 0; i --) {
            if (arrB.getEntity(i) != null) {
                arrB.getEntity(i).move(grid, arrB);
            }
        }
        for (int i = 0; i <= 59; i ++) {
            if (arrB.getEntity(i) != null) {
                arrB.getEntity(i).attack(grid, arrB, arrZ);
            }
        }
    }
    public void addSunPoint(int sunPoints){
        this.sunPoints += sunPoints;
    }
    public void buyPlant(Plant plant, int position, EntityArray<Plant> arr, GridField grid){
        
    }
}