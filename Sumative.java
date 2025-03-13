/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Grade Report
03/12/2025
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Summative {
    public static void main(String[] args) {

        Scanner userScanner =new Scanner(System.in);
        System.out.print("Enter your input file name dont forget the .txt: "); 
        String inpt_file = userScanner.next();
            
        File textFile = new File(inpt_file);
        int lines=counting(textFile);
        if(lines<0){
            System.out.println("Sorry the "+inpt_file+" file was not found");
        } else{
            String inptarr[]=file_inpt(textFile,lines);

            if(inptarr.length!=lines){
                System.out.println("Could not import data from file");
            }else{

                String[] name = new String[lines];
                int[] score = new int[lines];

                boolean allocation_control = true;

                allocation(allocation_control,lines,name,score,inptarr);
                if(allocation_control==true){
                    mergeSort(score,name,0,score.length-1);

                    String average=calculateAverage(score);
                        
                    int bottom=score[0];
                    int top=score[lines-1];
                    String[] top_scorers= best(top,score,name);
                    String[] bottom_scorers= still_trying(bottom,score,name);

                    writeToFile(lines,average,top,bottom,top_scorers,bottom_scorers);
                    userScanner.close();
                }
            }
        }
    }


    public static int counting(File textFile){
        try {
            Scanner fileScanner = new Scanner(textFile);
            int lines=0;
            while (fileScanner.hasNextLine()){
                fileScanner.nextLine();
                lines++;
            }
            fileScanner.close();
            return lines;
        } catch (IOException e) {
            return -1;
        }
    }

    public static String[] file_inpt(File textFile, int lines){
        try {
            String[] storage = new String[lines];
            Scanner fileScanner2 = new Scanner(textFile);
            for(int i=0;i<lines;i++){
                String inptTxt = fileScanner2.nextLine();
                storage[i]=inptTxt;
            }
            fileScanner2.close();
            return storage;
        } catch (IOException e) {
            String[] except=new String[lines-10];
            return except;
        }
    }


    public static void allocation(boolean allocation_control, int lines, String[] name,int[] score, String[] inptarr){
        for(int i=0;i<lines;i++){
            String[] info=inptarr[i].split(" ");
            name[i]=info[0];
            try{
            score[i]=Integer.valueOf(info[1]);
            } catch(Exception e){
                allocation_control=false;
                System.out.println("The input data seems to have a format issue please check and try again");
            }
        }
    }


    public static void mergeSort(int[] arr1, String[] arr2, int low, int high){
    //declaring function mergeSort that sorts 2 arrays together using merge sort
    //takes 2 arrays and the upper and lower bounds of the processed array as parameters
        if(low<high){
        //compares low and high to create an exit condition for the recursion
            int mid = low + Math.floorDiv((high - low),2);
            //calculating the middle index for splitting the array into sub-arrays for sorting
            mergeSort(arr1, arr2, low, mid);
            //sorting first half of array
            mergeSort(arr1,arr2, mid + 1, high);
            //sorting second half of array
            merge(arr1,arr2, low, mid, high);
            //merging the split arrays together by calling merge function
        }    
    }


    public static void merge(int[] arr1,String[] arr2, int low, int mid, int high){
    //declaring merge function that merges two sorted sub-arrays
    //takes arr1 and arr2 along with the lower and upper bounds of the array and the middle
    //index as parameters
    int n1 = mid - low + 1;
    //calculate the number of elements in the left sub-array and store in n1
    int n2 = high - mid;
    //calculate the number of elements in the right sub-array and store in n2
    int[] L = new int[n1];
    //creating temp arrays
    int[] R = new int[n2];
    //creating temp arrays
    String[] L2 = new String[n1];
    //creating temp arrays
    String[] R2 = new String[n2];
    //creating temp arrays
    
    //copying data to the temp arrays declared above
    for(int i=0; i<n1; i++){
    //going through the left sub-arrays L/L2
        L[i] = arr1[low + i];
        //copying data 
        L2[i] = arr2[low + i];
        //copying data
    } 
    for(int j=0; j<n2; j++){
    //going through the right sub-arrays R/R2
        R[j] = arr1[mid + 1 + j];
        //copying data 
        R2[j] = arr2[mid + 1 + j];
        //copying data 
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
            //copying the data from left sub-array back to the main array
            arr2[k]=L2[follow_left];
            //copying the data from left sub-array back to the main array
            follow_left++;
            //incrementing follow_left and not follow_right since the follow_rightth 
            //index of R/R2 wasnt copyed yet
        }else{
        //declaring else statment
            arr1[k] = R[follow_right];
            //copying the data from right sub-array back to the main array
            arr2[k] = R2[follow_right];
            //copying the data from right sub-array back to the main array
            follow_right++;
            //incrementing follow_right and not follow_left since the 
            //follow_leftth index of L/L2 wasnt copyed yet
        }
        k++;
        //adding to k so we don't change the same index of the merged array twice
    }//closing the while loop
    while(follow_left < n1){
    //checking if there's anything left in L/L2 that wasn't copied
        arr1[k] = L[follow_left];
        //adding anything left in L to the main array
        arr2[k] = L2[follow_left];
        //adding anything left in L2 to the secondary array
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
        //adding anything left in R to the main array
        arr2[k] = R2[follow_right];
        //adding anything left in R2 to the secondary array
        follow_right++;
        //incrementing follow_right since the follow_rightth
        // index has now been copied 
        k++;
        //incrementing k since the follow_rightth index has now been copied to 
        //the kth index of the merged arrays
    }//closing the while loop
    }


    public static String calculateAverage(int[] grades){
    //declaring calculateAverage function that calculates the average of all
    //the students score taking an int array with students grades as a parameter 
    //and returning the average as type String rounded to one decimal space
        int total=0;
        //creating int variable total for storing the
        //total grades of all the students
        double size=grades.length;
        //creating double size and setting to the
        //length of the grades array also the
        //number of students for calculating
        //the average
        for(int i=0; i<size; i++){
        //creating a for loop that runs through the entire
        //grades array
            total+=grades[i];
            //adding the ith term of the 
            //grades array to total variable
        }//closing for loop
        double average=total/size;
        //calculating the average of the students
        //grades and storing in the average double variable
        DecimalFormat oneplace= new DecimalFormat("#.#");
        //declaring a DecimalFormat variable oneplace that
        //formats decimals to one place
        String formatAverage = oneplace.format(average);
        //using DecimalFormat variable oneplace to 
        //format the grade average to one decimal space
        //and storing in String variable formatAverage
        return formatAverage;
        //returning the formatAverage variable
    }//closing the calculateAverage function


    public static String[] best(int top, int[] score, String[] name){
        int occurances_of_top=0;
        for(int i=score.length-1; i>0; i--){
            if(score[i]==top){
                occurances_of_top++;
            } else{
                break;
            }
        }
        String[] top_scorers= new String[occurances_of_top];

        for(int i=0; i<occurances_of_top; i++){
            top_scorers[i]=name[name.length-occurances_of_top+i];
        }

        return top_scorers;
    }


    public static String[] still_trying(int bottom, int[] score, String[] name){
        int occurances_of_bottom=0;
        for(int i=0; i<score.length; i++){
            if(score[i]==bottom){
                occurances_of_bottom++;
            } else{
                break;
            }
        }
        String[] bottom_scorers= new String[occurances_of_bottom];

        for(int i=0; i<occurances_of_bottom; i++){
            bottom_scorers[i]=name[i];
        }

        return bottom_scorers;
    }

    public static void writeToFile(int lines, String average, int top, int bottom, String[] top_scorers,
    String[] bottom_scorers){
        Scanner userScanner2 =new Scanner(System.in);
        System.out.print("Enter your output file name dont forget the .txt: "); 

        String output_file = userScanner2.next();
        try {
            FileWriter writeFile = new FileWriter(output_file, false);
            //openning the outpt_file file for writing with the FileWriter 
            //variable writeFile
            String bst=top_scorers[0];
            for(int i=1;i<top_scorers.length;i++){
                bst=bst+", "+top_scorers[i];
            }
            String wrst=bottom_scorers[0];
            for(int i=1;i<bottom_scorers.length;i++){
                wrst=wrst+", "+bottom_scorers[i];
            }
            writeFile.write("Total Students: "+lines+"\n");
            writeFile.write("Average Grade: "+average+"%\n");
            writeFile.write("Highest Grade: "+top+" ("+bst+")\n");
            writeFile.write("Lowest Grade: "+bottom+" ("+wrst+")\n");
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Sorry we couldn't write to the "+output_file+" file");
        }
        userScanner2.close();
        
    }
}
