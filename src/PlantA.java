public class PlantA extends Plant{
    // turunan Plant dengan FireBul.

    //Konstruktor
    public PlantA(int baris, int kolom, GridField grid, EntityArray<Plant> arr){
        super("PA", 50, 25, 2, "NormalBul", baris, kolom, grid, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr){
        NormalBul b = new NormalBul(this.position,grid,arr);
        /*while(grid.getTextButton(b1.getNextPosition()).equals=""){
            b1.move();
            b1.attack();
        }*/
    }


}