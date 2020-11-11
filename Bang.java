/*
 * This file is for the main game logic
 */

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Bang {
    static int players = 0; //number of players
    int arrows = 9; //Total arrows


    public static LinkedList < Player > makeTable() {

        Integer[] options = {
            4,
            5,
            6,
            7,
            8
        };
        int option = JOptionPane.showOptionDialog(null, "How many players?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);


        option += 4;
        //System.out.println(option);     

        LinkedList < Player > table = new LinkedList < Player > ();



        for (int i = 0; i < option; i++) {


            Player playerTemp = new Player();
            playerTemp.setPlayer(i, 1);
            table.add(playerTemp);
        }



        return table;
    }

    public static Player[] tableArray(LinkedList < Player > table) {
        Player[] tableArray = new Player[table.size()];
        int size = table.size();


        for (int i = 0; i < size; i++) {
            tableArray[i] = table.pop();
        }

        return tableArray;
    }

    public static void assignAffiliaton(Player[] table) {

        Integer[] positions = new Integer[table.length];


        if (table.length == 4) {
            positions[0] = 0; //makes sherrif
            positions[1] = 3; //makes Renegade
            positions[2] = 1; //makes outlaw
            positions[3] = 1;
        }
        if (table.length == 5) {
            positions[0] = 0;
            positions[1] = 3;
            positions[2] = 1;
            positions[3] = 1;
            positions[4] = 2; //makes deputy
        }
        if (table.length == 6) {
            positions[0] = 0;
            positions[1] = 3;
            positions[2] = 1;
            positions[3] = 1;
            positions[4] = 2;
            positions[5] = 1;
        }
        if (table.length == 7) {
            positions[0] = 0;
            positions[1] = 3;
            positions[2] = 1;
            positions[3] = 1;
            positions[4] = 2;
            positions[5] = 1;
            positions[6] = 2;
        }
        if (table.length == 8) {
            positions[0] = 0;
            positions[1] = 3;
            positions[2] = 1;
            positions[3] = 1;
            positions[4] = 2;
            positions[5] = 1;
            positions[6] = 2;
            positions[7] = 3;
        }

        List < Integer > posList = Arrays.asList(positions);
        Collections.shuffle(posList);
        posList.toArray(positions);
        //System.out.println(Arrays.deepToString(positions));	



        for (int i = 0; i < table.length; i++) {
            table[i].setAffiliation(positions[i]);
        }


    }


    public static void assignNames(Player[] table) {
        Integer[] names = new Integer[16];

        for (int i = 0; i < 16; i++) {
            names[i] = i + 1;
            //System.out.println(names[i]);
        }



        List < Integer > scrambledNames = Arrays.asList(names);
        Collections.shuffle(scrambledNames);
        scrambledNames.toArray(names);

        for (int i = 0; i < table.length; i++) {
            table[i].setName(names[i]);
        }

    }

    public static void randomizeTable(Player[] table) {
        table[0] = pickYourCharacter(table[0]);
        System.out.println(table[0].playerName);

        assignNames(table);
        assignAffiliaton(table);

        for (int i = 0; i < table.length; i++) {
            //System.out.println(table[i].playerName);
            table[i].dispAffiliation();
            System.out.print(" " + table[i].playerName + "\n");
        }

    }

    public static Player pickYourCharacter(Player player) {


        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 16; i++) {
            System.out.print("\n" + (i + 1) + ". ");
            System.out.print(player.getName(i + 1));

        }
        System.out.println("\nChoose your character:");


        int playerChoice = sc.nextInt();

        player.setPlayer(playerChoice, 1);
        //System.out.print("\n"+player.playerName+"\n");
        return player;
    }

    public static int[] getTarget(Player[] player, int players, int j, int distance) {


        int targetA;
        int targetB;
        if (j % players == 0)
            targetA = players - 1;
        else
            targetA = (j - distance + players) % players;
        targetB = (j + distance) % players;



        System.out.print("\nTarget A: " + player[targetA].playerName);
        if (player[targetA].isIdentified == false)
            System.out.print(" (unidentified)");
        else {
            System.out.print(" (");
            player[targetA].dispAffiliation();
            System.out.print(")");
        }

        System.out.print("\nTarget B: " + player[targetB].playerName);
        if (player[targetB].isIdentified == false)
            System.out.print(" (unidentified)");
        else {
            System.out.print(" (");
            player[targetB].dispAffiliation();
            System.out.print(")");
        }


        int[] targets = {
            targetA,
            targetB
        };
        return targets;

    }




    public static Player[] atkLogic(int[] hand, Player[] playerArray, int[] targets, int current) {
        int a = targets[0];
        if (a < 0) { //if c is negative
            a = playerArray.length + a;
        }
        int b = targets[1];
        int c = targets[0] - 1;
        int d = targets[1] + 1;
        if (c < 0) { //if c is negative
            c = playerArray.length - 1;
        }
        if (d > (playerArray.length - 1)) { //if d is bigger than array
            d = d % playerArray.length;
        }


        Random rand = new Random();

        for (int z = 0; z < hand.length; z++) {
            if (hand[z] == 3) {
                if (playerArray[current].affiliation == 0) { //Sherriff
                    if (playerArray[a].isIdentified == true) {
                        if (playerArray[a].affiliation != 2) {
                            System.out.print("\nSheriff Attacking ");
                            playerArray[a].dispAffiliation();
                            System.out.print(" " + playerArray[a].playerName);
                            playerArray[a].health--;
                        }
                    } else if (playerArray[b].isIdentified == true) {
                        if (playerArray[b].affiliation != 2) {
                            System.out.print("\nSheriff Attacking ");
                            playerArray[b].dispAffiliation();
                            System.out.print(" " + playerArray[b].playerName);
                            playerArray[b].health--;
                        }
                    }
                }
                if (playerArray[current].affiliation == 2) { //Deputy
                    if (playerArray[a].isIdentified == true) {
                        if (playerArray[a].affiliation != 0 || playerArray[a].affiliation != 2) { //if they are not Sheriff nor Deputy
                            System.out.print("\nDeputy Attacking ");
                            playerArray[a].dispAffiliation();
                            System.out.print(" " + playerArray[a].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[a].health--;
                        }
                    } else if (playerArray[b].isIdentified == true || playerArray[b].affiliation != 0) {
                        if (playerArray[b].affiliation != 0 || playerArray[b].affiliation != 2) { //if they are not Sheriff nor Deputy
                            System.out.print("\nDeputy Attacking ");
                            playerArray[b].dispAffiliation();
                            System.out.print(" " + playerArray[b].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[b].health--;
                        }
                    } else {
                        if (playerArray[current].isIdentified == false) //if neither known
                            playerArray[current].isIdentified = true;


                        int random = rand.nextInt(2);
                        System.out.print("\nDeputy Attacking ");
                        if (playerArray[targets[random]].isIdentified == true)
                            playerArray[targets[random]].dispAffiliation();
                        System.out.print(" " + playerArray[targets[random]].playerName);
                        playerArray[targets[random]].health--;

                    }
                }
                if (playerArray[current].affiliation == 1) { //Outlaw
                    if (playerArray[a].isIdentified == true) {
                        if (playerArray[a].affiliation == 0) {
                            System.out.print("\nOutlaw Attacking ");
                            playerArray[a].dispAffiliation();
                            System.out.print(" " + playerArray[a].playerName);
                            playerArray[current].isIdentified = true; //makes outlaw known
                            playerArray[a].health--;
                        }
                    } else if (playerArray[b].isIdentified == true) {
                        if (playerArray[b].affiliation == 0) {
                            System.out.print("\nOutlaw Attacking ");
                            playerArray[b].dispAffiliation();
                            System.out.print(" " + playerArray[b].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[b].health--;
                        }
                    }
                }

                if (playerArray[current].affiliation == 3) { //Renegade
                    if (playerArray[current].isIdentified == false)
                        playerArray[current].isIdentified = true;


                    int random = rand.nextInt(2);
                    System.out.print("\nAttacking ");
                    if (playerArray[targets[random]].isIdentified == true)
                        playerArray[targets[random]].dispAffiliation();
                    System.out.print(" " + playerArray[targets[random]].playerName);
                    playerArray[targets[random]].health--;
                }


            }

            if (hand[z] == 4) { //TWO SPACE SHOT - consider re-coding simpler later.
                if (playerArray[current].affiliation == 0) { //Sherriff
                    if (playerArray[c].isIdentified == true) {
                        if (playerArray[c].affiliation != 2) {
                            System.out.print("\nSheriff Attacking ");
                            playerArray[c].dispAffiliation();
                            System.out.print(" " + playerArray[c].playerName);
                            playerArray[c].health--;
                        }
                    } else if (playerArray[b].isIdentified == true) {
                        if (playerArray[d].affiliation != 2) {
                            System.out.print("\nSheriff Attacking ");
                            playerArray[d].dispAffiliation();
                            System.out.print(" " + playerArray[d].playerName);
                            playerArray[d].health--;
                        }
                    }
                }
                if (playerArray[current].affiliation == 2) { //Deputy
                    if (playerArray[c].isIdentified == true) {
                        if (playerArray[c].affiliation != 0 || playerArray[a].affiliation != 2) { //if they are not Sheriff nor Deputy
                            System.out.print("\nDeputy Attacking ");
                            playerArray[c].dispAffiliation();
                            System.out.print(" " + playerArray[a].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[c].health--;
                        }
                    } else if (playerArray[d].isIdentified == true || playerArray[b].affiliation != 0) {
                        if (playerArray[d].affiliation != 0 || playerArray[b].affiliation != 2) { //if they are not Sheriff nor Deputy
                            System.out.print("\nDeputy Attacking ");
                            playerArray[d].dispAffiliation();
                            System.out.print(" " + playerArray[b].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[d].health--;
                        }
                    } else { //if neither identified
                        if (playerArray[current].isIdentified == false)
                            playerArray[current].isIdentified = true;

                        int random2 = rand.nextInt(2);
                        int target = d;
                        if (random2 == 0)
                            target = c;
                        else if (random2 == 1)
                            target = d;

                        System.out.print("\nDeputy Attacking ");
                        if (playerArray[target].isIdentified == true)
                            playerArray[target].dispAffiliation();
                        System.out.print(" " + playerArray[target].playerName);
                        playerArray[target].health--;

                    }
                }
                if (playerArray[current].affiliation == 1) { //Outlaw
                    if (playerArray[c].isIdentified == true) {
                        if (playerArray[c].affiliation == 0) {
                            System.out.print("\nOutlaw Attacking ");
                            playerArray[c].dispAffiliation();
                            System.out.print(" " + playerArray[a].playerName);
                            playerArray[current].isIdentified = true; //makes outlaw known
                            playerArray[c].health--;
                        }
                    } else if (playerArray[d].isIdentified == true) {
                        if (playerArray[d].affiliation == 0) {
                            System.out.print("\nOutlaw Attacking ");
                            playerArray[d].dispAffiliation();
                            System.out.print(" " + playerArray[d].playerName);
                            playerArray[current].isIdentified = true;
                            playerArray[d].health--;
                        }
                    }
                }

                if (playerArray[current].affiliation == 3) { //Renegade
                    if (playerArray[current].isIdentified == false)
                        playerArray[current].isIdentified = true;



                    int random2 = rand.nextInt(2);
                    int target = d;
                    if (random2 == 0)
                        target = c;
                    else if (random2 == 1)
                        target = d;

                    System.out.print("\nAttacking ");
                    if (playerArray[target].isIdentified == true)
                        playerArray[target].dispAffiliation();
                    System.out.print(" " + playerArray[target].playerName);
                    playerArray[target].health--;


                }


            }
        }

        return playerArray;
    }

    public static Player[] healLogic(int[] hand, int j, Player[] tableArray) {
        int b = 0;

        Player player = tableArray[j];
        Player Sheriff = new Player();
        int sheriff = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 5) {
                if (player.affiliation == 0 || player.affiliation == 1 || player.affiliation == 3) { //heal self if these 3
                    System.out.print("Self +1 ");
                    b++;
                } else if (player.affiliation == 2) { //heal sheriff
                    System.out.print("Sheriff +1");
                    for (int k = 0; k < tableArray.length; k++) {
                        if (tableArray[k].affiliation == 0) {
                            sheriff = k;
                            Sheriff = tableArray[sheriff];
                            player.isIdentified = true; //Deputy is identified when healing the Sheriff
                        }
                    }
                    b++;
                }
            }
        }

        if (player.affiliation == 2) {
            Sheriff.health = Sheriff.health + b;
            tableArray[sheriff] = Sheriff;
            tableArray[j] = player;
            return tableArray;
        } else {
            player.health = player.health + b;
            tableArray[j] = player;
            return tableArray;
        }


    }

    public static void handLogic(int[] hand) { //Collected
        int a, b, d, g; //arrows, dynamite, gattling
        a = 0;
        b = 0;
        d = 0;
        g = 0;
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == 1)
                a++;
            if (hand[i] == 2)
                d++;
            if (hand[i] == 5)
                b++;
            if (hand[i] == 6)
                g++;
        }
        if (a != 0)
            System.out.print("+" + a + " Arrow, ");
        if (d != 0)
            System.out.print("+" + d + " Dynamite, ");
        if (g != 0)
            System.out.print("+" + g + " Gattling, ");
        if (b != 0)
            System.out.print("+" + b + " Beer, ");
    }

    public static void gameLoop(Player[] tableArray, Dice dice) {
        Player prev = new Player();
        Player next = new Player();
        int players = tableArray.length;

        System.out.print("\nOrder: \n");

        for (int i = 0; i < tableArray.length; i++) {
            System.out.print("\n" + (i + 1) + ". " + tableArray[i].playerName);
        }

        int j = 0;
        while (j != 10) {
            System.out.print("\n\nIt is: ");
            if (tableArray[j % players].isIdentified == true) {
                tableArray[j % players].dispAffiliation();
                System.out.print(": ");
            }
            System.out.print(tableArray[j % players].playerName + "'s turn. ");
            System.out.print(tableArray[j % players].health + "\n");
            System.out.print("\n1. Roll Dice | 2. Use Ability | 3. Use Dice | 4.Check Ability | 5. End Turn");
            System.out.print("\nThe Following Dice were rolled: ");
            int hand[] = dice.makeHand(); //
            tableArray[j % players].handAsText(hand);
            System.out.print("\nHealed: ");
            //tableArray[j%players].affiliation=2; //test to see if Deputies heal Sheriff
            tableArray = healLogic(hand, j % players, tableArray); //how to use beers, all except dep heal self
            System.out.print("\nCollected: ");
            handLogic(hand);
            System.out.print("\nLost: " + "" + " health.");
            System.out.print("\nUsed: " + "" + " ability.");
            int t[] = getTarget(tableArray, players, j % players, 1);
            System.out.print("\nAttacked: ");
            //for(int i=0;i<hand.length;i++){
            //if(hand[i]==2||hand[i]==3)
            tableArray = atkLogic(hand, tableArray, t, j % players);
            //}

            //getTarget(tableArray, players, j%players, 2);
            j++;
        }

        //return tableArray;
    }

    public static void main(String[] args) {
        Dice dice = new Dice();


        LinkedList < Player > table = new LinkedList < Player > ();
        table = makeTable();
        Player[] tableArray = tableArray(table);
        randomizeTable(tableArray);

        gameLoop(tableArray, dice);
    }

}
