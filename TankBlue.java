import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TankBlue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankBlue extends Tank
{

    private int leben = 5;
    private int ypos = 300;

    private Firetube firetube = new Firetube();

    private boolean tubeAdded = false;

    public TankBlue(){
    }
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int shottime = 0;
    int waitingtime = 30;
    public void act() 
    { 
        if(tubeAdded == false){
            getWorld().addObject(firetube, getX(), getY());

            firetube.setLocation(getX(), getY());
            tubeAdded = true;
        }
        if(Greenfoot.isKeyDown("W"))
        {
            ypos += -4;
        }
        if(Greenfoot.isKeyDown("S"))
        {
            ypos += 4;
        }

        if(Greenfoot.isKeyDown("space"))
        {
            shottime++;
            if(shottime > waitingtime ){
                Projectile projectile = new Projectile();
                getWorld().addObject(projectile, getX(), getY());
                shottime=0;
            }

            //Bullet bullet = new Bullet();
            //World.addObject(bullet, 200, 200);
        }    
        firetube.setLocation(getX(), ypos);
        setRotation(0);
        setLocation(getX(), ypos);
    }

}
