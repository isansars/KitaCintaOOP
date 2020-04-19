public class PlantA extends Plant{
    // Turunan Plant dengan NormalBul.

    // Konstruktor
    // health : 50, sunPoint : 25, attfreq : 8000
    public PlantA(int position, EntityArray<Plant> arr){
        super("PA", 50, 25, 8000, "NormalBul", position, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP){
        int i = 1;
        //ada tanaman lain di depannya
        while (arrP.getEntity(position + i) != null) {
            i ++;
        }
        //ada zombie lain di depannya
        if (arrZ.getEntity(position + i) != null) {
            if (arrZ.getEntity(position + i).getHealth() > 0) {
                arrZ.getEntity(position + i).setHealth(arrZ.getEntity(position + i).getHealth() - 20);
                System.out.println("attack");
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