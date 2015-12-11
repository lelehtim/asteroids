/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import asteroids.asteroids.*;
import java.awt.geom.AffineTransform;
import java.awt.RenderingHints;

/**
 *
 * @author Lauri
 */

/**
 * Visible class is responsible for showing the game for the player
 */
public class Visible extends JPanel {
    
    /** the game instance*/
    Game game;
    
    public Visible(Game game) {
        super.setBackground(Color.BLACK);
        this.game = game;
        
    }
    
    
    
    @Override
    protected void paintComponent(Graphics graphics) {
        int i = 0;
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.RED);
        AffineTransform transform = g.getTransform();
        
       while(i < game.list.size()) {
           Vector vec = game.list.get(i).getPosition();
            paintElement(g, game.list.get(i), vec.x, vec.y);
            g.setTransform(transform);
            i++;
        }
        
       paintScore(g);
    }
    
    /**
     * paints an element on the window
     * @param g
     * @param e element
     * @param x coordinate of the position vector of the element
     * @param y coordinate of the position vector of the element
     */
    
    public void paintElement(Graphics2D g, Element e, double x, double y) {
        g.translate(x, y);
        g.rotate(e.getRotation());
        e.draw(g, game);
    }
    /**
     * converts the integer score to a string and paints it on the window
     * @param g
     */
    public void paintScore(Graphics2D g) {
        String score = Integer.toString(game.score);
        g.drawString("Score: " + score, 10, 10);
    }
}
