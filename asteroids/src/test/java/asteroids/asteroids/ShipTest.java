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

/**
 *
 * @author Lauri
 */
public class ShipTest {
    Ship s;
    
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
        s = new Ship();
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

    
}
