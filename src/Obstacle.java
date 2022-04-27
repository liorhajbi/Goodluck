import java.awt.*;

public class Obstacle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 650;
    boolean flag = false;
    public static final int OBSTACLE_WIDTH = 40;
    public static final int OBSTACLE_HEIGHT = 40;
    public static final int MAX_OF_RIGHT = 655;
    public static final int MAX_OF_LEFT = 0;


    public Obstacle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = OBSTACLE_WIDTH;
        this.height = OBSTACLE_HEIGHT;
        this.color = color;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(
                this.x,
                this.y,
                this.width,
                this.height
        );

    }
    public void moveRight() {
        this.x++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveObstacle() {
        if (!flag) {
            moveRight();
        }
        if (this.x == MAX_OF_RIGHT) {
            flag = true;
        }
        if (flag) {
            moveLeft();
        }
        if (this.x == MAX_OF_LEFT) {
            flag = false;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getWidth() {
        return width;
    }

}
