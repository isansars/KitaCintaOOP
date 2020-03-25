//GridField.java
//inisiasi field player  
    
import java.awt.*;  
import javax.swing.*;  
      
public class GridField{
    //atribut  
    private JFrame f;
    private JButton[] arrayButton;
      
    public GridField(){  
        f = new JFrame();
        arrayButton = new JButton[60];

        //insert into array
        int i;
        for(i = 0; i <= 59; i++) {
            arrayButton[i] = new JButton("");
        }

        //buat grid     
        for (i = 0; i <= 59; i ++) {
            f.add(arrayButton[i]);
        }
      
        f.setLayout(new GridLayout(4,15));  
        //setting grid layout of 4 rows and 7 columns  
      
        f.setSize(700,400);  
        f.setVisible(true);  
    }

    //getter
    public String getTextButton(int i) {
        return arrayButton[i].getText();
    }
    
    public void editGrid(String code, int position) {
    //position adalah index dari grid yang ingin diubah, code adalah karakter yang akan muncul di grid tsb
        arrayButton[position].setText(code);
    }

    public boolean gameOver() {
        return ((getTextButton(0).equals("Z")) || (getTextButton(15).equals("Z")) || (getTextButton(30).equals("Z")) || (getTextButton(45).equals("Z")));
    }
}  
