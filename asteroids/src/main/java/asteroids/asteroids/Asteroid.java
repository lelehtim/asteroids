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
import java.util.Random;

/**
 * represents the asteroid instance in the game
 */

public class Asteroid extends Element{
    
    /** velocity of the asteroid*/
    private static final double VELOCITY = 3.0;
    
    public Asteroid(Random rand) {
        super(new Vector(rand), new Vector(10*rand.nextDouble()),20.0);
        speed.adjust(VELOCITY);
        this.type = 2;
    }
    
    
    
    @Override
    public void refresh(Game g) {
        super.refresh(g);
        takeCareOfImpact(g);
    }

    @Override
    public void draw(Graphics2D g, Game game) {
        g.drawOval(-1,1,(int)radius,(int)radius);
    }

    @Override
    public void takeCareOfImpact(Game game) {
        int i = 0;
        while (i < game.list.size()) {
            if (game.list.get(i).type == 1) { 
                double xPosition = game.list.get(i).position.x;
                double yPosition = game.list.get(i).position.y;
                if ((-radius < this.position.x - xPosition && this.position.x - xPosition < radius) && (-radius < this.position.y - yPosition && this.position.y - yPosition < radius)) {
                    game.list.get(i).takeCareOfImpact(game); // takes care of the bullet
                    setStatusToFalse();
                    game.score++;
                }
            }
            i++;
        }
    }
}
