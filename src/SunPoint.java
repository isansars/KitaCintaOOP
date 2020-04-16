import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*; 
import javax.swing.JTextPane;
import java.awt.Font;

public class SunPoint {
    private static final Icon sunIcon = new ImageIcon("icon/sun.png");
    private int position;

    //konstruktor menggunakan autogenerator
    public SunPoint() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 59 + 1);
        position = randomNum;
    }

    //getter
    public static Icon getSunIcon() {
        return sunIcon;
    }

    //method
    //mengembalikan true apabila grid kosong
    public boolean isSpaceEmpty(EntityArray<Zombie> arrZ, EntityArray<Plant> arrP, EntityArray<Bullet> arrB) {
        return (arrZ.getEntity(position) == null && arrP.getEntity(position) == null && arrB.getEntity(position) == null);
    }

    //meletakkan SunPoint di grid
    public void generateSunPoint(EntityArray<Zombie> arrZ, EntityArray<Plant> arrP, EntityArray<Bullet> arrB, GridField grid) {
        while (!isSpaceEmpty(arrZ, arrP, arrB)) {
            position ++;
            if (position == 59) { //mencapai petak maksimum
                position = 0;
            }
        }

        if (isSpaceEmpty(arrZ, arrP, arrB)) {
            grid.addSunIcon(position);
            grid.editGrid(".", position);
            grid.getButton(position).setForeground(Color.yellow);
            grid.getButton(position).setFont(new Font("Arial", Font.PLAIN, 1));
        }
    }

    public void deleteSun(GridField grid) {
        grid.deleteIcon(position);
        grid.getButton(position).setText("");
    }
}