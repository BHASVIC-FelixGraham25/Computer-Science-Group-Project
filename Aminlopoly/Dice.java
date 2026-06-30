import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice extends Actor
{
    /**
     * Act - do whatever the Dice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int dTravelled=0;
    boolean canMove = true;
    boolean mousePressed = false;
    public Dice(){
        getImage().scale(getImage().getWidth()/2, getImage().getHeight()/2);
    }

    public void act()
    {
        mouseHeld4AndMovement();
    }

    public boolean isBounding(){
        if(getX() < 600 && getY() > 185){
            return true;
        } else{
            return false;
        }
    }
    
    public void moveAtASlowerPacePlease(int howSlow){
        int x = 10;
        if(x>0){
            x--;
        }
        move(howSlow);
    }

    public void mouseSpin(){
        MouseInfo mi = Greenfoot.getMouseInfo();
        if(mi.getX() == getX() && mi.getY() == getY()){
            turn(2);
        }
    }
    
    public int get_DisplayRes(){
        int d1= Greenfoot.getRandomNumber(3)+1;
        int d2= Greenfoot.getRandomNumber(3)+1;     // w  h
        //String w = "text";
        GreenfootImage image = new GreenfootImage("Dice 1: "+d1+"   Dice 2: "+d2, 110, Color.WHITE, Color.BLACK, Color.BLACK);
        setImage(image);
        canMove = false;
        setRotation(0);
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
        
        if(Greenfoot.mouseClicked(null)){
            //setImage(new GreenfootImage("Dice 1: "+d1+"   Dice 2: "+d2, 0, Color.WHITE, Color.BLACK, Color.BLACK));

            getWorld().removeObject(this);
            //Greenfoot.delay(10);
            //getWorld().addObject(new Dice(), getWorld().getWidth()/2, getWorld().getWidth()/2);
        }
        
        return d1+d2;
    }
    
    public void mouseHeld4AndMovement(){
        if(Greenfoot.mousePressed(null)) mousePressed = true;
        else if(Greenfoot.mouseClicked(null)) mousePressed = false;
        if(mousePressed && canMove == true){
            MouseInfo mi = Greenfoot.getMouseInfo();
            turnTowards(mi.getX(), mi.getY());
            //move(2);
            if(isBounding()){
                moveAtASlowerPacePlease(3);
                dTravelled++;
                if(dTravelled > 1000){
                    //get_DisplayRes();
                    dTravelled = -999999999;
                    getWorld().addObject(new DiceResult(Greenfoot.getRandomNumber(3)+1, Greenfoot.getRandomNumber(3)+1), 0, 0);
                    getWorld().removeObject(this);
                    canMove = false;
                }
            } else{
                move(-2);
            }
        }
    }

}

