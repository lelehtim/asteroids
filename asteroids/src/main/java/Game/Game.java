/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Lauri
 */
import asteroids.asteroids.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Game extends JFrame {
    
    ArrayList<Element> list;
    Graphics2D g;
    Visible v;
    
    public Game() {
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        v = new Visible(this);
        add(v, BorderLayout.CENTER);
        Ship ship = new Ship();
        list = new ArrayList();
        list.add(ship);
    }
    
    public void run() {
        this.initialize();
        v.repaint();
        
    }
    
    public void initialize() {
        setSize(300,300);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setVisible(true);
    }
    
    
    
}
