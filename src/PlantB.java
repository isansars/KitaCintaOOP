public class PlantB extends Plant{
    // turunan Plant dengan NormalBul.


    //Konstruktor
    public PlantB(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PB", 60, 50, 2, "FireBul", baris, kolom, grid, arr);
    }

    // Method
    public void die(GridField grid, EntityArray<Plant> arr){
        grid.editGrid("", position);
        arr.delete(position);
    }
    public void shoot(GridField grid, EntityArray<Bullet> arr){
        FireBul b = new FireBul(this.position+1, grid, arr);
        /*while(grid.getTextButton(b1.getNextPosition()).equals=""){
            b1.move();
            b1.attack();
        }*/
    }


}