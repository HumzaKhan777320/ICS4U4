/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: Review Assignment 1 - Iterative Fibonacci
02/13/2025

Variable Dictionary:
a1 - name of the file and the main class on the code
main - name of the main method of the code
control - bollean variable for controling the do while loop
sc - name of the scanner created for taking input from the user
a - int variable for storing the users inputed fibonacci term number
i - int variable iderating in the main for loop for calculating the ath term of the fibonacci sequence
x - int variable used for storing the ath term of the fibonacci sequence 
y - int variable for storing the smaller number to be added to calculate the ath term
z - int variable for storing the bigger number to be added to calculate the ath term
b - char variable for storing the users y or n input for reruning the code
*/

import java.util.*;//importing java.util library for taking inputs

public class a1{//declaring the main class of the code with same name as file (a1)
    public static void main(String[] args) {//creating the main method/function for the code
    //necessary for coding anything in java (skeleton code)

        boolean control=true;//declaring boolean type variable control for controling the main while loop

        Scanner sc = new Scanner(System.in);//creating a new scanner sc for taking input from the user

        do{//creating the main d0-while loop with the condition the control variable is True
        //necesarry for rerunning the code if the user wants to continue or has made an invalid input

            //of the fibonacci sequence
            System.out.print("Enter a number to get that term of the Fibonacci sequence: ");
            //printing a message to the user telling them what to enter
            int a=sc.nextInt();
            //creating int variable a to store the users input of the fibonacci term

            if(a>0){//checking that the user's input is positive as there are no negative or 0
            //terms of the fibonacci sequence
            int x=0;//declaring int variable x for calculating the wanted term of the fibonacci sequence
            //and setting to 0
            int y=0;//declaring int variable y for calculating the wanted term of the fibonacci sequence
            //and setting to 0
            int z=1;//declaring int variable y for calculating the wanted term of the fibonacci sequence
            //and setting to 1

            for(int i=0;i<a;i++){//declaring for loop to calculate the term of the fibonacci sequence
                if(i==0){//checking if the first term of the fibonacci sequence is being iterated
                //(checking if the for loop is looking for the first term)
                    x=0;//setting x variable to the first term of the fibonacci sequence
                }//ending if statement
                else if(i==1){//checking if the second term of the fibonacci sequence is being iterated
                //(checking if the for loop is looking for the second term)
                    x=1;//setting x variable to the second term of the fibonacci sequence
                } else{//declaring else statment
                x=y+z;//setting x variable to y+z for storing the i+2th term of the fibonacci sequence
                y=z;//setting y to z since z is the next term smaller term to be added
                z=x;//setting z to x since x is the next bigger term to be added
                }//ending else statment
            }//ending for loop

            if(a==1){//declaring an if statment checking if the user wants the 1st term of the
            //fibonacci sequence as 1,2,3 shouldn't end with th 
                System.out.println("The 1st Fibonacci number is "+x+".");
                //printing out the 1st term of the fibonacci sequence to the user
            } else if(a==2){//declaring an if statment checking if the user wants the 2nd term of the
            //fibonacci sequence as 1,2,3 shouldn't end with th 
                System.out.println("The 2nd Fibonacci number is "+x+".");
                //printing out the 2nd term of the fibonacci sequence to the user
            } else if(a==3){//declaring an if statment checking if the user wants the 3rd term of the
            //fibonacci sequence as 1,2,3 shouldn't end with th 
                System.out.println("The 3rd Fibonacci number is "+x+".");
                //printing out the 3rd term of the fibonacci sequence to the user
            }else{//declaring else statment
                System.out.println("The "+a+"th Fibonacci number is "+x+".");
                //printing the ath term of the fibonacci sequence to the user
            }//ending else statment

            } else{//declaring else statement incase the user's input is less than 1
                System.out.println("Sorry that was not a valid input");
                //telling the user there input was invalid
            }//ending else statment

            System.out.print("Would you like to try again (y for yes, n for no): ");
            //asking the user to input y or n indicating if they want to try the code again 
            char b = sc.next().charAt(0);
            //storing the users input in char b using the sc scanner previously declared
            if(b=='N' || b=='n'){//checking if the user inputed n/N not capatalized specific
                System.out.println("Thank you for using the Fibonacci sequence code!");
                //thanking the user for using the code
                break;//ending the do while loop
            } else if(b!='Y'&& b!='y'){//checking if the user made a typo and dindnt enter y/Y or n/N 
            //from if statment above
                System.out.println("Sorry that is not a valid input but we'll take that as a yes!");
                //telling the uer that their input for continuing was invalid but the code will still 
                //continue
            }//ending else if statment

            System.out.println();//printing an empty line to make it easier to diferentiate between one
            //run and the other

        }while(control==true);//setting while statment for do while loop with condition control variable
        //equals true
        sc.close();//closing the sc scanner to prevent resource leaks
}//closing main function
}//closing a1 class
