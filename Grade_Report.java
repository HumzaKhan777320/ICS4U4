/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Grade Report
03/15/2025

Variable Dictionary:
Grade_Report - name of the file and the main class of the code
main - name of the main method/function of the code
userScanner - name of the scanner created for taking the input file name from the user as input
inpt_file - String variable for storing the user's inputed input file name
textFile - name of the File variable used to open the inpt_file file
lines - int variable used for counting the number of lines in the inpt_file file
counting - name of function that conts the number of lines in the inpt_file file and returns it
inptarr - array of strings used for storing each full line of data read from the inpt_file file
file_inpt - name of function that reads and stores lines from the inpt_file file and returns them 
in a strings array
name - array of strings for storing names read from the inpt_file file
score - array of integers for storing grades read from the inpt_file file coresponding with
each name
allocation_control - boolean variable to check if an exception occured when running the 
allocation function 
allocation - name of function that allocates data from the inptarr array into 2 seperate 
arrays one for grades and one for names
mergeSort - function that sorts the score array from lowest to highest and sorts the names array
acordingly
average - string representing the average grade formatted to one decimal place from the return of
the calculateAverage function
calculateAverage - name of function that calculates the average grade from the score array formats
it to one decimal space and returns it as a string
bottom - integer variable that stores the 0th index of the score array which is the lowest grade
because the array was previously sorted from least to greatest
top - integer variable that stores the last index of the score array representing the highest grade
as the score array was sorted from least to greatest
top_scorers - array of strings containing the names of the student(s) with the highest grade returned 
from the best function (not necissarily the BEST function lol)
best - name of function that finds the names of the students with the highest grade and returns them in
a string type array
bottom_scorers - array of strings containing the names of the student(s) with the lowest grade returned 
from the still_trying function
still_trying - name of function that finds the names of the students with the lowest grade and returns them in
a string type array
writeToFile - function that writes the data processed through the other 9 funtions to a file inputed from
the user
fileScanner - scanner used to read data from the inpt_file file when counting lines
storage - array of strings used to store each line of data from the inpt_file file
fileScanner2 - scanner used to read data from the inpt_file file when storing each line of data in
the storage array
inptTxt - string used to temporarily store each line of data from the inpt_file file during file reading
and storing in the storage array
except - array of strings used as a fallback return in the file_inpt function when an exception occurs
also useful for identifying if an exception occurs at all when file_inpt is called in main
info - array of strings that temporarily stores each index of inptarr split into 2 indexes (the name
and the grade) to allocate to the name and score arrays
arr1 - name of the main array of integers sorted in the mergeSort function from least to greatest used to
sort the score array
arr2 - name of the follow along array of strings sorted in the mergeSort function to follow changes made to
arr1 used to alter the order of the name array to match the score array as its sorted
low - integer variable that equals the lower bound (0th index) of the array (arr1/arr2) in sorting
high - integer variable that equals the upper bound (array length-1th index) of the array (arr1/arr2) in sorting
mid - integer variable that equals the middle index of arr1/arr2 for spliting the array in merge/mergeSort
L/L2/R/R2 - temporary arrays for holding data during the merge process of merge sort
follow_left - int variable used for iterating through the left sub-array during the merging process
of merge sort (L/L2)
follow_right - int variable used for iterating through the right sub-array during the merging process 
of merge sort (R/R2)
k - int variable used for tracking the main array index during the merging process of merge sort
n1 - int variable representing the size of the left sub-array (L/L2) in the merge function
n2 - int variable representing the size of the right sub-array (R/R2) in the merge function
j - int variable used for iterating through the right sub-array (R/R2) for copying data to the
main arrays (arr1/arr2)
total - integer variable that equals the sum of the students grades for calculating the average in 
the calculateAverage function
size - double variable that equals the total number of grades int the score array for calculating
the average
oneplace - DecimalFormat variable for rounding the average grade to one decimal place
formatAverage - string variable representing the formatted average grade to one decimal place
occurances_of_top - integer variable used for counting the occurrences of the highest score in the
score array
occurances_of_bottom - integer variable used for counting the occurrences of the lowest score in the
score array
userScanner2 - name of the scanner created for taking the output file name from the user as input
output_file - string variable storing the output file name
writeFile - name of the FileWriter variable for opening the output_file file for writing
bst - string variable for concatenating names of the top scorers to write to the output_file file
wrst - string variable for concatenating names of the bottom scorers to write to the output_file file
d_version - double variable used to convert the formated to one decimal place average back to type
double necessary to keep a.0 when needed
i - int variable used in for loops in various parts of the code mainly for iterating through arrays 
i.e. score array
 */

import java.io.File;//importing the File library for opening the inpt_file file
import java.io.FileWriter;//importing the FileWriter library for writing to files
import java.io.IOException;//importing the IOException library for the try/catch statement
import java.util.Scanner;//importing the Scanner library for taking inputs
import java.text.DecimalFormat;//importing the DecimalFormat library for rounding the average
//grade to 1 decimal place

public class Grade_Report {//declaring the main class of the code with same name as file (Grade_Report)
    public static void main(String[] args) {//creating the main method/function for the code
    //necessary for coding anything in java (skeleton code)

        Scanner userScanner =new Scanner(System.in);//creating userScanner to take the
        //input file name from the user
        System.out.print("Enter your input file name dont forget the .txt: "); 
        //asking the user to input the input file name
        String inpt_file = userScanner.next();
        //storing the inputted input file name in string variable inpt_file
            
        File textFile = new File(inpt_file);
        //openning the inpt_file file with the File variable textFile
        int lines=counting(textFile);
        //calling the counting function with textFile as a parameter and
        //storing the return in int variable lines
        if(lines<0){
        //checking if the lines variable is less than 0 as the counting fuction
        //returns a negative if an exception occurs in the function
            System.out.println("Sorry the "+inpt_file+" file was not found");
            //telling the user that the inpt_file file was unopenable
        } else{//declaring else statment as the code should only continue
        //if no exception occures
            String inptarr[]=file_inpt(textFile,lines);
            //calling the file_inpt function with textFile and lines as
            //parameters and storing the return in the inptarr string array

            if(inptarr.length!=lines){
            //checking if the return array length of file_inpt dosent equal 
            //lines indicating an exception occured and data couldn't be read
                System.out.println("Could not import data from file");
                //telling the user that data couldn't be imported from the file
            }else{//declaring else statment as the code should only continue if
            //no exceptions occured

                String[] name = new String[lines];
                //creating a string array for storing the students names
                //in the allocation function and setting it to a legth of lines
                //as there should be 1 name per line in the inpt_file file
                int[] score = new int[lines];
                //creating an int array for storing the students grades
                //in the allocation function and setting it to a legth of lines
                //as there should be 1 grade per line in the inpt_file file

                boolean allocation_control = true;
                //declaring a boolean variable allocation_control and setting it
                //to true necessary for indicating if an exception occurs in 
                //the allocation function as the code should stop then

                allocation(allocation_control,lines,name,score,inptarr);
                //calling the void allocation function that takes the
                //inptarr,name, and score arrays as parameters along
                //with the allocation_control variable to check for exceptions
                if(allocation_control==true){//checking that the allocation_control variable
                //is still true indicating an exception didnt occur in the allocation function
                    mergeSort(score,name,0,score.length-1);
                    //calling the mergeSort function which takes the score and name
                    //arrays as parameters along with the lower and upper bound of them
                    //as parameters to sort the score array from least to greatest

                    String average=calculateAverage(score);
                    //calling the calculateAverage function with score as a parameter
                    //and storing the return in the string variable average
                        
                    int bottom=score[0];
                    //creating int variable bottom and setting it to the lowest grade in the inpt_file file
                    //(as the score function is sorted the 1st index is the lowest grade)
                    int top=score[lines-1];
                    //creating int variable top and setting it to the highest grade in the inpt_file file
                    //(as the score function is sorted the last index is the highest grade)
                    String[] top_scorers= best(top,score,name);
                    //calling the best function with the name and score arrays as
                    //parameters along with the int variable top and storing the return 
                    //in the string array top_scorers
                    String[] bottom_scorers= still_trying(bottom,score,name);
                    //calling the still_trying function with the name and score arrays as
                    //parameters along with the int variable bottom and storing the return 
                    //in the string array top_scorers

                    writeToFile(lines,average,top,bottom,top_scorers,bottom_scorers);
                    //calling the writeToFile function with various arrays, ints, and strings
                    //as parameters to create a summary and writing to an output file
                    userScanner.close();//closing the userScanner scanner
                }//closing if statment
            }//closing else statment
        }//closing else statment
    }//closing the main function


    public static int counting(File textFile){//creating counting function that returns an int and takes a file as a parameter returns the number of lines in the file
        try {//declaring try function
            Scanner fileScanner = new Scanner(textFile);
            //declaring a scanner variable fileScanner to take input from the textFile file
            int lines=0;
            //creating an int variable lines to count the number of lines in the textFile file
            while (fileScanner.hasNextLine()){//creating a while loop that will run for the number 
            //of lines in the textFile file
                fileScanner.nextLine();
                //moving to the next line of the file to prevent an infinite loop
                lines++;
                //incrementing lines as the loop passed through a line
            }//closing while loop
            fileScanner.close();//closing the fileScanner scanner
            return lines;//returning the lines variable
        } catch (IOException e) {//declaring catch statment incase the file was not found
            return -1;//returning a negative to indicate the file was 
            //not found when the function is called
        }//closing catch statment
    }//closing counting function


    public static String[] file_inpt(File textFile, int lines){//----------------------------------------------------------------------------------------------------------------------save for javadoc
        try {//declaring try function
            String[] storage = new String[lines];
            //declaring a string array storage with a length of lines
            //as it will store each line of the textFile file
            Scanner fileScanner2 = new Scanner(textFile);
            //declaring a scanner variable fileScanner2 to take input from the textFile file
            for(int i=0;i<lines;i++){//declaring for loop that will run lines times
                String inptTxt = fileScanner2.nextLine();
                //storing the ith line of the texFile file in the string variable inptTxt
                storage[i]=inptTxt;
                //storing inptTxt at the ith index of the storage variable
            }//closing for loop
            fileScanner2.close();//closing the fileScanner2 scanner
            return storage;//returning the string array storage
        } catch (IOException e) {//declaring catch statment incase the textFile file was not found
            String[] except=new String[lines+10];//declaring a string array except with a length
            //greater than lines to indicate an exception
            return except;//returning the except array if an exception occured
        }//closing catch statment
    }//closing file_inpt function


    public static void allocation(boolean allocation_control, int lines, String[] name,int[] score, 
    String[] inptarr){//--------------------------------------------------------------------------------------------------------------------------------------------------------------save for javadoc
        for(int i=0;i<lines;i++){//declaring for loop that runs lines times
            try{//declaring try statment
                String[] info=inptarr[i].split(" ");//spliting the ith index of the inptarr array
                //and temporarily storing the 2 pieces of information in the string array info
                name[i]=info[0];
                //setting the ith index of the name array to the first index of the info array
                score[i]=Integer.valueOf(info[1]);
                //converting the second index of the info array to an int
                //and storing it at the ith index of the score array
            } catch(Exception e){//declaring catch statment incase the data read is formated incorectly
                allocation_control=false;//setting allocation_control to false to
                //indicate an exception occured when the allocation function is called
                System.out.println("The input data seems to have a format issue please check and try again");
                //telling the user that the input file has a format issue
            }//closing the catch statment
        }//closing for loop
    }//closing the allocation function


    public static void mergeSort(int[] arr1, String[] arr2, int low, int high){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
    //declaring function mergeSort that sorts 2 arrays together using merge sort
    //takes 2 arrays and the upper and lower bounds of the processed array as parameters
        if(low<high){
        //compares low and high to create an exit condition for the recursion
            int mid = low + Math.floorDiv((high - low),2);
            //calculating the middle index for splitting the array into sub-arrays for sorting
            mergeSort(arr1, arr2, low, mid);
            //calling mergeSort to sort the first half of the array
            mergeSort(arr1,arr2, mid + 1, high);
            //calling mergeSort to sort the second half of the array
            merge(arr1,arr2, low, mid, high);
            //merging the split arrays together by calling the merge function
        }//closing if statment    
    }//closing the mergeSort function


    public static void merge(int[] arr1,String[] arr2, int low, int mid, int high){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
    //declaring merge function that merges two sorted sub-arrays
    //takes arr1 and arr2 along with the lower and upper bounds of the array and the middle
    //index as parameters
    int n1 = mid - low + 1;
    //calculating the number of elements in the left sub-array and storing in n1
    int n2 = high - mid;
    //calculating the number of elements in the right sub-array and storing in n2
    int[] L = new int[n1];
    //creating temp array for the left sub-array of arr1
    int[] R = new int[n2];
    //creating temp array for the right sub-array of arr1
    String[] L2 = new String[n1];
    //creating temp array for the left sub-array of arr2
    String[] R2 = new String[n2];
    //creating temp array for the right sub-array of arr2
    
    //copying data to the temp arrays declared above
    for(int i=0; i<n1; i++){
    //going through the left sub-arrays L/L2
        L[i] = arr1[low + i];
        //copying data from arr1
        L2[i] = arr2[low + i];
        //copying data from arr2
    } 
    for(int j=0; j<n2; j++){
    //going through the right sub-arrays R/R2
        R[j] = arr1[mid + 1 + j];
        //copying data from arr1
        R2[j] = arr2[mid + 1 + j];
        //copying data from arr2
    }
    //merging back the sub-arrays
    int follow_left=0;
    //creating follow_left variable for checking if the full 
    //left sub-array has been copied to the main array
    int follow_right=0;
    //creating follow_right variable for checking if the full 
    //right sub-array has been copied to the main array
    int k = low;
    //setting k to the initial index of the merged sub-array
    while(follow_left < n1 && follow_right < n2){
    //checking if either sub-array has been completely copied yet
        if(L[follow_left] <= R[follow_right]){
        //comparing each sub-array's corresponding elements
            arr1[k] = L[follow_left];
            //copying the data from left sub-array back to arr1
            arr2[k]=L2[follow_left];
            //copying the data from left sub-array back to arr2
            follow_left++;
            //incrementing follow_left and not follow_right since the follow_rightth 
            //index of R/R2 wasnt copyed yet
        }else{
        //declaring else statment
            arr1[k] = R[follow_right];
            //copying the data from right sub-array back to arr1
            arr2[k] = R2[follow_right];
            //copying the data from right sub-array back to arr2
            follow_right++;
            //incrementing follow_right and not follow_left since the 
            //follow_leftth index of L/L2 wasnt copyed yet
        }
        k++;
        //incrementing k so we don't change the same index of the merged array twice
    }//closing the while loop
    while(follow_left < n1){
    //checking if there's anything left in L/L2 that wasn't copied
        arr1[k] = L[follow_left];
        //adding anything left in L to arr1
        arr2[k] = L2[follow_left];
        //adding anything left in L2 to arr2
        follow_left++;
        //incrementing follow_left since the follow_leftth 
        //index has now been copied 
        k++;
        //incrementing k since the follow_leftth index has now been copied to
        //the kth index of the merged arrays 
    }//closing the while loop
    while(follow_right < n2){
    //checking if there's anything left in R/R2 that wasn't copied
        arr1[k] = R[follow_right];
        //adding anything left in R to arr1
        arr2[k] = R2[follow_right];
        //adding anything left in R2 to arr2
        follow_right++;
        //incrementing follow_right since the follow_rightth
        // index has now been copied 
        k++;
        //incrementing k since the follow_rightth index has now been copied to 
        //the kth index of the merged arrays
    }//closing the while loop
    }//closing the merge function


    public static String calculateAverage(int[] score){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
    //declaring calculateAverage function that calculates the average of all
    //the students score taking an int array with students grades as a parameter 
    //and returning the average as type String rounded to one decimal space
        int total=0;
        //creating int variable total for storing the
        //total grades of all the students
        double size=score.length;
        //creating double size and setting to the length of the score 
        //array also the number of students for calculating the average
        for(int i=0; i<size; i++){
        //creating a for loop that runs through the entire score array
            total+=score[i];
            //adding the ith term of the score array to total variable
        }//closing for loop
        double average=total/size;
        //calculating the average of the students grades
        //and storing in the average double variable
        DecimalFormat oneplace= new DecimalFormat("#.#");
        //declaring a DecimalFormat variable oneplace that
        //formats decimals to one decimal place
        String formatAverage = oneplace.format(average);
        //using DecimalFormat variable oneplace to format the grade average 
        //to one decimal space and storing in String variable formatAverage
        return formatAverage;
        //returning the formatAverage variable
    }//closing the calculateAverage function


    public static String[] best(int top, int[] score, String[] name){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
        int occurances_of_top=0;//creating int variable occurances_of_top and setting
        //it to 0 to count the number of students who acheved the highest grade
        for(int i=score.length-1; i>0; i--){//declaring for loop that iterates through the
        //score array backwards starting from the last index of score 
            if(score[i]==top){//checking if the ith index of score is the top grade
                occurances_of_top++;//incrementing occurances_of_top
            } else{//declaring else statment
                break;//breaking out of the for loop since the score array is sorted
                //once the ith term isnt equal to top the rest are not top either
            }//closing else statment
        }//closing for loop
        String[] top_scorers= new String[occurances_of_top];
        //delaring a string array top_scorers of length occurances_of_top 
        //for the names of the people with the highest grade
        for(int i=0; i<occurances_of_top; i++){
        //declaring a for loop that runs occurances_of_top times
            top_scorers[i]=name[name.length-occurances_of_top+i];
            //setting the ith index of top_scorers to the ith person
            //in the name array with the top grade
        }//closing for loop

        return top_scorers;//returning the top_scorers string array
    }//closing the best function


    public static String[] still_trying(int bottom, int[] score, String[] name){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
        int occurances_of_bottom=0;//creating int variable occurances_of_bottom and 
        //setting it to 0 to count the number of students who acheved the lowest grade
        for(int i=0; i<score.length; i++){//declaring for loop that iterates through the score array
            if(score[i]==bottom){//checking if the ith index of score is the bottom grade
                occurances_of_bottom++;//incrementing occurances_of_bottom
            } else{//declaring else statment
                break;//breaking out of the for loop since the score array is sorted
                //once the ith term isnt equal to bottom the rest are not bottom either
            }//closing else statment
        }//closing for loop
        String[] bottom_scorers= new String[occurances_of_bottom];
        //delaring a string array bottom_scorers of length occurances_of_bottom
        //for the names of the people with the lowest grade
        for(int i=0; i<occurances_of_bottom; i++){
        //declaring a for loop that runs occurances_of_bottom times
            bottom_scorers[i]=name[i];
            //setting the ith index of bottom_scorers to the ith person
            //in the name array with the bottom grade
        }//closing for loop

        return bottom_scorers;//returning the bottom_scorers string array
    }//closing the still_trying function

    public static void writeToFile(int lines, String average, int top, int bottom, String[] top_scorers,
    String[] bottom_scorers){//---------------------------------------------------------------------------------------------------------------------------------javadoc this
        Scanner userScanner2 =new Scanner(System.in);//creating userScanner2 to take the
        //output file name from the user
        System.out.print("Enter your output file name dont forget the .txt: "); 
        //asking the user to input the input file name
        String output_file = userScanner2.next();
        //storing the inputted output file name in string variable output_file
        try {//declaring try statment
            FileWriter writeFile = new FileWriter(output_file, false);
            //openning the outpt_file file for writing with the FileWriter 
            //variable writeFile
            String bst=top_scorers[0];
            //declaring string variable bst to store the 0th index of top_scorers
            //and to concatanate to with the rest of the names in top_scorers
            
            for(int i=1;i<top_scorers.length;i++){//declaring for loop that
            //runs from 1 to the length of top_scorers
                bst=bst+", "+top_scorers[i];
                //concatanating best with a comma and the ith term of top_scorers
            }//closing for loop
            String wrst=bottom_scorers[0];
            //declaring string variable wrst to store the 0th index of bottom_scorers
            //and to concatanate to with the rest of the names in bottom_scorers
            for(int i=1;i<bottom_scorers.length;i++){//declaring for loop that
            //runs from 1 to the length of bottom_scorers
                wrst=wrst+", "+bottom_scorers[i];
                //concatanating wrst with a comma and the ith term of bottom_scorers
            }//closing for loop
            double d_version= Double.valueOf(average);
            //converting average back to a double and storing in double variable d_version
            //necessary to add a .0 when needed 
            writeFile.write("Total Students: "+lines+"\n");
            //writing the total number of students to the output_file file
            writeFile.write("Average Grade: "+d_version+"%\n");
            //writing the average grade to the output_file file
            writeFile.write("Highest Grade: "+top+" ("+bst+")\n");
            //writing the highest grade and the students
            //who achived it to the output_file file
            writeFile.write("Lowest Grade: "+bottom+" ("+wrst+")\n");
            //writing the lowest grade and the students
            //who achived it to the output_file file
            writeFile.close();//closing the writeFile file writer
        } catch (IOException e) {//declaring catch statment incase the file was not found
            System.out.println("Sorry we couldn't write to the "+output_file+" file");
            //letting the user know we couldn't write to the output_file file
        }//closing catch statment
        userScanner2.close();//closing the userScanner2 scanner
        
    }//closing the writeToFile function
}//closing the main class Grade_Report
