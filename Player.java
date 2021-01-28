

public class Player {
	private int diceValue;
	private int boardPos;
	private String playerName; 
	
	
	public Player(String name) {
		diceValue = 0;
		boardPos = 0;
		playerName = name;
	}

	
	public Player (Player player){
		diceValue = player.getDiceValue();
		boardPos = player.getBoardPos();
		playerName = player.getPlayerName();
	}
	
	
	public static void playerOrder(Player[] array) { // copy players to other player array
		Player[] players = new Player[array.length];
		for (int i = 0; i < players.length; i++){
           players[i] = new Player(array[i]);
        }

		
		
		flipNsort(players);
		
		
		for (int i=0; i < players.length; i++) {
			System.out.println(players[i]);
		}
		System.out.println();

		

		
		for (int startPos =0; startPos < players.length ; startPos = startPos + subArray(players, startPos).length  )

			for (int i=0; i < subArray(players, startPos).length; i++) {
				System.out.print(subArray(players, startPos)[i] + " ");
				
			}
			
			
		


	




		/*
		Player[] PLAYERS = new Player[players.length];
		

		for (int i=0; i < players.length-1; i++ ) {
			for (int j=0; j < players.length-i-1; j++) {
				if (players[j] != players[j+1]){
					PLAYERS[i] = players[j];
				}
				else{
					for (int f=1 ; f < players.length ; f++ ){
						if (players[j] == players[j + (players.length -f)]){
							switch (players.length-2 +j){
								case 2:
									System.out.println("A tie was acheived between " + players[j] + " and " 
									+ players[j+1] + ". Attempting to break the tie.");
								case 3: 
									System.out.println("A tie was acheived between " + players[j] + " and " 
									+ players[j+1] + " and " + players[j+2]+ ". Attempting to break the tie.");
								case 4:
									System.out.println("A tie was acheived between " + players[j] + " and " 
									+ players[j+1] + " and " + players[j+2] + " and " + players[j+3] +". Attempting to break the tie.");

							}
							int g= players.length-f;
							Player[] tempPlayer = new Player[players.length-2 +j];
							for (int z=0; z < tempPlayer.length; z++){
								tempPlayer[z] = new Player(players[j+z]);
							}
							flipNsort(tempPlayer);
						}
					}
					
				}
			}
		}
*/
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

	public void setDiceValue(int diceValue){
		this.diceValue= diceValue;
	}

	public String getPlayerName(){
		return playerName;
	}
	

	public static boolean isTie(){
		return true;
	}


	public static Player[] subArray(Player[] array , int startPos ){
		
		
		
		int arraySize = 0;
		
		Player[] subPlayers = new Player[array.length];
		for (int i=0 ; i < subPlayers.length; i++){
		   subPlayers[i] = new Player(array[i]);
		}
		for (int i=1 ; i < subPlayers.length-(startPos+1); i++ ) {
			
				if ((subPlayers[startPos].getDiceValue() != subPlayers[startPos+i].getDiceValue() ) || ((startPos+i) == subPlayers.length) ){
					arraySize = i;
					
				}
					
		}
		Player[] subArr = new Player[arraySize];
		for (int i=0 ; i < arraySize; i++){
			subArr[i] = new Player(subPlayers[i]);
		 }

		 
		return subArr;
	}


	public static void flipNsort(Player[] array) {

		for (int i=0; i < array.length ; i++)
			array[i].flipDice();	

		for (int i=0; i < array.length-1; i++ ) {
			for (int j=0; j < array.length-i-1; j++) {
				if (array[j].getDiceValue() < array[j+1].getDiceValue()) {
					
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