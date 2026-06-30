import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DiceResult here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceResult extends Actor
{
    /**
     * Act - do whatever the DiceResult wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int d1 = 0;
    int d2 = 0;
    public DiceResult(int d1, int d2){
        this.d1 = d1;
        this.d2 = d2;
    }
    public void act()
    {
        // Add your action code here.
        get_DisplayRes();
    }
    public int get_DisplayRes(){
        //int d1= Greenfoot.getRandomNumber(3)+1;
        //int d2= Greenfoot.getRandomNumber(3)+1; 
        GreenfootImage image = new GreenfootImage("Dice 1: "+d1+"   Dice 2: "+d2, 110, Color.WHITE, Color.BLACK, Color.BLACK);
        setImage(image);
        setRotation(0);
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        if(Greenfoot.isKeyDown("space")){
            Greenfoot.delay(50);
            getWorld().removeObject(this);
            
        }
        
        return d1+d2;
    }
}
