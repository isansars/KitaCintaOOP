public class PlantB extends Plant{
    // turunan Plant dengan NormalBul.


    //Konstruktor
    public PlantB(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PB", 60, 2, 1, grid, arr,"NormalBul",baris,kolom,grid,arr);
    }
    public void die(GridField grid, EntityArray<Plant> arr)
    {
        grid.editGrid("", position);
        arr.set(position, null);
    }
    public void shoot(GridField grid, EntityArray<Bullet> arr)
    {
        Firebul b1 = new FireBul(this.position,grid,arr);
        while(grid.getTextButton(b1.getNextPosition()).equals=""){
            b1.move();
            b1.attack();
        }
    }


}