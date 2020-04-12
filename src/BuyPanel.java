

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class BuyPanel extends JPanel{
    // Atribut
    private JPanel pan;
    private JButton paButton;
    private JButton pbButton;

    // Konstruktor
    public BuyPanel(){
        pan = new JPanel();

        // Buat Plant Button - BUY
        // Plant A
        paButton  = new JButton( new AbstractAction("Plant A") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
            }
        });
        paButton.setText("PA");
        pan.add(paButton);

        // Plant B
        /* pbButton = new JButton( new AbstractAction("Plant B") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
            }
        }); */
        pbButton = new JButton("Button B");
        pbButton.setText("PB");
        pan.add(pbButton);
        
        pan.setLayout(new GridLayout(1,1));
        pan.setSize(1500,400);
        pan.setVisible(true);
    }
}
