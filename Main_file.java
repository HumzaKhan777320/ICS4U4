package ICS4U4.battleship;//declaring the package for the battleship files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: SUMMATIVE - Final Program
06/18/2025
*/

import java.util.Scanner;//importing the scanner library to take inputs from the user

public class Main_file {//declaring the main class of the code with same name as file (Main_file)
    public static void main(String[] args) {//creating the main method/function for the code
    //necessary for coding anything in java (skeleton code)
        int boardSize = 6;//declaring int variable boardSize and setting to 6
        Player player = new Player(boardSize);//creating a new Player object player with boardSize as parameter
        Computer enemy = new Computer(boardSize);//creating a new Computer object enemy with boardSize as parameter

        startGame(player, enemy, boardSize);//calling the startGame function with the palyer and enemy objects as
        //parameters along with the boardSize int
    }//closing main function

    public static void startGame(Player player, Computer enemy, int size){//declaring void function startGame for running
    //the game and takes the player and enemy objects as parameters along with the boardSize int

        Scanner user = new Scanner(System.in);//creating a new Scanner object user for taking the user's input

        System.out.println("Welcome to the Online Java Battleship Game! In this game you will be playing against a computer programed to play randomly. Both boards are randomly generated with ships alredy placed. The board is generated as followed (~ for Water, S for Ships, X for a successful hit, and O for a miss (Note: you cannot see the enemy ships)). Have fun, attack, and win one for us humans.");
        //printing out a welcome message and instructions for the user

        while(endGame(player, enemy, size)==false){//declaring a while loop that runs while the 
        //endGame function returns false
            String move = player.playerMove(user, size);//calling the player objects playerMove function and 
            //storing the return in the string variable move
            String[] coordinates= move.split(",");//splitting the move by the , and storing in string
            //type array coordinates
            int x=Integer.parseInt(coordinates[0]);//converting the x-coordinate to type int 
            //and storing in int variable x
            int y=Integer.parseInt(coordinates[1]);//converting the y-coordinate to type int 
            //and storing in int variable y
            player.turn(x,y,enemy);//calling the player object's turn function for performing the attack
            System.out.println();//printing a line of space between turns
            enemy.displayBoard(size);//calling the enemy object's displayBoard function for showing the user 
            //the enemy board
            System.out.println("\nEnemy's Turn: ");//telling the user it's the enemy's turn
            enemy.attack(player, size);//calling the enemy's attack function to perform the enemy's attack 
        }//closing while loop
        user.close();//closing the user scanner
    }//closing the startGame function

    public static boolean endGame(Player player, Computer enemy, int size){
    //declaring endGame functionthat checks if either the player or enemy has won yet taking both objects
    //and the board's size as parameters and returns true or false based on if the game has ended yet
        if(allShipsSunk(enemy.getBoard(), size)==true){//calling the allShipsSunck function for the enemy's board
        //and chcking if it returns true indicating the player won
            System.out.println("You win! All enemy ships destroyed.");
            //telling the player they won
            return true;//returning true as the game has ended
        }//closing if statment

        if(allShipsSunk(player.getBoard(), size)==true){//calling the allShipsSunck function for the player's board
        //and chcking if it returns true indicating the enemy won
            System.out.println("Game over! The enemy sank all your ships.");
            //telling the player they lost
            return true;//returning true as the game has ended
        }//closing if statment

        return false;//returning false as by now neither of the checks have returned true   
    }//closing endGame function

    public static boolean allShipsSunk(Board board, int size){//declaring allShipsSunk function that returns a  
    //boolean based off of if all the ships are sunk taking a board object and the size of the board as parameters
        for(int i=0; i<size; i++){//declaring a for loop that runs through each row of the game board
            for(int j=0; j<size; j++){//declaring a for loop that runs through each index of the ith row
                if(board.game_board[i][j]=='S'){//checking if any ships are left on the game board
                    return false;//returning false as there are ships left
                }//closing if statment
            }//closing for loop
        }//closing for loop
        return true;//returning true as no ships have been identified
    }//closing the allShipsSunk function
}//closing the Main_file class
