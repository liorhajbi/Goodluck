import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {

    private Obstacle obstacle1;
    private Obstacle obstacle2;
    private Obstacle obstacle3;
    private Obstacle obstacle4;
    private Player player;
    private ImageIcon backGround;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private ImageIcon chocolate1;
    private ImageIcon chocolate2;
    private ImageIcon chocolate3;
    private int currentFail;
    private int currentWin;
    private EndOfGame endOfGame;

    public static final int MILL_THREAD1= 2, MILL_THREAD2= 200, SUM_OF_WIN=3, SUM_OF_FAIL=3, X_OF_GAME_SCENE= 0,
    Y_OF_GAME_SCENE= 0, WIDTH_OF_END_GAME= 700, HEIGHT_OF_END_GAME= 600, X_OF_TEXT= 250,
     Y_OF_TEXT= 0, X_OF_PLAYER= 330, Y_OF_PLAYER= 520, WIDTH_OF_TEXT= 300, HEIGHT_OF_TEXT= 40,
            SIZE_OF_TEXT = 20, WIDTH_OF_OBSTACLE= 30, HEIGHT_OF_OBSTACLE=30, WIDTH_OF_PLAYER= 30, HEIGHT_OF_PLAYER=30,
    X_OF_OBSTACLE1= 100, Y_OF_OBSTACLE1= 90,X_OF_OBSTACLE2= 200,Y_OF_OBSTACLE2= 230,X_OF_OBSTACLE3= 610
    , Y_OF_OBSTACLE3= 34, X_OF_OBSTACLE4= 430,Y_OF_OBSTACLE4= 460;



    public static final int X_MIN_CHOCOLATE1_LOCATION= 10,X_MAX_CHOCOLATE1_LOCATION= 100,Y_MIN_CHOCOLATE1_LOCATION= 10
    ,Y_MAX_CHOCOLATE1_LOCATION= 150,
    X_MIN_CHOCOLATE2_LOCATION= 150,X_MAX_CHOCOLATE2_LOCATION= 300,Y_MIN_CHOCOLATE2_LOCATION= 200,Y_MAX_CHOCOLATE2_LOCATION= 350,
    X_MIN_CHOCOLATE3_LOCATION= 350,X_MAX_CHOCOLATE3_LOCATION= 500,Y_MIN_CHOCOLATE3_LOCATION= 400,Y_MAX_CHOCOLATE3_LOCATION= 500;


    int xLocation1 = (int) ((Math.random() * (X_MAX_CHOCOLATE1_LOCATION - X_MIN_CHOCOLATE1_LOCATION)) + X_MIN_CHOCOLATE1_LOCATION);
    int yLocation1 = (int) ((Math.random() * (Y_MAX_CHOCOLATE1_LOCATION - Y_MIN_CHOCOLATE1_LOCATION)) + Y_MIN_CHOCOLATE1_LOCATION);
    int xLocation2 = (int) ((Math.random() * (X_MAX_CHOCOLATE2_LOCATION - X_MIN_CHOCOLATE2_LOCATION)) + X_MIN_CHOCOLATE2_LOCATION);
    int yLocation2 = (int) ((Math.random() * (Y_MAX_CHOCOLATE2_LOCATION - Y_MIN_CHOCOLATE2_LOCATION)) + Y_MIN_CHOCOLATE2_LOCATION);
    int xLocation3 = (int) ((Math.random() * (X_MAX_CHOCOLATE3_LOCATION - X_MIN_CHOCOLATE3_LOCATION)) + X_MIN_CHOCOLATE3_LOCATION);
    int yLocation3 = (int) ((Math.random() * (Y_MAX_CHOCOLATE3_LOCATION - Y_MIN_CHOCOLATE3_LOCATION)) + Y_MIN_CHOCOLATE3_LOCATION);
    private String text;
    private JLabel label;

    public GameScene() {
        this.setBounds(X_OF_GAME_SCENE, Y_OF_GAME_SCENE, WIDTH_OF_END_GAME, HEIGHT_OF_END_GAME);
        currentWin = 0;
        currentFail = 0;
        this.chocolate1 = new ImageIcon("chocolate.png");
        this.chocolate2 = new ImageIcon("chocolate.png");
        this.chocolate3 = new ImageIcon("chocolate.png");
        this.backGround = new ImageIcon("background.jpg");
        this.obstacle1 = new Obstacle(X_OF_OBSTACLE1, Y_OF_OBSTACLE1, Color.BLACK);
        this.obstacle2 = new Obstacle(X_OF_OBSTACLE2, Y_OF_OBSTACLE2, Color.BLACK);
        this.obstacle3 = new Obstacle(X_OF_OBSTACLE3, Y_OF_OBSTACLE3, Color.BLACK);
        this.obstacle4 = new Obstacle(X_OF_OBSTACLE4, Y_OF_OBSTACLE4, Color.BLACK);
        this.player = new Player(X_OF_PLAYER, Y_OF_PLAYER, WIDTH_OF_PLAYER, HEIGHT_OF_PLAYER, Color.MAGENTA);
        this.rectangle1 = new Rectangle(xLocation1, yLocation1, WIDTH_OF_OBSTACLE, HEIGHT_OF_OBSTACLE);
        this.rectangle2 = new Rectangle(xLocation2, yLocation2, WIDTH_OF_OBSTACLE, HEIGHT_OF_OBSTACLE);
        this.rectangle3 = new Rectangle(xLocation3, yLocation3, WIDTH_OF_OBSTACLE, HEIGHT_OF_OBSTACLE);
        text = "you have " + currentFail +"/"+SUM_OF_FAIL+ " tries";
        label = new JLabel(text);
        label.setBounds(X_OF_TEXT, Y_OF_TEXT, WIDTH_OF_TEXT, HEIGHT_OF_TEXT);
        label.setFont(new Font("TimesRoman", Font.PLAIN, SIZE_OF_TEXT));
        add(label);
        mainGameLoop();
        this.setBackground(Color.white);
        this.moveObstacles(obstacle1);
        this.moveObstacles(obstacle2);
        this.moveObstacles(obstacle3);
        this.moveObstacles(obstacle4);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.backGround.paintIcon(this, g, X_OF_GAME_SCENE, Y_OF_GAME_SCENE);
        this.obstacle1.paint(g);
        this.obstacle2.paint(g);
        this.obstacle3.paint(g);
        this.obstacle4.paint(g);
        this.chocolate1.paintIcon(this, g, xLocation1, yLocation1);
        this.chocolate2.paintIcon(this, g, xLocation2, yLocation2);
        this.chocolate3.paintIcon(this, g, xLocation3, yLocation3);
        this.player.paint(g);

    }

    public void moveObstacles(Obstacle obstacle) {

        Thread t1 = new Thread(() -> {
            Movement movement = new Movement(this.player);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(movement);
            while (true)
            {
                obstacle.moveObstacle();
                repaint();
                try {
                    Thread.sleep(MILL_THREAD1);
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

                switch (this.player.getDirection()) {
                    case Player.LEFT -> this.player.moveLeft();
                    case Player.RIGHT -> this.player.moveRight();
                    case Player.UP -> this.player.moveUp();
                    case Player.DOWN -> this.player.moveDown();
                }
                if (player.checkCollision(obstacle1) ||
                        player.checkCollision(obstacle2) ||
                        player.checkCollision(obstacle3) ||
                        player.checkCollision(obstacle4)) {
                    currentFail++;
                    label.setText("you have" + currentFail + "/" + "3 tries");
                    // System.out.println(sumOfFail);
                    if (currentFail >= SUM_OF_FAIL) {
                        label.setText("you collected" + " " + currentWin + "/" + "3 chocolate");
                        endOfGame = new EndOfGame("GAME-OVER");
                        this.add(endOfGame);
                        currentFail = 0;
                        break;


                    }
                }
                try {
                    //  }
                      System.out.println(currentWin);
                       if (player.checkCollision2(rectangle1) ) {
                           currentWin++;
                           rectangle1 = null;
                           chocolate1.setImage(null);
                           System.out.println(currentWin);
                       }
                   // if (ifCollision(rectangle2,chocolate2)) {
                 //   }

                  if (player.checkCollision2(rectangle2)) {
                        currentWin++;
                       rectangle2 = null;
                         chocolate2.setImage(null);
                        System.out.println(currentWin);
                    }
                    if (player.checkCollision2(rectangle3)) {
                        currentWin++;
                        rectangle3 = null;
                        chocolate3.setImage(null);
                          System.out.println(currentWin);
                    }

                } catch (Exception e) {
                }
                repaint();
                try {
                    if (currentWin == SUM_OF_WIN) {
                        endOfGame = new EndOfGame("YOU WON!!");
                        this.add(endOfGame);
                        this.remove(label);
                        break;

                    }
                    Thread.sleep(MILL_THREAD2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }



    public boolean ifCollision(Rectangle rectangle, ImageIcon chocolate) {
        boolean flag =false;
        if (player.checkCollision2(rectangle)) {
            flag =true;
            rectangle = null;
            chocolate.setImage(null);
            currentWin++;
            System.out.println("yes");
        }
        return flag;
    }
}
