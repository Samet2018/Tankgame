import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /** Der Schaden, den diese Projektil anrichten wird. */
    private static final int schaden = 1;
    /** Eine Kugel verliert bei jedem Akt ein Leben und verschwindet, wenn das Leben = 0 ist. */
    private int life = 145;
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Projectile(){}

    public Projectile(int x, int y){
        if(Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            x = mouse.getX();
            y = mouse.getY();
            turnTowards(x,y);

        }

    }

    public void act() 
    {

        //removeAtWorldEdge();

        if(life <= 0 || (getY() < 10 || getY() > getWorld().getHeight())) {
            getWorld().removeObject(this);
        }else {
            life--;
            move(5);

            checkHitTankBrown();
        }

        // Test kommmentar

    } 

    /**
     * Check whether we have hit an tankbrown.
     */
    private void checkHitTankBrown()
    {
        TankBrown tankBrown = (TankBrown) getOneIntersectingObject(TankBrown.class);
        Block block = (Block) getOneIntersectingObject(Block.class);

        if (block != null){
            getWorld().removeObject(this);
        }else{
            if (tankBrown != null){
                getWorld().removeObject(this);
                tankBrown.schadenVerursachen(schaden);            
            }
        }
    }

    public void removeAtWorldEdge()
    {

        if(getY() < 10 || getY() > getWorld().getHeight()){
            getWorld().removeObject(this);
        }

    }
}    

