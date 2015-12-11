/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids.asteroids;

import Game.Game;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

/**
 *
 * @author Lauri
 */
public class ShipTest {
    Game g;
    Ship s;
    Bullet b;
    
    public ShipTest() {
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
        Random rand = new Random();
        s = new Ship();
        b = new Bullet(s, s.getRotation());
        
        int j = 0;
        while(j<100) {
            Asteroid a = new Asteroid(rand);
            g.list.add(a);
            j++;
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testAccelerate() {
        s.accelerate(true);
        assertTrue(true == s.getAcceleration());
    }
    
    @Test
    public void testShoot() {
        s.shoot(true);
        assertTrue(true == s.getShoot());
    }
    
    @Test
    public void testTurnLeft() {
        s.turnleft(true);
        assertTrue(true == s.getTurnLeft());
    }
    
    @Test
    public void testTurnRight() {
        s.turnright(true);
        assertTrue(true == s.getTurnRight());
    }

    @Test
    public void testTakeCareOfImpactWithBullet() {
        g.list.add(b);
        g.ship.takeCareOfImpact(g);
        assertTrue(g.ship.status == true);
    }
    
    @Test
    public void testTakeCareOfImpactWithAsteroid() {
        g.ship.position.x = 1.0;
        g.ship.position.y = 1.0;
        g.ship.takeCareOfImpact(g);
        assertTrue(g.ship.status == false);
    }
    
    @Test
    public void testRefresh() {
        g.ship.turnleft(Boolean.TRUE);
        g.ship.refresh(g);
        assertTrue(g.ship.rotation == (-Math.PI / 2) - 0.1);
        g.ship.turnleft(Boolean.FALSE);
        g.ship.turnright(Boolean.TRUE);
        g.ship.refresh(g);
        assertTrue(g.ship.rotation == (-Math.PI / 2));
        g.ship.turnright(Boolean.FALSE);
        g.ship.shoot(Boolean.TRUE);
        g.ship.refresh(g);
        int j = 0;
        int t = 0;
        while (g.list.size() > j) {
            t = g.list.get(j).type;
            if (t == 1) {
                break;
            }
            j++;
        }
        assertEquals(1, t);
        
        
    }
    
    
}
