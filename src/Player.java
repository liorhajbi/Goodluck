import javax.swing.*;
import java.awt.*;

public class Player extends JFrame {
    private static final int NONE = 0;
    private int x;
    private int y;
    private int width;
    private int height;
    private int direction;
    private Color color;
    public static final int RIGHT = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    public static final int MAX_OF_FAIL= 2;
    public static final int MAX_OF_LEFT = 1;
    public static final int MAX_OF_RIGHT= 655;
    public static final int MAX_OF_UP= 2;
    public static final int MAX_OF_DOWN= 530;



    int sumOfFails =0;


    public Player(int x, int y, int width, int height,Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.direction=NONE;
        this.color = color;
    }




    public void paint (Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(
                this.x,
                this.y,
                this.width,
                this.height
        );
    }
    public boolean checkCollision2 (Rectangle rectangle) {
        boolean collision = false;
        Rectangle rectangle1 = new Rectangle(rectangle.x, rectangle.y,
                rectangle.width,rectangle.height);
        Rectangle player = new Rectangle(x, y, width, height);
            if (player.intersects(rectangle1)) {
                collision = true;
            }

        return collision;
    }

    public boolean checkCollision (Obstacle obstacle) {
        boolean collision = false;
        Rectangle obstecleRect = new Rectangle(obstacle.getX(), obstacle.getY(),
                obstacle.getWidth(), obstacle.getWidth());
        Rectangle player = new Rectangle(this.x, this.y, this.width, this.height);

     //   GameOver gameOver = new GameOver(0,0,700,600);
        if (player.intersects(obstecleRect)) {
            collision = true;
            sumOfFails++;
            System.out.println(sumOfFails);
            if (sumOfFails > MAX_OF_FAIL) {
        //        this.add(gameOver);
                System.out.println(collision);
            }

        }
        return collision;
    }

    public void moveRight () {
        if (x <= MAX_OF_RIGHT) {
            this.x++;

        }
    }

    public void moveLeft () {
        if (x>MAX_OF_LEFT) {
            this.x--;

        }
    }

    public void moveUp () {
        if (y>MAX_OF_UP) {
            this.y--;

        }
    }

    public void moveDown () {
        if (y <MAX_OF_DOWN) {
            this.y++;

        }
    }

    public int getX() {
        return x;
    }
    public int getDirection () {
        return this.direction;
    }

    public void setDirection (int direction) {
        this.direction = direction;
    }


    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

