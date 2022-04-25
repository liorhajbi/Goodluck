import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[]args){
        new Main();
    }


    public static final int WINDOW_WIDTH=700;
    public static final int WINDOW_HEIGHT=600;
    public Main() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

       //  StartScene startScene = new StartScene(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        //this.add(startScene);



        GameScene gameScene=new GameScene(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.add(gameScene);

    }

}