// GridField.java
// Inisiasi field player  
    
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
      
public class GridField{
    // Atribut  
    private JFrame f;
    private JButton[] arrayButton;
      
    public GridField(){  
        f = new JFrame();
        arrayButton = new JButton[60];

        // Insert into array
        int i;
        for(i = 0; i <= 59; i++) {
            arrayButton[i] = new JButton("");
            arrayButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            arrayButton[i].setVerticalTextPosition(SwingConstants.CENTER);
        }

        // Buat grid     
        for (i = 0; i <= 59; i ++) {
            f.add(arrayButton[i]);
        }
      
        f.setLayout(new GridLayout(4,15));  
        //setting grid layout of 4 rows and 7 columns  
      
        f.setSize(1500,400);  
        f.setVisible(true);  
    }

    // Getter
    public String getTextButton(int i) {
        return arrayButton[i].getText();
    }
    
    public void deleteIcon(int position) {
    // position adalah index dari grid yang ingin diubah, code adalah karakter yang akan muncul di grid tsb
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/Blank.png");
        arrayButton[position].setIcon(icon);
    }

    public void editGrid(String code, int position) {
        arrayButton[position].setText(code);
    }

    public void addPlantA(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/PlantA.png");
        arrayButton[position].setIcon(icon);
    }

    public void addPlantB(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/PlantB.png");
        arrayButton[position].setIcon(icon);
    }

    public void addZombieA(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/ZombieA.png");
        arrayButton[position].setIcon(icon);
    }

    public void addZombieB(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/ZombieB.png");
        arrayButton[position].setIcon(icon);
    }

    public void addNormalBul(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/NormalBul.png");
        arrayButton[position].setIcon(icon);
    }

    public void addFireBul(int position) {
        Icon icon = new ImageIcon("/home/madiha/KitaCintaOOP/icon/FireBul.png");
        arrayButton[position].setIcon(icon);
    }


//     public boolean gameOver() {
//         if (getTextButton(1).equals("ZA")) {
//             return getTextButton(0).equals("");
//         }
//         else if (getTextButton(16).equals("ZA")) {
//             return getTextButton(15).equals("");
//         }
//         else if (getTextButton(31).equals("ZA")) {
//             return getTextButton(30).equals("");
//         }
//         else if (getTextButton(46).equals("ZA")) {
//             return getTextButton(45).equals("");
//         }
//         else {
//             return ((getTextButton(0).equals("ZA")) || (getTextButton(15).equals("ZA")) || (getTextButton(30).equals("ZA")) || (getTextButton(45).equals("ZA")) || (getTextButton(0).equals("ZB")) || (getTextButton(15).equals("ZB")) || (getTextButton(30).equals("ZB")) || (getTextButton(45).equals("ZB")))
//             || (getTextButton(1).equals("ZA")) || (getTextButton(16).equals("ZA")) || (getTextButton(31).equals("ZA")) || (getTextButton(46).equals("ZA"));
//         }
//     }
}  
