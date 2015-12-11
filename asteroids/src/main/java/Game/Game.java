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
import java.util.Random;

/**
 * class is responsible for creating the Game instance and other instances needed in the game
 * loop which is responsible for runing the game is in this class
 */

public class Game extends JFrame {
    
    /** list of the element in the game*/
    public ArrayList<Element> list;
    
    /** graphics object*/
    Graphics2D g;
    
    /** the visible instance used to display the game to the player*/
     public Visible v;
    
    /** ship instance*/
    public Ship ship;
    
    /** listener used to taking care of the commands given by the player*/
    Listener l;
    
    /** timer is used to keep track of time in the game*/
    Timer timer;
    
    /** number of times the loop has elapsed*/
    public int cyckleNum;
    
    /** number of a cyckles in a current round*/
    public int numOfCycklesInRound;
    
    /** players score*/
    public int score;
    
    /** ordinal number of the current round*/
    public int roundCount;
    
    public Game() {
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        v = new Visible(this);
        add(v, BorderLayout.CENTER);
        
        setSize(600,600);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        
        
        ship = new Ship();
        ship.setStatusToTrue();
        list = new ArrayList();
        list.add(ship);
        l = new Listener(ship);
        timer = new Timer();
        
        setVisible(true);
        
        cyckleNum = 0;
        score = 0;
        roundCount = 1;
        
        this.addKeyListener(l);
    }
    
    /**
     * run method updates the game int the main loop by calling the refresh method. If the game is starting to delay
     * the refresh method is called more than once per cyckle in order to catch up
     */
    
    public void run() {
        while(true) {
            numOfCycklesInRound = 400;
            long begin = System.nanoTime();
            timer.update();
            if (ship.status) {
                for(int i = 0; i < 5 && timer.cyckleHasElapsed(); i++) {
		refresh();
                }
                v.repaint();
            }
            
            /* (1000000000.0 / 60) is the time that one frame should take
             difference is the time left in a frame*/
            long difference = (long)(1000000000.0 / 60) - (System.nanoTime() - begin);
            
            // if difference > 0 sleep until it is time to continue
            if (difference > 0) {
                try {
                    Thread.sleep(difference / 1000000L, (int) difference % 1000000);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            cyckleNum++;
            if (ship.getreStart()) {
                break;
            }
            
            if (cyckleNum % numOfCycklesInRound == 0) {
                cyckleNum = 0;
                roundCount++;
                numOfCycklesInRound += 200;
            }
        }
        reStart();
    }
    
    public void reStart() {
        this.list.clear();
        ship.initialize();
        list.add(ship);
        score = 0;
        this.run();
        
    }
    
    
    /**
     * first loop updates the states of the elements
     * adds asteroids to the game 
     * second loop removes elements with a status false
     * 
     */
    
    public void refresh() {
        int i = 0;
        int j = 0;
        if (cyckleNum % 100 == 0) {
            while (roundCount > j) {
                Asteroid a = new Asteroid(new Random());
                list.add(a);
                j++;
            }
        }
        while (i < list.size()) {
            list.get(i).refresh(this);
            if (!list.get(i).status && list.get(i).type == 3) {
                return;
            }
            i++;
        }
        Iterator<Element> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(!iterator.next().status) {
                iterator.remove();
            }
        }
        
    }
    
}
