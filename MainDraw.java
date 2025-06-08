import processing.core.*;//importing processing for drawing 
import java.util.Random;//importing random for generating random ball colors, speeds, sizes, and locations
import java.util.Scanner;//importing scanner for user input

public class MainDraw extends PApplet{//declaring the main class with same name as file (MainDraw) that is
//a child class of PApplet for drawing and updating the processing screen
    static ball[] balls;//creating a static class parameter array of ball objects so each function can access it
    public static void main(String[] args)
    {//declaring the main function of the code necessary for running the file
        int num = usrInput();//calling the usrInput function and storing the return in int variable num
        //for the number of ball objects to be drawn
        balls = new ball[num];//setting the length of the balls array parameter
        PApplet.main("MainDraw");//creating and titling the processing window
    }//closing main function
    
    public void settings()
    {//Setting up the screen settings
        size(600, 600);//setting the size of the processing screen to 600 by 600 pixels
    }//closing the settings function

    public void setup(){//creating the ball objects 
        for(int i=0; i<balls.length; i++){//going through the length of the balls array to only make 
        //how many the user wants

            Random rand = new Random();//creating a random object for generating ball characteristics

            int radius = rand.nextInt(20,100);//randomly generating a radius for the ith ball
            //object between 20 and 100 for variety

            int x = rand.nextInt(radius/2, 600-(radius/2));//finding a random number based on the width of the 
            //screen and the size of the ball and storing it as the ball's starting x-coordinate
            int y = rand.nextInt(radius/2, 600-(radius/2));//finding a random number based on the height of the 
            //screen and the size of the ball and storing it as the ball's starting y-coordinate
            int dx = rand.nextInt(-5,6);//finding a random number for the horizontal speed of the ball
            //for a randomized pattern of movement not just in one direction
            int dy = rand.nextInt(-5,6);//finding a random number for the vertical speed of the ball
            //for a randomized pattern of movement not just in one direction

            int[] color = new int[3];//creating an int array of size 3 to store the RGB values
            //of the ball's color
            color[0]=rand.nextInt(0,255);//Finding a random number between 0 and 255
            //for the first color coordinate and storing in color array
            color[1]=rand.nextInt(0,255);//Finding a random number between 0 and 255
            //for the second color coordinate and storing in color array
            color[2]=rand.nextInt(0,255);//Finding a random number between 0 and 255
            //for the third color coordinate and storing in color array

            balls[i] = new ball(x,y,dx,dy,radius,color);//creating a new ball object with the numbers
            //generated and storing in the ith index of the balls array
        }//closing for loop
    }//closing setup function

    public void draw(){//drawing the background, the balls, and updating the balls continuously
        //Redraw the background
        background(0,0,0);

        for(int i=0; i<balls.length; i++){//going through the balls array   
            balls[i].drawBall(this);//using the drawball function on the current ball object
            //in the balls array to draw it to the screen    
            balls[i].Update(this);//using the Update function on the current ball object
            //in the balls array to update the position of the ball 
        }//closing for loop
    }//closing the draw function
    
    public static int usrInput(){//creating an int return function for the user's input for the number of 
    //balls on the screen

        Scanner usr= new Scanner(System.in);//creating a new scanner object usr for taking input from the user

        System.out.print("How many balls (circles) do you want: ");//printing a prompt to the user 
        //to ask for the # of balls to draw

        int num_of_balls;//creating an int variable num_of_balls to be returned once assigned a value

        try {//declaring a try function
            num_of_balls= usr.nextInt();//trying to store the user's input in the num_of_balls variable
        }catch(Exception e) {//catching an exception if the data type of the input is wrong
            System.out.println("Sorry that is not a valid input we'll default to 50");
            //printing out that the user's input was invalid and will refer to the default value
            num_of_balls= 50;//setting the num_of_balls variable to 50
        }//closing catch statement
        
        usr.close();//closing the usr scanner

        return num_of_balls;//returning the num_of_balls variable
    }//closing the usrInput function
    
}//closing the MainDraw class
