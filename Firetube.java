import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Firetube here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Firetube extends Actor
{
    /**
     * Act - do whatever the Firetube wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();          
            turnTowards(mouse.getX(), mouse.getY());
        }
        shoot();
    }

    public void shoot(){

        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(null)){
            Projectile projectile = new Projectile(getX(),getY());
            projectile.setRotation(getRotation());
            int x = getX();
            int y = getY();
            // TODO: verschiebung von projektilen zu Kanonenrohrspitze
            getWorld().addObject(projectile,x, y);         
        }
    }
}
 

