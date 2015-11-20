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
    static final double ROTATION = -Math.PI / 2.0;
    static final double ROTATION_SPEED = 0.000002;
    static final double MAXVELOCITY = 5.0;
    static final double THRUST = 0.02;
    private boolean turnleft;
    private boolean turnright;
    private boolean accelerate;
    private boolean shoot;
    private boolean exists;
    
    public Ship() {
        super(new Vector(300.0,300.0), new Vector(0.0,0.0),10.0);
        this.rotation = ROTATION;
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
    public boolean getTurnLeft() {
        return turnleft;
    }
    
    public boolean getTurnRight() {
        return turnright;
    }
    
    @Override
    public void refresh(Game g) {
        super.refresh(g);
        if (getAcceleration()) {
            speed.sum(new Vector(rotation).adjust(THRUST));
            
            if (speed.getSquaredLength() >= MAXVELOCITY*MAXVELOCITY) {
                speed.makeLengthOne().adjust(MAXVELOCITY);
            }
        }
        if (speed.getSquaredLength() != 0.0) {
            speed.adjust(0.002);
        }
        
        if (getTurnRight()) {
            turn(ROTATION_SPEED);
        }
        if (getTurnLeft()) {
            turn(-ROTATION_SPEED);
        }
    }
    
    @Override
    public void draw(Graphics2D g, Game game) {
//        int x[]={300,310,290};
//        int y[]={290,310,310};
//        g.drawPolygon(x,y,3);
        g.drawLine(-10, -8, 10, 0);
	g.drawLine(-10, 8, 10, 0);
	g.drawLine(-6, -6, -6, 6);
    }
}
