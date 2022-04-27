import javax.swing.*;
import java.awt.*;

public class EndOfGame extends JPanel {

    private ImageIcon background;
    public static final int X_OF_END_GAME= 0;
    public static final int Y_OF_END_GAME= 0;
    public static final int WIDTH_OF_END_GAME= 700;
    public static final int HEIGHT_OF_END_GAME= 600;
    public static final int X_OF_LABEL= 200;
    public static final int Y_OF_LABEL= 150;
    public static final int WIDTH_OF_LABEL= 500;
    public static final int HEIGHT_OF_LABEL= 200;
    public static final int SIZE_OF_LABEL= 50;
    public static final int X_OF_BACK_GROUND= 0;
    public static final int Y_OF_BACK_GROUND= 0;



    public EndOfGame(String text) {
        this.setBounds(X_OF_END_GAME, Y_OF_END_GAME, WIDTH_OF_END_GAME, HEIGHT_OF_END_GAME);
        this.setBackground(Color.MAGENTA);
        this.setLayout(null);
        this.setVisible(true);
        this.background = new ImageIcon("background.jpg");
        JLabel label = new JLabel(text);
        label.setBounds(X_OF_LABEL, Y_OF_LABEL, WIDTH_OF_LABEL, HEIGHT_OF_LABEL);
        label.setFont(new Font("TimesRoman",Font.PLAIN,SIZE_OF_LABEL));
        this.add(label);
        JButton button = new JButton("NEW GAME");
      //  add(button);
       button.setBounds(250,300,200,70);
       button.addActionListener( (event) -> {
           remove(button);
            remove(label);
           Main main = new Main();
             this.add(main);
            repaint();
            GameScene gameScene = new GameScene();
            add(gameScene);
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.background.paintIcon(this, g, X_OF_BACK_GROUND, Y_OF_BACK_GROUND);
    }
}
