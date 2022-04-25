import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Movement implements KeyListener {
    private Player player;

    public Movement (Player player) {
        this.player = player;
    }


    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            this.player.moveUp();
        }
        if (code == KeyEvent.VK_DOWN) {
            this.player.moveDown();
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.player.moveRight();
        }
        if (code == KeyEvent.VK_LEFT) {
            this.player.moveLeft();
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
