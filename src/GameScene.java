import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Obstacle obstacle1;
    private Obstacle obstacle2;
    private Obstacle obstacle3;
    private Obstacle obstacle4;
    private Player player1;
    private Player player;
    private JLabel gameOver;
    private ImageIcon backGround;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private ImageIcon chocolate1;
    private ImageIcon chocolate2;
    private ImageIcon chocolate3;

    int xLocation1 = (int) ((Math.random()*(100-10))+10);
    int yLocation1 = (int) ((Math.random()*(150-10))+10);
    int xLocation2 = (int) ((Math.random()*(300-150))+150);
    int yLocation2 = (int) ((Math.random()*(350-200))+200);
    int xLocation3 = (int) ((Math.random()*(600-350))+350);
    int yLocation3 = (int) ((Math.random()*(620-400))+400);

    public GameScene(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.gameOver = new JLabel();
        this.chocolate1 = new ImageIcon("שוקולד.png");
        this.chocolate2 = new ImageIcon("שוקולד.png");
        this.chocolate3 = new ImageIcon("שוקולד.png");
        this.backGround = new ImageIcon("תכלת-בועות.jpg");
        this.obstacle1 = new Obstacle(100, 90, Color.BLACK);
        this.obstacle2 = new Obstacle(200, 230, Color.BLACK);
        this.obstacle3 = new Obstacle(610, 345, Color.BLACK);
        this.obstacle4 = new Obstacle(430, 460, Color.BLACK);
        this.player1 = new Player(330, 520, 30, 30, Color.MAGENTA);
        this.rectangle1 = new Rectangle(xLocation1, yLocation1,20,20);
        this.rectangle2 = new Rectangle(xLocation2, yLocation2,20,20);
        this.rectangle3 = new Rectangle(xLocation3, yLocation3,20,20);
        mainGameLoop();
        this.setBackground(Color.white);
        this.moveObstacles(obstacle1);
        this.moveObstacles(obstacle2);
        this.moveObstacles(obstacle3);
        this.moveObstacles(obstacle4);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.backGround.paintIcon(this,g,0,0);

        this.obstacle1.paint(g);
        this.obstacle2.paint(g);
        this.obstacle3.paint(g);
        this.obstacle4.paint(g);
        this.chocolate1.paintIcon(this,g, xLocation1, yLocation1);
        this.chocolate2.paintIcon(this,g,xLocation2,yLocation2);
        this.chocolate3.paintIcon(this,g,xLocation3,yLocation3);
        this.player1.paint(g);


        // g.drawImage(candy,20,20,this.getWidth(),this.getHeight(),null);



    }

    public void moveObstacles(Obstacle obstacle) {

        Thread t1 = new Thread(() -> {
            Movement movement = new Movement(this.player1);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(movement);
            while (true) {
                obstacle.moveObstacle();
                repaint();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
    }
    private void mainGameLoop() {

        Thread t2 = new Thread(() -> {
            while (true) {
                switch (this.player1.getDirection()) {
                    case Player.LEFT -> this.player1.moveLeft();
                    case Player.RIGHT -> this.player1.moveRight();
                    case Player.UP -> this.player1.moveUp();
                    case Player.DOWN -> this.player1.moveDown();
                }
                player1.checkCollision(obstacle1);
                player1.checkCollision(obstacle2);
                player1.checkCollision(obstacle3);
                player1.checkCollision(obstacle4);
                if (player1.checkCollision2(rectangle1)) {
                    //  remove(chocolate1);
                    //remove(rectangle1);
                }
                player1.checkCollision2(rectangle2);
                player1.checkCollision2(rectangle3);


                repaint();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }

    private void remove(Rectangle rectangle1) {
        remove(rectangle1);
    }

    private void remove(ImageIcon chocolate1) {
        remove(chocolate1);
    }

}
