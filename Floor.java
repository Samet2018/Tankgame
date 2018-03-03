import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends World
{
    private Counter scoreCounter = new Counter("Score: ");
    private Health health = new Health("Leben: ");
    private TankBrownFiretube tube;



    /**
     * Constructor for objects of class Floor.
     * 
     */
    public Floor()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 630, 1); 
        
        //boolean gameover = false;
       // while(gameover == false){
        //   createTankBrown();
        //}
        
        health.setLeben(5);
        addObject(health, 50, 70);

        addObject(scoreCounter, 50, 50);
        prepare();
        
        
       //GreenfootImage image = new GreenfootImage(100, 20);
       //image.drawString("Hello World", 10, 16);
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
        tankblue.setLocation(50, getHeight()/2);
       // Firetube firetube = new Firetube();
        //addObject(firetube, 298, 189);        
        //firetube.setLocation(42, 198);
        
        //Health healthbar= new Health(50,10);
        //showText("Leben: "+ spielerLeben, getWidth()-50  , 20);
        //showText("Treffer: "+ treffer, getWidth()-50  , 70);
        createBlock(3);
    }
    int duration = 0;
    int tankBrownCounter = 0;
    int tankCounter = 0;
    public void createTankBrown()
    {
        duration++;
        
        while(duration > 100 && tankBrownCounter < 5){
            int leben = 1;
            
            TankBrown brown = new TankBrown(leben);

            int yPos= getRandomNumber(getHeight());
            yPos = yPos*35; 
            int xPos = getWidth()-50-(tankCounter*50);
            addObject(brown, xPos, yPos);    
            duration = 0;
            if(tankCounter > 6){
                tankCounter=0;
            }else{
                tankCounter++;
            }

            tankBrownCounter++;
            //tube = new TankBrownFiretube(xPos-40, yPos);            
            //addObject(tube, xPos-40, yPos);        
            //currentTime = System.currentTimeMillis();
            
        }
        
    }
    public void countScore()
    {
         scoreCounter.add(1);
    }
    
    public void countHealth()
    {
         health.updateLeben(1);
    }
    
    
    public int getRandomNumber(int end){
        int zahl = end/35;
        int normal = Greenfoot.getRandomNumber(zahl);
       return normal;
    }
    
    public void showScore(){
        treffer++;
       
    }
    public void createBlock(int num){
        int xPos = getWidth()/3;
        for(int i = 0; i < num; i++){
            Block b = new Block();
            int yPos= getRandomNumber(getHeight());
            yPos = yPos*35;             
            addObject(b, xPos, yPos);    
        }
    }
}
