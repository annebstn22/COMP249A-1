/**
 * ------------------------------------------------------------------
 * Written by: Anne Bastien (40133471) and Julian Lussier (40131285)
 * COMP249
 * Assignment#1
 * Due Date: February 8th 2021
 * ------------------------------------------------------------------
 */

/**
 * The Tile class keeps track of the type of game board tile (normal, snake, ladder), the players on it and more.<br>
 * Attributes include: isAction Tile, isSnake, isLadder, hasPlayer, name of player on tile, tile number 
 * and end tile which depends on the presence of a snake head or the ladder bottom of a ladder.
 */

public class Tile {

    private int tileNb; // tile on grid
    public int endTile; // tile to move to if ladder or snake 
    private boolean isActionTile; // normal tile or snake/ladder tile --> automatically set to false?
    private boolean isSnake;
    private boolean isLadder;
    private String tileType; // " ", S or L
    private boolean hasPlayer; // first character of player name on tile
    private String playerName; // name of player on tile

    //CONSTRUCTORS

    /**
     * Tile constructor
     * 
     * @param tileNb integer - number of tile in board
     * @param endTile integer - tile at the end of snake or ladder
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
     * Tile default constructor
     */
    public Tile(){
        this.isActionTile = false;
        this.isLadder = false;
        this.isSnake = false;
        this.hasPlayer= false;
    }

    /**
     * Tile constructor 
     * @param tileNb integer - Tile number on the board
     */
    public Tile(int tileNb){
        this.isActionTile = false;
        this.tileNb = tileNb;
        this.endTile = tileNb;
        this.hasPlayer= false;
    }

    //Getters and Setters

    /**
     * Sets which player is on the Tile. <br>
     * Player name must be 6 characters to fit on the Tile when printed so spaces are either added or characters removed to fit 
     * length requirements.
     * @param playerName String - name of player
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
        else{                                               // if player's name exceeds tile character width of 6. ex: |elizab|eth   |
            this.playerName = playerName.substring(0,6);    //                                                         |  45  |  46  |
        }
    }

    /**
     * gets player name on tile.
     * @return - name of player on Tile
     */
    public String getPlayerName(){
        return playerName;
    }


    /**
     * checks if a player exists on that tile.
     * @return - true if has player or false if no player exists on that tile
     */
    public boolean getHasPlayer(){
        return hasPlayer;
    }

    /**
     * sets hasPlayer to true or false.
     * @param hasPlayer boolean - true or false
     */
    public void setHasPlayer(boolean hasPlayer){
        this.hasPlayer = hasPlayer;
    }

    /**
     * checks if its an action tile.
     * @return - boolean
     */
    public boolean getIsActionTile(){
        return isActionTile;
    }

    /**
     * sets isAction to true or false.
     * @param isAction boolean
     */
    public void setIsActionTile(boolean isAction){
        this.isActionTile = isAction;
    }

    /**
     * get tile number.
     * @return - tile number integer
     */
    public int getTileNb(){
        return tileNb;
    }

    /**
     * set tile number.
     * @param tileNb integer
     */
    public void setTileNb( int tileNb){
        this.tileNb = tileNb;
    }

  
    /**
     * get end tile.
     * @return end tile
     */
    public int getEndTile(){
        return endTile;
    }

    /**
     * set end tile.
     * @param endTile integer
     */
    public void setEndTile(int endTile){
        this.endTile = endTile;
    }

    /**
     * get whether snake head or not.
     * @return isSnake (true or false)
     */
    public boolean getIsSnake(){
        return isSnake;
    }

    /**
     * Set whether snake head or not.
     * @param isSnake boolean
     */
    public void setIsSnake(boolean isSnake){
        this.isSnake = isSnake;
    }

    /**
     * get whether ladder bottom or not.
     * @return isLadder (true or false)
     */
    public boolean getIsLadder(){
        return isLadder;
    }

    /**
     * set whether ladder bottom or not.
     * @param isLadder boolean
     */
    public void setIsLadder(boolean isLadder){
        this.isLadder= isLadder;
    }

    /**
     * gets the tile type.
     * @return the type of tile
     */
    public String getTileType(){
        return this.tileType;
    }

    /**
     * sets the tile type.
     * @param tiletype String
     */
    public void setTileType(String tileType){
        this.tileType = tileType;
    }
  
}
