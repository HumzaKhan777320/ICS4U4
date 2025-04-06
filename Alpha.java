package package1;//storing the Alpha.java file in package1

public class Alpha {//creating a class to call in future constructors
    
    //This class just exists to test out access modifiers
    public int publicProp;//declaring a public int variable
    protected int protectedProp;//declaring a protected int variable
    int defaultProp;//declaring a regular int variable without specification of access
    private int privateProp;//declaring a private int variable

    public Alpha(){//creating a constructor for the Alpha file
        Alpha a0 = new Alpha();//creating a new alpha object
        a0.publicProp=0;//trying to access the public int variable in Alpha with viewable results
        a0.protectedProp=0;//trying to access the protected int variable in Alpha with viewable results
        a0.defaultProp=0;//trying to access the unspecified access int variable in Alpha with viewable results
        a0.privateProp=0;//trying to access the private int variable in Alpha with viewable results
    }//closing Alpha constructor

}//closing Alpha class
