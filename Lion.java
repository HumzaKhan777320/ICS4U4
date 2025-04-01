/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: QUIZ - Lion Class extends Animal Class
04/01/2025
*/

public class Lion extends Animal{//declaring new child class Lion

    public Lion(String name, int age){//declaring main constructor for Lion class
		super(name, age);
	}

    public Lion(String name){//declaring a somewhat default constructor for Lion class
    //with no age 
        super(name);
    }

    public void hunt(){//declaring new method hunt specific to the Lion class
        System.out.println(name + " hunts for zebras!");

        tiredness+=10;//altering tirdness as hunting takes energy
        hunger-=20;//altering hunger as hunting allows lions to eat

    }
    public void speak(){//altering speak method
		System.out.println("Roar!");//printing roar instead of cannot speak
	}
    
}
