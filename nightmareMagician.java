package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

public class nightmareMagician extends character{//declaring the child class for the Nightmare Magician
//with same name as file (nightmareMagician) that inherits the character class
    public nightmareMagician(){
        super("Omega", 600, 900, 1000, false, true, 3, 20, false);
        //calling the parent class constructor using super to set specific values 
        //for the nightmare magician child class
    }//closing nightmareMagician constructor

    public int attack(int Strength) {//overriding the character class's attack function
        return super.attack(Strength)-10;//subtracting 10 from the return because too strong attacks
        //drain the nightmare magician
    }//closing attack function

    //NOT ALTERING BLOCK AS EVERY CHARACTER FOLLOWS THE SAME BLOCKING PRINCIPAL

    public int heal(int endurance, int originalEndurance){//overriding the character class's heal function
        return super.heal(endurance, 1000);//recalling the heal function with the 
        //originalEndurance set as a constant 
    }//closing heal function

    //NOT ALTERING TAKEDAMAGE AS EVERY CHARACTER FOLLOWS THE SAME TAKE DAMAGE PRINCIPAL

    public String description(){//overriding the character class's description function
        return "a resilient and battle ready fighter with solid strength and armor, cloaked in chaotic energy that blurs the line between reality and nightmare";
        //returning an actual description of the Nightmare Magician
    }//closing description function


}//closing nightmareMagician class
