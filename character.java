package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

import java.util.Random;//importing Random to generate enemy moves

public class character {//declaring the parent class for each character with same name as file (character)
    
    protected String Name;//declaring string variable name so each character has a name atribute
    protected int Strength;//declaring int variable strength so each character has a strength atribute
    protected int Armor;//declaring int variable armor so each character has an armor atribute
    protected int Endurance;//declaring int variable endurance so each character has an endurance atribute
    protected boolean isPlayer;//declaring boolean variable isPlayer so each character has an isPlayer atribute
    protected boolean isEnemy;//declaring boolean variable isEnemy so each character has an isEnemy atribute
    protected int heals;//declaring int variable heals so each character has a heals atribute
    protected int chance;//declaring int variable chance so each character has a chance atribute
    protected boolean isBlock;//declaring boolean variable isBlock so each character has an isBlock atribute

    /**
     * Constructor for the character class.
     * 
     * <p>
     * Initializes attributes when an object is created.
     *
     * @param Name Character's name
     * @param Strength Character's strength attribute
     * @param Armor Character's armor attribute
     * @param Endurance Character's endurance attribute
     * @param isPlayer Boolean indicating if the character is the player
     * @param isEnemy Boolean indicating if the character is an enemy
     * @param heals Number of healing opportunities
     * @param chance Probability of landing a critical hit
     * @param isBlock Boolean indicating block status
     */
    public character(String Name, int Strength, int Armor, int Endurance, boolean isPlayer, 
    boolean isEnemy, int heals, int chance, boolean isBlock){//declaring main constructor of 
    //the character class to initialize attributes when an object is created

        this.Name = Name;//assign's the object's name
        this.Strength = Strength;//assign's the object's strength
        this.Armor = Armor;//assign's the object's armor
        this.Endurance = Endurance;//assign's the object's endurance
        this.isEnemy = isEnemy;//assign's the object's isEnemy attribute
        this.isPlayer = isPlayer;//assign's the object's isPlayer attribute
        this.heals = heals;//assign's the object's heals attribute
        this.chance = chance;//assign's the object's chance attribute
        this.isBlock = isBlock;//assign's the object's isBlock attribute
    }//closing character constructor

    /**
     * Performs an attack.
     * 
     * <p>
     * Calculates and returns the damage dealt based on strength.
     * If a critical hit occurs the damage is doubled.
     *
     * @param Strength Strength attribute of the character
     * @return a random value generated based on the Strength attribute
     */
    public int attack(int Strength){//declaring attack function that 
    //calculates and returns damage based on strength
        Random rand = new Random();//creating a new random to find the amount of damage
        int minDamage = Strength / 2;//finding the lower bound of the damage by dividing the
        //strength by 2 and storing in int variable minDamage
        int maxDamage = Strength;//storing the upper bound of the damage in int variable maxDamage
        int damage = rand.nextInt(maxDamage - minDamage) + minDamage;//finding a random number 
        //between min and max damage and storing in int variable damage

        if (rand.nextInt(100) < this.chance) {//generating a random number between 0 and 100
        //and comparing it to an objects chance attribute  
            System.out.println("CRITICAL HIT!");//printing an indicator of a critical hit
            damage *= 2;//multiplying the damage by 2
        }//closing if statement
        return damage;//returning the damage variable
    }//closing attack function

    /**
     * Performs a block.
     * 
     * <p>
     * Sets the block attribute to true, indicating the character is blocking an attack.
     */
    public void block(){//declaring void function that performs a block using the isBlock 
    //attribute of an object
        this.isBlock = true;//setting the isBlock attribute of an object to true
    }//closing block function

    /**
     * Performs a heal.
     * 
     * <p>
     * Performs healing based on the character's endurance levels.
     * Reduces the number of available heals.
     *
     * @param endurance Current endurance level of the character
     * @param originalEndurance Original endurance level of the character
     * @return The amount of endurance to be restored
     */
    public int heal(int endurance, int originalEndurance){//declaring function that performs healing 
    //based on an objects original and current endurance and returns it as an int
        Random rand2 = new Random();//creating a new random to find the amount to heal 
        int healAmount = rand2.nextInt(Math.max(1,originalEndurance-endurance));
        //finding a random number in between 0 and the higher number of 1 and the difference between 
        //the current and original endurance to find the amount to heal by and storing in int variable 
        //healAmount
        this.heals -= 1;//subtracting 1 from the objects heals attribute
        return healAmount;//returning the amount to heal by
    }//closing heal function

    /**
     * Ensures the damage taken is the correct amount based on other factors.
     * 
     * <p>
     * Calculates the damage taken after considering block status and armor.
     *
     * @param damage Incoming damage value
     * @param armor Character's armor value
     * @return Adjusted damage taken
     */
    public int takeDamage(int damage, int armor){//declaring takeamage function that returns the amount of damage 
    //the enemy should take after considering factors such as block and armor
        if(this.isBlock == true){//checks if the object's isBlock attribute is true
            damage -= armor;//subtracting the armor from the damage as a character with weak/no armor should
            //not be able to block all damage
            this.isBlock = false;//setting an object's isBlock to false now as a block should only work if 
            //set in the last turn
        }//closing if statment
        damage = Math.max(damage, 0);//setting damage to the higher value of 0 and the current damage
        //to avoid negative damage
        return damage;//returning the damage
    }//closing takeDamage function

    /**
     * Returns a description.
     * 
     * <p>
     * Provides a description of the character.
     * This function is meant to be overridden in subclasses.
     *
     * @return A generic character description to be overrided
     */
    public String description(){//declaring description function that returns the description as a string
        return "Description";//returning a default string description to be overrided in subclasses
    }//closing description function
}//closing character class