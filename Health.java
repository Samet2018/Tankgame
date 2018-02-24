import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    public Health(int x, int y){
        GreenfootImage img = new GreenfootImage(x, y);
        float fontSize = 35.0f; //change this to the font size that you want
        Font font = img.getFont();
        font = font.deriveFont(12);
        img.setFont(font);
    
            
        img.drawString("" + 100, 10, 100); //this x and y position is the bottom-left of the first letter.
        setImage(img);
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(100, 100);
        float fontSize = 35.0f; //change this to the font size that you want
        Font font = img.getFont();
        font = font.deriveFont(12);
        img.setFont(font);
    
            
        img.drawString("" + 100, 10, 100); //this x and y position is the bottom-left of the first letter.
        setImage(img);
    }    
}
