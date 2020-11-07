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
   int gattling = 0;
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
         int input = 0;
         int round = 0;
         boolean oneSpacePressed = false;	
         boolean twoSpacePressed = false;
         boolean isHit = false;
         int isAttacking = 0;
         boolean isAttacked = false;
         boolean indiansAttacking = false;
         boolean gattlingAttacking = false;
         boolean beerUsed = false;
         int damage = 1; //because slab can double his damage once per beer
         boolean playerDefeated = false; //if a player was defeated on this turn - for vulture sams
			switch(character)
			{
			case 1:
				//Bart Cassidy
            //occurs: whenever one or two space shot damage is inflicted on the player
            //effect: adds one arrow counter to the player , restore life if player selects this option
            if(input==1){
               System.out.println("Chose to substitute shot for arrow");
            }
				break;
			case 2:
				//Black Jack
            //occurs: every turn, before dice are calculated
            //optional: player is given the option to recalculate the dice unlimited times (cpu will only reshuffle once)
            //effect: given the condition they do not roll 3 Dynamtites ,
            //if they roll 3 or more dyn, a condition needs to be put in place that ends their turn, (in other words, the value of their dice can get set to null, meaning their turn is over).
            if(input==1){
               System.out.println("Rerolled the dice");
            }
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
            
            System.out.println("Can use 1 Space Shots as 2 Space Shots and Vice Versa: ");
            if(oneSpacePressed==true){
               String extraOption1 = "2 Right"; //2 to the Right
               String extraOption2 = "2 Left"; // 2 to the Left
            
               System.out.println("Who would you like to hit?");
               System.out.println("El Gringo");
               System.out.println("Jesse Doolan");
               System.out.println("Bart Cassidy");
               System.out.println("Black Jack");
            }
            if(twoSpacePressed==true){
               String extraOption1 = "1 Right"; //1 to the Right
               String extraOption2 = "1 Left"; //1 to the Left
            
               System.out.println("Who would you like to hit?");
               System.out.println("El Gringo");
               System.out.println("Jesse Doolan");
               System.out.println("Bart Cassidy");
               System.out.println("Black Jack");
            }
            break;
			case 4:
				//El Gringo
            //occurs: on every players turn. we'll need to make a global array of all the abilities in play for that game that repeat each turn. 
               //whenever one or two space shot damage is inflicted on the player
            //effect: get the player who inflicted damage to him. add one arrow to them and remove 1 health from them as well
            
            System.out.println("The player with the number: "+ isAttacking + " loses -1 health and gains 1 arrow ");
            
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
            System.out.println("Can gain 2 health for using beer on self!");
            if(beerUsed= true)
               if(input==1 && health<=4){
                  System.out.println("Gained 2 health for using beer on self!");
               }
				break;
			case 6:
				//playerName = "Jourdonnais";
            //occurs: when indian attack occurs
            //effect: remove arrows like normal, but instead, make the amount of damage recieved for this player only be 1, if at all.
            //if they had no arrows then nothing happens
            if(indiansAttacking==true&&arrows!=0){ //if the indians attack happens and the player has any arrows
               System.out.println("lost only 1 health as a result of his abilities");
            }
				break;
			case 7:
				//Kit Carlson
            //TWO abilities:
            //occurs 1: every turn, if the amount of arrow dice is 3 or more (write a for loop to do it)
            //occurs 2: every turn, count the number of arrow dice, if the player selects this option, 
            //effect 1: players arrows becomes = 0
            //effect 2: remove an arrow from any player
               //logic: all remove from self except deputy
               //Sheriff: remove from self
               //Deputy: remove from SHERIFF
               //outlaw: remove from self
               //renegade: remove from self
            int arrowsRolled = 0;
            for(int i=0; i<currentHand.length;i++){
               if(currentHand[i]==0){
                  arrowsRolled++;
               }
            }
            if(arrowsRolled>=3){
               arrows=0;
            }
            if(input == 1){
               System.out.println("Select player to remove arrow from"); 
            }
				break;
			case 8:
				//Lucky Duke
            //occurs: every turn, if player chooses
            //effect: reroll
            if(input == 1){
               System.out.println("Lucky Duke re-rolled dice"); 
            }
				break;
			case 9:
				//Paul Regret
            //occurs: when gattling fired
            //effect: health reduced on this player becomes 0
            if(gattlingAttacking==true){
               health++; //since gattling only reduces health by 1 each time its used 
            }
				break;
			case 10:
				//Pedro Ramirez
            //occurs: whenever damage taken. (bool value)
            //remove arrow from player
            if(isAttacked==true){
               arrows--;
            }
				break;
			case 11:
				//Rose Doolan
            //every turn
            //present twice as many options when selecting a target, if 2 selected, 3 spaces away becomes an option
            //if outlaw: shoot sheriff
            //renegade: shoot anybody
            //deputy: shoot people who have shot sheriff
            //sheriff: shoot anybody but cant shoot people who healed him
            if(input == 1){
               System.out.println("Range for this shot extended by 1"); 
            }
				break;
			case 12:
				//Sid Ketchum
            //start of turn
            //heal one player 
            //if deputy deal sheriff, unless self health is 5 less than sheriff, then heal self
            //sheriff heal self
            //outlaw heal self
            //renegade heal self
            System.out.println("heal 1 player"); 
            if(input == 1){
               System.out.println("healed self");
               health++; //since they are most likely to heal themselves anyways
            }
				break;
         case 13:
				//Slab the Killer
            //every turn: if beer in hand (run a loop
            //effect: inflict twice damage to player
            //cpu renegade will always use, for the rest make it 50/50 and set it to randopm for which of their cards this will effect, they can relly on their deicision method for which person to shoot.
				if(input == 1){
               System.out.println("Traded beer for extra damage");
               damage = 2;
            }
            break;
         case 14:
				//Suzy Lafayette
            //every time the player rolls, check to see if no 1's or 2's were drawn (super rare)
            //effect raise players health by 2 (still have max health tho)
            boolean hasOneOrTwo = false;
            for(int i=0; i<currentHand.length;i++){
               if(currentHand[i]==2||currentHand[i]==3){
                  hasOneOrTwo = false;
               }
            }
            if(hasOneOrTwo==false){
               health = health + 2;
            }
            break;
         case 15:
				//Vulture Sam
            //
            //effect
            if(playerDefeated == 2){
               System.out.println("Healed for +2);
               health = health + 2;
            }
               
            break;
         case 16:
				//Willy the Kid
            //every time the player reaches 2 gattling parts
            //they can use gattling
            //for renegades and outlaws they always use
            //for deputy, if the Sherrif's healt is 6 or above, run a 50/50 they will use it
               //or if any identified outlaws have 1-2 health, they will also use the gattling, if the sherrif does not have 1-2 health
            //sheriff have a 50/50 chance to use it  
            if(gattling==0){
               gattling++;
            }
            break;
			case 17:
				//Jose Delgado
            //every time player is eliminated (so make a globab variable), 
            //every turn: player can choose to select saloon dice (loud mouth) additionally (dice need to be objects)
            //cpu wil always choose to take this option
            
            //if(cpu == true) input = 1;
            if(input==1){
               System.out.println("Took an extra saloon dice (loud mouth)");
            }
				break;
			case 18:
				//Tequila Joe
            //every turn: player can choose to select saloon dice (coward) additionally (dice need to be objects)
            //cpu wil always choose to take this option
            
            //if(cpu == true) input = 1;
            if(input==1){
               System.out.println("Took an extra saloon dice (coward)");
            }
				break;
			case 19:
				//Apache Kid
            //his turn
            //check if any player had indian arrow (loop through)
            //can take Indian chief arrow
            //renegade,outlaw, and sheriff would do this regardles
            //deputy will do this only if the person is someone identified, that is if they shot the sheriff or themselves
            /*
               for(int i=0;i<player.length;i++){
                  if(player[i].hasChiefArrow==true){
                     player[i].hasChiefArrow=false;
                     hasChiefArrow=true;
                     System.out.println("Took chief arrow!);
                  }
               }
            */
				break;
			case 20:
				//Billy Noface -rolls not calculated till the end of turn - basically we dont have to implement this
				break;
         case 21:
				//Elena Fuente
            boolean hasArrow = false;
            for(int i=0; i<currentHand.length;i++){
               if(currentHand[i]==1){
                  hasArrow = true;
               }
            }
            if(hasArrow==true)
               System.out.println("Give arrow?");
            if(input==1){
               System.out.println("Gave arrow");
            }
				break;
			case 22:
				//Vera Custer 
            //nie invulnerability
            if(isAttacked==true){
               health++;
            }
				break;
			case 23:
				//Doc Holiday
            int hasGuns = 0;
            for(int i=0; i<currentHand.length;i++){
               if(currentHand[i]==2||currentHand[i]==3){
                  hasGuns++;
               }
            }
            if(hasGuns >=3){
               health = health + 2;
            }
				break;
			case 24:
				//Molly Stark
            //every players turn
            if(isAttacking!=0){ //if any player is attacking, every turn, (print a new menu popup)
               System.out.println("Take damage in place of this player?");
            }
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

