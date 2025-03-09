/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: Classwork - File I/O
03/08/2025

Variable Dictionary:
Fileio - name of the file and the main class of the code
main - name of the main method/function of the code
userScanner - name of the scanner created for taking input from the user
fileScanner - name of the scanner created for taking input from the inpt_file file
working - boolean variable for controling the main while loop
inpt_file - string variable for storing the uer's input for the input file
outpt_file - string variable for storing the uer's input for the output file
textFile - name of the File variable  to open the inpt_file file
writeFile - name of the FileWriter variab;e for opening the outpt_file file for writing
inptTxt - string variable for storing each line of input from the inpt_file
indexArr - array for storing each int of input in inptTxt but still as type string
i - int variable for iterating through every second index in the indexArr array
first_value - int variable for storing the ith index of the indexArr array as an int
second_value - int variable for storing the i+1th index of the indexArr array as an int
eqn - string type variable for storing each equation sentence made from the inpt_file 
and to be written to the outpt_file
 */
import java.io.File;////importing the File library for opening the input file
import java.io.FileWriter;//importing the FileWriter library for writing to files
import java.io.IOException;//importing the IOException library for the try/catch statement
import java.util.Scanner;//importing the Scanner library for taking inputs

public class Fileio {//declaring the main class of the code with same name as file (Fileio)

    public static void main(String[] args) {//creating the main method/function for the code
    //necessary for coding anything in java (skeleton code)

        //Create the Scanners for the file and user inputs
        Scanner userScanner;//creating userScanner to take the file
        //name inputs from the user
        Scanner fileScanner;//creating the fileScanner to take input
        //from the input file on the user's computer
        boolean working = false;//creating a boolean variable working to 
        //control the main while loop and setting to false so the code runs atleast once

        while(!working){//creating the main while loop

            try {//declaring try function
            //necessary for if the input file dosent exist
                
                userScanner = new Scanner(System.in);
                //setting the userScanner to a new scanner that 
                //takes input from the console (user input)

                System.out.print("Enter your input file name dont forget the .txt: ");
                //asking the user to input the input file name
                String inpt_file = userScanner.next();
                //storing the inputted file name in string variable inpt_file
            
                System.out.print("Enter your output file name dont forget the .txt: ");
                //asking the user to input the output file name
                String outpt_file = userScanner.next();
                //storing the inputted file name in string variable outpt_file

                //Open the file
                File textFile = new File(inpt_file);
                //openning the inpt_file file with the File variable textFile
                FileWriter writeFile = new FileWriter(outpt_file, false);
                //openning the outpt_file file for writing with the FileWriter 
                //variable writeFile

                fileScanner = new Scanner(textFile);
                //setting the fileScanner to a new scanner that 
                //takes input from the inpt_file file (textFile)

                while (fileScanner.hasNextInt()){//declaring while loop that runs
                //if the inpt_file has text that can be interpreted as an integer
                
                String inptTxt = fileScanner.nextLine();
                //Reading a line of text from the inpt_file file
                //and storing it in the inptTxt string variable

                String[] indexArr = inptTxt.split(" ");
                //spliting the inputed text inptTxt from inpt_file by
                //spaces and storing in the indexArr string type array

                for(int i = 0;i<indexArr.length-1;i+=2){
                //declaring a for loop that runs through every
                //second index of the indexArr array
                    int first_value = Integer.valueOf(indexArr[i]);
                    //converting the ith index of indexArr from
                    //a string type to an int type by using the
                    //Integer.valueOf function similar to the 
                    //String.valueOf function taught in course 
                    //content and storing in the first_value int variable

                    int second_value = Integer.valueOf(indexArr[i+1]);
                    //converting the i+1th index of indexArr from
                    //a string type to an int type by using the
                    //Integer.valueOf function similar to the 
                    //String.valueOf function taught in course 
                    //content and storing in the second_value int variable

                    String eqn = first_value + " + " + second_value + " = " + (first_value + second_value);
                    //storing the equation sentence with first and second_value in the string variable eqn

                    writeFile.write(eqn+"\n"); //writing the eqn string to the outpt_file file
                    //through the file writer variable and moving the the next line for the next
                    //equation sentence to be written 

                }//closing the for loop
                }//closing the while loop

                System.out.println("Your output is now complete please check the "+outpt_file+" file");
                //telling the user the output is complete and is located in the outpt_file file

                writeFile.close();//closing the writeFile file writer

                
                fileScanner.close();//Closing the fileScanner scanner
                userScanner.close();//Closing the userScanner scanner
                working = true;//setting working to true as if this line is reached the code
                //worked successfully without catching an IOexception

            } catch (IOException e) {//declaring catch function incase of 
            //an IOException such as a typo in the inputed file names
                System.out.println("Sorry one/both of your files were not found please check and try again");
                //telling the user that one/both of their file name inputs were not found
                //and to try again
            }//closing the catch function
        }//closing the main while loop
}//closing the main function
}//closing the main class Fileio
