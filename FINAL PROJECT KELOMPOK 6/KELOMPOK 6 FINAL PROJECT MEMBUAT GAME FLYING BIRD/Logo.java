import greenfoot.*;  

public class Logo extends Actor
{
    /**
     * Act - display the logo. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("up")||Greenfoot.mouseClicked(null)||Greenfoot.isKeyDown("space")) {
            World world;
            world = getWorld();
            world.removeObject(this);
            
        }
    }    
}
