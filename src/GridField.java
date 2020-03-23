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
        
        //translasi point ke index arrayButton
        //(1,4) index 0
        //(2,4) index 1
        //(3,4) index 2
        //(4,4) index 3
        //(5,4) index 4
        //(6,4) 5
        //(7,4) 6
        //(1,3) 7
        //(2,3) 8
        //(3,3) 9
        //(4,3) 10
        //(5,3) 11
        //(6,3) 12
        //(7,3) 13
        //(1,2) 14
        //(2,2) 15
        //(3,2) 16
        //(4,2) 17
        //(5,2) 18
        //(6,2) 19
        //(7,2) 20
        //(1,1) 21
        //(2,1) 22
        //(3,1) 23
        //(4,1) 24
        //(5,1) 25
        //(6,1) 26
        //(7,1) 27

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

}  
