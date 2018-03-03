import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private int leben = 0;
    private String text;
    private int stringLength;
    private static final Color textColor = new Color(0, 0, 0);

    public Health(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 30));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    public void setLeben(int leben){
        this.leben = leben;
    }
    public void updateLeben(int schaden){
        if(leben <= 0){
            leben = 0;
        }else{
            this.leben =this.leben - schaden;
        }
        
    }
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
         //if(value < ziel) {
           // value++;
            //updateImage();
        //}
        //else if(value > ziel) {
          //  value--;
           updateImage();
        //}
    }    
    

    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + leben, 1, 12);        
    }
}
