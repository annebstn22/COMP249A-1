public class Tile {

    private int tileNb; // tile on grid
    public int endTile; // tile to move to if ladder or snake 
    private boolean isAction; // normal tile or snake/ladder tile

    // this would work if were settings tile individually --> change such that can set all snakes at once and all ladders at once
    public Tile(int tileNb, int endTile){
        this.tileNb = tileNb;
        this.endTile = endTile;
        if (tileNb == endTile){
            this.isAction = false; 
        } else {
            this.isAction = true;
        }
    }

    public Tile(int tileNb){
        this.isAction = false;
        this.tileNb = tileNb;
        this.endTile = tileNb;
    }

    public boolean getIsAction(){
        return isAction;
    }

    public void setIsAction(boolean isAction){
        this.isAction = isAction;
    }

    public int getTileNb(){
        return tileNb;
    }

    public void setTileBb( int tileNb){
        this.tileNb = tileNb;
    }

    public int getEndTile(){
        return endTile;
    }

    public void setEndTile(int endTile){
        this.endTile = endTile;
    }

    public boolean checkForSnake(){
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
    }



    
}
