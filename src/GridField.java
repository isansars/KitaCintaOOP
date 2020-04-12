// GridField.java
// Inisiasi field player  
    
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
      
public class GridField{
    // Atribut  
    private JFrame f;
    private JButton[] arrayButton;
    private ButtonGroup buyButton;
      
    public GridField(){  
        f = new JFrame();
        arrayButton = new JButton[60];
        buyButton = new ButtonGroup();

        // Set Title
        f.setTitle("Plants vs. Zombies - Kita Cinta OOP");

        // Insert into array
        int i;
        for(i = 0; i <= 59; i++) {
            arrayButton[i] = new JButton("");
        }

        // Buat grid     
        for (i = 0; i <= 59; i ++) {
            f.add(arrayButton[i]);
        }
      
        //setting grid layout of 4 rows and 7 columns  
        f.setLayout(new GridLayout(4,15));  

        // Buat Plant Button - BUY
        // Plant A
        JButton paButton = new JButton( new AbstractAction("Plant A") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
            }
        });
        paButton.setText("PA");
        buyButton.add(paButton);
        f.add(paButton);
        
        // Plant B
        JButton pbButton = new JButton( new AbstractAction("Plant B") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
            }
        });
        pbButton.setText("PB");
        buyButton.add(pbButton);
        f.add(pbButton);

        
        /* buyButton.setBounds(130,100,100, 40);

        JButton addButton = new JButton( new AbstractAction("add") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
            }
        }); */
      
        f.setSize(1000,400);  
        f.setVisible(true);  
    }

    // Getter
    public String getTextButton(int i) {
        return arrayButton[i].getText();
    }

    /* @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
        //Do Something
        }else if(e.getSource() == button2){
        //Do Something Else
    } */
    
    public void editGrid(String code, int position) {
    // position adalah index dari grid yang ingin diubah, code adalah karakter yang akan muncul di grid tsb
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
