/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: CLASSWORK - Creating a Date Class
03/28/2025

Variable Dictionary:
Date - name of the file, main class and constructor 
day - int variable representing the day part of each Date object created
month - int variable representing the month part of each Date object created
year - int variable representing the year part of each Date object created
wrd_mnths - a string type array containing the names of the months
thirtyOne - an array of integers representing months with 31 days
thirty - an array of integers representing months with 30 days
month_identification - int variable that tracks the number of days in the date object's month
getLongDate - method that formats the date into long form and returns it as a string
longdate - string variable for the long date format
getShortDate - method that formats the date into short form and returns it as a string
concat_month - string variable for formatting the month as a 2 digit string for short form
concat_day - string variable for formatting the day as a 2 digit string for short form
shortdate - string variable for the full short date format
*/
public class Date{//declaring the main class of the code with same name as file (Date)

    private int day;//creating a private int variable day to store the day part of the date
    //that can be accessed by any method in the file but not changed
    private int month;//creating a private int variable month to store the month part of
    //the date that can be accessed by any method in the file but not changed
    private int year;//creating a private int variable year to store the year part of 
    //the date that can be accessed by any method in the file but not changed

    String[] wrd_mnths={"January","February","March","April","May","June",
    "July","August","September","October","November","December"};
    //storing the names of the months in a String type array
    //wrd_mnths for converting the date to long form

    public Date(int day, int month, int year) throws Exception{
    //declaring a constructor with same name as the class (Date)
        if(month<1 || month>12){//checking if the month provided when calling
        //the Date constructor is invalid (not in between 1-12 months)
            throw new Exception("Month is not valid");
            //throwing an exception to tell the user the month is invalid
        }//closing if statment
        int[] thirtyOne = {1,3,5,7,8,10,12};//declaring a type int
        //array named thirtyOne with the numerical format of months 
        //with thirty-one days in them
        int[] thirty = {4,6,9,11};//declaring a type int array named thirty
        //with the numerical format of months with thirty days in them
        
        int month_identification=0;//declaring int variable month_identification
        //and setting to 0 used to store the number of days in the month provided

        for(int i=0;i<thirtyOne.length;i++){//declaring a for loop to increment
        //an int variable i to go through each index of the thirtyOne array
            if(thirtyOne[i]==month){//checking if the ith index of the thirtyOne array
            //is the month the code is trying to identify 
                month_identification=31;//setting the month_identification 
                //variable to 31 if the month was identified in the thirtyOne
            }//closing if statment
        }//closing for loop
        if(month_identification==0){//checking to see if the month hasnt been identifyed yet
            for(int i=0;i<thirty.length;i++){//declaring a for loop to increment
            //an int variable i to go through each index of the thirty array
                if(thirty[i]==month){//checking if the ith index of the thirty array
                //is the month the code is trying to identify 
                    month_identification=30;//setting the month_identification 
                    //variable to 30 if the month was identified in the thirty array
                }//closing if statment
            }//closing for loop
        }//closing if statment
        if(month_identification==0){//checking to see if the month hasnt been identifyed yet
            if(year%4==0){//checking if the year is a leap year 
            //as now we know the only month it can be is february
                month_identification=29;//setting the month identification
                //to 29 if the year is a leap year and the month is february
            } else{//declariong else statment
                month_identification=28;//at this point the month has to have been
                //identifyed if not the code sets the month_identification variable
                //to 28 as the only possibility left is february in a non leap year
            }//closing else statment
        }//closing if statment

        if(day<0 || day>month_identification){//checking if the given day is invalid for the 
        //given month (the day is negative or the day is too big to be in the given month)
            throw new Exception("Date is not valid for given month and/or year");
            //throwing an exception to tell the user that the day is invalid for the given month
        }//closing if statment

        this.day=day;//storing day is the private variable day to be accessed by other methods
        this.month=month;//storing month is the private variable month to be accessed by other methods
        this.year=year;//storing year is the private variable year to be accessed by other methods
    }
    public Date() throws Exception{
    //declaring a default constructor with the same name (Date)
        this(1,1,2000);
        //calling the main caonstructor with 
        //the default date 01/01/2000
    }//closing default constructor

    public String getLongDate(){//declaring getLongDate method
    //that returns a string with the long formated date
        String longdate=wrd_mnths[this.month-1]+" "+day+", "+year;
        //declaring a string with the date formated to long form
        return longdate;
        //returning the long formated date
    }//closing getLongDate method

    public String getShortDate(){//declaring getShortDate method
    //that returns a string with the short formated date

        String concat_month=String.valueOf(this.month);
        //storing the given month to a string for concatinating
        //a 0 to if it is less than 10 for the short format in
        //the string variable concat_month
        String concat_date=String.valueOf(this.day);
        //storing the given day to a string for concatinating
        //a 0 to if it is less than 10 for the short format in
        //the string variable concat_date
        if(this.month<10){//checking if the month is less than 10
            concat_month="0"+concat_month;
            //concatinating a 0 to the concat_month string
        }//closing if statment
        if(this.day<10){//checking if the day is less than 10
            concat_date="0"+concat_date;
            //concatinating a 0 to the concat_date string
        }//closing if statment
        String shortdate=concat_date+"/"+concat_month+"/"+year;
        //creating a short formated string with the information
        //and storing in string variable shortdate
        return shortdate;
        //returning the short formated date
    }//closing getShortDate method
}//closing date class
