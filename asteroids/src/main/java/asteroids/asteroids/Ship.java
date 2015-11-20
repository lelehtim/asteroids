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
    static final double ACCELERATION = 0.2;
    private boolean turnleft;
    private boolean turnright;
    private boolean accelerate;
    private boolean shoot;
    private boolean exists;
    Vector position;
    Vector speed;
    
    public Ship() {
        // first vector needs to be adjusted to the center of the screen and the radius to be corrected
        super(new Vector(300.0,300.0), new Vector(0.0,0.0),10.0);
        turnleft = false;
        turnright = false;
        accelerate = false;
        shoot = false;
        exists = true;
        
        
    }
    
    public boolean exists() {
        return exists;
    }
    
    public void accelerate(Boolean b) {
        accelerate = b;
        if (b) {
            this.speed = new Vector(1.0,1.0);
        }
        if (!b) {
            this.speed = new Vector(0.0,0.0);
        }
    }
    
    public void turnleft(Boolean b) {
        turnleft = b;
    }
    
    public void turnright(Boolean b) {
        turnright = b;
    }
    
    public void shoot(Boolean b) {
        shoot = b;
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
        int x[]={300,310,290};
        int y[]={290,310,310};
        g.drawPolygon(x,y,3);
    }
}
