import java.util.*;

public class Player{
    // Atribut
    protected static int sunPoints;
    protected static int giliran; 

    // Konstruktor
    public Player(){
        this.sunPoints  = 100; 
        this.giliran    = 1;
    }

    // Getter
    public int getSunPoints(){
        return sunPoints;
    }
    public int getGiliran(){
        return giliran;
    }

    // Setter
    public void setSunPoint(int sunPoints){
        this.sunPoints = sunPoints;
    }
    public void setGiliran(int giliran){
        this.giliran = giliran;
    }

    // Method
    public void skip(EntityArray<Zombie> arrZ, EntityArray<Plant> arrP, EntityArray<Bullet> arrB, GridField grid){
        this.giliran += 1;
        sunPoints += 25;
        System.out.println(giliran);
        //prioritas 1 : bullet
        for (int i = 59; i >= 0; i --) {
            if (arrB.getEntity(i) != null) {
                arrB.getEntity(i).move(grid, arrB);
            }
        }
        for (int i = 0; i <= 59; i ++) {
            if (arrB.getEntity(i) != null) {
                arrB.getEntity(i).attack(grid, arrB, arrZ);
            }
        }

        //prioritas 2 : plant shoot
        for (int i = 0; i <= 59; i ++) {
            if (arrP.getEntity(i) != null) {
                if (giliran % arrP.getEntity(i).getAttFreq() == 0) {
                    arrP.getEntity(i).shoot(grid, arrB, arrZ);
                }
            }
        }

        //prioritas 3 : zombie
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null) {
                arrZ.getEntity(i).move(grid, arrZ);
            }
        }
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null) {
                arrZ.getEntity(i).attack(grid, arrZ, arrP);
            }
        } 
        
    }

    //method untuk player membeli plant
    public void buy(GridField grid, EntityArray<Plant> arrP) {
        Scanner input = new Scanner(System.in);

        System.out.println("Daftar harga: ");
        System.out.println("1. PlantA: 25 sunPoint");
        System.out.println("2. PlantB: 50 sunPoint");
        System.out.print("Masukkan angka 1 atau 2 untuk memilih tanaman:");
        String read = input.next();
        System.out.print("Masukkan row tanaman: ");
        int row = input.nextInt();
        System.out.print("Masukkan column tanaman: ");
        int column = input.nextInt();
        if (row >= 1 && row <= 4 && column >= 1 && column <= 15) {
            // Cek petak
            int pos = (column+((row-1)*15)-1);
            boolean check;
            if (!(grid.getTextButton(pos).equals(""))){
                System.out.println("Petak telah terisi.");
            } else{
                if (read.equals("1")) {
                    Plant pnew = new PlantA(row, column, grid, arrP);
                    sunPoints -= pnew.getSunPoints();
                    System.out.println("Pembelian berhasil");
                }
                else if (read.equals("2")) {
                    Plant pnew = new PlantB(row, column, grid, arrP);
                    sunPoints -= pnew.getSunPoints();
                    System.out.println("Pembelian berhasil");
                }
                else {
                    System.out.println("Input Anda tidak valid");
                }
            }
        }
        else {
            System.out.println("Input Anda tidak valid");
        }
    }
    public void addSunPoint(int sunPoints){
        this.sunPoints += sunPoints;
    }
    public boolean check(GridField grid, int position){
        if (!(grid.getTextButton(position).equals(""))){
            return false;
        } else{
            return true;
        }
    }
}