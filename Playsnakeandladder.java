import java.util.Scanner;
public class Playsnakeandladder {

	public static void main(String[] args) throws InterruptedException {
		final int NB_PLAYERS_MIN = 2;
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);
		printWelcomeBanner();
		
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
		loadingIcon("Generating friends ...");
		
		loadingIcon("Ordering players...");
		
		Players.orderPlayers(playersArray, 0, playersArray.length-1);
		
		
		System.out.print("The final order of players is: \n- ");
        for (int i=0; i < playersArray.length ; i++) {
			System.out.print(playersArray[i].getPlayerName() + " - ");
		}
		System.out.println("\n\n----  Let's start the game!  ----\n");

		
		
		LadderAndSnake game = new LadderAndSnake(playersArray);

		game.play();


		userInput.close();
	}


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
	}

	public static void printEndScreen() {
				System.out.println("\n|<-------------------------------------------------------------------------------->|");
				System.out.println("|<-------------------------------->| GAME OVER |<--------------------------------->|");
				System.out.println("|<-------------------------------------------------------------------------------->|\n");
			}
			// elaborate welcome banner
	public static void printWelcomeBanner(){
		System.out.println("\n||<---------------------------------------------------------------------------------->||");
		System.out.println("||                           _______________________________        ('-__--__--.      ||");
		System.out.println("||                           | Welcome to Ladder and Snake |      (o)  (o)    \\       ||");
		System.out.println("||                           |-----------------------------|      / / /     _  '.     ||");
		System.out.println("||                                                              _/ / /    -' )   \\    ||");
		System.out.println("||       Authors:  Anne Bastien and Julian Lussier             / o   o  .'  /     )   ||");
		System.out.println("||       Date:  Feburary 8th 2021                             \\______-'   /    //|    ||");
		System.out.println("||       Course: COMP 249                 /___________/         \\/ \\/   .'  /_|/|     ||");
		System.out.println("||       Lab sections: ____ and G-X      /___________/                  .' /__|/|     ||");
		System.out.println("||                                      /___________/              \\/_/ /  |__|/|     ||");
		System.out.println("||                                     /___________/              /\\ _/    |__|/|     ||");
		System.out.println("||                                    /___________/      AND     /\\        \\__\\/\\     ||");
		System.out.println("||                                   /___________/       ---                 \\__\\/\\   ||");
		System.out.println("||                                  /___________/                              \\__\\/\\ ||");
		System.out.println("||                                 /___________/                                \\__\\/\\||");
		System.out.println("||                                /___________/                                  \\_\\/\\||");
		System.out.println("||<---------------------------------------------------------------------------------->||\n");
	}
	
	} 
	

	 

