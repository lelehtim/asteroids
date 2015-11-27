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
import java.awt.Polygon;
import java.util.Random;

/**
 * represents the asteroid instance in the game
 */

public class Asteroid extends Element{
    
    private static final double VELOCITY = 3.0;
    
    public Asteroid(Random rand) {
        //super(position(rand), new Vector(0.5*rand.nextDouble()).adjust(VELOCITY),10.0);
        super(new Vector(rand), new Vector(0.5*rand.nextDouble()).adjust(VELOCITY),10.0);
        this.type = 2;
    }
    
    /**
     * 
     * 
     */
    
//    public static Vector position(Random rand) {
//        Vector vector = new Vector(300.0, 300.0);
//        vector.sum(new Vector(rand.nextDouble()).adjust(200 + rand.nextDouble()*50));
//        return vector;
//    }
//    
//    public static Vector speed(Random rand) {
//        Vector vector = new Vector(rand.nextDouble());
//        return vector.adjust(VELOCITY);
//    }
    
    @Override
    public void refresh(Game g) {
        super.refresh(g);
        
    }

    @Override
    public void draw(Graphics2D g, Game game) {
        g.drawOval(-1,1,10,10);
    }

    @Override
    public void takeCareOfImpact(Game game) {
        
    }
}
