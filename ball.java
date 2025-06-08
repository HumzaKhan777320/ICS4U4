/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Bouncing Balls
06/08/2025
*/

import processing.core.*;//importing processing for drawing

public class ball {//declaring the main class with same name as file (ball)
    int x;//declaring non static parameter x for the x-coordinate location of a ball object
    int y;//declaring non static parameter y for the y-coordinate location of a ball object
    int dx;//declaring non static parameter dx for the horizontal speed of a ball object
    int dy;//declaring non static parameter dy for the vertical speed of a ball object
    int radius;//declaring non static parameter radius for the size of a ball object
    int[] color;//declaring non static parameter color for storing the 3 numbers 
    //identifying the color of a ball object
    
    //Create a ball
    public ball(int x, int y, int dx, int dy, int radius, int[] color) {//declaring the constructor of the ball class
        this.x=x;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
        this.y=y;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
        this.dx=dx;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
        this.dy=dy;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
        this.radius=radius;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
        this.color=color;//storing one of the constructor's given parameters as a class parameter
        //to be accessed in other functions
    }//closing ball constructor
    
    //Update the position of the ball
    public void Update(PApplet canvas){
        //Update the position of the ball
        x += dx;//adding the horizontal speed (dx) to the ball's x-coordinate
        y += dy;//adding the vertical speed (dy) to the ball's y-coordinate
        
        //Bounce!
        //Left
        if (x <= radius/2)//checking to see if the ball's x-coordinate is less than or equal
        //to half the ball's radius as the x-coordinate is based off of the center of the ball
        {
            dx = -dx;//Change direction horizontally
            x = radius/2;//Make sure the ball didn't go offscreen
        }
        
        //Right
        if (x >= canvas.width-radius/2)//checking to see if the ball's x-coordinate is greater than or equal
        //to the canvas' width - half the ball's radius as the x-coordinate is based off of the center of the ball
        {
            dx = -dx;//Change direction horizontally
            x = canvas.width-radius/2;//Make sure the ball didn't go offscreen
        }
        
        //Top
        if (y <= radius/2)//checking to see if the ball's y-coordinate is less than or equal to
        //half the ball's radius as the y-coordinate is based off of the center of the ball
        {
            dy =-dy;//Change direction vertically
            y = radius/2;//Make sure the ball didn't go offscreen
        }
        //Bottom
        if (y >= canvas.height-radius/2)//checking to see if the ball's y-coordinate is greater than or equal
        //to the canvas' width - half the ball's radius as the y-coordinate is based off of the center of the ball
        {
            dy =-dy;//Change direction vertically
            y = canvas.height-radius/2;//Make sure the ball didn't go offscreen
        }
    }//closing update function
    
    //Draw the ball; if it's off the canvas, bounce!
    public void drawBall(PApplet canvas){
        //Draw the circle
        canvas.fill(this.color[0],this.color[1],this.color[2]);// Setting the fill color of the ball using the 3
        //numbers stored in the color array parameter
        canvas.circle(x,y,radius);//Drawing the ball at coordinates (x, y) with a size of radius   
    }//closing the drawBall function
}//closing ball class