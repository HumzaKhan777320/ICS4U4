/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: CLASSWORK - 2D Array Exercise
05/04/2025
*/

import java.util.Scanner;//importing the Scanner library for taking inputs

public class arrays_2D{//declaring the main class of the code with same name as file (arrays_2D)

    public static void displayTable(int[][] table, int rows, int columns) {//declaring void function
    //displayTable with 2d int type array table, int rows and int columns as parameters

        for (int i=0;i<rows;i++){//declaring a for loop that runs rows times
            for (int j=0; j<columns; j++){//declaring a for loop that runs columns times
                System.out.print(table[i][j] + " ");//printing the jth index of the ith array of table followed
                //by a space for readability
            }//closing for loop
            System.out.println();//printing an empty line to move to the next row
        }//closing for loop

        System.out.print("Row Totals: ");//telling the user the row totals will now be displayed
        for (int i=0; i<rows; i++){//declaring a for loop to run rows times
            System.out.print(rowTotal(table, i) + " ");//printing the return of the rowTotal function
            //with the 2d int type variable array table and int i as parameters followed by a space for readability
        }//closing for loop
        System.out.println();//printing an empty line for clear readability between row and column totals

        System.out.print("Column Totals: ");//telling the user the column totals will now be displayed
        for (int j=0; j<columns; j++){//declaring a for loop to run columns times
            System.out.print(columnTotal(table, j) + " ");//printing the return of the columnTotal function
            //with the 2d int type variable array table and int j as parameters followed by a space for readability
        }//closing for loop
        System.out.println();//printing an empty line for clear readability
    }//closing displayTable function

    public static int rowTotal(int[][] table, int row){//declaring rowTotal function with 2d int type
    //array table and int row as parameters
        int sum = 0;//declaring int variable sum to store the sum of the rowth row
        for (int i=0; i<table[row].length; i++){//declaring for loop that runs for the length of the rowth row
            sum += table[row][i];//adding the ith index of the rowth index of table to sum
        }//closing for loop
        return sum;//returning sum
    }//closing rowTotal function

    public static int columnTotal(int[][] table, int col){//declaring columnTotal function with 2d int type
        //array table and int col as parameters
        int sum = 0;//declaring int variable sum to store the sum of the colth column
        for (int i=0; i<table.length; i++){//declaring for loop that runs for the length of the table 2d array
            sum += table[i][col];//adding the colth index of the ith array of table to sum
        }//closing for loop
        return sum;//returning sum
    }//closing columnTotal function

    public static void main(String[] args) {//creating the main method/function for the code
    //necessary for coding anything in java (skeleton code)

        
        Scanner userInputs = new Scanner(System.in);//creating userInputs scanner to take 
        //various inputs from the user to create and add to a table

        System.out.println("Create a Table:");//telling the user they are creating a new table
        System.out.print("How many rows: ");//asking the user to enter the number of rows in the table
        int rows = userInputs.nextInt();//storing the user's input in int variable rows
        System.out.print("How many columns: ");//asking the user to enter the number of columns in the table
        int columns = userInputs.nextInt();//storing the user's input in int variable columns

        int[][] table = new int[rows][columns];//creating a 2d int type array with rows arrays and columns 
        //elements per array to store the user's table

        boolean going = true;//declaring boolean variable going to control the main while loop

        while(going){//declaring main while loop of the code that will run as long as going is true

            System.out.println();//printing an empty line for a cleaner display
            System.out.println("Table:");//printing a title before displaying the current table
            displayTable(table, rows, columns);//calling the displayTable function with the 
            //table 2d array, the # of rows, and the # of columns as parameters 
            System.out.println();//printing an empty line for a cleaner display

            System.out.print("Row: ");//asking the user to inpput the row where they want to add a value
            int row = userInputs.nextInt();//storing the user's input in int variable row
            if (row < 0 || row >= rows) {//checking incase the user's input is negative or too large
                System.out.println("Sorry that's an invalid row, the final table will now be displayed.");
                //telling the user their input was invalid and the final tabel will be displayed now 
                break;
                //breaking out of the while loop
            }//closing if statement

            System.out.print("Column: ");//asking the user to inpput the column where they want to add a value
            int col = userInputs.nextInt();//storing the user's input in int variable col
            if (col < 0 || col >= columns) {//checking incase the user's input is negative or too large
                System.out.println("Sorry that's an invalid column, the final table will now be displayed.");
                //telling the user their input was invalid and the final tabel will be displayed now 
                break;
                //breaking out of the while loop
            }//closing if statement

            System.out.print("Value: ");//asking the user to inpput the value they want to add
            int value = userInputs.nextInt();//storing the user's input in int variable value

            table[row][col] = value;//setting the col element ow the row array in table to value
        }//closing main while loop

        System.out.println("Final table:");//telling the user the final table will now be displayed
        //(as the code has now broken out of the while loop)
        displayTable(table, rows, columns);//calling the displayTable function with the 
        //table 2d array, the # of rows, and the # of columns as parameters

        userInputs.close();//closing the userInputs scanner
    }//closing main function
}//closing arrays_2D class

   
