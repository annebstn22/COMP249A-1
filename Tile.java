public class Tile {

    private int tileNb; // tile on grid
    public int endTile; // tile to move to if ladder or snake 
    private boolean isActionTile; // normal tile or snake/ladder tile --> automatically set to false?
    private boolean isSnake;
    private boolean isLadder;
    private String tileType;

    //CONSTRUCTORS

    // this would work if were settings tile individually --> change such that can set all snakes at once and all ladders at once
    public Tile(int tileNb, int endTile){
        this.tileNb = tileNb;
        this.endTile = endTile;
        this.tileType = " ";
        if (tileNb == endTile){
            this.isActionTile = false; 
        } else {
            this.isActionTile = true;
        }
    }
    public Tile(){
        this.isActionTile = false;
        this.isLadder = false;
        this.isSnake = false;
    }

    public Tile(int tileNb){
        this.isActionTile = false;
        this.tileNb = tileNb;
        this.endTile = tileNb;
    }

    //Getters and Setters
    public boolean getIsAction(){
        return isActionTile;
    }

    public void setIsAction(boolean isAction){
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

    //Other Methods 
    // could omit for variables isSnake and isLadder above;
    /*public boolean checkForSnake(){
        boolean snake = false;
        if (endTile < tileNb){
            snake = true;
            // Display message
        }
        return snake;
    }

    public boolean checkForLadder(){
        boolean ladder = false;
        if (endTile > tileNb){
            ladder = true;
            // Display message
        }
        return ladder;
    }*/



    
}
