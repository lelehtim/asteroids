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
public class VectorTest {
    Vector v;
    Vector s;
    Vector sumVector;
    Vector vecToBeAdjusted;
    Vector vecAdjusted;
    
    public VectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        v = new Vector(0.5, 0.5);
        s = new Vector(0.7, 0.4);
        vecToBeAdjusted = new Vector(0.5);
        vecAdjusted = new Vector(0.5);
        double x = v.x + s.x;
        double y = v.y + s.y;
        sumVector = new Vector(x,y);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class Vector.
     */
    @Test
    public void testSum() {
        v.sum(s);
        assertTrue(sumVector.x == v.x);
        assertTrue(sumVector.y == v.y);
    }
    @Test
    public void testAdjust() {
        vecAdjusted.x = vecAdjusted.x*10;
        vecAdjusted.y = vecAdjusted.y*10;
        vecToBeAdjusted.adjust(10);
        assertTrue(vecAdjusted.x == vecToBeAdjusted.x);
        assertTrue(vecAdjusted.y == vecToBeAdjusted.y);

}
}