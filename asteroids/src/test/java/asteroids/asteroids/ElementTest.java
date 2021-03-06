/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.asteroids;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Game.Game;
/**
 *
 * @author Lauri
 */
public class ElementTest {
    Ship s;
    Game g;
    
    public ElementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        g = new Game();
        s = new Ship();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPosition method, of class Element.
     */
//    @Test
//    public void testGetPosition() {
//        assertTrue(s.getPosition().x == 0.0);
//        assertTrue(s.getPosition().y == 0.0);
//    }

    /**
     * Test of getSpeed method, of class Element.
     */
    @Test
    public void testGetSpeed() {
        assertTrue(s.getSpeed().x == 0.0);
        assertTrue(s.getSpeed().y == 0.0);
    }

    /**
     * Test of refresh method, of class Element.
     */
    @Test
    public void testRefresh() {
        Vector v = new Vector(s.position.x+s.speed.x, s.position.y+s.speed.y);
        s.refresh(g);
        assertTrue(v.x == s.position.x);
        assertTrue(v.y == s.position.y);
    }

    /**
     * Test of getRadius method, of class Element.
     */
    @Test
    public void testGetRadius() {
        assertTrue(s.getRadius() == 10.0);
    }

    /**
     * Test of turn method, of class Element.
     */
    @Test
    public void testTurn() {
        double a = s.getRotation();
        s.turn(0.5);
        assertTrue(a+0.5 == s.getRotation());
    }
    
}
