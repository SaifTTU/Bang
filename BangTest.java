import java.util.Scanner;

public class BangTest { //practice with making each ability work each turn, and activate when its supposed to
    public static Scanner sc = new Scanner(System.in);
    public static int globalArrows = 0;
    public static boolean globalGatting = true; //set when gattling attack happens
    public static Dice dice = new Dice();
    
    public static void main(String[] args) {
      
        int turn;
        Player player[] = new Player[12];
        player[0] = new Player();
        player[0].index=0;
        player[1] = new Player();
        player[1].index=1;
        player[2] = new Player();
        player[2].currentHand = dice.makeHand(); //giving her a dice hand, before-hand, in order to switch between
        player[2].index=2;
        player[3] = new Player(); //we'll pretend janet attacks el
        player[3].index=3;
        player[4] = new Player();
        player[4].currentHand = dice.makeHand();
        player[4].health=3; //for testing purposes setting jesse's health < 4
        player[4].index=4;
        player[5] = new Player();
        globalArrows=7; //since Jourdonnais' ability has to do with arrows
        player[5].currentHand = dice.makeHand(); //if this hand has any arrows the ability will trigger
        player[5].index=5;
        
        
        //-----incomplete---------------------------------------------------------------
        player[6] = new Player(); //kitCarlson
        player[6].index=6; //discard a players arrow for every gattling in your hand
        player[6].currentHand = dice.makeHand();
        player[7] = new Player(); //luckyDuke
        player[7].index=7; //reroll
        player[8] = new Player(); //paulRegret
        player[8].index=8; //no damage taken from Gattlings
        player[9] = new Player();
        player[9].index=9;
        player[10] = new Player();
        player[10].index=10;
        player[11] = new Player();
        player[11].index=11;
        //------------------------------------------------------------------------------
        // ** -1 means not in effect**
        //int ability, int attacking, int attacked, Player[] player)
        player=getAbility(0,1,0, player); //bart attacked by black
        player=getAbility(1,-1,-1, player); //black gets to reroll, 
        player=getAbility(2,-1,-1, player); //janet can switch 1's and 2's
        player=getAbility(3,2,3, player); //el gives arrow to another player
        player=getAbility(4,-1,4, player); //beers count twice for jesse
        player=getAbility(5,-1,5, player); //Jourdonnais only takes 1 indian arrow damage
        player=getAbility(6,-1,6, player); //trade gat tokens for arrow
        player=getAbility(7,-1,7, player); //lucky duke up to 4 rerolls
        player=getAbility(8,1,8, player); //take no damage from gattling 
        player=getAbility(9,8,9, player); //remove an arrow when taking damage
        player=getAbility(10,-1,-1, player); //rose do what janet do but make it one space farther
        player=getAbility(11,-1,-1, player); //sid - heal whoever you want
    }
    
    public static Player[] getAbility(int ability, int attacking, int attacked, Player[] player){
      if(attacked==0&&ability==0){
         player = bartCassidy(attacked, attacking, player);
      }
      if(ability==1){
         player = blackJack(player[1].index, player);
      }
      if(ability==2){
         player = calamityJanet(player[2].index, player);
      }
      if(attacking>-1&&ability==3){
         player = elGringo(attacked, attacking, player);
      }
      if(ability==4){
         player = jesseJones(player);
      }
      if(ability==5){
         player = jourdonnais(player); //we'll also be using "globabl arrows" as a parameter in this. (unwritten because its global)
      }
      if(ability==6){
         player = kitCarlson(player); 
      }
      if(ability==7){
         player = luckyDuke(player,0); //rerolls: it will recursively loop up to 4 times based on if the user presses N for No to stop it.
      }
      if(ability==8){
         player = paulRegret(player, attacking); 
      }
      if(ability==9&&attacking!=9&&attacked==9){
         player = pedroRamirez(player,attacking,attacked); //rerolls: it will recursively loop up to 4 times based on if the user presses N for No to stop it.
      }
      if(ability==10){
         player = roseDoolan(player[10].index, player);
      }
      if(ability==11){
         player = sidKetchum(player);
      }
      return player;
    }
    
    public static Player[] bartCassidy(int currentPlayer, int enemy, Player[] playerArray){
      System.out.print("\nPlayer "+ enemy+" attacked Player " + currentPlayer);
      System.out.print("\nUse Ability? Y or N? (Replace damage taken with one arrow)");
      char bart = sc.next().charAt(0); //this is where the option begins
      if(bart=='Y'){
         playerArray[0].health++;
         playerArray[0].arrows++;
         globalArrows++;
      }
      return playerArray;      
   }
   public static Player[] blackJack(int currentPlayer, Player[] playerArray){
      int dynCount=0;
      //System.out.print("\nPlayer "+ enemy+" attacked Player " + currentPlayer);
      System.out.print("\nUse Ability? Y or N? (Reroll, unless you get 3 Dynamite)");
      char black = sc.next().charAt(0); //this is a new option
      if(black=='Y'){
         playerArray[1].currentHand=dice.makeHand();
         playerArray[1].handAsText(playerArray[1].currentHand);
         for(int i=0;i<playerArray[1].currentHand.length;i++){
            if(playerArray[1].currentHand[i]==2)
               dynCount++;
         }
         if(dynCount<3){
            System.out.print("\nReroll?");
            if(black=='Y'){
               playerArray = blackJack(currentPlayer, playerArray); //recursive
            }
         }
         if(dynCount>3){
            System.out.print("\nRolled 3 Dynamite.");
         }
         
      }
      return playerArray;      
   }
   public static Player[] calamityJanet(int currentPlayer, Player[] playerArray){
      int ones = 0;
      int twos = 0;
      for(int i=0;i<playerArray[2].currentHand.length; i++){
         if(playerArray[2].currentHand[i]==3)
            ones++;
         if(playerArray[2].currentHand[i]==4)
            twos++;   
      }
      System.out.print("\nUse Ability? Y or N? (Exchange 1 Space Shots for 2's)");
      char cal = sc.next().charAt(0); 
      if((ones>0||twos>0)&&cal=='Y')
      {
         System.out.print("\nNumber of 1's: "+ones);
         System.out.print("\nNumber of 2's: "+twos);
         System.out.print("\nSwitch 1's (A.): ("+ones+")");
         System.out.print("\nSwitch 2's (B.): ("+twos+")");
         System.out.print("\nCancel: N.");
         cal = sc.next().charAt(0); 
         if(cal=='A'){
            for(int i=0;i<playerArray[2].currentHand.length;i++){ //only does it to 1 at a time
               if(playerArray[2].currentHand[i]==3){
                  playerArray[2].currentHand[i]=4;
                  i=playerArray[2].currentHand.length;//aka stop looping
                  calamityJanet(currentPlayer, playerArray); //rerolls the method
               }
            }
         }
         if(cal=='B'){
            for(int i=0;i<playerArray[2].currentHand.length;i++){ //only does it to 1 at a time
               if(playerArray[2].currentHand[i]==4){
                  playerArray[2].currentHand[i]=3;
                  i=playerArray[2].currentHand.length;//aka stop looping
                  calamityJanet(currentPlayer, playerArray); //rerolls the method
               }
            }
         }
      }
   
      return playerArray;
   }
    public static Player[] elGringo(int currentPlayer, int enemy, Player[] playerArray){
    //public int counter = 0;
      System.out.print("\nPlayer "+ enemy+" attacked Player " + currentPlayer);
      System.out.print("\nUse Ability? Y or N? (Give arrow to attacking enemy player)");
      char el = sc.next().charAt(0); //this is where the option begins
      if(el=='Y'){
         //playerArray[enemy].health++;
         playerArray[enemy].arrows++;
         globalArrows++;
         for(int i=0;i<playerArray[enemy].currentHand.length;i++){
            if(playerArray[enemy].currentHand[i]==3||playerArray[enemy].currentHand[i]==4){
               playerArray[enemy].currentHand[i]=-1;
               playerArray=elGringo(currentPlayer, enemy, playerArray);
            }
         }
      }
      return playerArray;      
   }
   public static Player[] jesseJones(Player[] playerArray){
      int beerCount = 0;
      System.out.print("\nPlayer "+ playerArray[4].index+" has less than 4 health");
      
      playerArray[4].handAsText(playerArray[4].currentHand);
      for(int i =0;i<playerArray[4].currentHand.length;i++){
         if(playerArray[4].currentHand[i]==5)
            beerCount++;
      }
      System.out.print("\nPlayer "+ playerArray[4].index+" has (" +beerCount+") beers");
      if(beerCount>0){
         System.out.print("\nUse Ability? Y or N? (Heal Self for 2 with Beer)");
         char jess = sc.next().charAt(0); //this is where the option begins
         if(jess=='Y'){
            playerArray[4].health++; //healing them for 2
            playerArray[4].health++;
            for(int i =0;i<playerArray[4].currentHand.length;i++){
                  if(playerArray[4].currentHand[i]==5){
                        playerArray[4].currentHand[i]=-1; //remove that beer when used
                        i=playerArray[4].currentHand.length; //stop looping
                        playerArray=jesseJones(playerArray);
                     }
               }
         }
      }
      else{
         //System.out.print("\nCannot use ability this turn. Not enough beers.");
      }
      
      return playerArray;      
   }
   public static Player[] jourdonnais(Player[] playerArray){
      int arrowCounter;
      for(int i =0;i<playerArray[5].currentHand.length;i++){
            if(playerArray[5].currentHand[i]==1)
               globalArrows++;
      }
      if(globalArrows>=8){
         System.out.print("\nIndian Attack!!!!");
         System.out.print("\nArrows: "+globalArrows);
         globalArrows=0; //setting it to 0 so it doesnt do indian attack twice
         for(int i =0;i<playerArray.length;i++){
            if(i!=5){
               //playerArray[i].health=playerArray[i].health-playerArray[i].arrows;
               }
            if(i==5){
               System.out.print("\nPlayer "+5+" only loses 1 health to the indians.");
            }
         }
         
      }
      
      return playerArray;      
   }
   public static Player[] kitCarlson(Player[] playerArray){ //remove an arrow from any player (per gattling)
      int gatCount = 0;
      for(int i=0;i<playerArray[6].currentHand.length;i++){
         if(playerArray[6].currentHand[i]==6)
         gatCount++;
      }
      System.out.print("\n\nPlayer: "+playerArray[6].index);
      System.out.print("\nNumber of gattlings: ("+gatCount+") (Trade Gattling to inflict Arrow)");
      if(gatCount>0){
         System.out.print("\nUse Ability? Y or N? (Trade Gattling to inflict Arrow)");
         char kit = sc.next().charAt(0); //this is where the option begins
         if(kit=='Y'){
            System.out.print("\nHere is a list of players: ");
            for(int i=0;i<playerArray.length;i++){
               System.out.print("\n"+i+".");
            }
            System.out.print("\nWho would you like to add arrows to? (N to cancel)");
            char kit2 = sc.next().charAt(0);
            if(kit2!='N'){
               for(int i=0;i<playerArray[6].currentHand.length;i++){
                  if(playerArray[6].currentHand[i]==6){
                     playerArray[6].currentHand[i]=-1;
                     i=playerArray[6].currentHand.length;
                  }
               }
            }
            switch(kit2) {
               case '0' :
                  playerArray[0].arrows++; //adds an arrow to that selected player 
                  globalArrows++; //increases the total ammount of arrows by 1
                  break;
               case '1' :
                  playerArray[1].arrows++;
                  globalArrows++; 
                  break;
               case '2' :
                  playerArray[2].arrows++;
                  globalArrows++; 
                  break;
               case '3' :
                  playerArray[3].arrows++;
                  globalArrows++; 
                  break;
               case '4' :
                  playerArray[4].arrows++;
                  globalArrows++; 
                  break;
               case '5' :
                  playerArray[5].arrows++;
                  globalArrows++; 
                  break;
               case '6' :
                  playerArray[6].arrows++;
                  globalArrows++; 
                  break;
               case '7' :
                  playerArray[7].arrows++; //the eigth ( and last possible ) player
                  globalArrows++; 
               default : //cancelling
                  return playerArray;
            }
            playerArray=kitCarlson(playerArray); //recursive
         }
         
      }
      
      return playerArray;
   }
   public static Player[] luckyDuke(Player[] playerArray, int times){ //may reroll. 
      if(times<4){
         System.out.print("\nUse Ability? Y or N? (Reroll, unless you reroll 4 times)");
         char luck = sc.next().charAt(0); //this is a new option
         if(luck=='Y'){
               playerArray[7].currentHand=dice.makeHand();
               playerArray[7].handAsText(playerArray[1].currentHand);
               playerArray=luckyDuke(playerArray, times+1);
            }
      }
      return playerArray; //can do this 4 times
   }
   public static Player[] paulRegret(Player[] playerArray, int attacking){  
      if(attacking!=playerArray[8].index){
         System.out.print("\nPlayer "+attacking+" uses gattling attack!");
         for(int i=0;i<playerArray.length;i++){
            if(i!=playerArray[8].index||i==attacking){
                  //playerArray[i].health--;
                  System.out.print("\nPlayer "+playerArray[i].index+" takes damage.");
               }
            else{
               System.out.print("\nPlayer "+playerArray[8].index+" takes no damage.");
            }
         }
         System.out.print("\nPlayer "+playerArray[8].index+" takes no damage from gattling gun.");
      }
      return playerArray; 
   }
   public static Player[] pedroRamirez(Player[] playerArray, int attacking, int attacked){  
      if(playerArray[9].index==attacked){ //if pedro was attacked
         System.out.print("\nPlayer "+9+" takes damage from player "+attacking);
         System.out.print("\nRemoving one arrow from player "+9);
         if(playerArray[9].arrows>0){
            playerArray[9].arrows--;
         }
      }
      return playerArray; 
   }
   public static Player[] roseDoolan(int currentPlayer, Player[] playerArray){
      int ones = 0;
      int twos = 0;
      int threes = 0;
      for(int i=0;i<playerArray[2].currentHand.length; i++){
         if(playerArray[2].currentHand[i]==3)
            ones++;
         if(playerArray[2].currentHand[i]==4)
            twos++;   
         if(playerArray[2].currentHand[i]==7)//threes as a 7th card type
            threes++;  
      }
      System.out.print("\n\nPlayer: "+currentPlayer+" (Rose Doolan's - Exchange 1' for 2's AND 2's for 3's)\n");
      System.out.print("\nUse Ability? Y or N? (Exchange 1' for 2's AND 2's for 3's) ");
      char ros = sc.next().charAt(0); 
      if((ones>0||twos>0)&&ros=='Y')
      {
         System.out.print("\nNumber of 1's: "+ones);
         System.out.print("\nNumber of 2's: "+twos);
         System.out.print("\nNumber of 3's: "+threes); //THREES are represented by the dice face "7"  which usually doesnt appear
         System.out.print("\nSwitch 1's to 2's (A.): ("+ones+")");
         System.out.print("\nSwitch 2's to 3's (B.): ("+twos+")");
         System.out.print("\nSwitch 3's to 2's (C.): ("+threes+")");
         System.out.print("\nCancel: N.");
         ros = sc.next().charAt(0); 
         if(ros=='A'){
            for(int i=0;i<playerArray[2].currentHand.length;i++){ //only does it to 1 at a time
               if(playerArray[2].currentHand[i]==3){
                  playerArray[2].currentHand[i]=4;
                  i=playerArray[2].currentHand.length;//aka stop looping
                  roseDoolan(currentPlayer, playerArray); //rerolls the method
               }
            }
         }
         if(ros=='B'){
            for(int i=0;i<playerArray[2].currentHand.length;i++){ //only does it to 1 at a time
               if(playerArray[2].currentHand[i]==4){
                  playerArray[2].currentHand[i]=7;
                  i=playerArray[2].currentHand.length;//aka stop looping
                  roseDoolan(currentPlayer, playerArray); //rerolls the method
               }
            }
         }
         if(ros=='C'){
            for(int i=0;i<playerArray[2].currentHand.length;i++){ //only does it to 1 at a time
               if(playerArray[2].currentHand[i]==7){
                  playerArray[2].currentHand[i]=4;
                  i=playerArray[2].currentHand.length;//aka stop looping
                  roseDoolan(currentPlayer, playerArray); //rerolls the method
               }
            }
         }
      }
   
      return playerArray;
   }
   public static Player[] sidKetchum(Player[] playerArray){  
      System.out.print("\nUse Ability? (Sid) Y or N? (Heal 1 Player)");
      char sid = sc.next().charAt(0); 
      if(sid=='Y'){
         System.out.print("\nWhich player would you like to heal?");
         for(int i=0;i<playerArray.length;i++){
            System.out.print("\n"+i+".");
         }
         int sid2 = sc.nextInt(); 
         
         playerArray[sid2].health++;
      }
      return playerArray; 
   }
   public static Player[] slabTheKiller(Player[] playerArray){  
      return playerArray; 
   }
   public static Player[] suzyLafayette(Player[] playerArray){  
      return playerArray; 
   }
   public static Player[] vultureSam(Player[] playerArray){  
      return playerArray; 
   }
   public static Player[] willyTheKid(Player[] playerArray){  
      return playerArray; 
   }
}

class Player {
	int health = 8;
	int character;
	int affiliation;
	int arrows = 0;
	boolean isHuman;
   boolean isIdentified= false; //added this
	int gatling = 0;
	int[] currentHand;
	String playerName;
   int index; //player number
	
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
   
   public String getName(int character)
	{
         String name;
			switch(character)
			{
			case 1:
				name = "Bart Cassidy";
				break;
			case 2:
				name = "Black Jack";
				break;
			case 3:
				name = "Calamity Janet";
				break;
			case 4:
				name = "El Gringo";
				break;
			case 5:
				name = "Jesse Jones";
				break;
			case 6:
				name = "Jourdonnais";
				break;
			case 7:
				name = "Kit Carlson";
				break;
			case 8:
				name = "Lucky Duke";
				break;
			case 9:
				name = "Paul Regret";
				break;
			case 10:
				name = "Pedro Ramirez";
				break;
			case 11:
				name = "Rose Doolan";
				break;
			case 12:
				name = "Sid Ketchum";
				break;
			case 13:
				name = "Slab The Killer";
				break;
			case 14:
				name = "Suzy Lafayette";
				break;
			case 15:
				name = "Vulture Sam";
				break;
			case 16:
				name = "Willy The Kid";
				break;
			default:
				name = "Player";
				break;
			}
         
         return name;
	}
   
	
	public void setAffiliation(int choice)
	{
		affiliation = choice;
	}
	
	public int shoot(Player player)
	{
		player.health -= 1;
		return player.health;
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
         isIdentified=true;
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
	
	public void handAsText(int[] hand)
	{
		System.out.print("\n{");
		for(int i =0; i < 5; i++)
		{
			switch(hand[i]) {
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

class Dice{
	int die1;
	int die2;
	int die3;
	int die4;
	int die5;
   int die6;
	
	public int[] makeHand() {
		int[] hand = {die1, die2, die3, die4, die5, die6};
		
		for(int i = 0; i < 5; i++) {
			hand[i] = (int) (Math.random() * (6)+1);
		}
		
		return hand;
	}
}
