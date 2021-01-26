import java.util.Scanner;
public class PlayLadderAndSnake {

	
	public static void main(String[] args) {
		int  numChances = 0;
		Scanner userInput = new Scanner(System.in);
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
		
		Player[] playerArray = new Player[numPlayers];
		
		for (int i=0; i < numPlayers; i++) {
			playerArray[i] = new Player("player"+Integer.toString(i+1));
		}
			
		System.out.println("you've chosen " + numPlayers + " players");
		
		GameBoard newBoard = new GameBoard();
		newBoard.printBoard();
		
		Player.playerOrder(playerArray);
		System.out.println();
		for (int i=0; i < numPlayers; i++) {
			System.out.println(playerArray[i]);
		
		}
	}
	
	



	public void play() {
		
	}
					
			
	}
	

	 

