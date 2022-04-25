import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private int x ;
    private int y ;
    private int height ;
    private int wight ;


    public GameOver(int x , int y , int wight , int height) {
        this.setBounds(x , y , wight , height);
        this.setBackground(Color.MAGENTA);
        this.setLayout(null);
        this.setVisible(true);
    }
}
