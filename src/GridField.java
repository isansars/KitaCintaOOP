// GridField.java
// Inisiasi field player  
    
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
      
public class GridField{
    // Atribut  
    private Player p;
    private JFrame f;
    private JPanel lanePane;
    private JPanel buyPane;
    private JSplitPane splitPaneV;
    private JButton[] arrayButton;
    private JButton buyButtonA;
    private JButton buyButtonB;

    public GridField(Player player){  
        p = player;
        f = new JFrame();

         // Set Title
         f.setTitle("Plants vs. Zombies - Kita Cinta OOP");
         f.setSize(1500,600);

         // Create a splitter pane
        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        f.add(splitPaneV, BorderLayout.CENTER);
        createLanePane();
        createBuyPane();
        splitPaneV.setTopComponent(lanePane);
        splitPaneV.setBottomComponent(buyPane);
        splitPaneV.setResizeWeight(0.7);
        splitPaneV.setOneTouchExpandable(true);
        
        //f.add(lanePane);
        //f.add(buyPane);
        f.setVisible(true);  
    }

    // Getter
    public String getTextButton(int i) {
        return arrayButton[i].getText();
    }

    public void createBuyPane(){
        buyPane = new JPanel();
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        int top = 0;
        int bottom = 0;
        int left = 10;
        int right = 10;
        gbc.insets = new Insets(top, left, bottom, right);
        buyPane.setLayout(gridbag);
        

        // Buat Plant Button - BUY
        // Plant A
        buyButtonA = new JButton( new AbstractAction("Plant A (25 SP)") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
                if (p.getSunPoints() < 25){
                    sunPointsMinPrompt();   
                } else{
                    
                }
            }
        });
        buyButtonA.setPreferredSize(new Dimension(200, 50));
        Icon iconA = new ImageIcon("/home/madiha/KitaCintaOOP/icon/PlantA.png");
        buyButtonA.setIcon(iconA);
        buyPane.add(buyButtonA, gbc);

        // Plant B
        buyButtonB = new JButton( new AbstractAction("Plant B (50 SP)") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
                if (p.getSunPoints() < 50){
                    sunPointsMinPrompt();   
                } else{
                    
                }
            }
        }); 
        buyButtonB.setPreferredSize(new Dimension(200, 50));
        Icon iconB = new ImageIcon("/home/madiha/KitaCintaOOP/icon/PlantB.png");
        buyButtonA.setIcon(iconB);
        buyPane.add(buyButtonB, gbc);
        
        buyPane.setSize(1500,200);
        buyPane.setVisible(true);
    }

    public void createLanePane(){
        lanePane = new JPanel();
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
            lanePane.add(arrayButton[i]);
        }

        //setting grid layout of 4 rows and 7 columns  
        lanePane.setLayout(new GridLayout(4,15));  
        lanePane.setSize(1500,400);
        lanePane.setVisible(true);
    }

    public void sunPointsMinPrompt(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Jumlah SunPoints yang Anda miliki tidak mencukupi.");
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
