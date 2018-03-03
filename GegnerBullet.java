import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GegnerBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GegnerBullet extends Actor
{
     private int life = 145;
    /**
     * Act - do whatever the GegnerBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GegnerBullet(){
      

    }
    
    public void act() 
    {
       
        //removeAtWorldEdge();
        if(life <= 0 || getX() <= 0|| getY() <=0 || getY() >= getWorld().getHeight()) {
          getWorld().removeObject(this);
        }else {
            life--;
            move(5);   
            checkHitTankBlue();

        }
    } 
    
    /**
     * Check whether we have hit an asteroid.
     */
    private void checkHitTankBlue()
    {
        TankBlue tankBlue = (TankBlue) getOneIntersectingObject(TankBlue.class);
        Block block = (Block) getOneIntersectingObject(Block.class);

        if (block != null){
            getWorld().removeObject(this);
        }else{
            int schaden = 1;
        
            if (tankBlue != null){            
                Floor floor = (Floor) getWorld();
                floor.countHealth();
                getWorld().removeObject(this);
            }

        }
    }
    
    private void checkHitBlock(){
        Block block = (Block) getOneIntersectingObject(Block.class);

        if (block != null){
            getWorld().removeObject(this);
        }
    }
}
