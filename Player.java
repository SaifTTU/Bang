/**
 * Character table
 * 1	Bart Cassidy
 * 2	Black Jack
 * 3	Calamity Janet
 * 4	El Gringo
 * 5	Jesse Jones
 * 6	Jourdonnais
 * 7	Kit Carlson
 * 8	Lucky Duke
 * 9	Paul Regret
 * 10	Pedro Ramirez
 * 11	Rose Doolan
 * 12	Sid Ketchum
 * 13	Slab The Killer
 * 14	Suzy Lafayette
 * 15	Vulture Sam
 * 16	Willy The Kid
 * 17 Jose Delgado
 * 18 Tequila Joe
 * 19 Apache Kid
 * 20 Bill Noface
 * 21 Elena Fuente
 * 22 Vera Custer
 * 23 Doc Holiday
 * 24 Molly Stark
 * 25 Belle Star
 * 26 Chuck Wengam
 * 27 Greg Digger
 * 28 Herb Hunter
 * 29 Pat Brennan
 * 30 Pixie Pete
 * 31 Sam the Healer
 * 32 Sean Mallory
 *
 *
 * Affiliation table
 * 0 - Sheriff
 * 1 - Outlaw
 * 2 - Deputies
 * 3 - Renegade
 * 
 */

public class Player {
	int health = 8;
	int character;
	int affiliation;
	int arrows = 0;
	boolean isHuman;
	int gatling = 0;
	int[] currentHand;
	String playerName;
	
	public void setPlayer( int setCharacter, int setAffiliation) {
		character = setCharacter;
		affiliation = setAffiliation;
		
		
		//Change the health due to character choice
		if(setCharacter == 4 || setCharacter == 6 || setCharacter == 7)
			health = 7;
		if(setCharacter == 5 || setCharacter == 9 || setCharacter == 11 || setCharacter == 15)
			health = 9;
		
		setName(character);
		
		
	}
	
	public int returnHealth()
	{
		return health;
	}
	
	public void setName(int character)
	{
			switch(character)
			{
			case 1:
				playerName = "Bart Cassidy";
				break;
			case 2:
				playerName = "Black Jack";
				break;
			case 3:
				playerName = "Calamity Janet";
				break;
			case 4:
				playerName = "El Gringo";
				break;
			case 5:
				playerName = "Jesse Jones";
				break;
			case 6:
				playerName = "Jourdonnais";
				break;
			case 7:
				playerName = "Kit Carlson";
				break;
			case 8:
				playerName = "Lucky Duke";
				break;
			case 9:
				playerName = "Paul Regret";
				break;
			case 10:
				playerName = "Pedro Ramirez";
				break;
			case 11:
				playerName = "Rose Doolan";
				break;
			case 12:
				playerName = "Sid Ketchum";
				break;
			case 13:
				playerName = "Slab The Killer";
				break;
			case 14:
				playerName = "Suzy Lafayette";
				break;
			case 15:
				playerName = "Vulture Sam";
				break;
			case 16:
				playerName = "Willy The Kid";
				break;
			default:
				playerName = "Player";
				break;
			}
	}
   
   public void getAbility(int character)
	{
			switch(character)
			{
			case 1:
				//Bart Cassidy
            //occurs: whenever one or two space shot damage is inflicted on the player
            //effect: adds one arrow counter to the player , restore life if player selects this option
				break;
			case 2:
				//Black Jack
            //occurs: every turn, before dice are calculated
            //optional: player is given the option to recalculate the dice unlimited times (cpu will only reshuffle once)
            //effect: given the condition they do not roll 3 Dynamtites ,
            //if they roll 3 or more dyn, a condition needs to be put in place that ends their turn, (in other words, the value of their dice can get set to null, meaning their turn is over).
				break;
			case 3:
				//Calamity Janet
            //occurs: every turn, when the player rolls 1's and 2's, when you click on/select those dice ,
            //effect: multiple options will appear on screen for who you can shoot because your range becomes expanded by one
            //we will need to design shooting logic for this one
            
            //note: create a decision() method 
            //this was meant to be a descripton of an ability but turned into shooting logic:
            //if the cpu is sherriff, him wont use it unless its on a person who fired on him or someone else
            //if the cpu is a deputy, he will on anybody so long as its not the sheriff, but if they heal the sherrif he also will not be allowed to fire on them
            //if the cpu is an outlaw, they will prioritize shooting the sherrif if he is in range, or other rise shoot the person that makes the shortest path to the sherriff, if they did shoot the sherriff then other outlawas wont shoot them
            //if the cpu is renegade, they will always shoot somebody and prioritize the ones with lower health, if that person shoots the sherrif, he is not allowed to shoot that person anymore
            			
   
            break;
			case 4:
				//El Gringo
            //occurs: on every players turn. we'll need to make a global array of all the abilities in play for that game that repeat each turn. 
               //whenever one or two space shot damage is inflicted on the player
            //effect: get the player who inflicted damage to him. add one arrow to them and remove 1 health from them as well
				break;
			case 5:
				//Jesse Jones
            //occurs: on players turn: if (player.health<=4), will inform player if this is an option
            //if they
            //effect: when beer is used, define a variable for the player and the selected player, 
               //if they are the same, use this function again and double the amount for the beer(2)
               //logic:
               //Sheriff:always use on self, unless [identified Deputy] to the left or right have 5 less health than the player, because they can block shots from the sheriff
               //Deputy: always use on Sheriff
               //Outlaw: always use on self
               //Renegade: always use on self
				break;
			case 6:
				//playerName = "Jourdonnais";
            //occurs: when indian attack occurs
            //effect: remove arrows like normal, but instead, make the amount of damage recieved for this player only be 1, if at all.
            //if they had no arrows then nothing happens
				break;
			case 7:
				//Kit Carlson
            //two abilities:
            //occurs 1: every turn, if the amount of arrow dice is 3 or more (write a for loop to do it)
            //occurs 2: every turn, count the number of arrow dice, if the player selects this option, 
            //effect 1: players arrows becomes = 0
            //effect 2: remove an arrow from any player
               //logic:
               //Sheriff: remove from self
               //Deputy: remove from SHERIFF
               //outlaw: remove from self
               //renegade: remove from self
				break;
			case 8:
				//Lucky Duke
            //occurs: every turn, if player chooses
            //effect: reroll
				break;
			case 9:
				//Paul Regret
            //occurs: when gattling fired
            //effect: health reduced on this player becomes 0
				break;
			case 10:
				//Pedro Ramirez
            //occurs: whenever damage taken. (bool value)
            //remove arrow from player
				break;
			case 11:
				//Rose Doolan
            //every turn
            //present twice as many options when selecting a target, if 2 selected, 3 spaces away becomes an option
            //if outlaw: shoot sheriff
            //renegade: shoot anybody
            //deputy: shoot people who have shot sheriff
            //sheriff: shoot anybody but cant shoot people who healed him
				break;
			case 12:
				//Sid Ketchum
            //start of turn
            //heal one player 
            //if deputy deal sheriff, unless self health is 5 less than sheriff, then heal self
            //sheriff heal self
            //outlaw heal self
            //renegade heal self
				break;
         case 13:
				//Slab the Killer
            //every turn: if beer in hand (run a loop
            //effect: inflict twice damage to player
            //cpu renegade will always use, for the rest make it 50/50 and set it to randopm for which of their cards this will effect, they can relly on their deicision method for which person to shoot.
				break;
         case 14:
				//Suzy Lafayette
            //every time the player rolls, check to see if no 1's or 2's were drawn (super rare)
            //effect raise players health by 2 (still have max health tho)
            break;
         case 15:
				//Vulture Sam
            //every time the player rolls, check to see if no 1's or 2's were drawn (super rare)
            //effect raise players health by 2 (still have max health tho)
            break;
         case 15:
				//Willy the Kid
            //every time the player reaches 2 gattling parts
            //they can use gattling
            //for renegades and outlaws they always use
            //for deputy, if the Sherrif's healt is 6 or above, run a 50/50 they will use it
               //or if any identified outlaws have 1-2 health, they will also use the gattling, if the sherrif does not have 1-2 health
            //sheriff have a 50/50 chance to use it  
            break;
			case 17:
				//Jose Delgado
            //every time player is eliminated (so make a globab variable), 
            //effect: increase health by 2
            //cpu, if a target is eliminatable and they are not an "ally" this becomes the priority for shooting.
				break;
			case 18:
				//Tequila Joe
            //every turn: player can choose to select saloon dice (coward) additionally (dice need to be objects)
            //cpu wil always choose to take this option
				break;
			case 19:
				//Apache Kid
            //his turn
            //check if any player had indian arrow (loop through)
            //can take Indian chief arrow
            //renegade,outlaw, and sheriff would do this regardles
            //deputy will do this only if the person is someone identified, that is if they shot the sheriff or themselves
				break;
			case 20:
				//Billy Noface
				break;
         case 21:
				//Elena Fuente
				break;
			case 22:
				//Vera Custer
				break;
			case 23:
				//Doc Holiday
				break;
			case 24:
				//Molly Stark
				break;
			case 25:
				//Belle Star
				break;
			case 26:
				//Chuck Wengam
				break;
         case 27:
				//Greg Digger
				break;
			case 28:
				//Herb Hunter
				break;
			case 29:
				//Pat Brennan
				break;
			case 30:
				//Pixie Pete
				break;
         case 31:
				//Sam the Healer
				break;
			case 32:
				//Sid Ketchum
				break;
			case 33:
				//Sean Mallory
				break;
			default:
				//playerName = "Player";
				break;
			}
	}
   
  

	public void setAffiliation(int choice)
	{
		affiliation = choice;
	}
	
	public int shoot()
	{
		health -= 1;
		return health;
	}
	
	public int drinkBeer()
	{
		health += 1;
		return health;
	}
	
	
	/*
	 * Method: getPart()
	 * 
	 * will increment the gatling variable to keep track of gun parts
	 * if the player has 3 parts will return true so we know to damage the other
	 * players, else it will return false;
	 * 
	 * */
	 
	public boolean getPart()
	{
		
		gatling += 1;
		
		if(gatling == 3)
		{
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Method: addArrow()
	 * 
	 * Will increment the players arrow counter. If all of the arrows have
	 * been fired method will return true so damage will be assessed. if tokens != 0
	 * will return false
	 * 
	 */
	
	
	public boolean addArrow(int tokensLeft)
	{
		arrows += 1;
		
		if(tokensLeft == 0)
		{
			System.out.println("ALL ARROWS HAVE BEEN FIRED!");
			return true;	
		}else {
			return false;
		}
		
	}
	
	public int arrowDamage()

	{
		health -= arrows;
		return health;
	}

	public boolean isDead() {

		if(health <= 0)	
			return true;
		else {
			return false;
		}
	}
	
	public void dispAffiliation()
	{
		switch(affiliation) {
		case 0:
			System.out.print("Sheriff");
			break;
		case 1:
			System.out.print("Outlaw");
			break;
		case 2:
			System.out.print("Deputy");
			break;
		case 3:
			System.out.print("Renegade");
			break;
		}
	}
	
	public void handAsText()
	{
		System.out.print("\n{");
		for(int i =0; i < 5; i++)
		{
			switch(currentHand[i]) {
			case 1:
				System.out.print(" Arrow");
				break;
			case 2:
				System.out.print(" Dynamite");
				break;
			case 3:
				System.out.print(" One-Space-Shot");
				break;
			case 4:
				System.out.print(" Two-Space-Shot");
				break;
			case 5:
				System.out.print(" Beer");
				break;
			case 6:
				System.out.print(" Gatling Part");
				break;	
			}
			if(i<4)
				System.out.print(",");
		}
		System.out.print("}");
	}
	
	
}

