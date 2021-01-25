

public class LadderAndSnake{

    private int nbPlayers;
    private final static int nbDiceSides = 6;

    public LadderAndSnake(int nbPlayers) {
        this.nbPlayers = nbPlayers;

    }

    //random integer between 1 and 6
    static public int flipDice() {
        return (int) ((Math.random() * nbDiceSides + 1));
    }

}