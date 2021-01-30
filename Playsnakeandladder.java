import java.util.Scanner;
public class Playsnakeandladder {

	public static void main(String[] args) {
		final int NB_PLAYERS_MIN = 2;
		final int NB_PLAYERS_MAX = 4;
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\nWelcome to Snakes And Ladders!\n");

		// User Input Validation 
		System.out.println("Please enter amount of players (2-4 players):");
		int numPlayers = userInput.nextInt();
		while (numPlayers < NB_PLAYERS_MIN || numPlayers > NB_PLAYERS_MAX) { // to change back
			numChances++;
			if (numChances == 4) {
				System.out.println("You've run out of chances");
				System.exit(0);
			}
			else {
			System.out.println("Attempt (" + numChances + "/4). Invalid number of players.");
			numPlayers = userInput.nextInt();
			}
		}
		
		// Create array of players
		Player[] playerArray = new Player[numPlayers];
		
		for (int i=0; i < numPlayers; i++) {
			playerArray[i] = new Player("Player "+Integer.toString(i+1));
		}

		Players[] playersArray = new Players[numPlayers];

		for (int i=0; i < numPlayers; i++) {
			playersArray[i] = new Players("Player "+Integer.toString(i+1));
		}

		//Players.flipNsort(playersArray, 0, playersArray.length-1);
		//Players.printPlayerArray(playersArray);

		System.out.println("\nYou've chosen " + numPlayers + " players!\n");
		System.out.println("Ordering players...\n");
		Players.orderPlayers(playersArray, 0, playersArray.length-1);
		
		
		System.out.print("The final order of players is: \n- ");
        for (int i=0; i < playersArray.length ; i++) {
			System.out.print(playersArray[i].getPlayerName() + " - ");
		}
		System.out.println("\n\n----  Let's start the game!  ----\n");

		
		
		//LadderAndSnake game = new LadderAndSnake(numPlayers, playerArray);

		//game.play();


		/* Player.playerOrder(playerArray);
		System.out.println();
		for (int i=0; i < numPlayers; i++) {
			System.out.println(playerArray[i]);
		
		}*/

		userInput.close();
	}
	
					
			
	} 
	

	 

