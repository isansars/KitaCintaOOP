public class PlantA extends Plant{
    // turunan Plant dengan FireBul.

    //Konstruktor
    //health : 50, sunPoint : 25, freq : 4
    public PlantA(int baris, int kolom, GridField grid, EntityArray<Plant> arr){
        super("PA", 50, 25, 4, "NormalBul", baris, kolom, grid, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ){
        if ((grid.getTextButton(position + 1).equals("ZA")) || grid.getTextButton(position + 1).equals("ZB")) {
            if (arrZ.getEntity(position + 1).getHealth() > 0) {
                arrZ.getEntity(position + 1).setHealth(arrZ.getEntity(position + 1).getHealth() - 20);
                System.out.println("attack");
                System.out.println(arrZ.getEntity(position + 1).getHealth());
            }
            if (arrZ.getEntity(position + 1).getHealth() <= 0) {
                arrZ.getEntity(position + 1).die(grid, arrZ);
                System.out.println("die");
            }
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