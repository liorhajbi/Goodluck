import javax.swing.*;
import java.awt.*;

public class StartScene extends JPanel {
    private ImageIcon backGround;
  //  private JButton start;
    public static final int WINDOW_WIDTH=700;
    public static final int WINDOW_HEIGHT=600;


    public StartScene (int x, int y, int wight, int height) {
        this.setBounds(x , y , wight , height);
       // this.backGround = new ImageIcon("תכלת-בועות.jpg");
        GameScene gameScene=new GameScene(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.setVisible(true);
        JButton button = new JButton("start the game");
        button.setBounds(200,200,300,100);
        this.add(button);
       // button.setOpaque(true);
        button.addActionListener( (event) -> {
            this.remove(button);
            this.add(gameScene);
        } );


    }
   // protected void paintComponent(Graphics g) {
     //   super.paintComponent(g);
       // this.backGround.paintIcon(this, g, 0, 0);
    //}
}
