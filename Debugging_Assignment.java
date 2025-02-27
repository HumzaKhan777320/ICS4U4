/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: Debugging Assignment
02/27/2025

 * This program is supposed to allow the user to add numbers to
 * an array, stopping when the enter a negative value.
 * At the end, it should display the contents of the array
 * 
 * It's required that new values appear at the beginning of the array,
 * not the end.
 * 
 * The program isn't working correctly at all.
 * 
 * Your task is to:
 * 
 * 1) Fix the program so that it actually correctly maintains
 *    the entered numbers, with new numbers appearing at the
 *    beginning of the list, and no negative numbers in the list
 *    
 * 2) Try to make the program error-proof; deal with cases where
 *    the user enters invalid values, or enters too many values.
 *    You cannot make the array bigger, or replace it with a
 *    different type of structure like a List.  Once the array
 *    is full, the program should just tell the user that they
 *    can't enter any more numbers, display the contents of the array
 *    and end
 */

 import java.util.Scanner;//importing the Scanner library for taking inputs

 public class Debugging_Assignment {//changed the public class name to a
 //more representative name
 
     public static void main(String[] args)
     {
         //Create a Scanner
         Scanner sc = new Scanner(System.in);
         
         //Here is our array
         int[] values = new int[100];
         
         //This variable keeps track of how many numbers have actually
         //been added to the list
         int valueCount = 0;
         
         //Keep asking the user for new values until they signal
         //that they want to stop by entering a negative number
         int newValue = 0;
         
         while (newValue >= 0)//having the while loop run as long as the inputted
         //value is greater than or equal to 0 which is also checked for later in the
         //loop to prevent a negative in the array
         {
            if(valueCount>=100){//checking if the valueCount is over or equal to 100
            //to make sure the program dosn't overfill the array
                System.out.println("Congratulations you entered 100 values into the array now it's full Goodbye!");
                //telling the user the array is full
            }
             //Get the number
             newValue = getInteger(sc);//setting the newValue variabe to the run the getInteger function
             //with the name of the Scanner as a parameter and stores the return in newValue
             
             if(newValue<0){//checking if the user's input is a negative before it gets 
             //added to the array by mistake
                break;//breaking the while loop as a negative input is the check to
                //stop the loop
             }
            
             //Add the new value to the start of the list,
             //moving all other values down the line
             
             for (int i = valueCount; i >0; i--)//iterating i backwards from valueCount to 0
             //instead of 0 to valueCount so the same value is not copied throughout the values array
             {
                values[i] = values[i-1];//copying the i-1th value of the array to the ith index while i>0
             } 
             values[0] = newValue;//moved the adding new value to the list to after the list is pushed back
             //and storing the new value in the now empty 0th index of values array instead of the valueCount index
             //Increase the valueCount
             valueCount++;
             
         }
 
         //Output the contents of the list
         System.out.println("Done!  Here are your numbers:");//telling the user the
         //program is displaying the outputted numbers
         System.out.print("[ ");//printing the oppening bracket of the outputted
         //array
         for (int i = 0; i < valueCount; i++)//going through the values array
         {
             System.out.format("%d ", values[i]);//doing a formated print statement
             //for each array value
         }
         System.out.println("]");//printing the closing bracket of the outputted array
 
         //Close the Scanner
         sc.close();
     }
     
     //Might be useful to complete this as well, and use it as part
     //of your solution
     public static int getInteger(Scanner scanner_name)//declaring the getInteger function
     //with Scanner scanner_name as a parameter and an int return type
     {
         
         int nValue = 0;//creating a variable to store the user's input and to return
         boolean bValidInput = false;//setting the while loop control variable to false
         while (!bValidInput)//declaring while loop based on bValid input boolean variable
         {
            //removing the scanner decleration from getInteger function

            try{//declaring try block for trying to store the user;s input in an int variable
                //Get the number
                System.out.print("Please enter a number (type a negative number to end):");
                nValue = scanner_name.nextInt();//storing the user's input in return int variable nValue
                bValidInput = true;//seting boolean variable bValidInput to true to exit the loop
            }
            catch(Exception e){//catching an exception if the user's inout is not an int
                System.out.println("Sorry that's an invalid input!");//telling the user there input is invalid
                scanner_name.nextLine();//emptying the scanner's invalid input by by clearing the input  
                bValidInput = false;//setting bValidInput to false as an extra precaution to activate if the user's input 
                //is not an int
            }
         }
         return nValue;//returning the nValue variable
     }
 }
