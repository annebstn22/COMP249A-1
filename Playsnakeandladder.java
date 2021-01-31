import java.util.Scanner;
public class Playsnakeandladder {

	public static void main(String[] args) {
		final int NB_PLAYERS_MIN = 2;
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.println("\n<--------------------------------->");
		System.out.println("  Welcome to Snakes And Ladders!");
		System.out.println("<--------------------------------->");
		System.out.println("Created by Anne Bastien and Julian Lussier");
		
		System.out.print("\nPlease enter your name: ");
		String userName = userInput.nextLine();
		String playerLimit;
		int maxPlayers;
		do{
			System.out.print( userName + ", Would you like to play extreme mode? (Y/N): \n");
			 playerLimit = userInput.next();
			if (playerLimit.equals("Y") || playerLimit.equals("y") )
		maxPlayers = 100;
	else 
		maxPlayers = 4;}while(!(playerLimit.equals("Y") || playerLimit.equals("y") || playerLimit.equals("N") || playerLimit.equals("n")) );
		

		// User Input Validation 
		System.out.print("Please enter amount of players (2-"+ maxPlayers + " players): ");
		int numPlayers = userInput.nextInt();
		while (numPlayers < NB_PLAYERS_MIN || numPlayers > maxPlayers) { // to change back
			numChances++;
			if (numChances == 4) {
				System.out.println("You've run out of attempts");
				printEndScreen();
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

	public static void printEndScreen() {
				System.out.println("\n|<---------------------------------------------------------->|");
				System.out.println("|<--------------------->| GAME OVER |<---------------------->|");
				System.out.println("|<---------------------------------------------------------->|\n");
			}
	} 
	

	 

