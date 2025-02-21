/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: Homework - Fixing Errors
02/21/2025

Note: I added some additional comments in the GetValues function
to better underdtand the code as I was reviewing it

With fixing error comments I also $pecified what type of
error it is along with where i.e. ^syntax error 
 */
public class FixMePlease {

    public static void main(String[] args) {


        int[] values = GetValues(100, 1);//swapped the max and min values from a max of 1 to a max of 100
        //and a min of 100 to a min of 1 ^runtime error
        
        for (int i = 1; i < values.length; i++)//setting i to 1 instead of 0 to print values from 1-100 not 0-100
        //           ^logical error 
        {
            System.out.format("%d ", values[i]);//swapped curly brackets with square brackets necessary for 
            //indexing the values array            ^syntax error     
        }

    }

    
    public static int[] GetValues(int max, int min)//declaring GetValues function
    {
        int length = max + 1;//setting the length to max + 1 as the length should be 1 more than the max 
        //               ^logical error  
        
        if (length < 0)//checking that the length is not 0
        {
            return null;//returning null 
        }
        
        int[] arr = new int[length];//creating array arr of type int to return
        
        for (int i=0; i < length; i++)//iterating i length times
        {
            arr[i] = i;//appending to return array arr
        }
        
        return arr;//returning arr
    }
}
