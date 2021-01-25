

public class LadderAndSnake{

    private int nbPlayers;
    private final static int NB_DICE_FACES = 6;
    private final static int BOARD_SIZE = 10;

    public LadderAndSnake(int nbPlayers) {
        this.nbPlayers = nbPlayers;

    }

    //random integer between 1 and 6
    static public int flipDice() {
        return (int) ((Math.random() * NB_DICE_FACES + 1));
    }

}