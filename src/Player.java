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

        // Prioritas 1 : bullet
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

        // Prioritas 2 : plant shoot
        for (int i = 0; i <= 59; i ++) {
            if (arrP.getEntity(i) != null) {
                int temp = arrP.getEntity(i).getTurn();
                if (arrP.getEntity(i).getAttFreq() == temp) {
                    arrP.getEntity(i).shoot(grid, arrB, arrZ);
                }
                temp--;
                if (temp ==  0){
                    temp = arrP.getEntity(i).getAttFreq();
                }
                arrP.getEntity(i).setTurn(temp);
            }
        }

        // Prioritas 3 : zombie
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null && !grid.gameOver()) {
                arrZ.getEntity(i).move(grid, arrZ);
            }
        }
        for (int i = 0; i <= 59 ; i++) {     
            if (arrZ.getEntity(i) != null && !grid.gameOver()) {
                arrZ.getEntity(i).attack(grid, arrZ, arrP);
            }
        }    
    }

    // Method untuk player membeli plant
    public void buy(GridField grid, EntityArray<Plant> arrP) {
        Scanner input = new Scanner(System.in);

        System.out.println("Daftar harga: ");
        System.out.println("1. PlantA: 25 sunPoint");
        System.out.println("2. PlantB: 50 sunPoint");
        System.out.print("Masukkan angka 1 atau 2 untuk memilih tanaman:");
        String read = input.next();
        if ((read.equals("1")) && (this.sunPoints < 25)){
            System.out.println("Sun Points tidak mencukupi.");
        } else if ((read.equals("2")) && (this.sunPoints < 50)){
            System.out.println("Sun Points tidak mencukupi.");
        } else {
            System.out.print("Masukkan row tanaman: ");
            int row = input.nextInt();
            System.out.print("Masukkan column tanaman: ");
            int column = input.nextInt();
            if (row >= 1 && row <= 4 && column >= 1 && column <= 15) {
                // Cek petak
                int pos = (column+((row-1)*15)-1);
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
    }
    public void addSunPoint(int sunPoints){
        this.sunPoints += sunPoints;
    }
}