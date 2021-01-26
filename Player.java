public class Player {

    private String name;
    private int currentPosition = 0;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCurrentPosition(){
        return this.currentPosition;
    }

    public void setCurrentPosition(int newPosition){
        currentPosition = newPosition;
    }
    
}
