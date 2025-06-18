package ICS4U4.battleship;//declaring the package for the battleship files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: SUMMATIVE - Final Program
06/18/2025
*/

import java.util.Scanner;//importing the scanner library to take inputs from the user

public class Player {//declaring the class for the Player with same name as file (player)
    public Board board;//declaring a Board variable board so each player object has a board attribute

    public Player(int size){//creating a main constructor for the Player that takes the board size as a parameter
        board = new Board(size);//creating a new board object of size size and storing
        //in the board attribute
    }//closing main constructor

    public void turn(int x, int y, Computer enemy){//declaring void function turn that takes the
    //x and y coordinates as parameters along with a computer object to process attacks to the
    //enemy's board
        enemy.getBoard().attack(x, y);//calling the getBoard function of the computer object
        //enemy to get its board object and calling it's attack function with parameters x,y 
        //to perform the player's attack
    }//closing the turn function

    public String playerMove(Scanner user, int size){//declaring function playerMove that returns the
    //inputed coordinates as a string and takes a scanner object as a parameter for taking inputs
    //and the size of the grid for calling the boards displayBoard function and validating the input

        System.out.println("\nYour board:");//telling the user their board is being printed
        board.displayBoard(size);//calling the displayBoard function on the player's board with
        //size as a parameter

        System.out.println("\nEnter attack coordinates (x y): ");//telling the user to enter their 
        //attack coordinates which will be done in the do-while loop
        
        boolean checkInput;//declaring boolean variable checkInput for checking
        //if the user's input is valid

        int x=0;//declaring int variable x to store the user's inputted x-coordinate
        int y=0;//declaring int variable y to store the user's inputted y-coordinate

        do{//declaring do-while loop to keep taking input from the user until its valid
            checkInput=true;//setting checkInput to true as the input isn't proven invalid yet
            System.out.print("Enter x: ");//telling the user to input their x-coordinate
            try{//declaring try function
                x = user.nextInt();//storing the user's input in x variable
            } catch(Exception e){//catching an exception if the data type is wrong
                user.next();//clearing error inputs
                System.out.println("Sorry that's an invalid input, try again");
                //telling the user that their input is invalid
                checkInput=false;//setting checkInput to false so the do-while loop
                //asks for inputs again
                continue;//skipping to the next instance as there is no need to take 
                //a y input if x is invalid
            }//closing catch statment 
            System.out.print("Enter y: ");//telling the user to input their y-coordinate
            try{//declaring try function
                y = user.nextInt();//storing the user's input in y variable
            } catch(Exception e){//catching an exception if the data type is wrong
                user.next();//clearing error inputs
                System.out.println("Sorry that's an invalid input, try again");
                //telling the user that their input is invalid
                checkInput=false;//setting checkInput to false so the do-while loop
                //asks for inputs again
                continue;//skipping to the next instance as there is no need to check if the
                //number is in range if its not an int
            }//closing catch statment

            if(x<0 || x>=size || y<0 || y>=size){//checking if either the user's x or y
            //coordinates are out of range
                System.out.println("Sorry your input is out of range");
                //telling the user that their input is pout of range (invalid)
                checkInput=false;//setting checkInput to false so the do-while loop
                //asks for inputs again
            }//closing if statment

        } while(checkInput==false);//continuing the do-while loop while the checkInput variable is false

        return x + "," + y;//returning the coordinates as a string seperated by a ,
    }//closing the playerMove function

    public Board getBoard(){//declaring getBoard function that returns a Board object
        return board;//returning the player's board object
    }//closing the getBoard function
}//closing the Player class
