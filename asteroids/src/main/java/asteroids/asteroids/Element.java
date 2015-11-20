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
    
    public double rotation;
    Vector speed; // coordinates to be added to the element after a rotation in the game loop
    Vector position; // initial position of the element
    private double radius; // within this radius the element experiences impact
    private boolean status;
    
    public Element(Vector position, Vector speed, double radius) {
        this.position = position;
        this.speed = speed;
        this.radius = radius;
        this.rotation = 0;
        this.status = false;
    }
    
    public void setStatusToFalse() {
        status = false;
    }
    
    public void setStatusToTrue() {
        status = true;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getSpeed() {
        return speed;
    }
    
    /**
     * method updates the state of the element
     * @param game is the JFrame instance 
     */
    
    public void refresh(Game game) {  
        position.sum(speed);
        
    }
    
    public double getRadius() {
        return radius;
    }
    
    /**
     * rotates the element
     * @param a 
     */
    
    public void turn(double a) {
        this.rotation += a;
    }
    
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
    
}
