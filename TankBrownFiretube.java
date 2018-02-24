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
    private int x, y;
     int direction = 1;  
   int speed = 2;  
   int topY = 10;  
   int lowerY = 1;       

    
    public TankBrownFiretube(int x, int y){
        this.x = x;
        this.y = y; 
    }
    public void act()     
    {
        lowerY = getWorld().getHeight()-10;
       if (getY() < topY && direction == -1) {  
           direction = 1;  
       }  
       if (getY() > lowerY && direction == 1) {  
           direction = -1;  
       }  
        setLocation(getX(), getY() + (direction * speed));
        
    }

    public void shoot(){

       
    }
}
 

