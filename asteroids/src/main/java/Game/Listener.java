/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import asteroids.asteroids.Ship;


/**
 *
 * @author Lauri
 */

/**
 * overrides the methods defined for keyAdapter for listening the commands given by the player
 */
public class Listener extends KeyAdapter {
    
    /** ship is the element that is being listened*/
    Ship ship;
    
    /**
     *
     * @param ship
     */
    public Listener(Ship ship) {
        this.ship = ship;
    }
    
    /**
     * 
     * @param e 
     */

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                ship.accelerate(true);
                break;
                
            case KeyEvent.VK_LEFT:
                ship.turnleft(true);
                break;
                
            case KeyEvent.VK_RIGHT:
                ship.turnright(true);
                break;
                
            case KeyEvent.VK_SPACE:
                ship.shoot(true);
                break;
                
            case KeyEvent.VK_R:
                ship.reStart(true);
                break;
                
        }
    }
    
    /**
     * 
     * @param e 
     */

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                ship.accelerate(false);
                break;
                
            case KeyEvent.VK_LEFT:
                ship.turnleft(false);
                break;
                
            case KeyEvent.VK_RIGHT:
                ship.turnright(false);
                break;
                
            case KeyEvent.VK_SPACE:
                ship.shoot(false);
                break;
                
            case KeyEvent.VK_R:
                ship.reStart(false);
        }
    }
    
}
