

public class LadderAndSnake{

    private int nbPlayers;
    private final static int NB_DICE_FACES = 6;
    private final static int BOARD_SIZE = 10;
    private final static int NB_TILES = BOARD_SIZE*BOARD_SIZE;
    private final static int SNAKE_AND_LADDERS[][] = {{16,6}, {48,30}, {62,19}, {64,60}, {93,68}, {95,24}, {97,76}, {98,78},
                                                        {1,38},{4,14},{9,31},{21,42},{28,84},{36,44},{51,67},{71,91},{80,100}};

    // SNAKES_HEADS_AND_TAILS[0][0] --> snake 1's tile nb; 16 1
    // SNAKES_HEADS_AND_TAILS[0][1] --> snake 1s endTile; 6 38
    private Tile[] ladderAndSnakeGrid = new Tile[NB_TILES]; 
    private Player[] players;
    private boolean winner = false;
    private final static String snakeIcon = "S";
    private final static String ladderIcon = "L";


    public LadderAndSnake(int nbPlayers, Player[] players) {
        this.nbPlayers = nbPlayers;
        this.players = new Player[players.length];
        for (int i = 0; i < players.length; i++){
            this.players[i] = new Player(players[i].getPlayerName());
        }
        // add players to array "players"
    }

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

    public void playerOrder(){
        //figure out order of player
    }

    public void buildGrid(){
        //loop to create grid of tiles numbered 1 - 100

        for (int i=0; i<NB_TILES; i++){
            ladderAndSnakeGrid[i] = new Tile(i+1, i+1);
            //System.out.print(ladderAndSnakeGrid[i].getTileNb()); //to check functioning well
        }

        for (int i=0; i<SNAKE_AND_LADDERS.length; i++){
            ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setEndTile(SNAKE_AND_LADDERS[i][1]);
            ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsAction(true);
            if (SNAKE_AND_LADDERS[i][0] < SNAKE_AND_LADDERS[i][1]){
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsLadder(true);
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setTileType("L");
            } else {
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setIsSnake(true);
                ladderAndSnakeGrid[SNAKE_AND_LADDERS[i][0]-1].setTileType("S");
            }
        }

        //loop to set snakes

        //loop to set ladders
    }

    public void printGrid(){
        //--> figure out how to indicate if snake / ladder -- text? ladder --> 29 / snake --> 10
        boolean printRowLeft = true;
        for (int i = BOARD_SIZE - 1; i>=0; i--){
            if(printRowLeft){
                for (int j = 0; j<BOARD_SIZE; j++){
                    System.out.print(" { "+ ladderAndSnakeGrid[10*(i+1)-j-1].getTileNb()+ladderAndSnakeGrid[10*(i+1)-j-1].getTileType()+" } ");
                }
                printRowLeft = false;
            }else{
                for (int j = BOARD_SIZE - 1; j >=0; j--){
                    if (ladderAndSnakeGrid[10*(i+1)-j-1].getTileNb() < 10){
                        System.out.print(" { "+ ladderAndSnakeGrid[10*(i+1)-j-1].getTileNb()+ladderAndSnakeGrid[10*(i+1)-j-1].getTileType()+ "  } ");
                    }else{
                        System.out.print(" { "+ ladderAndSnakeGrid[10*(i+1)-j-1].getTileNb()+ ladderAndSnakeGrid[10*(i+1)-j-1].getTileType()+" } ");
                    }
                    printRowLeft = true;
                }
            }
            System.out.println();
        }

    }

    

    public void play(){

        // playerOrder(); -- to be added later
        buildGrid();
        boolean winner = false;
        do{
            for(int i=0;i<players.length; i++){
                int diceRoll = flipDice();
                int landingTile = getEndPosition(diceRoll, i) - 1;
                int endTile = ladderAndSnakeGrid[landingTile].getEndTile();
                System.out.println("Board Position before: " + players[i].getBoardPos());
                players[i].setBoardPos(endTile); // Change player position 
                System.out.println("Board Position after: " + players[i].getBoardPos());
                if (endTile == 100){
                    System.out.println( players[i].getPlayerName() + " won!");
                    winner = true;
                } else if (ladderAndSnakeGrid[landingTile].getIsAction()){
                    if (ladderAndSnakeGrid[landingTile].getIsSnake()){
                        System.out.println("Uh Oh Snake!");
                    } else if (ladderAndSnakeGrid[landingTile].getIsLadder()){
                        System.out.println("Youpi Ladder!!!");
                    }
                } 
                System.out.println(players[i].getPlayerName() + " rolled a " + diceRoll + ".");
                System.out.println(players[i].getPlayerName() + " has moved to position: " + endTile + ".");
                printGrid();
                

                //change current position to endTile of tile it moved too.
                //Check if winner
                    //If Yes:
                    //winner = true;
                    //break
                //checkIfAction --> actually no need can just change current position to endTile
                    //If action -- display specific message?
            }
        }while(!winner);

        //display closing message

    }

}