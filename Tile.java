/**
 *
 * Class to define attributes of each tile on the board. <br>
 * Attributes include: isSnake, isLadder, hasPlayer, name of player on tile, tile number 
 * and end tile (dependant on whether it is the start of a snake or ladder.)
 */
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
    /**
     * sets which player name is on Tile. <br>
     * Player name must be 6 characters to fit in Tile when printed so spaces are either added or characters removed to fit 
     * length requirements.
     * @param playerName - name of player
     */
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
    /**
     * gets player name on tile
     * @return - name of player on Tile
     */
    public String getPlayerName(){
        return playerName;
    }


    /**
     * checks if a player exists on that tile 
     * @return - true if has player or false if no player exists on that tile
     */
    public boolean getHasPlayer(){
        return hasPlayer;
    }
    /**
     * sets hasPlayer to true or false
     * @param hasPlayer - true or false
     */
    public void setHasPlayer(boolean hasPlayer){
        this.hasPlayer = hasPlayer;
    }

    /**
     * checks if its an action tile
     * @return - boolean
     */
    public boolean getIsActionTile(){
        return isActionTile;
    }
    /**
     * sets isAction to true or false
     * @param isAction - boolean
     */
    public void setIsActionTile(boolean isAction){
        this.isActionTile = isAction;
    }

    /**
     * get tile number
     * @return - tile number integer
     */
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

    /**
     * gets the tile type
     * @return the type of tile
     */
    public String getTileType(){
        return this.tileType;
    }

    /**
     * sets the tile type
     * @param tiletype
     */
    public void setTileType(String tileType){
        this.tileType = tileType;
    }
  
}
