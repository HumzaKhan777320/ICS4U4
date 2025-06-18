package ICS4U4.battleship;//declaring the package for the battleship files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: SUMMATIVE - Final Program
06/18/2025
*/

import java.util.Random;//importing the random library for placing the ships in random locations

public class Board {//declaring the class for the Board with same name as file (board)
     public char[][] game_board;//declaring a 2D char array so each board object has it as an attribute

    public Board(int size){//creating a main constructor for Board that takes the board size as a parameter
        game_board = new char[size][size];//creating a new 2D char array of size size and storing in the
        //game_board attribute
        initializeBoard(size);//calling the initializeBoard function with the sie as a parameter
        //for filling the board with water at first
    }//closing main constructor

    public void initializeBoard(int size){//declaring void function initialize board with size as a parameter
    //to fill the board with water
        for(int i=0; i<size; i++){//going through the size arrays in game_board
            for(int j=0; j<size; j++){//going through the ith sub array in game_board
                game_board[i][j] = '~';//setting each index of game_board to ~
            }//closing for loop
        }//closing for loop
        placeShips();//calling the placeShips function for placing ships in random locations on the board
    }

    public void placeShips(){//declaring void function placeShips for placing ships in random locations on the board
        int[] shipSizes = {2, 3, 4, 5};//creating an int array of the various ship sizes (same for all boards)
        Random r = new Random();//creating a new random object r for placing the ships in random locations

        for(int i=0; i<shipSizes.length; i++){//declaring a for loop that runs through the shipSizes array
            boolean placed = false;//creating a boolean variable placed and setting to false to ensure
            //a valid location is found

            while(placed==false){//declaring a while loop that runs while the placed variable is false
                int x = r.nextInt(game_board.length);//generating a random int between 0 and the length of the
                //game_board and storing in int variable x
                int y = r.nextInt(game_board[0].length);//generating a random int between 0 and the length of a
                //sub array in game_board and storing in int variable y

                boolean horizontal = r.nextBoolean();//generating a random boolean to decide wheather
                //the boat will be vertical or horizontal

                if(canPlaceShip(x, y, shipSizes[i], horizontal)==true){//calling the canPlaceShip function
                //with the x and y coordinates as parameters along with the boat's size and wheather it's
                //vertical or horizontal and checking if its return is true
                    placeShip(x, y, shipSizes[i], horizontal);//calling the placeShip function
                    //with the same parameters as canPlaceShip to actually place the ith ship on the board
                    placed = true;//setting placed to true as the ith ship has now been placed
                }//closing if statment
            }//closing while loop
        }//closing for loop
    }//closing the placeShips function

    public boolean canPlaceShip(int x, int y, int size, boolean horizontal){//declaring the canPlaceShip function
    //for checking if the ship can be placed in the randomized location taking the x and y coordinates as
    //parameters along with the size of the boat and wheather the ship is being placed vertically or horizontally

        if(horizontal==true){//checking if the boat is being placed horizontally
            if((x+size)>game_board[0].length){// checking to see if the boat goes off the grid
            //based off of the generated x coordinate
                return false;//returning false since the boat goes off grid
            }//closing if statment
            for(int i=0; i<size; i++){//going through the coordinates of the whole boat
            //to check for intersections with other boats
                if(game_board[x+i][y]=='S'){//checking if any coordinates on the boats
                //placement path are alredy occupied by a boat
                    return false;//returning false as this location isn't usable
                }//closing if statment
            }//closing for loop
        }else{//declaring else statment
            if((y+size)>game_board.length){// checking to see if the boat goes off the grid
            //based off of the generated y coordinate
                return false;//returning false since the boat goes off grid
            }//closing if statment
            for(int i=0; i<size; i++){//going through the coordinates of the whole boat
            //to check for intersections with other boats
                if(game_board[x][y+i]=='S'){//checking if any coordinates on the boats
                //placement path are alredy occupied by a boat
                    return false;//returning false as this location isn't usable
                }//closing if statment
            }//closing for loop
        }//closing else statment
        return true;//returning true as by this point the location is usable
    }//closing the canPlaceShip function

    public void placeShip(int x, int y, int size, boolean horizontal){//declaring the placeShip function for
    //placing the ship on the randomized location on the board taking the x and y coordinates as parameters 
    //along with the size of the boat and wheather the ship is being placed vertically or horizontally
        for(int i = 0; i < size; i++){//declaring a for loop that runs for the length of the boat
            if(horizontal==true){//checking if the boat is meant to be placed horizontally
                game_board[x+i][y] = 'S';//placing the ships on the board horizontally
            }else{//declaring else statment
                game_board[x][y+i] = 'S';//placing the ships on the board vertically
            }//closing else statment
        }//closing for loop
    }//closing the placeShip function

    public boolean attack(int x, int y){//declaring attack function for processing attacks viually
    //on the board including the misses taking the x and y coordinates as parameters

        if(game_board[y][x]=='S'){//checking if the coordinates on the game board had a ship
            game_board[y][x]='X';//setting the game_board location to X to indicate a hit
            System.out.println("Hit at (" + x + ", " + y + ")");//telling the user where the hit was
            return true;//returning true as it was a successful hit

        }else if(game_board[y][x]=='~'){//declaring else if statment for if the location was water
            game_board[y][x]='O';//setting the location to O to indicate a miss
            System.out.println("Miss at (" + x + ", " + y + ")");//telling the user where the miss was
            return false;//returning false as it was a miss
        }else{//declaring else statment
            System.out.println("You have already attacked this location.");
            //telling the user they already attacked that location
            return false;//returning false as it wasn't a successful hit
        }//closing else statment
    }//closing attack function

    public void displayBoard(int size){//declaring void function displayBoard to print out the board to the user
    //taking the size of the board as a parameter
        System.out.println("  0 1 2 3 4 5");//printing out the x-axis
        for(int i=0; i<size; i++){//going through the size arrays in game_board
            System.out.print(i+" ");//printing out each index of the y-axis
            for(int j=0; j<size; j++){//going through the ith sub array of game_board
                System.out.print(game_board[i][j]+" ");//printing each index of game_board
            }//closing for loop
            System.out.println();//printing a line to move to the next line of the board
        }//closing for loop
    }//closing the displayBoard function
}//closing the board class

