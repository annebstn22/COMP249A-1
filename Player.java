import jdk.tools.jimage.resources.jimage;

public class Player {
	private int diceValue;
	private int boardPos;
	private String playerName; 
	
	public Player(String name) {
		diceValue = 0;
		boardPos = 0;
		playerName = name;
	}
	
	
	public static void playerOrder(Player[] players) {
		for (int i=0; i < players.length ; i++)
			players[i].flipDice();	
		
		sort(players);
		
		
		for (int i=0; i < players.length; i++) {
			System.out.println(players[i]);
		}
		
		int[][] checkArr = new int[6][5];
		for (int i=0; i < checkArr.length; i++) {
			for(int j=0; j < checkArr[0].length; j++){
			checkArr[i][j] = -1;
			}
		}
		

		
		for (int i=0; i< checkArr.length; i++) {
			int n=0;
			for (int j=0; j<players.length; j++) {
			
				if (players[j].getDiceValue() == (i+1)) {
				n++;
				checkArr[i][0]=n;
				checkArr[i][j+1]=j;
					}
					
				}
			}
			for (int i=0; i < checkArr.length; i++) {
				for(int j=0; j < checkArr[0].length; j++){
					if (checkArr[i][j] != -1)
				System.out.print(" " + checkArr[i][j] + " ");
				else 
				System.out.print( checkArr[i][j] + " ");
				}
				System.out.println();
			}
		}
	
	
	public int flipDice() {
		diceValue = (int)(Math.random()* 6)+1;
		return diceValue;
	}
	
	public int getDiceValue() {
		return diceValue;
	}
	public int getBoardPos() {
		return boardPos;
	}
	
	public static void sort(Player[] array) {
		for (int i=0; i < array.length-1; i++ ) {
			for (int j=0; j < array.length-i-1; j++) {
				if (array[j].getDiceValue() > array[j+1].getDiceValue()) {
					
					Player temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				
			}
		}
	}
	
	public String toString() {
		return playerName + " has dice value of " + getDiceValue();
	}
}