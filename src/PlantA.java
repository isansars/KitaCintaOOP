public class PlantA extends Plant{
    // turunan Plant dengan FireBul.

    //Konstruktor
    public PlantA(int baris, int kolom, GridField grid, EntityArray<Plant> arr){
        super("PA", 50, 25, 4, "NormalBul", baris, kolom, grid, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ){
        if ((grid.getTextButton(position + 1).equals("ZA")) || grid.getTextButton(position + 1).equals("ZB")) {
            arrZ.getEntity(position + 1).setHealth(arrZ.getEntity(position + 1).getHealth() - 2);
        }
        else {
            NormalBul b = new NormalBul(this.position,grid,arr);
        }
        /*while(grid.getTextButton(b1.getNextPosition()).equals=""){
            b1.move();
            b1.attack();
        }*/
    }


}