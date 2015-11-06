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
// this class represents vectors which will be used as determining location and a speed of an element in a game

public class Vector {
    
    double x; // x coordinate of a vector
    
    double y; // y coordinate of vector
    
    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector(double direction) {
        this.x = Math.cos(direction);
        this.y = Math.sin(direction);
    }
    
    public Vector adjust(double speed) {
        this.x = this.x*speed;
        this.y = this.y*speed;
        return this;
    }
    
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
}
