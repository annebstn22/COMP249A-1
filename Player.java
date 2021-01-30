

public class Player {
	private int diceValue;
	private int boardPos;
	private String playerName; 
	public static int finalIndexPos=0;
	public static int subStartPos=0;
	
	
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
		
	
			printDiceResults(players);
		
		
		Player[] finalSequence = new Player[players.length];
		
		int startPos = 0;
		while (finalSequence[players.length-1] == null){
			
			Player[] subArray = new Player[subArray(players,startPos).length];
		for (int i=0 ; i < subArray.length; i++){
			subArray[i] = new Player(subArray(players,startPos)[i]);
			}

			do{

			furtherSort(subArray, finalSequence);
			if (furtherSort(subArray, finalSequence)){

				Player[] subSubArray = new Player[subArray(players,startPos).length];
		for (int i=0 ; i < subArray.length; i++){
			subSubArray[i] = new Player(subArray(players,startPos)[i]);
			}

			}
			} while(furtherSort(subArray, finalSequence));


			startPos= startPos + subArray.length;
		}

		System.out.println("Final starting order determined: ");
		for(int i=0; i<finalSequence.length;i++){
			System.out.print(finalSequence[i].getPlayerName() + ", ");
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

	public void setDiceValue(int diceValue){
		this.diceValue= diceValue;
	}

	public String getPlayerName(){
		return playerName;
	}
	

	public static boolean isTie(){
		return true;
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

 		 static boolean furtherSort(Player[] array, Player[] finalArray) {
			  
		
		if (array.length == 1){
			array[0] = finalArray[finalIndexPos];
			finalIndexPos++;
			return false;
		}
		else if (array.length == 2){

			System.out.println("There is a tie between "+ array[0].getPlayerName() +" and "+ array[1].getPlayerName() + 
			" . Attemmpting to break tie.");
			while (array[0].getDiceValue() == array[1].getDiceValue()){
				flipNsort(array);
			}
			printDiceResults(array);
			array[0] = finalArray[finalIndexPos];
			
			array[1] = finalArray[finalIndexPos+1];
			finalIndexPos = finalIndexPos +2;;
			return false;
		}
		else {
			System.out.println("There is a tie between ");
			for (int i=0; i< array.length; i++){
				System.out.print(array[i].getPlayerName() + " and ");
			}
			System.out.print(" . Attempting to break tie.");

			flipNsort(array);
			
			return true;
		}
	
	}


	private static void printDiceResults(Player[] array){


		for (int i=0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
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