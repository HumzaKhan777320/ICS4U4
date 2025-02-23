//working but need to check for negative earlier so there are no negatives also complete loop
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: Debugging Assignment
02/23/2025

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

 import java.util.Scanner;

 public class Debugging_Assignment {
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
         
         while (newValue >= 0)
         {
             //Get the number
             System.out.print("Please enter a number (type a negative number to end):");
             newValue = sc.nextInt();
             
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
         System.out.println("Done!  Here are your numbers:");
         System.out.print("[ ");
         for (int i = 0; i < valueCount; i++)
         {
             System.out.format("%d ", values[i]);
         }
         System.out.println("]");
 
         //Close the Scanner
         sc.close();
     }
     
     //Might be useful to complete this as well, and use it as part
     //of your solution
     public static int getInteger()
     {
         Scanner sc = new Scanner(System.in);
         
         int nValue = 0;
         boolean bValidInput = false;
         
         while (!bValidInput)
         {
             //Try to get an integer, dealing with any exceptions.
             //If the integer is successfully received set
             //bValidInput to true
         }
         sc.close();
         
         return nValue;
     }
 }
