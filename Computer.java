package ICS4U4.battleship;//declaring the package for the battleship files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: SUMMATIVE - Final Program
06/18/2025
*/

import java.util.Random;//importing the random library for generating random moves

public class Computer {//declaring the class for the Computer with same name as file (computer)
    public Board board;//declaring a Board variable board so each computer object has a board attribute  
    public boolean[][] attacked;//declaring a boolean type 2D array for storing wheather a location
    //has been previously attacked to avoid redundent attacks

    public Computer(int size){//creating a main constructor for the Computer that takes the board size 
    //as a parameter
        board = new Board(size);//creating a new board object of size size and storing in the file's
        //board attribute
        attacked = new boolean[size][size];//setting the attacked 2D array's size to match the board
    }//closing main constructor

    public void attack(Player player, int size){//declaring a void function attack for processing the
    //player's turn

        String move;//declaring a string variable move for storing the randomly generated move 
        move = randomMoves(size);//calling the randomMoves function with 
        //size as a parameter and storing the return in the move variable

        String[] coordinates = move.split(",");//splitting the move by the , and storing in string
        //type array coordinates
        int x = Integer.parseInt(coordinates[0]);//converting the x-coordinate to type int 
        //and storing in int variable x
        int y = Integer.parseInt(coordinates[1]);//converting the y-coordinate to type int 
        //and storing in int variable y
        attacked[x][y]=true;//setting the location in the attacked 2D array to true as it has now
        //been attacked
        player.getBoard().attack(x, y);//calling the boards attack function with the x and y coordinates
        //as parameters to perform the computer's attack
    }//closing attack function

    public String randomMoves(int size){//declaring randomMoves function for generating random coordinates
    //for the computer's attack taking the board's size as a parameter
        Random r = new Random();//creating a new random object (r) for generating inputs
        int x;//declaring int variable x for storing the generated x-coordinate
        int y;//declaring int variable y for storing the generated y-coordinate
        do {//declaring do-while loop to generate random moves until a valid one 
        //is found that was not alredy attacked
            x = r.nextInt(size);//randomly generating a number in the range of the x-axis and storing in x
            y = r.nextInt(size);//randomly generating a number in the range of the y-axis and storing in y
        } while(attacked[x][y]==true);//ensuring the loop dosen't end until a location is found that hasn't already
        //been attacked

        return x + "," + y;//returning the coordinates as a string seperated by a ,
    }//closing randomMoves function

    public Board getBoard(){//declaring getBoard function that returns a Board object
        return board;//returning the computer's board object
    }//closing getBoard function

    public void displayBoard(int size){//overriding void function displayBoard to print out the coputer's
    //board to the user taking the size of the board as a parameter replacing the ships with water to
    //not reveal the enemy's ship to the user
        System.out.println("Enemy board:");//telling the user this is the enemy board not to be
        //mistaken with their own board
        System.out.println("  0 1 2 3 4 5");//printing the x-axis
        for(int i=0; i<size; i++){//going through the size arrays in the board
            System.out.print(i+" ");//printing out each index of the y-axis
            for(int j=0; j<size; j++){//going through the ith sub array of the board
                if(board.game_board[i][j]=='S'){//checking if the current index of the board has a ship
                    System.out.print("~ ");//printing out water in its place
                }else{//declaring else statment
                    System.out.print(board.game_board[i][j]+" ");//printing out the current index of the
                    //board elsewise
                }//closing else statment
            }//closing for loop
            System.out.println("");//moving to the next line
        }//closing for loop
    }//closing the displayBoard function
}//closing the computer class
