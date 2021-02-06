public class Players {
     
    private int diceValue; //between 1 and 6 inclusively
    private int boardPos; //between 1 and 100 inclusively
    private String playerName;

    //constructor
    /**
     * players constructor
     * sets dice value and board position to 0
     * @param playerName - name of player
     */
    public Players(String playerName) {
        this.diceValue = 0;
        this.boardPos = 0;
        this.playerName = playerName;
     }

   //copy constructor
/**
 * Players copy constructor 
 * @param player 
 */

   public Players (Players player){
       this.diceValue = player.getDiceValue();
       this.boardPos = player.getBoardPos();
       this.playerName = player.getPlayerName();
   }

   // array for random name generator

   
  

   public static String[] randNames = {"James","Mary","John","Patricia","Robert","Jennifer","Linda","Elizabeth","David","Barbara", 
   "William", "Michael",
   "Erica","Richard","Joseph","Thomas","Charles","Christopher","Susan","Jessica","Sarah","Karen","Nancy","Lisa","Daniel",
   "Matthew","Anthony","Donald","Mark","Margaret","Betty","Sandra","Ashley","Dorothy","Kimberly","Emily","Donna","Michelle",
   "Carol","Amanda","Melissa","Deborah","Stephanie","Rebecca","Laura","Sharon","Cynthia","Mindy","Anne","Julian","Laika","Kathleen",
   "Amy","Shirley","Angela","Helen","Anna","Brenda","Pamela","Nicole","Samantha","Katherine","Emma","Christine","Catherine","Debra",
   "Rachel","Carolyn","Janet","Virginia","Matthew","Anthony","Donald","Mark","Paul","Steven","Andrew","Kenneth","Joshua","Kevin",
   "Brian","George","Edward","Ronald","Timothy","Jason","Jeffrey","Ryan","Jacob","Gary","Nicholas","Eric","Jonathan","Stephen",
   "Larry","Justin","Scott","Brandon","Benjamin","Samuel","Ruth","Frank","Gregory","Raymond","Alexander","Patrick" };

  

   /**
    * Flips dice
    */

   public void flipDice() {
       this.diceValue = (int) ((Math.random() * 6 + 1));
    }

    
    /**
     * Flips all players in array and sorts in decreasing order
     * 
     * @param gamePlayers
     * @param startPos
     * @param endPos
     */
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

    /**
     * breaks ties between players and reorders them
     * 
     * @param gamePlayers
     * @param start
     * @param end
     */

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
   /**
    * gets dice value
    * @return the dice value
    */
    public int getDiceValue(){
       return this.diceValue;
    }

    /**
     * sets dice value
     * @param diceValue
     */
    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }
    

    /**
     * gets board position
     * @return  board position
     */
    public int getBoardPos(){
        return this.boardPos;
    }

    /**
     * sets board position
     * @param boardPos
     */
    public void setBoardPos(int boardPos){
        this.boardPos = boardPos;
    }

    /**
     * gets player name
     * @return name of player
     */
    public String getPlayerName(){
        return this.playerName;
    }

    /**
     * sets player name
     * @param playerName
     */
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    /**
     * prints all players from array of player objects to console
     * @param gamePlayers
     */
    static public void printPlayerArray (Players[] gamePlayers){
        for (int i=0; i < gamePlayers.length ; i++) {
			System.out.println(gamePlayers[i]);
		
        }
        System.out.println();
    }
    /**
     * toString method 
     * @return player name has dice value of x
     */
    public String toString() {
		return playerName + " has dice value of " + getDiceValue();
	}
}
