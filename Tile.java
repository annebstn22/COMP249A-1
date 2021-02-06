public class Tile {

    private int tileNb; // tile on grid
    public int endTile; // tile to move to if ladder or snake 
    private boolean isActionTile; // normal tile or snake/ladder tile --> automatically set to false?
    private boolean isSnake;
    private boolean isLadder;
    private String tileType;
    private boolean hasPlayer; // first character of player name on tile
    private String playerName; // name of player on tile

    //CONSTRUCTORS

    // this would work if were settings tile individually --> change such that can set all snakes at once and all ladders at once
    /**
     * Tile constructor
     * @param tileNb - number of tile in board
     * @param endTile - tile at the end of snake or ladder
     */
    public Tile(int tileNb, int endTile){
        this.tileNb = tileNb;
        this.endTile = endTile;
        this.hasPlayer= false;
        this.tileType = " ";
        if (tileNb == endTile){
            this.isActionTile = false; 
        } else {
            this.isActionTile = true;
        }
    }
    /**
     * Tile default cosntructor
     */
    public Tile(){
        this.isActionTile = false;
        this.isLadder = false;
        this.isSnake = false;
        this.hasPlayer= false;
    }
    /**
     * Tile constructor 
     * @param tileNb - number of tile in the board
     */
    public Tile(int tileNb){
        this.isActionTile = false;
        this.tileNb = tileNb;
        this.endTile = tileNb;
        this.hasPlayer= false;
    }

    //Getters and Setters
    public void setPlayerName(String playerName){
        if (playerName.length() == 6 ){
            this.playerName = playerName;
        }

        else if (playerName.length() < 6){
            this.playerName = playerName;
            for (int i=0 ; i < (6-playerName.length()) ; i++){
                this.playerName = this.playerName + " ";
            }
        }
        else{                                            // if player's name exceeds tile character width of 6. ex: |elizab|eth   |
            this.playerName = playerName.substring(0,6);    //                                                         |  45  |  46  |
    }
    }

    public String getPlayerName(){
        return playerName;
    }



    public boolean getHasPlayer(){
        return hasPlayer;
    }

    public void setHasPlayer(boolean hasPlayer){
        this.hasPlayer = hasPlayer;
    }


    public boolean getIsActionTile(){
        return isActionTile;
    }

    public void setIsActionTile(boolean isAction){
        this.isActionTile = isAction;
    }

    public int getTileNb(){
        return tileNb;
    }

    public void setTileNb( int tileNb){
        this.tileNb = tileNb;
    }

    public int getEndTile(){
        return endTile;
    }

    public void setEndTile(int endTile){
        this.endTile = endTile;
    }

    public boolean getIsSnake(){
        return isSnake;
    }

    public void setIsSnake(boolean isSnake){
        this.isSnake = isSnake;
    }

    public boolean getIsLadder(){
        return isLadder;
    }

    public void setIsLadder(boolean isLadder){
        this.isLadder= isLadder;
    }

    public String getTileType(){
        return this.tileType;
    }

    public void setTileType(String tileType){
        this.tileType = tileType;
    }
  
}
