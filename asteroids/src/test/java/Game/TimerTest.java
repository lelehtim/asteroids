/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri
 */
public class TimerTest {
    Timer timer;
    
    @Test
    public void updateTest() {
        timer = new Timer();
        timer.update();
        assertEquals(0, timer.getNumOfCyckles());
    }
    
    @Test
    public void cyckleHasElapsedTest() {
        timer = new Timer();
        timer.update();
        assertEquals(false, timer.cyckleHasElapsed());
    }
}
