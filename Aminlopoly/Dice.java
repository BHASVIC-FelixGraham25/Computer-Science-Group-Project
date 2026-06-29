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
    
    }
    
    public void mouseHeld4AndMovement(){
        if(Greenfoot.mousePressed(null)) mousePressed = true;
        else if(Greenfoot.mouseClicked(null)) mousePressed = false;
        if(mousePressed){
            MouseInfo mi = Greenfoot.getMouseInfo();
            turnTowards(mi.getX(), mi.getY());
            //move(2);
            if(isBounding()){
                moveAtASlowerPacePlease(1);
            } else{
                move(-2);
            }
        }
    }

}

