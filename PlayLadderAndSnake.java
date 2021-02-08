
/**
 * ------------------------------------------------------------------
 * Written by: Anne Bastien (40133471) and Julian Lussier (insert ID)
 * COMP249
 * Assignment#1
 * Due Date: February 8th 2021
 * ------------------------------------------------------------------
 */

/**
 * PlayLadderAndSnake 
 * plays the ladder and snake game where 2 to 4 people roll a dice and move on up the board with the added chance of 
 * going up or down depending on whether they land on a ladder or snake respectively. <br> First to reach tile 100 wins!
 * @author Anne Bastien
 * @author Julian Lussier 
 * @version 1.0 Feb 5, 2021
 */

import java.util.Scanner;
public class PlayLadderAndSnake {

	public static void main(String[] args) throws InterruptedException {
		
		final int NB_PLAYERS_MIN = 2;
		int  numChances = 0;
		String playerLimit;
		int maxPlayers;
		String gameContinue = "y";
		String userName;
		Scanner userInput = new Scanner(System.in);
		
		printWelcomeBanner();
		System.out.print("\nPlease enter your name: ");
		userName = userInput.nextLine();
		
		do {

			//Offer normal (2-4 players) or extreme mode (4+ players)
			do{
				System.out.print( userName + ", Would you like to play extreme mode? (Y/N): \n");
				playerLimit = userInput.next();
				if (playerLimit.equals("Y") || playerLimit.equals("y") )
					maxPlayers = 100;
				else 
					maxPlayers = 4;
			} while(!(playerLimit.equals("Y") || playerLimit.equals("y") || playerLimit.equals("N") || playerLimit.equals("n")) );
		

			// User Input Validation - Allows 4 attempts then terminates
			System.out.print("Please enter amount of players (2-"+ maxPlayers + " players): ");
			int numPlayers = userInput.nextInt();
			while (numPlayers < NB_PLAYERS_MIN || numPlayers > maxPlayers) { 
				numChances++;
				
				if (numChances == 4) {
					System.out.println("You've run out of attempts");
					printEndScreen();
					System.exit(0);
				} else {
				System.out.println("Attempt (" + numChances + "/4). Invalid number of players.");
				numPlayers = userInput.nextInt();
				}
			}
		
			// Create Array of players with randomly generated player names
			Players[] playersArray = new Players[numPlayers];
			
			playersArray[0] = new Players(userName);

			for (int i=1; i < numPlayers; i++) {
				int x =(int)(Math.random()*100);
				playersArray[i] = new Players(Players.randNames[x]);
			}

			System.out.println("\nYou've chosen " + numPlayers + " players!\n");
			loadingIcon("Generating friends ...");
			
			//Players flip dice until player order is determined
			loadingIcon("Ordering players...");
			Players.orderPlayers(playersArray, 0, playersArray.length-1);
			
			System.out.print("The final order of players is: \n- ");
			for (int i=0; i < playersArray.length ; i++) {
				System.out.print(playersArray[i].getPlayerName() + " - ");
			}

			// Create and start game
			System.out.println("\n\n----  Let's start the game!  ----\n");
			
			LadderAndSnake game = new LadderAndSnake(playersArray);

			game.play();

			//Offer user to play again
			do { 
				System.out.print("\nDo you want to Play again? (y/n): ");
				gameContinue = userInput.next();
			} while (!(gameContinue.equals("y") || gameContinue.equals("Y") || gameContinue.equals("n") || gameContinue.equals("N")));
		
		} while (gameContinue.equals("Y") || gameContinue.equals("y"));

		// Closing message
		System.out.println("\nThe program has termintated\n");
		userInput.close();
	}
	/**
	 * provides a visual indication that the program is working
	 * @param word - sentence describing what is being calculated
	 * @throws InterruptedException
	 */

	public static void loadingIcon(String word) throws InterruptedException {
		System.out.println();
		for (int i=0; i < 9; i++){
			switch(i%4){
				case 0:
				System.out.print(word+"(|)\r");
				Thread.sleep(500);
				break;
				case 1:
				System.out.print(word+"(/)\r");
				Thread.sleep(500);
				break;
				case 2:
				System.out.print(word+"(-)\r");
				Thread.sleep(500);
				break;
				case 3:
				System.out.print(word+"(\\)\r");
				Thread.sleep(500);
				break;
			}
			
		}
		System.out.print(word + "(done)\r");
		System.out.println();
	}
	/**
	 * prints game over is a fashionable display to console
	 */
	public static void printEndScreen() {
		System.out.println("\n|<-------------------------------------------------------------------------------->|");
		System.out.println("|<-------------------------------->| GAME OVER |<--------------------------------->|");
		System.out.println("|<-------------------------------------------------------------------------------->|\n");
	}
			
	/**
	 * Prints an elaborate welcome banner to the program
	 */
	public static void printWelcomeBanner(){
		System.out.println("\n||<-----------------------------------------------/-----------/---------------------->||");
		System.out.println("||                           ____________________/__________ /      ('-__--__--.      ||");
		System.out.println("||                           | Welcome to Ladder and Snake |/      (o)  (o)    \\      ||");
		System.out.println("||                           |-----------------------------|      / / /     _  '.     ||");
		System.out.println("||                                           /___________/      _/ / /    -' )   \\    ||");
		System.out.println("||       Authors:  Anne Bastien and Julian Lussier______/      / o   o  .'  /     )   ||");
		System.out.println("||       Date:  Feburary 8th 2021          /___________/      \\______-'   /    //|    ||");
		System.out.println("||       Course: COMP 249                 /___________/         \\/ \\/   .'  /_|/|     ||");
		System.out.println("||       Lab sections:  L-X and G-X      /___________/                  .' /__|/|     ||");
		System.out.println("||                                      /___________/              \\/_/ /  |__|/|     ||");
		System.out.println("||                                     /___________/              / \\_/    |__|/|     ||");
		System.out.println("||                                    /___________/      AND     /\\        \\__\\/\\     ||");
		System.out.println("||                                   /___________/       ---                 \\__\\/\\   ||");
		System.out.println("||                                  /___________/                              \\__\\/\\ ||");
		System.out.println("||                                 /___________/                                \\__\\/\\||");
		System.out.println("||                                /___________/                                  \\_\\/\\||");
		System.out.println("||<------------------------------/-----------/--------------------------------------->||\n");
	}
	
	} 
	

	 

