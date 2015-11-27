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
 * this class represents the space ship controlled by the player
 */

public class Ship extends Element {
    static final double ROTATION = -Math.PI / 2.0;
    static final double ROTATION_SPEED = 0.1;
    static final double MAXVELOCITY = 8.0;
    static final double THRUST = 0.5;
    private boolean turnleft;
    private boolean turnright;
    private boolean accelerate;
    private boolean shoot;
    private boolean hasBeenShot;
    
    
    public Ship() {
        super(new Vector(300.0,300.0), new Vector(0.0,0.0),10.0);
        this.rotation = ROTATION;
        turnleft = false;
        turnright = false;
        accelerate = false;
        shoot = false;
        hasBeenShot = false;
        this.type = 3;
        
    }
    
    
    /**
     * change the value of accelerate to b
     * @param b 
     */
    
    public void accelerate(Boolean b) {
        accelerate = b;
    }
    
    /**
     * change value of turnleht to b
     * @param b 
     */
    
    public void turnleft(Boolean b) {
        turnleft = b;
    }
    
    /**
     * change value of turnright to b
     * @param b 
     */
    
    public void turnright(Boolean b) {
        turnright = b;
    }
    
    /**
     * change value of shoot to b
     * @param b 
     */
    
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
    
    
    /**
     * update the status of the ship
     * @param g 
     */
    
    @Override
    public void refresh(Game g) {
        super.refresh(g);
        takeCareOfImpact(g);
        
        if (getAcceleration()) {
            speed.sum(new Vector(rotation).adjust(THRUST));
            
            if (speed.getSquaredLength() >= MAXVELOCITY*MAXVELOCITY) {
                speed.makeLengthOne().adjust(MAXVELOCITY);
            }
        }
        if (speed.getSquaredLength() != 0.0) {
            speed.adjust(0.9);
        }
        
        if (getTurnRight()) {
            turn(ROTATION_SPEED);
        }
        if (getTurnLeft()) {
            turn(-ROTATION_SPEED);
        }
        
        if (getShoot()) {
            Bullet b = new Bullet(this, rotation);
            g.list.add(b);
            
        }
    }
    
    /**
     * draw ship
     * @param g
     * @param game 
     */
    
    @Override
    public void draw(Graphics2D g, Game game) {
//        int x[]={300,310,290};
//        int y[]={290,310,310};
//        g.drawPolygon(x,y,3);
        g.drawLine(-10, -8, 10, 0);
	g.drawLine(-10, 8, 10, 0);
	g.drawLine(-6, -6, -6, 6);
    }
    
    @Override
    public void takeCareOfImpact(Game game) {
        int i = 1;
        while(i < game.list.size()) {
            Element e = game.list.get(i);
            double eXposition = game.list.get(i).position.x;
            double eYposition = game.list.get(i).position.y;
            if (e.type != 1 && (-radius <= position.x - eXposition && position.x - eXposition <= radius) && (-radius <= position.y - eYposition && position.y - eYposition <= radius)) {
                setStatusToFalse();
                break;
            }
            i++;
        }
    }
} 
