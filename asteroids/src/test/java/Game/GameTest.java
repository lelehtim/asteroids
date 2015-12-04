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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }
    
    public void testRefresh() {
        
    }
    
//    @Test
//    public void testreStart() {
//        game.reStart();
//        
//        assertEquals(-2*Math.PI,game.ship.rotation);
//    }
    
}
