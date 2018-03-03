import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TankBrownFiretube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankBrownFiretube extends Actor
{
    /**
     * Act - do whatever the TankBrownFiretube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()     
    {

        
    }
   
    /**
     * Tube von Tankbrown zerstoeren
     */
    public void tubeZerstoeren() {
        getWorld().removeObject(this);          
     
    }
}
 

