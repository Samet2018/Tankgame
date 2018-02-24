import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends World
{
    private Counter scoreCounter;
    /**
     * Constructor for objects of class Floor.
     * 
     */
    public Floor()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        //boolean gameover = false;
       // while(gameover == false){
        //   createTankBrown();
        //}
              
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 380);
        prepare();            
    }
    public void act() 
    {
        createTankBrown();

    }   
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    int timer = 0;
    int spielerLeben = 5;
    int treffer = 0;
    private void prepare()
    {       
        TankBlue tankblue = new TankBlue();
        addObject(tankblue, 297, 205);
        tankblue.setLocation(41, 199);
        Firetube firetube = new Firetube();
        addObject(firetube, 298, 189);        
        firetube.setLocation(42, 198);
        
        Health healthbar= new Health(50,10);
        showText("Leben: "+ spielerLeben, getWidth()-50  , 20);
        showText("Treffer: "+ treffer, getWidth()-50  , 70);
    }
    int duration = 0;
    int tankBrownCounter = 0;
    public void createTankBrown()
    {
        duration++;
        
        while(duration > 100 && tankBrownCounter <=5){
            int leben = 1;
            TankBrown brown = new TankBrown(leben);
            int yPos= getRandomNumber(getHeight());
            yPos = yPos*35; 
            addObject(brown, getWidth()-50, yPos);    
            duration = 0;
            tankBrownCounter++;
            //currentTime = System.currentTimeMillis();
            
        }
        
    }
    public void countScore()
    {
         scoreCounter.add(1);
    }
    
    
    public int getRandomNumber(int end){
        int zahl = end/35;
        int normal = Greenfoot.getRandomNumber(zahl);
       return normal;
    }
    
    public void showScore(){
        treffer++;
        showText("Treffer: "+ treffer, getWidth()-50  , 70);
    }
}
