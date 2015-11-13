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

public class Ship extends Element {
    static final double ROTATION = Math.PI / 1.5;
    static final double ACCELARATION = 0.2;
    private boolean turnleft;
    private boolean turnright;
    private boolean accelerate;
    private boolean shoot;
    
    public Ship() {
        // first vector needs to be adjusted to the center of the screen and the radius to be corrected
        super(new Vector(0.0,0.0), new Vector(0.0,0.0),10.0);
        turnleft = false;
        turnright = false;
        accelerate = false;
        shoot = false;
        
    }
    
    public void accelerate() {
        accelerate = true;
    }
    
    public void turnleft() {
        turnleft = true;
    }
    
    public void turnright() {
        turnright = true;
    }
    
    public void shoot() {
        shoot = true;
    }
    
    public boolean getAcceleration() {
        return accelerate;
    }
    
    public boolean getShoot() {
        return shoot;
    }
    public boolean getTrunLeft() {
        return turnleft;
    }
    
    public boolean getTurnRight() {
        return turnright;
    }
    
    @Override
    public void draw(Graphics2D g, Game game) {
        g.drawRect(0, 0, 20, 20);
    }
}
