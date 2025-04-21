package turnBasedBattle;//declaring the package for the turn-based battle files
/*
Name: Humza Saleem Khan 
Student Number: 777320@pdsb.net
Course Code: ICS4U4
Assignment: ASSIGNMENT - Turn-based Battle
04/20/2025
*/

import java.util.Random;//importing Random to generate enemy moves
import java.util.Scanner;//importing Scanner to handle user input

public class battleMain {//declaring the main class for the battle system with same name as file (battleMain)
    public static void main(String[] args) {//declaring main function for the code necessary for coding 
    //anything in java (skeleton code)

        Scanner userInputs = new Scanner(System.in);//creating a new scanner for taking inputs from the user
        Random enemyMoves = new Random();//creating a new random for generating enemy moves

        int playerChoice;//declaring int variable to store the user's player choice number
        int enemyChoice;//declaring int variable to store the user's enemy choice number

        System.out.println("Choose your character (this is who you will be playing as):");
        //asking the user to select their character/player
        System.out.println("1. Battle Ox - "+new battleOx().description());
        //giving the user the option of Battle Ox
        System.out.println("2. Wizard - "+ new wizard().description());
        //giving the user the option of Wizard

        System.out.print("Please enter your choice as a number: ");
        //asking the user to enter their player choice as a number

        try {//declaring try statment
            playerChoice = userInputs.nextInt();
            //storing the user's input in playerChoice
        } catch (Exception e) {//declaring catch statement
            System.out.println("Sorry your input was invalid. Through the magic of time your character is now the Wizard by default");
            //telling the user we are defaulting to the wizard
            playerChoice = 2;
            //setting playerChoice to 2 so Wizard is chosen
            userInputs.next();
            //clearing error input incase of an exception
        }//closing catch statment

        System.out.print("\nName your player: ");
        //telling the user to input a name for the player
        String Playername = userInputs.next();
        //storing the user's player name input in string variable Playername

        System.out.println("\nChoose an enemy (this is who you're playing against):");
        //asking the user to select their enemy/opponent
        System.out.println("1. Baxter the Chaos Synchron - " +  new chaosSynchron().description());
        //giving the user the option of Baxter the Chaos Synchron with name already set
        System.out.println("2. Omega the Nightmare Magician - " + new nightmareMagician().description());
        //giving the user the option of Omega the Nightmare Magician with name already set
        System.out.print("Please enter your choice as a number: ");
        //asking the user to enter their enemy choice as a number

        try {//declaring try statment
            enemyChoice = userInputs.nextInt();
            //storing the user's input in enemyChoice
        } catch (Exception a) {//declaring catch statment
            System.out.println("Sorry your input was invalid. Through the magic of the shadows your enemy is now Baxter the Chaos Synchron by default");
            //telling the user we are defaulting to Baxter the Chaos Synchron
            enemyChoice = 1;
            //setting enemyChoice to 1 so Baxter is chosen
            userInputs.next();
            //clearing error input incase of an exception
        }//closing catch statment

        character player = null;//initializing a character player to create a player object based on the
        //user input. It's a character object because all players and enimies derive from the character class

        String playerType = "";
        //declaring a string variable playerType to store the type of player the user chooses

        if(playerChoice == 1){//checking if the user chose player type 1 (Battle Ox)
            player= new battleOx(Playername);
            //storing a new battleOx object in player variable with name Playername
            playerType = "Battle Ox";//storing the type Battle Ox in variable playerType
        } else if(playerChoice == 2){//checking if the user chose player type 2 (Wizard)
            player = new wizard(Playername);
            //storing a new wizard object in player variable with name Playername
            playerType = "Wizard";//storing the type Wizard in variable playerType
        }//closing else if statement

        character enemy = null;//initializing a character enemy to create an enemy object based on the
        //user input. It's a character object because all players and enimies derive from the character class
        
        String enemyType = "";
        //declaring a string variable enemyType to store the type of enemy the user chooses

        if(enemyChoice == 1){//checking if the user chose enemy type 1 (Chaos Synchron)
            enemy = new chaosSynchron();
            //storing a new chaosSynchron object in enemy variable
            enemyType = "Chaos Synchron";//storing the type Chaos Synchron in variable enemyType
        } else if(enemyChoice == 2){//checking if the user chose enemy type 2 (Nightmare Magician)
            enemy = new nightmareMagician();
            //storing a new nightmareMagician object in enemy variable
            enemyType = "Nightmare Magician";//storing the type Nightmare Magician in variable enemyType
        }//closing else if statment

        System.out.println("\nThe battle is beginning you are "+player.Name +" the "+playerType+
        " and your opponent is "+ enemy.Name+" the "+enemyType+"!");
        //indicating the game is about to begin to the user along with the info they chose

        boolean battleGoing = true;
        //declaring boolean variable battleGoing to control the main while loop and setting to true 

        while (battleGoing){//declaring main while loop of the game

            int playerAction = 0;//declaring int variable playerAction and setting to 0 to store
            //the user's choce of action

            System.out.println("\nChoose your action:");
            //asking the user to choose an action
            System.out.println("1. Attack");
            //giving the user the option of attack
            System.out.println("2. Block");
            //giving the user the option of block
            if(player.heals>0){//checking that the player still has heals left
                System.out.println("3. Heal");//giving the user the option of heal
            }//closing if statment
            System.out.print("Enter your choice as a number: ");
            //asking the user to enter theit choice as a number

            try{//declaring try statement
                playerAction = userInputs.nextInt();//storing the user's input in playerAction variable
            } catch (Exception e) {//declaring catch statement
                System.out.println("Sorry your input was invalid so we'll go with Block");
                //telling the user their action input was invalid and defaulted to block
                playerAction = 2;//setting playerAction to 2 so Block is chosen
                userInputs.next();//clearing error input incase of an exception
            }//closing catch statement

            if(playerAction == 1){//checking if the player chose action 1 (attack)
                int damageDealt = player.attack(player.Strength);//calling the attack function for the player 
                //object and storing the result in int variable damageDealt
                damageDealt = enemy.takeDamage(damageDealt, enemy.Armor);//setting damageDealt to the
                //amount of damage the enemy takes through .takeDamage
                System.out.println(player.Name + " attacks dealing " + damageDealt + " damage.");
                //telling the user how much damage the enemy takes
                enemy.Endurance-=damageDealt;
                //subtracting the damage from the enemy's endurance
            } else if(playerAction == 2){//checking if the player chose action 2 (block)
                enemy.isBlock=false;//setting the enemy's block to false as it should only activate
                //if the player attacks right after the block is ready
                player.block();//calling the .block function so the player is ready to block
                System.out.println(player.Name + " is blocking."); 
                //indicating to the user that they are blocking
            } else if(playerAction == 3 && player.heals>0){//checking if the player chose 
            //action 3 (heal) and the player still has heals left
                enemy.isBlock=false;//setting the enemy's block to false as it should only activate
                //if the player attacks right after the block is ready
                int healAmount = player.heal(player.Endurance, 0);//calling .heal to find the 
                //amount the player heals by and storing in int variable healAmount (setting originalEndurance to 0
                //as each player subclass's super deals with the original as a constant)
                player.Endurance += healAmount;//adding healAmount to the player's endurance
                System.out.println(player.Name + " heals for " + healAmount + " points.");
                //letting the user know how much they healed by
            } else{//declaring else statement
                System.out.println("Invalid action so we'll default to block");
                //telling the user their inputed action was invalid 
                enemy.isBlock=false;//setting the enemy's block to false as it should only activate
                //if the player attacks right after the block is ready
                player.block();//calling the .block function so the player is ready to block
                System.out.println(player.Name + " is blocking.");
                //indicating to the user that they are blocking
            }//closing else statement

            if (enemy.Endurance <= 0) {//checking if the enemy's endurance is at
            //or below 0 after the player's last move
                System.out.println("Victory! You defeated " + enemy.Name + "!");
                //telling the user that they defeated the enemy
                battleGoing = false;
                //setting battleGoing boolean variable to false to stop the while loop
                break;//breaking out of the main while loop
            }//closing if statement

            System.out.println("\n" + player.Name + " stands strong with " + player.Endurance + 
            " HP left and " + player.heals + " heal(s) remaining.");
            //telling the user the player's endurance and heals left
            System.out.println(enemy.Name + " stares back holding on to " + enemy.Endurance + 
            " HP left and has " + enemy.heals + " heal(s) remaining.");
            //telling the user the enemy's endurance and heals left

            int enemyAction=0;//declaring int variable enemyAction to store the enemy's choice of action
            //and setting to 0

            System.out.println("\nEnemy's turn:");
            //indicating to the user that it's now the enemy's turn
            System.out.println("1. Attack");
            //indicating that attack is one of the enemy's option
            System.out.println("2. Block");
            //indicating that block is one of the enemy's option
            if(enemy.heals>0){//checking if the enemy has heals left
                System.out.println("3. Heal");
                //indicating that heal is one of the enemy's option
                enemyAction = enemyMoves.nextInt(1,4);
                //having the enemy choose their action from between 1 and 3
                //and storing in enemyAction
            } else{//declaring else statement
                enemyAction = enemyMoves.nextInt(1,3);
                //having the enemy choose their action from between 1 and 2
                //and storing in enemyAction
            }//closing else statement

            if(enemyAction == 1){//checking if the enemy chose action 1 (attack)
                int damageReceived = enemy.attack(enemy.Strength);//calling the attack function for the enemy
                //object and storing the result in int variable damageReceived
                damageReceived=player.takeDamage(damageReceived, player.Armor);//setting damageReceived to the
                //amount of damage the player takes through .takeDamage
                System.out.println(enemy.Name + " attacks dealing " + damageReceived + " damage.");
                //telling the user how much damage they take
                player.Endurance-=damageReceived;
                //subtracting the damage from the player's endurance
            } else if(enemyAction == 2){//checking if the enemy chose action 2 (block)
                player.isBlock=false;//setting the player's block to false as it should only activate
                //if the enemy attacks right after the block is ready
                enemy.block();//calling the .block function so the enemy is ready to block
                System.out.println(enemy.Name + " is blocking.");
                //indicating to the user that the enemy is blocking
            } else if(enemyAction == 3){//checking if the player chose action 3 (heal)
                player.isBlock=false;//setting the player's block to false as it should only activate
                //if the enemy attacks right after the block is ready
                int enemyHealAmount = enemy.heal(enemy.Endurance, 0);//calling .heal to find the 
                //amount the enemy heals by and storing in int variable enemyHealAmount (setting originalEndurance to 0
                //as each enemy subclass's super deals with the original as a constant)
                enemy.Endurance += enemyHealAmount;//adding enemyHealAmount to the enemy's endurance
                System.out.println(enemy.Name + " heals for " + enemyHealAmount + " points.");
                //letting the user know how much the enemy healed by
            }//closing else if statement 

            if (player.Endurance <= 0) {//checking if the player's endurance is at
            //or below 0 after the enemy's last move
                System.out.println("Defeat! You were defeated by " + enemy.Name + ".");
                //telling the user that they were defeated by the enemy
                battleGoing = false;
                //setting battleGoing boolean variable to false to stop the while loop
                break;//breaking out of the main while loop
            }//closing if statement

            System.out.println("\n" + player.Name + " stands strong with " + player.Endurance + 
            " HP left and " + player.heals + " heal(s) remaining.");
            //telling the user the player's endurance and heals left
            System.out.println(enemy.Name + " stares back holding on to " + enemy.Endurance + 
            " HP left and has " + enemy.heals + " heal(s) remaining.");
            //telling the user the enemy's endurance and heals left
        }//closing main while loop

        userInputs.close();//closing userInputs scanner
    }//closing main function
}//closing battleMain class
