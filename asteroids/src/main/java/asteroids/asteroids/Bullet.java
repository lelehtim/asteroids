/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.asteroids;

/**
 *
 * @author Lauri
 */
import Game.Game;
import java.awt.Graphics2D;

/**
 * bullet represents the bullets fired by the ship
 */

public class Bullet extends Element {
    /** velocity of the bullet*/
    static final double BULLETSPEED = 6;
    
    /** max number of the cycles a bullet can exist*/
    static final int MAX_TIME = 50;
    
    /** number of cyckles*/
    private int time;
    
    /**
     *
     * @param ship
     * @param direction
     */
    public Bullet(Element ship, double direction) { 
        super(new Vector(ship.getPosition().x,ship.getPosition().y), new Vector(direction).adjust(BULLETSPEED), 1.0);
        time = 0;
        this.type = 1;
    }
    
    @Override
    public void refresh(Game g) {
        super.refresh(g);
        if (time >= MAX_TIME) {
            this.setStatusToFalse();
        }
        time++;
        
    }
    
    @Override
    public void draw(Graphics2D g, Game game) {
        g.drawOval(-1,-1,3,3);
    }

    @Override
    public void takeCareOfImpact(Game game) {
        setStatusToFalse();
    }
    
    
    
}
