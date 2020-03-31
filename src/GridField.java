//GridField.java
//inisiasi field player  
    
import java.awt.*;  
import java.awt.event.*;  
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
      
        f.setSize(1000,400);  
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
        if (getTextButton(1).equals("ZA")) {
            return getTextButton(0).equals("");
        }
        else if (getTextButton(16).equals("ZA")) {
            return getTextButton(15).equals("");
        }
        else if (getTextButton(31).equals("ZA")) {
            return getTextButton(30).equals("");
        }
        else if (getTextButton(46).equals("ZA")) {
            return getTextButton(45).equals("");
        }
        else {
            return ((getTextButton(0).equals("ZA")) || (getTextButton(15).equals("ZA")) || (getTextButton(30).equals("ZA")) || (getTextButton(45).equals("ZA")) || (getTextButton(0).equals("ZB")) || (getTextButton(15).equals("ZB")) || (getTextButton(30).equals("ZB")) || (getTextButton(45).equals("ZB")));
        }
    }
}  
