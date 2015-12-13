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
 * class represents the elements which are needed in the game
 */

public abstract class Element {
    
    /** is the measure of the direction*/
    public double rotation;
    
    /** vector representing the speed of an element*/
    Vector speed;
    
    //* vector representing the position of the element in the game*/
    Vector position;
    
    /**within this radius the element experiences impact*/
    public double radius;
    
    /**if status is false, element needs to be removed*/
    public boolean status;
    
    /** each element has a unique type*/
    public int type;
    
    /**
     *
     * @param position
     * @param speed
     * @param radius
     */
    public Element(Vector position, Vector speed, double radius) {
        this.position = position;
        this.speed = speed;
        this.radius = radius;
        this.rotation = 0;
        this.status = true;
    }
    
    /**
     *
     */
    public void setStatusToFalse() {
        status = false;
    }
    
    /**
     *
     */
    public void setStatusToTrue() {
        status = true;
    }
    
    /**
     *
     * @return
     */
    public boolean getStatus() {
        return status;
    }
    
    /**
     *
     * @return
     */
    public Vector getPosition() {
        return position;
    }
    
    /**
     *
     * @return
     */
    public Vector getSpeed() {
        return speed;
    }
    
    /**
     * method updates the state of the element
     * if the coordinates of the element are out of bounds it will be moved to the opposite side of the screen
     * @param game is the JFrame instance 
     */
    
    public void refresh(Game game) {  
        position.sum(speed);
        
        if (position.x >= 600) {
            position.x = 1;
        }
        if (position.y >= 600) {
            position.y = 1;
        }
        if (position.x <= 0) {
            position.x = 599;
        }
        if (position.y <= 0) {
            position.y = 599;
        }
        
    }
    
    /**
     *
     * @return
     */
    public double getRadius() {
        return radius;
    }
    
    /**
     * rotates the element
     * @param a is the default rotation
     */
    
    public void turn(double a) {
        this.rotation += a;
    }
    
    /**
     *
     * @return
     */
    public double getRotation() {
        return this.rotation;
    }
    
    /**
     * handles the drawing of the elements
     * @param g
     * @param game
     * 
     */
    
    public abstract void draw(Graphics2D g, Game game);
    
    /**
     * method handles the situation where two Elements collide
     * @param game is the Game instance
     */
    
    public abstract void takeCareOfImpact(Game game);
    
}
