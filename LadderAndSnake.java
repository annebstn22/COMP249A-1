

public class LadderAndSnake{

    private final static int NB_DICE_FACES = 6;
    private final static int BOARD_SIZE = 10;
    private final static int NB_TILES = BOARD_SIZE*BOARD_SIZE;
    private final static int SNAKE_AND_LADDERS[][] = {{16,6}, {48,30}, {62,19}, {64,60}, {93,68}, {95,24}, {97,76}, {98,78},
                                                        {1,38},{4,14},{9,31},{21,42},{28,84},{36,44},{51,67},{71,91},{80,100}};

    private Tile[] ladderAndSnakeGrid = new Tile[NB_TILES]; 
    private Players[] players;
    private final static String snakeIcon = "S";
    private final static String ladderIcon = "L";

    //constructor with Players class
    public LadderAndSnake(Players[] players) {
        this.players = new Players [players.length];
        for (int i = 0; i < players.length; i++){
            this.players[i] = new Players(players[i].getPlayerName());
        }
        // add players to array "players"
    }

    //excluding snakes and ladders, this gets the tile player has landed on (before any snake ladder action if any)
    public int getEndPosition(int flipDice, int playerArrayPos){
        if (players[playerArrayPos].getBoardPos() + flipDice <= 100){
            return players[playerArrayPos].getBoardPos() + flipDice;
        } else {

            return (100 - (flipDice - (100-players[playerArrayPos].getBoardPos())));
        }
    }

    //random integer between 1 and 6
    static public int flipDice() {
        return (int) ((Math.random() * NB_DICE_FACES + 1));
    }

    public void buildGrid(){
        //loop to create grid of tiles numbered 1 - 100

        for (int i=0; i<NB_TILES; i++){
            ladderAndSnakeGrid[i] = new Tile(i+1, i+1);
            //System.out.print(ladderAndSnakeGrid[i].getTileNb()); //to check functioning well
        }

        for (int i=0; i<SNAKE_AND_LADDERS.length; i++){
            ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setEndTile(SNAKE_AND_LADDERS[i][1]);
            ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsActionTile(true);
            if (SNAKE_AND_LADDERS[i][0] < SNAKE_AND_LADDERS[i][1]){
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsLadder(true);
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setTileType(ladderIcon);
            } else {
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsSnake(true);
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setTileType(snakeIcon);
            }
        }
    }

    public void printGrid(){
        //--> figure out how to indicate if snake / ladder -- text? ladder --> 29 / snake --> 10
        boolean printRowLeft = true;
        System.out.println(" ----------------------------------------------------------------------------------");
        for (int i = BOARD_SIZE - 1; i>=0; i--){

            //TO DO: modify for loop to print players on tile
            

            // DECREASING ROWS i.e 100, 99, 98...
            if(printRowLeft){

                //PRINTS PLAYERS ON TILES 
                for (int j = 0; j<BOARD_SIZE; j++){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printPlayerName(currentTile);
                    
                }
                System.out.println("  |");

                // PRINTS ROW WITH NB OF TILE
                for (int j = 0; j<BOARD_SIZE; j++){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printNbRow(currentTile);
                }
                System.out.println("  |");

                //PRINTS ROW WITH ENDING TILE "->""
                for (int j = 0; j<BOARD_SIZE; j++){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printAction (currentTile);
                }
                printRowLeft = false;

            // INCREASING ROWS  i.e 1, 2, 3, 4...
            } else {
                //PRINTS PLAYERS ON TILES 
                for (int j = BOARD_SIZE - 1; j >=0; j--){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printPlayerName(currentTile);
                }
                System.out.println("  |");

                // PRINTS ROW WITH NB OF TILE
                for (int j = BOARD_SIZE - 1; j >=0; j--){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printNbRow(currentTile);
                }

                System.out.println("  |");

                //PRINTS ROW WITH ENDING TILE "->""
                for (int j = BOARD_SIZE - 1; j >=0; j--){
                    Tile currentTile = ladderAndSnakeGrid[10*(i+1)-j-1];
                    printAction(currentTile);
                }
                printRowLeft = true;
            }
            
            System.out.println("  |");
            System.out.println(" ----------------------------------------------------------------------------------");

            }
            
        }
        // method to print the tile number
    static private void printNbRow(Tile currentTile){
    System.out.print(" |  "+ currentTile.getTileNb()+ currentTile.getTileType());
                if (currentTile.getTileNb() <100){
                System.out.print(" ");
                }
                if (currentTile.getTileNb() <10){
                    System.out.print(" ");
                }
    }


    // method to print the name of player on tile
    static void printPlayerName(Tile currentTile){
        if (currentTile.getHasPlayer()){
            System.out.print(" |" + currentTile.getPlayerName());
        }
        else{
            System.out.print(" |      ");
        }

            currentTile.setHasPlayer(false);
    }
    // method to print the endtile 
    static private void printAction(Tile currentTile){
        if (currentTile.getIsActionTile()){
            System.out.print(" | ->"+ currentTile.getEndTile());
            if (currentTile.getEndTile()<100){
                System.out.print(" ");
            }
            if (currentTile.getEndTile()<10){
                System.out.print(" ");
            }
        }else {
            System.out.print(" |      ");
        }
    }

    public void play(){

        // playerOrder(); -- to be added later
        buildGrid();
        boolean winner = false;

        // play until winner
        do{
            for(int i=0;i<players.length; i++){

                //Variables
                int diceRoll = flipDice();
                int landingTile = getEndPosition(diceRoll, i) - 1;
                int endTile = ladderAndSnakeGrid[landingTile].getEndTile();
                String playerName = players[i].getPlayerName();
                
                //int playerBoardPos = players[i].getBoardPos();

                
                System.out.println("Board Position of " + playerName + " before: " + players[i].getBoardPos() );
                System.out.println(playerName + " rolled a " + diceRoll + ".");

                players[i].setBoardPos(endTile); // Change player position 

                //Check for action tile (snake or ladder)
                if (ladderAndSnakeGrid[landingTile].getIsActionTile()){ 
                    if (ladderAndSnakeGrid[landingTile].getIsSnake()){
                        System.out.println("Uh Oh Snake! Slither down to tile: " + ladderAndSnakeGrid[landingTile].getEndTile() );
                    } else if (ladderAndSnakeGrid[landingTile].getIsLadder()){
                        System.out.println("Youpi Ladder!!! Climb up to tile: " + ladderAndSnakeGrid[landingTile].getEndTile());
                    }
                } 

                System.out.println("Board Position of " + playerName + " after: " + players[i].getBoardPos());
                System.out.println(playerName + " has moved to position: " + endTile + ".");

                
                ladderAndSnakeGrid[endTile-1].setHasPlayer(true);
                ladderAndSnakeGrid[endTile-1].setPlayerName(playerName);
                

                if (endTile == 100){ //Check for winner
                    System.out.println(playerName + " won!");
                    winner = true;
                    break;
                } 
                System.out.println();
            }
            printGrid(); 
        } while (!winner);
        Playsnakeandladder.printEndScreen(); //display closing message


        

    }

}