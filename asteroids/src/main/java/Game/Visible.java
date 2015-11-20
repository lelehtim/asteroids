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
public class Visible extends JPanel {
    
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
            paintElement(g, game.list.get(i), game.list.get(i).getPosition().x, game.list.get(i).getPosition().y);
            g.setTransform(transform);
            i++;
        }
        
    }
    
    public void paintElement(Graphics2D g, Element e, double x, double y) {
        System.out.println(""+x+" "+y);
        g.translate(x, y);
        //g.rotate(e.getRotation());
        e.draw(g, game);
    }
}
