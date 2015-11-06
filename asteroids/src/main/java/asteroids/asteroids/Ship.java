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
public class Ship extends Element {
    static final double ROTATION = Math.PI / 1.5;
    static final double ACCELARATION = 0.2;
    
    
    public Ship() {
        // first vector needs to be adjusted to the center of the screen and the radius to be corrected
        super(new Vector(0.0,0.0), new Vector(0.0,0.0),10.0);
        
        
    }
    
}
