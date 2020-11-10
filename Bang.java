/*
 * This file is for the main game logic
 */

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;


public class Bang {
	static int players =0; //number of players
	int arrows = 9; //Total arrows
	
	
	 public static LinkedList<Player> makeTable(){
         
         Integer[] options = {4, 5, 6, 7, 8};
         int option = JOptionPane.showOptionDialog(null, "How many players?",null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,null);
         
         
         option += 4;
         //System.out.println(option);     
         
         LinkedList<Player> table = new LinkedList<Player>();
         
        
         
         for(int i =0; i < option; i++)
         {
             

              	Player playerTemp = new Player();
           		playerTemp.setPlayer(i, 1);
              	table.add(playerTemp);
         }
         
         
         
         return table;
    }
	 
	 public static Player[] tableArray(LinkedList<Player> table)
	 {
		 Player[] tableArray = new Player[table.size()];
		 int size = table.size();
		 
		 
		 for(int i = 0; i < size; i++)
		 {
			 tableArray[i] = table.pop();
		 }
		 
		 return tableArray;
	 }
	
	public static void assignAffiliaton(Player[] table)
	{
		
		Integer[] positions = new Integer[table.length];
		
		
		if(table.length == 4)
		{
			positions[0] = 0;//makes sherrif
			positions[1] = 3;//makes Renegade
			positions[2] = 1;//makes outlaw
			positions[3] = 1;
		}
		if(table.length == 5)
		{
			positions[0] = 0;
			positions[1] = 3;
			positions[2] = 1;
			positions[3] = 1;
			positions[4] = 2;//makes deputy
		}
		if(table.length == 6)
		{
			positions[0] = 0;
			positions[1] = 3;
			positions[2] = 1;
			positions[3] = 1;
			positions[4] = 2;
			positions[5] = 1;
		}
		if(table.length == 7)
		{
			positions[0] = 0;
			positions[1] = 3;
			positions[2] = 1;
			positions[3] = 1;
			positions[4] = 2;
			positions[5] = 1;
			positions[6] = 2;
		}
		if(table.length == 8)
		{
			positions[0] = 0;
			positions[1] = 3;
			positions[2] = 1;
			positions[3] = 1;
			positions[4] = 2;
			positions[5] = 1;
			positions[6] = 2;
			positions[7] = 3;
		}
		
		List<Integer> posList = Arrays.asList(positions);
		Collections.shuffle(posList);
		posList.toArray(positions);
		//System.out.println(Arrays.deepToString(positions));	
		
		
		
		for(int i =0; i < table.length; i++)
		{
			table[i].setAffiliation(positions[i]);
		}
		
		
	}
	
	
	public static void assignNames(Player[] table)
	{
		Integer[] names = new Integer[16];
		
		for(int i = 0; i < 16; i++)
		{
			names[i] = i+1;
			//System.out.println(names[i]);
		}
		
		
		
		List<Integer> scrambledNames = Arrays.asList(names);
		Collections.shuffle(scrambledNames);
		scrambledNames.toArray(names);
		
		for(int i =0; i < table.length; i++)
		{
			table[i].setName(names[i]);
		}
		
	}
	
	public static void randomizeTable(Player[] table)
	{
      table[0]=pickYourCharacter(table[0]);
      System.out.println(table[0].playerName);
      
		assignNames(table);
		assignAffiliaton(table);
		
		for(int i =0; i < table.length; i++)
		{
			//System.out.println(table[i].playerName);
			table[i].dispAffiliation();
			System.out.print(" " + table[i].playerName+ "\n");
		}
		
	}
   
   public static Player pickYourCharacter(Player player){
      
      
      Scanner sc = new Scanner(System.in);
      
      for(int i=0;i<16;i++){
         System.out.print("\n"+(i+1)+". ");
         System.out.print(player.getName(i+1));
         
      }
      System.out.println("\nChoose your character:");
      
       
      int playerChoice = sc.nextInt();
      
      player.setPlayer(playerChoice, 1);
      //System.out.print("\n"+player.playerName+"\n");
      return player;
   }
	
   public static void gameLoop(Player[] tableArray){
      int players = tableArray.length;
   
      System.out.print("\nOrder: \n");
      
      for(int i=0;i<tableArray.length;i++){
         System.out.print("\n"+(i+1)+". "+tableArray[i].playerName);
      }
      
      int j = 0;
      while(j!=10){
         System.out.print("\n\nIt is: ");
         if(tableArray[j%players].isIdentified==true){
            tableArray[j%players].dispAffiliation();
            System.out.print(": ");
         }
         System.out.print(tableArray[j%players].playerName+"'s turn.\n");
         System.out.print("\n1. Roll Dice | 2. Use Ability | 3. Use Dice | 4.Check Ability | 5. End Turn");
         System.out.print("\nThe Following Dice were rolled: ");
         System.out.print("\nAttacked: ");
         System.out.print("\nHealed: ");
         System.out.print("\nCollected: ");
         System.out.print("\nLost: "+""+" health.");
         System.out.print("\nUsed: "+""+" ability.");
         j++;
      }
      
      //return tableArray;
   }
	
	public static void main(String[] args) {
		Dice dice = new Dice();
		

		LinkedList<Player> table = new LinkedList<Player>();
		table = makeTable();
		Player[] tableArray = tableArray(table);
		randomizeTable(tableArray);
      
      gameLoop(tableArray);
	}

}
