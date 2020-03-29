public class Player{
    // Atribut
    protected static int sunPoints;
    protected static int giliran; //  ini mending int apa boolean?

    // Konstruktor
    public Player(){
        this.sunPoints  = 50; // ini mending initialnya berapa ya?
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
    public void skip(){
        this.giliran += 1;
        System.out.println(giliran);
    }
    public void addSunPoint(int sunPoints){
        this.sunPoints += sunPoints;
    }
    public void buyPlant(Plant plantType){
        
    }
}