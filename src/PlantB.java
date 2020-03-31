public class PlantB extends Plant{
    // Turunan Plant dengan FireBul.

    // Konstruktor
    // health : 60, sunPoint : 50, attfreq : 3
    public PlantB(int baris, int kolom,GridField grid, EntityArray<Plant> arr){
        super("PB", 60, 50, 3, "FireBul", baris, kolom, grid, arr);
    }

    // Method
    public void shoot(GridField grid, EntityArray<Bullet> arr, EntityArray<Zombie> arrZ){
        int i = 1;
        while (!(grid.getTextButton(position + i).equals(""))) {
            if ((grid.getTextButton(position + i).equals("ZA")) || grid.getTextButton(position + i).equals("ZB")) {
                if (arrZ.getEntity(position + i).getHealth() > 0) {
                    arrZ.getEntity(position + i).setHealth(arrZ.getEntity(position + i).getHealth() - 20);
                    System.out.println("attack");
                    System.out.println(arrZ.getEntity(position + i).getHealth());
                }
                if (arrZ.getEntity(position + i).getHealth() <= 0) {
                    arrZ.getEntity(position + i).die(grid, arrZ);
                    System.out.println("die");
                }
            }
            else {
                i ++;
            }
        }
        
        if (grid.getTextButton(position + i).equals("")) {
            FireBul b = new FireBul(position, grid, arr);
        }
    }
}