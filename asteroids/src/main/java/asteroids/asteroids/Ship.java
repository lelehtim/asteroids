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
    
    /** the rotation of a new ship*/
    static final double ROTATION = -Math.PI / 2.0;
    
    /** standard rotation speed*/
    static final double ROTATION_SPEED = 0.1;
    
    /** maximum speed of the ship*/
    static final double MAXVELOCITY = 8.0;
    
    /** ships thrust*/
    static final double THRUST = 0.5;
    
    /** if true ship will turn left*/
    private boolean turnleft;
    
    /** if true ship will turn right*/
    private boolean turnright;
    
    /** if true ship will move straight*/
    private boolean accelerate;
    
    /** if true a new bullet is created*/
    private boolean shoot;
    
    /** if true game will be restarted*/
    public boolean reStart;
    
    /** number of consecutive shots fired*/
    public int shots;
    
    /**
     *
     */
    public Ship() {
        super(new Vector(300.0,300.0), new Vector(0.0,0.0),10.0);
        this.rotation = ROTATION;
        turnleft = false;
        turnright = false;
        accelerate = false;
        shoot = false;
        reStart = false;
        this.type = 3;
        shots = 0;
        
    }
    
    /**
     * sets the coordinates and the direction of the ship to its default values
     */
    
    public void initialize() {
        this.rotation = ROTATION;
        this.status = true;
        this.position.x = 300.0;
        this.position.y = 300.0;
    }
    
    /**
     *
     * @return
     */
    public boolean getreStart() {
        return reStart;
    }
    
    
    /**
     * changes the value of accelerate to b
     * @param b 
     */
    
    public void accelerate(Boolean b) {
        accelerate = b;
    }
    /**
     * changes the value of reStart to b
     * @param b 
     */
    
    public void reStart(Boolean b) {
        reStart = b;
    }
    
    /**
     * changes the value of turnleft to b
     * @param b 
     */
    
    public void turnleft(Boolean b) {
        turnleft = b;
    }
    
    /**
     * changes the value of turnright to b
     * @param b 
     */
    
    public void turnright(Boolean b) {
        turnright = b;
    }
    
    /**
     * changes the value of shoot to b
     * @param b 
     */
    
    public void shoot(Boolean b) {
        shoot = b;
    }
    
    /**
     *
     * @return
     */
    public boolean getAcceleration() {
        return accelerate;
    }
    
    /**
     *
     * @return
     */
    public boolean getShoot() {
        return shoot;
    }

    /**
     *
     * @return
     */
    public boolean getTurnLeft() {
        return turnleft;
    }
    
    /**
     *
     * @return
     */
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
            /*
             ables the ship to shoot only five bullets at a time
            */
            if (shots > 4) {
                this.shoot(false);
                shots = 0;
            }
            shots++;
        }
    }
    
    /**
     * draw ship
     * @param g
     * @param game 
     */
    
    @Override
    public void draw(Graphics2D g, Game game) {
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
