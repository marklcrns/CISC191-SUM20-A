package edu.sdccd.cisc191.wizardGame.events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import edu.sdccd.cisc191.wizardGame.objects.GameObject;
import edu.sdccd.cisc191.wizardGame.objects.Handler;
import edu.sdccd.cisc191.wizardGame.objects.ID;

/**
 * Describes conditions that will change handler attributes upon a KeyEvent.
 * Used for player movement.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;

    /**
     * No args KeyInput constructor.
     */
    public KeyInput() {}

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObject().size(); i++) {
            GameObject tempObject = handler.getObject().get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) handler.setUp(true);
                if (key == KeyEvent.VK_S) handler.setDown(true);
                if (key == KeyEvent.VK_A) handler.setLeft(true);
                if (key == KeyEvent.VK_D) handler.setRight(true);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObject().size(); i++) {
            GameObject tempObject = handler.getObject().get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) handler.setUp(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_A) handler.setLeft(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);
            }
        }
    }

    /** Accessor methods */
    public Handler getHandler()             { return this.handler; }

    /** Modifiers methods */
    public void setHandler(Handler handler) { this.handler = handler; }
}
