import greenfoot.*;  

public class Bird extends Actor
{
    private WorldClass w;
    
    private int moveY = 5;  //Simulates gravity by specifying the amount that the bird will move down each time
                            //When the bird jumps, the moveY variable is set to a negative value and the bird moves up
                            //To reset to initial state, moveY is increased by 1 kn each act until it is equal to 5
                            
    private int imageNumber = 1; //Used for animating the bird's wings

    private GreenfootImage img1; //The initial image that is sequentially displayed for animation effect

        public Bird()
    {
        img1 = new GreenfootImage(getImage()); 
        setImage(img1);
    }

    public void addedToWorld(World world)
    {
        w = (WorldClass) world; 
    }

    public void act() 
    {
        flapUp();

        if(isTouching(Boundary.class)) 
        {
            w.score();
            w.removeObject(getOneIntersectingObject(Boundary.class)); //Menghapus batas yang tidak terlihat sehingga tidak mungkin mencetak skor lebih dari satu kali pada pipa yang sama.
            Greenfoot.playSound("ping.mp3");
        }

        if(isTouching(TopPipe.class) || isTouching(BottomPipe.class) || getY() >= 599)
        {
            w.lost();
            Greenfoot.playSound("death.wav");
        }
    }   

    /**
     * To animate the bird's wings.
     */
    private void animate()
    {
        if(Greenfoot.getRandomNumber(3) == 0)
        {
            if(imageNumber == 3)
            {
                imageNumber = 1;
            }
            else {
                imageNumber++;
            }
            setImage("flappybird"+imageNumber+".png");
        }
    }    

    /**
     * Flap up either on mouse click or keyboard input.
     */
    private void flapUp()
    {
        final int jumpDist = -18;
        if(Greenfoot.mouseClicked(null))
        {
            moveY = jumpDist;                       
        }

        else if(Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("up"))
        {
            moveY = jumpDist/2; //Control optimized for keyboard input
        }
        if(moveY != 5) 
        {
            moveY++; 
        }
        setLocation(getX(), getY() + moveY);
        animate();
    }
    
    private void flapUp(int customJumpDist) {
        if (Greenfoot.mouseClicked(null)) {
            moveY = customJumpDist;
        } else if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("up")) {
            moveY = customJumpDist / 2;
        }

        if (moveY != 5) {
            moveY++;
        }
        setLocation(getX(), getY() + moveY);
        animate();
    }
}
