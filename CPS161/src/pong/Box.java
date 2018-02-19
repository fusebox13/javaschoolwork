package pong;

import java.awt.Point;
import java.util.Random;
 
public class Box {
    Point boxUpperRight ;
    Point boxUpperLeft  ;
    Point boxLowerRight ;
    Point boxLowerLeft  ;
    Point holeUpper     ;
    Point holeLower     ;
    Point ballLoc       ;
    Point paddleLoc     ;
    
    int paddleWidth ;
    int ballRadius = 10;    
    private int ballVx, ballVy;
    private Random rand = new Random();
    
    int successCount=0;
    boolean bouncing=true;
    
    
    
    public Box(int box_top, int box_bottom, int box_left, int box_right)
    {
        boxUpperRight= new Point(box_right, box_top);
        boxUpperLeft = new Point(box_left, box_top);
        boxLowerRight= new Point(box_right, box_bottom);
        boxLowerLeft = new Point(box_left, box_bottom);
        holeUpper    = new Point(box_right, box_top +(box_bottom-box_top)/4);
        holeLower    = new Point(box_right, box_top +3*(box_bottom-box_top)/4);
        ballLoc      = new Point(box_left+ rand.nextInt(box_right - box_left),
                                box_top+ rand.nextInt(box_bottom - box_top));
        paddleLoc    = new Point(box_right,( holeUpper.y+holeLower.y)/2);
        paddleWidth  = (holeLower.y - holeUpper.y)/3;
        ballVx = (-10 + (int)(20*Math.random()));
        ballVy = -10 + (int)(20*Math.random());        
    }
    public void setPaddleY(int y)
    {
        paddleLoc.y =y;
        if (paddleLoc.y - paddleWidth/2 < holeUpper.y)
            paddleLoc.y = holeUpper.y + paddleWidth/2;
        if (paddleLoc.y + paddleWidth/2 > holeLower.y)
            paddleLoc.y = holeLower.y - paddleWidth/2;
        
    }
    
    public void update()
    {
        if (!bouncing)return;
        
        ballLoc.x = ballLoc.x + ballVx;
        ballLoc.y = ballLoc.y + ballVy;
        if (ballLoc.x + ballRadius > boxUpperRight.x)
        {  //ball either bounces off right wall, hits paddle, or lands in the hole
            if (ballLoc.y <= holeUpper.y || ballLoc.y >= holeLower.y )
            {   // ball bounces off the right wall
                ballVx *= -1;
                ballLoc.x = boxUpperRight.x - ballRadius;
            }
            else if (ballLoc.y >= paddleLoc.y-paddleWidth/2 &&
                    ballLoc.y <= paddleLoc.y + paddleWidth/2)
            {   // ball bounces off paddle
                successCount +=1;  // In hole but bounces off paddle
                ballVx *= -1;
                ballLoc.x = boxUpperRight.x - ballRadius;
                System.out.println("In Hole and hits paddle");
            }
            else
            {
                // In hole and missed by paddle
                bouncing = false;
                System.out.println("In Hole and missed by paddle");
            }
        }
        if (ballLoc.x - ballRadius < boxUpperLeft.x)
        {   // Ball bounces off left wall
            ballVx *= -1;
            ballLoc.x = boxUpperLeft.x + ballRadius;        
        }
        if (ballLoc.y + ballRadius > boxLowerRight.y)
        {   // Ball bounces off bottom wall
            ballVy *= -1;
            ballLoc.y = boxLowerRight.y - ballRadius;        
        }
        if (ballLoc.y - ballRadius < boxUpperRight.y)
        {   // Ball bounces off top wall
            ballVy *= -1;
            ballLoc.y = boxUpperRight.y + ballRadius;        
        }
    }

  
    
}