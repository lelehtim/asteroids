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
/**
 * Timer is used to keep track of the cyckles which have not yet been shown 
 */
public class Timer {
    
    /**stores the current time*/
    private long time1;
    
    /** time that one cyckle should take*/
    private static final float TIME_PER_CYCKLE = (1.0f/60)*1000;
    
    /** the number of elapsed cyckles*/
    private int numOfCyckles;
    
    /**time left untill the next cyckle*/
    private float timeTilNext;
    
    /**
     *
     */
    public Timer() {
        numOfCyckles = 0;
        time1 = getTime();
        timeTilNext = 0.0f;
        
    }
    private static long getTime() {
		return (System.nanoTime()/ 1000000L);
	}
    
    /**
     * method updates the number of cyckles that have elapsed but not yet been painted
     */
    
    public void update() {
        long time2 = getTime();
        float difference = (float)(time2-time1) + timeTilNext;
        numOfCyckles += (int)Math.floor(difference / TIME_PER_CYCKLE);
        timeTilNext = difference % TIME_PER_CYCKLE;
        time1 = time2;
    }
    
    /**
     * cyckleHasElapsed checks whether numOfCyckles is more than 0
     * and decreases the number by 1 if the number is originally more than 0
     * @return true if numOfCyckles is more than 0 else return false
     */
    
    public boolean cyckleHasElapsed() {
        if (0 < numOfCyckles) {
            numOfCyckles--;
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public int getNumOfCyckles() {
        return numOfCyckles;
    }
    
    
    
}
