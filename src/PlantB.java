public class PlantB extends Plant{
    // turunan Plant dengan NormalBul.

    //Konstruktor
    public PlantB(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PB", 60, 50, 2, "FireBul", baris, kolom, grid, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ){
        FireBul b = new FireBul(this.position, grid, arr);
        /*while(grid.getTextButton(b1.getNextPosition()).equals=""){
            b1.move();
            b1.attack();
        }*/
    }


}