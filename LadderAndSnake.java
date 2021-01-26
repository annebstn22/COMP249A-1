

public class LadderAndSnake{

    private int nbPlayers;
    private final static int NB_DICE_FACES = 6;
    private final static int BOARD_SIZE = 10;
    private final static int NB_TILES = BOARD_SIZE*BOARD_SIZE;
    private final static int NB_SNAKES = 8;
    private final static int NB_LADDERS = 9;
    private final static int SNAKE_HEADS_AND_TAILS[][] = new int[NB_SNAKES][2]; //to set all snake tiles at once
    private final static int LADDER_TOP_AND_BOTTOM[][] = new int[NB_LADDERS][2]; //to set all ladders tiles at once
    private Tile[] ladderAndSnakeGrid = new Tile[NB_TILES];
    private Player[] players;
    private boolean winner = false;


    public LadderAndSnake(int nbPlayers) {
        this.nbPlayers = nbPlayers;
        // add players to array "players"
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
            ladderAndSnakeGrid[i].setTileNb(i+1);
            ladderAndSnakeGrid[i].setEndTile(i+1);
            System.out.print(ladderAndSnakeGrid[i].getTileNb()); //to check functioning well
        }

        //loop to set snakes

        //loop to set ladders
    }

    public void printGrid(){
        //zig zag fun times
        //--> figure out how to indicate if snake / ladder -- text? ladder --> 29 / snake --> 10
    }


    public void play(){

        playerOrder();
        buildGrid();
        do{
            for(int i=0;i<players.length; i++){
                int diceRoll = flipDice();
                //getEndPosition
                //change current position to endTile of tile it moved too.
                //Check if winner
                    //If Yes:
                    //winner = true;
                    //break
                //checkIfAction --> actually no need can just change current position to endTile
                    //If action -- display specific message?
                printGrid();
            }
        }while(!winner);

        //display closing message

    }

}