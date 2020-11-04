import java.util.Scanner; //I know it should be GUI so we can change it later.

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
			System.out.println("Sheriff");
			break;
		case 1:
			System.out.println("Outlaw");
			break;
		case 2:
			System.out.println("Deputy");
			break;
		case 3:
			System.out.println("Renegade");
			break;
		}
	}
	
	public void handAsText(int[] hand)
	{
      boolean Saloon[] = {false,false, false, false, false, false};
      Scanner sc = new Scanner(System.in); //we can change this later
      System.out.println("\nUse Saloon Dice? 1. Yes 2. No");
      int option = sc.nextInt();
      if(option ==1)
         Saloon[0]=true;
      
       
      
		System.out.print("\n{");
		for(int i =0; i < 5; i++)
		{
			switch(hand[i]) {
			case 1:
            if(Saloon[i]==false)
				   System.out.print(" Arrow");
            else if(Saloon[i]==true)
               System.out.print(" *Break Arrow*");
				break;
			case 2:
            if(Saloon[i]==false)
				   System.out.print(" Dynamite");
            else if(Saloon[i]==true)
               System.out.print(" *Bullet*"); //hurts player so theres some risk
				break;
			case 3:
            if(Saloon[i]==true)
               System.out.print(" *Two*");
				System.out.print(" One-Space-Shot");
            
				break;
			case 4:
            if(Saloon[i]==true)
               System.out.print(" *Two*");
				System.out.print(" Two-Space-Shot");
            
				break;
			case 5:
            if(Saloon[i]==false)
				   System.out.print(" Beer");
            else if(Saloon[i]==true)
               System.out.print(" *Two* Beers");
				break;
			case 6:
            if(Saloon[i]==true)
               System.out.print(" *Two*");
				System.out.print(" Gatling Part");
            
				break;	
			}
			if(i<4)
				System.out.print(",");
		}
		System.out.print("}");
	}
   
   /*
	 * Method: getAbility()
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
   
   public boolean getAbility(int character){
         boolean resuse =false; //if they are allowed to reuse the abilty
         boolean active; //determines whether or not their ability is player controlled or automatic 
         switch(character)
			{
			case 1:
				System.out.println( "Bart Cassidy used his special ability!");
            System.out.println( "Added an arrow!");
            System.out.println( "Restored one health!");
				break;
			case 2:
				System.out.println( "Black Jack used his special ability!");
            System.out.println( "Re-rolled hand!");
            
            int numberOfDynamite = 0;
            for(int i=0;i<currentHand.length;i++){
               if(currentHand[i]==2){
                  numberOfDynamite++;
               }
            }
            if(numberOfDynamite>=3){
               System.out.println("\nAw, Rolled 3 dynamites! Too bad! Your turn ends!");
            }
            
				break;
			case 3:
				System.out.println( "Calamity Janet used her special ability!");
            System.out.println( "Converted 1 to a 2");
				break;
			case 4:
				System.out.println( "El Gringo used his special ability!");
            System.out.println( "Inflicted Arrow on Enemy Player!");
            
				break;
			case 5:
				System.out.println("Jesse Jones used his special ability!");
            System.out.println( "Doubled beer heal!");
            
				break;
			case 6:
				System.out.println("Jourdonnais used his special ability!");
            System.out.println( "Protected against arrows!"); //only lose up to 1 health
				break;
			case 7:
				System.out.println("Kit Carlson used his special ability!");
            System.out.println( "Removed arrow from ");
            
				break;
			case 8:
            int rerollCounter = 1;
				System.out.println("Lucky Duke used his special ability!");
            System.out.println( "Rerolled!"); // up to 4 times
            
				break;
			case 9:
				System.out.println("Paul Regret used his special ability!");
            System.out.println( "Protection against gattling guns!"); //completely
				break;
			case 10:
				System.out.println("Pedro Ramirez used his special ability!");
				break;
			case 11:
				System.out.println("Rose Doolan used her special ability!");
				break;
			case 12:
				System.out.println("Sid Ketchum used his special ability!");
				break;
			case 13:
				System.out.println("Slab The Killer used his special ability!");
				break;
			case 14:
				System.out.println("Suzy Lafayette used her special ability!");
				break;
			case 15:
				System.out.println("Vulture Sam used his special ability!");
				break;
			case 16:
				System.out.println("Willy The Kid used his special ability!");
				break;
			default:
				System.out.println("Player used their special ability!");
				break;
			}
         return resuse;

   }
