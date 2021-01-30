public class Players {
    private int diceValue; //between 1 and 6 inclusively
    private int boardPos; //between 1 and 100 inclusively
    private String playerName;

    //constructor
    public Players(String playerName) {
        this.diceValue = 0;
        this.boardPos = 0;
        this.playerName = playerName;
     }

   //copy constructor
   public Players (Players player){
       this.diceValue = player.getDiceValue();
       this.boardPos = player.getBoardPos();
       this.playerName = player.getPlayerName();
   }

   // array for random name generator

   public static String[] randNames = {"James","Mary","John","Patricia","Robert","Jennifer","Linda","Elizabeth","David","Barbara", "William", "Michael",
   "William","Richard","Joseph","Thomas","Charles","Christopher","Susan","Jessica","Sarah","Karen","Nancy","Lisa","Daniel",
   "Matthew","Anthony","Donald","Mark","Margaret","Betty","Sandra","Ashley","Dorothy","Kimberly","Emily","Donna","Michelle",
   "Carol","Amanda","Melissa","Deborah","Stephanie","Rebecca","Laura","Sharon","Cynthia","Mindy","Anne","Julian","Laika","Kathleen",
   "Amy","Shirley","Angela","Helen","Anna","Brenda","Pamela","Nicole","Samantha","Katherine","Emma","Christine","Catherine","Debra",
   "Rachel","Carolyn","Janet","Virginia","Matthew","Anthony","Donald","Mark","Paul","Steven","Andrew","Kenneth","Joshua","Kevin",
   "Brian","George","Edward","Ronald","Timothy","Jason","Jeffrey","Ryan","Jacob","Gary","Nicholas","Eric","Jonathan","Stephen",
   "Larry","Justin","Scott","Brandon","Benjamin","Samuel","Ruth","Frank","Gregory","Raymond","Alexander","Patrick" };

  



   public void flipDice() {
       this.diceValue = (int) ((Math.random() * 6 + 1));
    }

    //method to randomly flipDice -- assign 
    //player a diceValue and then sort in descending order
    public static void flipNsort(Players[] gamePlayers, int startPos, int endPos){

        //concerned players flip their dice
        for (int i = startPos; i <= endPos; i++){
            gamePlayers[i].flipDice();
        }

        //sort players in decreasing order
        for (int i = startPos; i <= endPos - 1; i++){
            for (int j = i + 1; j <= endPos; j++){
                if (gamePlayers[i].getDiceValue() < gamePlayers[j].getDiceValue()){
                    Players temp = gamePlayers[i];
                    gamePlayers[i]=gamePlayers[j];
                    gamePlayers[j] = temp;
                }
            }
        }
    }

    public static void orderPlayers(Players[] gamePlayers, int start, int end){

        int startPos = start;
        int endPos = start;

        flipNsort(gamePlayers, start, end);
        System.out.println("Current player order: ");
        printPlayerArray(gamePlayers);

        for (int i = startPos; i < end; i = startPos){

            // increment endPos each time two consecutive terms are identical. loop until endPos is the index of the last consecutive term
            if (endPos < end){
                while(endPos != end && gamePlayers[startPos].getDiceValue() == gamePlayers[endPos+1].getDiceValue()){
                    endPos++;
                } 
            }

            if (startPos == endPos ){ // move to next index if no duplicates
                //if (endPos < end){ // check that not at end of array
                    startPos = endPos+1;
                    endPos = startPos;
            } else { // order portion of array with duplicates then move to following index
                System.out.println("There is a tie between ");
			    for (int k=startPos; k< endPos; k++){
				System.out.print(gamePlayers[k].getPlayerName() + ", ");
                }

                System.out.println(" and " + gamePlayers[endPos].getPlayerName()+".\n");
			    System.out.print("Attempting to break tie.\n\n");
                orderPlayers(gamePlayers, startPos, endPos);
                System.out.println("Tie broken with:");
                for (int k=startPos; k<= endPos; k++){
                    System.out.println(gamePlayers[k] + " ");
                    }
                System.out.println();
                startPos = endPos + 1;
                endPos = startPos;
            }
            System.out.println();
        }
    }

   // getters and setters
   
    public int getDiceValue(){
       return this.diceValue;
    }

    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }
    
    public int getBoardPos(){
        return this.boardPos;
    }

    public void setBoardPos(int boardPos){
        this.boardPos = boardPos;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    static public void printPlayerArray (Players[] gamePlayers){
        for (int i=0; i < gamePlayers.length ; i++) {
			System.out.println(gamePlayers[i]);
		
        }
        System.out.println();
    }

    public String toString() {
		return playerName + " has dice value of " + getDiceValue();
	}
}
