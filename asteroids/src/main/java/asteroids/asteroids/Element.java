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
public abstract class Element {
    
    private double rotation;
    private Vector speed; // coordinates to be added to the element after a rotation in the game loop
    private Vector position; // initial position of the element
    private double radius; // within this radius the element experiences impact
    
    public Element(Vector position, Vector speed, double radius) {
        this.position = position;
        this.speed = speed;
        this.radius = radius;
        this.rotation = 0;
    }
    
    public Vector getPosition() {
        return position;
    }
    
    public Vector getSpeed() {
        return speed;
    }
    
    public void refresh() {  // parameter value passed to be checked
        this.position = this.position.sum(speed);
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void turn(double a) {
        this.rotation += a;
    }
    
    public double getRotation() {
        return this.rotation;
    }
    
}
