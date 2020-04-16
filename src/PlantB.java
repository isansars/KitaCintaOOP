public class PlantB extends Plant{
    // Turunan Plant dengan FireBul.

    // Konstruktor
    // health : 60, sunPoint : 50, attfreq : 6000
    public PlantB(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PB", 60, 50, 6000, "FireBul", baris, kolom, grid, arr);
        grid.addPlantB(position);
    }
    public PlantB(int position, EntityArray<Plant> arr){
        super("PB", 60, 50, 3, "FireBul", position, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP){
        int i = 1;
        //ada tanaman lain di depannya
        while (arrP.getEntity(position + i) != null) {
            //while (!(grid.getTextButton(position + i).equals(""))) {
            //if ((grid.getTextButton(position + i).equals("ZA")) || grid.getTextButton(position + i).equals("ZB")) {
            i ++;
        }
        //ada zombie lain di depannya
        if (arrZ.getEntity(position + i) != null) {
            if (arrZ.getEntity(position + i).getHealth() > 0) {
                arrZ.getEntity(position + i).setHealth(arrZ.getEntity(position + i).getHealth() - 20);
                System.out.println("attack");
                //System.out.println(arrZ.getEntity(position + i).getHealth());
            }
            else if (arrZ.getEntity(position + i).getHealth() <= 0) {
                arrZ.getEntity(position + i).die(grid, arrZ);
                System.out.println("die");
            }
        }
        else if (grid.getTextButton(position + i).equals("")) {
            FireBul b = new FireBul(position + i, grid, arr);
        }
    }
}