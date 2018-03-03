import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TankBrown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TankBrown extends Tank
{
    /**
     * Act - do whatever the TankBrown wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    /** Wenn die Lebenspunkte 0 erreichen, wird der Tank explodieren. */
    private int leben;
    
    private int timer = 0;
    
    private TankBrownFiretube firetube = new TankBrownFiretube();

    private boolean tubeAdded = false;
    
    private int direction = 1;  
    private int speed = 2;  
    private int topY = 10;  
    private int lowerY = 1;       

    public TankBrown (int leben){
       this.leben = leben;
    }

    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    { 
        if(tubeAdded == false){
             getWorld().addObject(firetube, getX(), getY());

             firetube.setLocation(getX()-40, getY());
             tubeAdded = true;
        }
        
        if(Greenfoot.isKeyDown("space"))
        {
            //Projectile projectile = new Projectile();
            //getWorld().addObject(projectile, getX(), getY());

            //Bullet bullet = new Bullet();
            //World.addObject(bullet, 200, 200);
        }    
        
         lowerY = getWorld().getHeight()-10;
         if (getY() < topY && direction == -1) {  
           direction = 1;  
        }  
        if (getY() > lowerY && direction == 1) {  
           direction = -1;  
        }  
        setLocation(getX(), getY() + (direction * speed));
         firetube.setLocation(getX()-40, getY());

        //setLocation(getX(), getY());
        shoot();
    }
        
    private int zeit=0;
    private int warteZeit=100;        

    public void shoot(){
        
        zeit++;
        if(zeit > warteZeit){
            GegnerBullet bullet = new GegnerBullet();    
           // bullet.move(-5);
            bullet.setRotation(180);
            getWorld().addObject(bullet, getX()-40, getY());
            zeit=0;

        }

    }
           
        
    
    /**
     * Treffer,  this tank dealing the given amount of damage.
     */
    public void schadenVerursachen(int schaden) {
        leben = leben - schaden;
        if(leben <= 0){            
            Floor floor = (Floor) getWorld();
            floor.countScore();
            firetube.tubeZerstoeren();
            getWorld().removeObject(this); 
        }
    }
}
