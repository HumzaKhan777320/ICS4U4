package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

public class wizard extends character{//declaring the child class for the Wizard
//with same name as file (wizard) that inherits the character class

    public wizard(String Name){//creating a main constructor for the wizard that takes the name as a parameter
        super(Name, 200, 600, 1200, true, false, 4, 40, false);
        //calling the parent class constructor using super to set specific values 
        //for the wizard child class excluding the name
    }//closing main constructor

    public wizard(){//creating a default constructor for the wizard
        super("Wizard", 200, 600, 1200, true, false, 4, 40, false);
        //calling the parent class constructor using super to set specific values 
        //for the wizard child class
    }//closing default constructor

    public int attack(int Strength) {//overriding the character class's attack function
        return super.attack(Strength)+10;//adding 10 to the return because the wizard's
        //attacks are delivered with a powerful staff resulting in more damage
    }//closing attack function

    //NOT ALTERING BLOCK AS EVERY CHARACTER FOLLOWS THE SAME BLOCKING PRINCIPAL

    public int heal(int endurance, int originalEndurance){//overriding the character class's heal function
        return super.heal(endurance, 1200);//recalling the heal function with the 
        //originalEndurance set as a constant 
    }//closing heal function

    //NOT ALTERING TAKEDAMAGE AS EVERY CHARACTER FOLLOWS THE SAME TAKE DAMAGE PRINCIPAL

    public String description(){//overriding the character class's description function
        return "a master of magic with moderate armor and high endurance, using intelligence to outlast enimies";
        //returning an actual description of the Wizard
    }//closing description function
}//closing wizard class
