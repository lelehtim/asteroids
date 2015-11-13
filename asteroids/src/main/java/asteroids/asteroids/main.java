/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.asteroids;
import java.awt.*;
import java.awt.event.*;
import Game.Game;
/**
 *
 * @author Lauri
 */

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Ship ship1 = new Ship();
//        Vector v = new Vector(0.5);
//        v.adjust(10);
//        System.out.println(""+v.x + "  " + v.y);
//        Vector vec = new Vector(1.0,1.0);
//        Vector vec2 = new Vector(1.0,2.0);
//        vec.sum(vec2);
//        System.out.println(""+vec.x + " "+ vec.y);
        Game game = new Game();
        game.run();
    }
    
}
