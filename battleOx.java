package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

public class battleOx extends character{//declaring the child class for Battle Ox
//with same name as file (battleOx) that inherits the character class

    public battleOx(String Name){//creating a main constructor for battleOx that takes the name as a parameter
        super(Name, 500, 800, 900, true, false, 3, 10, false);
        //calling the parent class constructor using super to set specific values 
        //for the battle ox child class excluding the name
    }//closing main constructor

    public battleOx(){//creating a default constructor for battleOx
        super("Battle Ox", 500, 800, 900, true, false, 3, 10, false);
        //calling the parent class constructor using super to set specific values 
        //for the battle ox child class
    }//closing default constructor

    public int attack(int Strength) {//overriding the character class's attack function
        return super.attack(Strength) + 20;//adding 20 to the return because battle ox's
        //attacks are delivered with a sharp axe resulting in more damage
    }//closing attack function

    //NOT ALTERING BLOCK AS EVERY CHARACTER FOLLOWS THE SAME BLOCKING PRINCIPAL

    public int heal(int endurance, int originalEndurance){//overriding the character class's heal function
        return super.heal(endurance, 900);//recalling the heal function with the 
        //originalEndurance set as a constant 
    }//closing heal function

    //NOT ALTERING TAKEDAMAGE AS EVERY CHARACTER FOLLOWS THE SAME TAKE DAMAGE PRINCIPAL

    public String description(){//overriding the character class's description function
        return "a fearsome warrior with immense strength, heavy armor, and high endurance, built for combat";
        //returning an actual description of Battle Ox
    }//closing description function
}//closing battleOx class
