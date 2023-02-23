package app.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    public int KEY_CODE = 0;
    public int SECONDARY_KEY_CODE = 0;

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '1':
                SECONDARY_KEY_CODE = 3;

                break;

            case '2':
                SECONDARY_KEY_CODE = 4;

                break;

            case '3':
                SECONDARY_KEY_CODE = 5;

                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w' :
                KEY_CODE = 1;

                break;

            case 's':
                KEY_CODE = 2;

                break;

            default:
                KEY_CODE = 0;

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
