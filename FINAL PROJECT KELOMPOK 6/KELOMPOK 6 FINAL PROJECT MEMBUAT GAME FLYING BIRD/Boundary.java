import greenfoot.*;  

public class Boundary extends Actor
{
    private GreenfootImage imgBoundary;
    private boolean isPipeInitialized = false; //Checks if pipe has been initialized in the world
    private int pos;
    public Boundary(int location)
    {
        imgBoundary = new GreenfootImage(1, 180); //The image for the line. This stays transparent.     
        pos = location;
        setImage(imgBoundary);
    }
 
    public void act() 
    {
        if(!isPipeInitialized)
        {
            setLocation(500, pos);
            isPipeInitialized = true;
        }
        
        move(-5);
    }    
}
