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
    
    int timer = 0;
    
   int direction = 1;  
   int speed = 2;  
   int topY = 10;  
   int lowerY = 1;       
    
    public TankBrown (int leben){
       this.leben = leben;
        
    }

      
    /**
     * Act - do whatever the defender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        
        
       //MouseInfo mouse = Greenfoot.getMouseInfo();          
       //turnTowards(mouse.getX(), mouse.getY());

       // shoot();

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
    /**
     * Treffer,  this asteroid dealing the given amount of damage.
     */
    public void schadenVerursachen(int schaden) {
        leben = leben - schaden;
        if(leben <= 0){            
            Floor floor = (Floor) getWorld();
            floor.countScore();
            getWorld().removeObject(this);            
        }
    }
}
