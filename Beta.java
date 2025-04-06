package package1;//storing the Beta.java file in the same package as Alpha

public class Beta {//declaring main class of Beta file

    public Beta(){//creating a constructor for the Beta file
        
        //See if we can access each of the properties from Alpha
        Alpha a = new Alpha();//creating a new alpha object
        
        a.publicProp = 0;//trying to access the public int variable in Alpha with viewable results
        a.protectedProp=0;//trying to access the protected int variable in Alpha with viewable results
        a.defaultProp=0;//trying to alter the unspecified access int variable in Alpha with viewable results
        //a.privateProp = 0;   //Not visible as private int variable was unaccessable
    }//closing Beta constructor
}//closing Beta class
