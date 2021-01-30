

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
	
	
	public static void playerOrder(Player[] players) { 

		flipNsort(players);
		
	

		for (int i=0; i < players.length; i++) {
			System.out.println(players[i]);
		}
		System.out.println();


		Player[] finalSequence = new Player[players.length];

		for (int i=0; i < subArray(players, 0).length; i++) {
			System.out.println(subArray(players, 0)[i] + " .");
		
		}
		int startPos = 0;
		while (finalSequence[players.length-1] == null){
			furtherSort(subArray(players,startPos), finalSequence,startPos);
		}




		furtherSort(players, finalSequence,1);
/*
		int startPos =0;
		while ( startPos < players.length  ){
			int length = subArray(players, startPos).length;
			for (int i=0; i < subArray(players, startPos).length; i++) {
				System.out.print(subArray(players, startPos)[i] + " .");
				startPos = startPos + length ;
				
			}
		}
			
		*/


	




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



 	public void printDiceResults(Player[] array){


	for (int i=0; i < array.length; i++) {
		System.out.println(array[i]);
	}
	System.out.println();
	}




	private static Player[] subArray(Player[] array , int startPos ){
		
		
		
		
		
		Player[] subPlayers = new Player[array.length];
		for (int i=0 ; i < subPlayers.length; i++){
		   subPlayers[i] = new Player(array[i]);
		   
		}
		int arraySize = 1;
		while ( ((startPos+arraySize) < subPlayers.length) && (subPlayers[startPos].getDiceValue() == subPlayers[startPos+arraySize].getDiceValue() ))  {
            arraySize++;
		}
		Player[] subArr = new Player[arraySize];
		for (int k=0 ; k < arraySize; k++){
			subArr[k] = new Player(subPlayers[k]);
		 }

		 
		return subArr;
	}

 		private static boolean furtherSort(Player[] array, Player[] finalArray, int x) {
		
		if (array.length == 1){
			array[0] = finalArray[x];
			return true;
		}
		else if (array.length == 2){
			System.out.println("There is a tie between"+ array[0] +" and "+ array[1] + " . Attemmpting to break tie.");
			while (array[0] == array[1]){
				flipNsort(array);
			}
			array.printDiceResults();
			array[0] = finalArray[x];
			array[1] = finalArray[x+1];
			return true;
		}
		else {
			flipNsort(array);
			subArray(array, x);
			return false;
		}
	
	}








	 private static void flipNsort(Player[] array) {

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