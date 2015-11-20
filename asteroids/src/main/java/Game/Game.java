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
import java.util.Iterator;
import java.util.ArrayList;

/**
 * class is responsible for creating the instances
 * loop which is responsible for runing the game is in this class
 */

public class Game extends JFrame {
    
    Iterator<Element> iterator;
    ArrayList<Element> list;
    Graphics2D g;
    Visible v;
    Ship ship;
    Listener l;
    
    public Game() {
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        v = new Visible(this);
        add(v, BorderLayout.CENTER);
        ship = new Ship();
        //Bullet b = new Bullet(ship,0.1);
        ship.setStatusToTrue();
        list = new ArrayList();
        list.add(ship);
       // list.add(b);
        iterator = list.iterator();
        l = new Listener(ship);
        
        this.addKeyListener(l);
    }
    
    public void run() {
        this.initialize();
        while(true) {
            refresh();
            v.repaint();
        }
    }
    
    public void initialize() {
        setSize(600,600);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setVisible(true);
    }
    
    public void refresh() {
        int i = 0;
        while (i < list.size()) {
            list.get(i).refresh(this);
            i++;
        }
//        while (iterator.hasNext()) {
//            iterator.next().refresh(); // updates the state of the element
//        }
        
    }
    
}
