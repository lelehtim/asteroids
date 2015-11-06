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
    
    public Vector sum(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }
}
