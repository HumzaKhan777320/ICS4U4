package package2;//storing the AlphaSub.java file in a seperate package than Alpha

import package1.Alpha;//importing the Alpha file from package1 to create an Alpha object

public class AlphaSub extends Alpha{//declaring main class of AlphaSub file that is a child class of Alpha

    public AlphaSub(){//creating a constructor for the AlphaSub file

        //See if we can access each of the properties from Alpha
        Alpha a1 = new Alpha();//creating a new alpha object
        
        a1.publicProp = 0;//trying to access the public int variable in Alpha with viewable results
        //a1.protectedProp=0;   //Not visible as protected int variable was unaccessable
        //a1.defaultProp=0;   //Not visible as unspecified access int variable was unaccessable
        //a1.privateProp = 0;   //Not visible as private int variable was unaccessable
    }//closing AlphaSub constructor
}//closing AlphaSub class
