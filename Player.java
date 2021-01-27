

public class Player {
	private int diceValue;
	private int boardPos;
	private String playerName; 
	
	public Player(String name) {
		diceValue = 0;
		boardPos = 0;
		playerName = name;
	}
	
	
	public static void playerOrder(Player[] players) { // copy players to other player array
		
		for (int i=0; i < players.length ; i++)
			players[i].flipDice();	
		
		sort(players);
		
		
		for (int i=0; i < players.length; i++) {
			System.out.println(players[i]);
		}

					}

	
	public int flipDice() {
		diceValue = (int)(Math.random()* 6)+1;
		return diceValue;
	}
	
	public int getDiceValue() {
		return diceValue;
	}

	public void setBoardPos(int boardPos){
		this.boardPos = boardPos;
	}

	public int getBoardPos() {
		return boardPos;
	}

	public String getPlayerName(){
		return playerName;
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