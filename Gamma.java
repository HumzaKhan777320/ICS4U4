package package2;//storing the Gamma.java file in a seperate package than Alpha

import package1.Alpha;//importing the Alpha file from package1 to create an Alpha object

public class Gamma {//declaring main class of Gamma file
    
    public Gamma(){//creating a constructor for the Gamma file
        
        //See if we can access each of the properties from Alpha
        Alpha a2 = new Alpha();//creating a new alpha object
        
        a2.publicProp = 0;//trying to access the public int variable in Alpha with viewable results
        //a2.protectedProp=0;   //Not visible as protected int variable was unaccessable
        //a2.defaultProp=0;   //Not visible as unspecified access int variable was unaccessable
        //a2.privateProp = 0;   //Not visible as private int variable was unaccessable
    }//closing Gamma constructor
}//closing Gamma class
