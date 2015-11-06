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
public class Bullet extends Element {
    static final double BULLETSPEED = 10;
    
    public Bullet(Element ship, double direction) { // direction is the direction where the ship is pointing
        super(new Vector(ship.getPosition().x,ship.getPosition().y), new Vector(direction).adjust(BULLETSPEED), 1.0);
                
    }
    
}
