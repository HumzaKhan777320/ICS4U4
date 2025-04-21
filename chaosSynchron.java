package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

public class chaosSynchron extends character{//declaring the child class for the Chaos Synchron
//with same name as file (chaosSynchron) that inherits the character class
    public chaosSynchron(){//declaring main constructor of chaosSynchron class
        super("Baxter", 300, 1000, 1000, false, true, 4, 15, false);
        //calling the parent class constructor using super to set specific values 
        //for the chaos synchron child class
    }//closing chaosSynchron constructor

    public int attack(int Strength) {//overriding the character class's attack function
        return super.attack(Strength)+20;//adding 20 to the return because the chaos synchron's
        //attacks are synchronized
    }//closing attack function

    //NOT ALTERING BLOCK AS EVERY CHARACTER FOLLOWS THE SAME BLOCKING PRINCIPAL

    public int heal(int endurance, int originalEndurance){//overriding the character class's heal function
        return super.heal(endurance, 1000);//recalling the heal function with the 
        //originalEndurance set as a constant 
    }//closing heal function

    //NOT ALTERING TAKEDAMAGE AS EVERY CHARACTER FOLLOWS THE SAME TAKE DAMAGE PRINCIPAL

    public String description(){//overriding the character class's description function
        return "a heavily armored and resilient fighter with solid strength who weaves chaos into synchronization by launching calculated attacks";
        //returning an actual description of the Chaos Synchron
    }//closing description function

}//clossing chaosSynchron class
