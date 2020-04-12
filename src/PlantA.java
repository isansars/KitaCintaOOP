public class PlantA extends Plant{
    // Turunan Plant dengan NormalBul.

    // Konstruktor
    // health : 50, sunPoint : 25, attfreq : 4
    public PlantA(int baris, int kolom, GridField grid, EntityArray<Plant> arr){
        super("PA", 50, 25, 4, "NormalBul", baris, kolom, grid, arr);
        grid.addPlantA(position);
    }

    public PlantA(int position, EntityArray<Plant> arr){
        super("PA", 50, 25, 4, "NormalBul", position, arr);
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
            NormalBul b = new NormalBul(position + i, grid, arr);
        }
    }
}