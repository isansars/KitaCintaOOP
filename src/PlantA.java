public class PlantA extends Plant{
    // turunan Plant dengan FireBul.


    //Konstruktor
    public PlantA(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PA", 50, 25, 2, grid, arr,"FireBul",baris,kolom,grid,arr);
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