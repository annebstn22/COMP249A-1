import java.util.Scanner;
public class Playsnakeandladder {

	public static void main(String[] args) {
		final int NB_PLAYERS_MIN = 2;
		final int NB_PLAYERS_MAX = 4;
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);

		System.out.println("\nWelcome to Snakes And Ladders!\n");

		System.out.print("\nPlease enter your name: \n");
		String userName = userInput.nextLine();

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
		Players[] playersArray = new Players[numPlayers];
		
		playersArray[0] = new Players(userName);

		for (int i=1; i < numPlayers; i++) {
			int x =(int)(Math.random()*100);
			playersArray[i] = new Players(Players.randNames[x]);
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

		
		
		LadderAndSnake game = new LadderAndSnake(playersArray);

		game.play();


		/* Player.playerOrder(playerArray);
		System.out.println();
		for (int i=0; i < numPlayers; i++) {
			System.out.println(playerArray[i]);
		
		}*/

		userInput.close();
	}
	
					
			
	} 
	

	 

