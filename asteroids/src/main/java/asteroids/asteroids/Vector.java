/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.asteroids;
import java.util.Random;

/**
 *
 * @author Lauri
 */
 /**
  * this class represents vectors which will be used as determining location and a speed of an element in a game
  */

public class Vector {
    
    public double x; // x coordinate of a vector
    
    public double y; // y coordinate of vector
    
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector(double direction) {
        this.x = Math.cos(direction);
        this.y = Math.sin(direction);
    }
    
    public Vector(Random rand) {
        double value = rand.nextDouble();
        if (value < 0.25) {
            this.x = 590.0;
            this.y = rand.nextDouble()*100;
        }
        if (0.25 <= value && value < 0.50) {
            this.x = rand.nextDouble() * 100;
            this.y = 590.0;
        }
        if (0.50 <= value && value < 0.75) {
            this.x = 10.0;
            this.y = rand.nextDouble() * 100;
        } else {
            this.x = rand.nextDouble() * 100;
            this.y = 10;
        }
        
    }
    
    /** 
     * adjust method changes the x and y coordinate by multiplying with double value speed
     * @param speed is the velocity of the Element
     * @return adjusted Vector
     */
    
    public Vector adjust(double speed) {
        this.x = this.x*speed;
        this.y = this.y*speed;
        return this;
    }
    
    /**
     * sums components of two vectors
     * @param vector is the speed vector of an element
     * @return new position Vector 
     */
    
    public Vector sum(Vector vector) { // will be used to calculate the location of an element after 
        this.x += vector.x;             // a rotation in a game loop
        this.y += vector.y;
        return this;
    }
    
    public double getxCoordinate(Vector v) {
        return v.x;
    }
    
    public double getyCoordinate(Vector v) {
        return v.y;
    }
    
    public double getSquaredLength() {
        return (x*x + y*y);
    }
    
    /**
     * adjust the vector length to one
     * @return Vector
     */
    
    public Vector makeLengthOne() {
        double length = getSquaredLength();
        if (length != 0.0 && length != 1.0) {
            length = Math.sqrt(length);
            x = x/length;
            y = y/length;
        }
        return this;
    }
}
