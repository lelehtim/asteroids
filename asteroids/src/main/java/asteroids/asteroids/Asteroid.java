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
    private int order; // 1 being the original, 4 being the one which does not brake down to smaller asteroids
    
    public Asteroid(Random rand) {
        //super(position(rand), new Vector(0.5*rand.nextDouble()).adjust(VELOCITY),10.0);
        super(new Vector(rand), new Vector(10*rand.nextDouble()),20.0);
        speed.adjust(VELOCITY);
        this.type = 2;
        this.order = 1;
    }
    
    public Asteroid(Asteroid a) {
        super(a.position, a.speed, a.radius - 3);
        this.order = a.order + 1;
        this.type = 2;
        switch(order) {
            case 2:
                speed.adjust(0.90);
                break;
            case 3:
                speed.adjust(0.90);
                break;
            case 4:
                speed.adjust(0.90);
                break;
        }
    }
    
    /**
     * 
     * 
     */
    
    
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
//                    if (radius > 10) {
//                        int j = 0;
//                        double change = 0.1;
//                        while (j < 2) {
//                            Vector s = new Vector(this.speed.x, speed.y);
//                            this.speed.sum(s.adjust(change));
//                            Asteroid asteroid = new Asteroid(this);
//                            game.list.add(asteroid);
//                            change += 0.2;
//                            j++;
//                        }
//                    }
                    game.list.get(i).takeCareOfImpact(game); // takes care of the bullet
                    setStatusToFalse();
                    game.score++;
                }
            }
            i++;
        }
    }
}
