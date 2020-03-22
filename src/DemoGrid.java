import java.awt.*;  
import javax.swing.*; 
import java.util.Scanner; 

public class DemoGrid {
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);

        GridField x = new GridField();
        //x.editGrid("P", 13);
        int n = input.nextInt();
        x.editGrid("P", n);
    }  
}