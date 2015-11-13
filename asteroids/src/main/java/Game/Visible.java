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

/**
 *
 * @author Lauri
 */
public class Visible extends JPanel {
    
    Game game;
    Graphics2D g;
    public Visible(Game game) {
        super.setBackground(Color.BLACK);
        this.game = game;
        
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        int i = 0;
        super.paintComponent(graphics);
        g = (Graphics2D) graphics;
        g.setColor(Color.RED);
        
        while(i < game.list.size()) {
            paintElement(game.list.get(i));
            i++;
        }
        
    }
    
    public void paintElement(Element e) {
        e.draw(g, game);
    }
}
