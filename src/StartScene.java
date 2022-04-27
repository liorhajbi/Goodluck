import javax.swing.*;
import java.awt.*;

public class StartScene extends JPanel {
    private ImageIcon backGround;
    public static final int WINDOW_WIDTH=700;
    public static final int WINDOW_HEIGHT=600;

    public StartScene () {
        this.setBounds(0 , 0 , WINDOW_WIDTH , WINDOW_HEIGHT);
       // this.setBackground(Color.CYAN);
        this.setLayout(null);
        this.setVisible(true);
        this.backGround = new ImageIcon("background.jpg");
        JButton button = new JButton("start the game");
        button.setBounds(200,200,300,100);
        this.add(button);
        GameScene gameScene=new GameScene();
        button.addActionListener( (event) -> {
            this.remove(button);
            this.add(gameScene);
        } );


    }
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       this.backGround.paintIcon(this, g, 0, 0);
    }
}
