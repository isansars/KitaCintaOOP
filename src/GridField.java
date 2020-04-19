// GridField.java
// Inisiasi field player  
    
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
      
public class GridField{
    // Atribut  
    private Player p;
    private JLabel sunPointsView;
    private JFrame f;
    private JPanel lanePane;
    private JPanel buyPane;
    private JSplitPane splitPaneV;
    private LaneButton[] arrayButton;
    private JButton buyButtonA;
    private JButton buyButtonB;
    private String buyPlant;
    private EntityArray<Zombie> arrZ;
    private EntityArray<Plant> arrP;
    private EntityArray<Bullet> arrB;

    // Konstruktor
    public GridField(Player player, EntityArray<Zombie> arrZ, EntityArray<Plant> arrP, EntityArray<Bullet> arrB){  
        p = player;
        buyPlant = "";
        this.arrZ = arrZ;
        this.arrP = arrP;
        this.arrB = arrB;
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
        f.setVisible(true);  
    }

    // Getter
    public String getTextButton(int i) {
        return arrayButton[i].getText();
    }
    public JButton getButton(int i) {
        return arrayButton[i];
    }
    public EntityArray<Zombie> getArrZ(){
        return arrZ;
    }
    public EntityArray<Plant> getArrP(){
        return arrP;
    }
    public EntityArray<Bullet> getArrB(){
        return arrB;
    }
    public JLabel getSunPointsView(){
        return sunPointsView;
    }

    // Setter
    public void setSunPointsView(JLabel sunPointsView){
        this.sunPointsView = sunPointsView;
    }
    public void setBuyPlant(String buyPlant){
        this.buyPlant = buyPlant;
    }

    // Method 
    // Membuat Panel Buy
    public void createBuyPane(){
        buyPane = new JPanel();
        
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbcs = new GridBagConstraints();
        sunPointsView = new JLabel("Jumlah SunPoints: " + p.getSunPoints());
        gbcs.anchor = GridBagConstraints.FIRST_LINE_START;
        buyPane.add(sunPointsView, gbcs);

        // Membuat constraint pada layout
        GridBagConstraints gbc = new GridBagConstraints();
        int top = 0;
        int bottom = 0;
        int left = 10;
        int right = 10;
        gbc.insets = new Insets(top, left, bottom, right);
        buyPane.setLayout(gridbag);
        

        // Instansiasi Plant Button - BUY
        // Plant A
        buyButtonA = new JButton( new AbstractAction("Plant A (25 SP)") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                // add Action
                if (p.getSunPoints() < 25){
                    sunPointsMinPrompt();   
                } else{
                    buyPlant = "Plant A";
                }
            }
        });
        buyButtonA.setPreferredSize(new Dimension(200, 50));
        Icon iconA = new ImageIcon("icon/PlantA.png");
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
                    buyPlant = "Plant B";
                }
            }
        }); 
        buyButtonB.setPreferredSize(new Dimension(200, 50));
        Icon iconB = new ImageIcon("icon/PlantB.png");
        buyButtonB.setIcon(iconB);
        buyPane.add(buyButtonB, gbc);
        
        buyPane.setSize(1500,200);
        buyPane.setVisible(true);
    }

    // Membuat panel lane
    public void createLanePane(){
        lanePane = new JPanel();
        arrayButton = new LaneButton[60];

        // Insert into array
        int i;
        for(i = 0; i <= 59; i++) {
            arrayButton[i] = new LaneButton("");
            arrayButton[i].setPos(i);
            arrayButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            arrayButton[i].setVerticalTextPosition(SwingConstants.CENTER);
            arrayButton[i].addActionListener(new LaneActionListener());
        }

        // Buat grid     
        for (i = 0; i <= 59; i ++) {
            lanePane.add(arrayButton[i]);
        }

        // Setting grid layout of 4 rows and 15 columns  
        lanePane.setLayout(new GridLayout(4,15));  
        lanePane.setSize(1500,400);
        lanePane.setVisible(true);
    }

    // Method action ketika grid pada lane ditekan
    class LaneActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            LaneButton btn = (LaneButton)e.getSource();
            int pos = btn.getPos();
            // Apabila memilih petak yang telah terisi maka akan tampil pesan exception
            try {
                if (btn.getText().equals(".")) {
                    Icon sun = new ImageIcon("icon/Blank.png");
                    btn.setIcon(sun);
                    p.setSunPoint(p.getSunPoints()+25);
                    sunPointsView.setText("Jumlah SunPoints: " + p.getSunPoints());
                }
                else if(btn.getText().equals("")){
                    if(buyPlant.equals("Plant A")){
                        Plant pnew = new PlantA(pos, arrP);
                        Icon iconA = new ImageIcon("icon/PlantA.png");
                        btn.setText(pnew.getPlantType());
                        btn.setIcon(iconA);
                        p.setSunPoint(p.getSunPoints()-pnew.getSunPoints());
                        setBuyPlant("");
                        sunPointsView.setText("Jumlah SunPoints: " + p.getSunPoints());
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Pembelian berhasil");
                    } else if(buyPlant.equals("Plant B")){
                        Plant pnew = new PlantB(pos, arrP);
                        Icon iconB = new ImageIcon("icon/PlantB.png");
                        btn.setText(pnew.getPlantType());
                        btn.setIcon(iconB);
                        p.setSunPoint(p.getSunPoints()-pnew.getSunPoints());
                        setBuyPlant("");
                        sunPointsView.setText("Jumlah SunPoints: " + p.getSunPoints());
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Pembelian berhasil");
                    } else if (buyPlant.equals("")){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Silahkan pilih tanaman terlebih dahulu");
                    }
                }
                else{
                    throw new SpaceFullException();
                }
            } catch (SpaceFullException x) {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "[" + x.getClass().getName() + "] " + x.getMessage());
            }
        }
    }

    // Inner class turunan JButton
    class LaneButton extends JButton{
        int pos;

        // Konstruktor
        public LaneButton(String s){
            super(s);
        }

        // Getter
        public int getPos(){
            return pos;
        }
        // Setter
        public void setPos(int pos){
            this.pos = pos;
        }
    }

    // Method yang menampilkan prompt apabila sunPoints kurang dari jumlah yang dibutuhkan untuk membeli tanaman
    public void sunPointsMinPrompt(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Jumlah SunPoints yang Anda miliki tidak mencukupi.");
    }
    
    // Method
    // Menghapus Icon pada Button
    public void deleteIcon(int position) {
    // position adalah index dari grid yang ingin diubah, code adalah karakter yang akan muncul di grid tsb
        Icon icon = new ImageIcon("icon/Blank.png");
        arrayButton[position].setIcon(icon);
    }

    // Mengubah text pada Button
    public void editGrid(String code, int position) {
        arrayButton[position].setText(code);
    }

    // Menambahkan PlantA
    public void addPlantA(int position) {
        Icon icon = new ImageIcon("icon/PlantA.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan PlantB
    public void addPlantB(int position) {
        Icon icon = new ImageIcon("icon/PlantB.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan ZombieA
    public void addZombieA(int position) {
        Icon icon = new ImageIcon("icon/ZombieA.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan ZombieB
    public void addZombieB(int position) {
        Icon icon = new ImageIcon("icon/ZombieB.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan NormalBul
    public void addNormalBul(int position) {
        Icon icon = new ImageIcon("icon/NormalBul.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan FireBul
    public void addFireBul(int position) {
        Icon icon = new ImageIcon("icon/FireBul.png");
        arrayButton[position].setIcon(icon);
    }

    // Menambahkan Sun
    public void addSunIcon(int position) {
        Icon icon = new ImageIcon("icon/sun.png");
        arrayButton[position].setIcon(icon);
    }
}  
