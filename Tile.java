public class Tile {

    private int tileNb;
    public int moveToTile;
    private boolean isAction;

    // if were doing tile individually --> change such that can set all snakes at once and all ladders at once
    public Tile(int tileNb, int moveToTile){
        this.tileNb = tileNb;
        this.moveToTile = moveToTile;
        if (tileNb == moveToTile){
            this.isAction = false; 
        } else {
            this.isAction = true;
        }
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

    public int getMoveToTile(){
        return moveToTile;
    }

    public boolean checkForSnake(){
        boolean snake = false;
        if (moveToTile < tileNb){
            snake = true;
            // Display message
        }
        return snake;
    }

    public boolean checkForLadder(){
        boolean ladder = false;
        if (moveToTile > tileNb){
            ladder = true;
            // Display message
        }
        return ladder;
    }



    
}
