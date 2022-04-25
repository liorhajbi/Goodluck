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
            System.out.println("yess");
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
            if (sumOfFails > 2) {
        //        this.add(gameOver);
                System.out.println(collision);
            }

        }
        return collision;
    }

    public void moveRight () {
        this.x++;
    }

    public void moveLeft () {
        this.x--;
    }

    public void moveUp () {
        this.y--;
    }

    public void moveDown () {
        this.y++;
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

