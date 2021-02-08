/**
 * ------------------------------------------------------------------
 * Written by: Anne Bastien (40133471) and Julian Lussier (insert ID)
 * COMP249
 * Assignment#1
 * Due Date: February 8th 2021
 * ------------------------------------------------------------------
 */

/**
 * The Players class defines a Ladder and Snake player who has a name, board position and current dice value.
 * Players can flip the dice, sort players and break ties.
 */

public class Players {
     
    private int diceValue; //between 1 and 6 inclusively
    private int boardPos; //between 1 and 100 inclusively
    private String playerName;

    //CONSTRUCTORS

    /**
     * Players constructor using player name
     * sets dice value and board position to 0.
     * @param playerName String - name of player
     */
    public Players(String playerName) {
        this.diceValue = 0;
        this.boardPos = 0;
        this.playerName = playerName;
     }

    /**
     * Players copy constructor 
     * @param player Players 
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
    * Flips dice and sets players diceValue to rolled number.
    * Used for when ordering the players
    */
   public void flipDice() {
       this.diceValue = (int) ((Math.random() * 6 + 1));
    }

    /**
     * Flips all players in array and sorts in decreasing order.
     * 
     * @param gamePlayers Players[]
     * @param startPos integer start index
     * @param endPos integer end index
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
     * Breaks ties between players and reorders them.
     * @param gamePlayers Players[] 
     * @param start integer start index
     * @param end integer end index
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

            if (startPos == endPos ){ 
                // move to next index if no duplicates
                startPos = endPos+1;
                endPos = startPos;
            } else { 
                // order portion of array with duplicates then move to following index

                //Narrate ordering of players
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

                //Increment indexes
                System.out.println();
                startPos = endPos + 1;
                endPos = startPos;
            }
            System.out.println();
        }
    }

   // Getters and Setters

   /**
    * gets dice value.
    * @return the dice value
    */
    public int getDiceValue(){
       return this.diceValue;
    }

    /**
     * sets dice value.
     * @param diceValue integer
     */
    public void setDiceValue(int diceValue){
        this.diceValue = diceValue;
    }
    
    /**
     * gets board position.
     * @return  board position
     */
    public int getBoardPos(){
        return this.boardPos;
    }

    /**
     * sets board position.
     * @param boardPos integer
     */
    public void setBoardPos(int boardPos){
        this.boardPos = boardPos;
    }

    /**
     * gets player name.
     * @return name of player
     */
    public String getPlayerName(){
        return this.playerName;
    }

    /**
     * sets player name.
     * @param playerName String
     */
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    /**
     * prints all players from array of player objects to console.
     * @param gamePlayers Players[]
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
