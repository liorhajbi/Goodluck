import java.awt.*;

public class Obstacle {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    public static final int WINDOW_WIDTH=800;
    public static final int WINDOW_HEIGHT=650;
    boolean flag= false;


    public Obstacle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.color = color;
    }
    public void paint (Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillOval(
                this.x,
                this.y,
                this.width,
                this.height
        );
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

    public void moveObstacle () {
        if (!flag ) {
            moveRight();
        }
        if (this.x == 640) {
            flag = true;
        }
        if (flag) {
            moveLeft();
        }
        if (this.x == 0) {
            flag =false;
        }

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

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
