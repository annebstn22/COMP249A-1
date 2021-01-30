import java.util.Scanner;
public class Playsnakeandladder {

	public static void main(String[] args) {
		final int NB_PLAYERS_MIN = 2;
		final int NB_PLAYERS_MAX = 4;
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);

		// User Input Validation 
		System.out.println("Enter amount of players :");
		int numPlayers = userInput.nextInt();
		while ((numPlayers < 2 || numPlayers > 4 ) ) {
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
		//Player[] playerArray = new Player[numPlayers];
		
		/*for (int i=0; i < numPlayers; i++) {
			playerArray[i] = new Player("player "+Integer.toString(i+1));
		}*/

		Players[] playersArray = new Players[numPlayers];

		for (int i=0; i < numPlayers; i++) {
			playersArray[i] = new Players("player "+Integer.toString(i+1));
		}

		//Players.flipNsort(playersArray, 0, playersArray.length-1);
		Players.printPlayerArray(playersArray);
		Players.orderPlayers(playersArray, 0, playersArray.length-1);
		Players.printPlayerArray(playersArray);

		System.out.println("you've chosen " + numPlayers + " players");
		
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
	

	 

