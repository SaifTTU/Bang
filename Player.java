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

